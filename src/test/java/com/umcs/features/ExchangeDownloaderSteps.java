package com.umcs.features;

import com.umcs.ExchangeRecordDownloader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ExchangeDownloaderSteps {
  private int numberOfDays = 0;

  @Given("^a timeframe of (\\d+) days$")
  public void aTimeframeOfDays(int arg0) throws Throwable {
    this.numberOfDays = arg0;
  }

  @When("^downloader is running every day$")
  public void downloaderRunningForDays() throws Throwable {
    for (int i = 0; i < numberOfDays; i++) {
      ExchangeRecordDownloader.fetchExchangeData();
    }
  }

  @Then("^downlaoder has been invoked (\\d+) times$")
  public void downlaoderHasBeenInvokedTimes(int expected) throws Throwable {
    assertEquals(expected, ExchangeRecordDownloader.runs);
  }
}
