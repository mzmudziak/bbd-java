package com.umcs.features;

import com.umcs.Kalendarz;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * testy = Steps
 * scenariusze = Feature
 */
public class CSVSteps {
    int month = 0;
    int nextMonth = 0;

    @Given("^current month is (.*)$")
    public void a_file_with_CSV_values(int month) {
        this.month = month;
    }

    @When("^i get the next month$")
    public void we_parse_the_file() {
        nextMonth = Kalendarz.getNextMonth(month);
    }

    @Then("^the current month is (.*)$")
    public void an_array_with_values_is_returned(int monthThatShouldBe) {
        assertEquals(nextMonth, monthThatShouldBe);
    }

    @Given("^is numer (.*) five$")
    public void is5(int nr) {
        assertEquals(5, nr);
    }
}
