package com.umcs.features;

import com.google.common.collect.Ordering;
import com.umcs.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SummarySteps {
  private SummaryGenerator<CompanySaleEntry> generator = new SummaryGenerator<>();
  private Map<String, SaleEntries<CompanySaleEntry>> months = new HashMap<>();
  private Summary summary;

  @Given("^a list of sale entries$")
  public void a_list_of_sale_entries() {
    months.put("January", new SaleEntries<CompanySaleEntry>());
    months.put("February", new SaleEntries<CompanySaleEntry>());
    months.put("March", new SaleEntries<CompanySaleEntry>());
    months.put("April", new SaleEntries<CompanySaleEntry>());
    months.put("May", new SaleEntries<CompanySaleEntry>());
  }

  @When("^I create the summary for month (.*)$")
  public void iCreateTheSummary(String month) {
    this.summary = generator.monthlySummary(months.get(month));
  }

  @Then("^the summary only contains data for month (.*)$")
  public void theSummaryOnlyContainsDataForMonth(String month) {
    assertEquals(month, summary.getMonth());
  }

  @Then("^the summary only contains data for year (.*)$")
  public void theSummaryOnlyContainsDataForYTear(String month) {
    assertEquals(month, summary.getMonth());
  }

  @Then("^the summary has (.*) record$")
  public void theSummaryHasTypeRecord(SummaryType type) {
    switch (type) {
      case AVERAGE:
        assertNotNull(summary.getAveragePrice());
        break;
      case HIGH:
        assertNotNull(summary.getHighestPrice());
        break;
      case LOW:
        assertNotNull(summary.getLowestPrice());
        break;
    }
  }

  @When("^I create the summary for year$")
  public void iCreateTheSummaryForYear() {
    this.summary = generator.yearlySummary(months);

  }

  @Then("^the summary only contains data for year$")
  public void theSummaryOnlyContainsDataForYear() {
    assertEquals(true, summary.isPerYear());
  }

  @Then("^report says that company was not noted on exchange after some time$")
  public void reportSaysThatCompanyWasNotNotedOnExchangeAfterSomeTime() {
    assertTrue(summary.companyStoppedBeingTraded());
  }

  @Then("^the summary top 3 company entries$")
  public void theSummaryTopCompanyEntries() {
    assertEquals(3, summary.getTop3().size());
  }

  @And("^the top list is sorted DESC$")
  public void theTopListIsSorted() throws Throwable {
    assertTrue(Ordering.natural().isOrdered(summary.getTop3()));
  }
}
