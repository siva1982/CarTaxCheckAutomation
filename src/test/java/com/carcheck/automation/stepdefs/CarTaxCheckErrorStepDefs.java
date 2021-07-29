package com.carcheck.automation.stepdefs;

import com.carcheck.automation.factory.WebDriverFactory;
import com.carcheck.automation.pages.CarTaxCheckPage;
import com.carcheck.automation.pages.CarTaxDetailsErrorPage;
import com.carcheck.automation.pages.CarTaxDetailsPage;
import com.carcheck.automation.util.PageLoader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class CarTaxCheckErrorStepDefs {

    private WebDriver webDriver;

    private PageLoader page;

    private CarTaxCheckPage carTaxCheckPage;

    private CarTaxDetailsPage detailsPage;

    private CarTaxDetailsErrorPage carTaxDetailsErrorPage;

    @Before
    public void setup() {
        if (webDriver == null) {
            webDriver = WebDriverFactory.create();
        }
        if (page == null) {
            page = new PageLoader(webDriver);
        }
    }

    @Given("^I have vehicle registration numbers which is wrong in pattern$")
    public void iHaveVehicleRegistrationNumberWhichIsWrongInPattern() throws Exception {
        carTaxCheckPage.enterWrongRegNumber();
    }
    @When("^I check the registration number on cartaxcheck\\.com$")
    public void iCheckRegistrationNumberOnCartaxcheckCom() {
        carTaxCheckPage.clickOnFreeCarCheckButton();
    }
    @Then("^I should see error for my search$")
    public void iShouldSeeErrorForMySearch() {
        carTaxDetailsErrorPage.isErrorDisplayed();
    }
}
