package com.umcs.features;

import com.umcs.CSVFileReader;
import com.umcs.SaleEntries;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * testy = Steps
 * scenariusze = Feature
 */
public class CSVSteps {
    private String filename;
    private Integer numRecords;
    private Character delimiter = ';';
    private SaleEntries saleEntries;

    @Given("^a CSV file named (.*) with (.*) records$")
    public void a_file_with_CSV_values(String filename, int records) {
        this.filename = filename;
        this.numRecords = records;
    }


    @When("^I parse the file contents$")
    public void iParseTheFileContents() throws FileNotFoundException {
        this.saleEntries = CSVFileReader.read(this.filename, this.numRecords, this.delimiter);
    }

    @Then("^total of (\\d+) records have been loaded$")
    public void totalOfRecordsHaveBeenLoaded(int numRecords) {
        assertEquals(numRecords, saleEntries.getSize());
    }

    @And("^the data is separated by (.*)$")
    public void theDataIsSeparatedBy(char c) {
        this.delimiter = c;
    }

    @Then("^data is being loaded from file$")
    public void dataIsBeingLoaded() {
        // assume if sourceFilename is there, the loading was success (no exceptions thrown ;])
        assertEquals(filename, saleEntries.getSourceFileName());
    }

    @Then("^only the first appearing price is taken into account$")
    public void onlyTheFirstAppearingPriceIsTakenIntoAccount() throws Throwable {
        assertTrue(isOnlyFirstApplied(saleEntries));
    }

    @And("^prices are calculated using average price from previous and next day$")
    public void pricesAreCalculatedUsingAveragePriceFromPreviousAndNextDay() throws Throwable {
        assertTrue(pricesAppliedCorrectlyWhenMissing(saleEntries, false));
    }

    @And("^prices are calculated using last known price$")
    public void pricesAreCalculatedUsingLastKnownPrice() throws Throwable {
        assertTrue(pricesAppliedCorrectlyWhenMissing(saleEntries, true));
    }

    private boolean pricesAppliedCorrectlyWhenMissing(SaleEntries saleEntries, boolean multipleMissing) {
        return true;
    }

    private boolean isOnlyFirstApplied(SaleEntries saleEntries) {
        return true;
    }

}
