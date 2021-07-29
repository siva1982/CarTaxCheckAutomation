package com.carcheck.automation.stepdefs;

import com.carcheck.automation.factory.WebDriverFactory;
import com.carcheck.automation.model.Vehicle;
import com.carcheck.automation.pages.CarTaxCheckPage;
import com.carcheck.automation.pages.CarTaxDetailsPage;
import com.carcheck.automation.util.FileHelper;
import com.carcheck.automation.util.PageLoader;
import com.carcheck.automation.vehiclemapper.VehicleMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

public class CarTaxCheckStepDefs {

    private List<String> vehicleRegistrationNumbers;

    private List<Vehicle> actualVehicles;

    private WebDriver webDriver;

    private PageLoader page;

    private CarTaxCheckPage carTaxCheckPage;

    private CarTaxDetailsPage detailsPage;


    @Before
    public void setup() {
        if (webDriver == null) {
            webDriver = WebDriverFactory.create();
        }
        if (page == null) {
            page = new PageLoader(webDriver);
        }
    }


    @Given("^I have vehicle registration numbers$")
    public void iHaveVehicleRegistrationNumbers() throws Exception {
        //Load car input file and read vehicle registration numbers
        vehicleRegistrationNumbers = FileHelper.getVehicleRegistrationNumbers();
        assertFalse(vehicleRegistrationNumbers.isEmpty());
    }

    @When("^I check each registration number on cartaxcheck\\.com$")
    public void iCheckEachRegistrationNumberOnCartaxcheckCom() {
        actualVehicles = new ArrayList<>();
        vehicleRegistrationNumbers.forEach(registrationNumber -> {
            //Loading Car Tax Check Page
            carTaxCheckPage = page.load(CarTaxCheckPage.class);
            assertTrue(carTaxCheckPage.isDisplayed());
            carTaxCheckPage.enterRegistrationNumber(registrationNumber);
            carTaxCheckPage.clickOnFreeCarCheckButton();

            //Check that registration number
            String actualRegistrationNumber = carTaxCheckPage.getRegistrationNumber().replaceAll("\\s", "");
            String expectedRegistrationNumber = registrationNumber.replaceAll("\\s", "");
            assertThat(actualRegistrationNumber, is(equalTo(expectedRegistrationNumber)));

            //Loading Car Details Page
            detailsPage = page.init(CarTaxDetailsPage.class);
            assertTrue(detailsPage.isDisplayed());

            //Verify car details with expected values from car_output.txt
            Vehicle actualVehicle = VehicleMapper.mapToActualVehicle(detailsPage);
            actualVehicles.add(actualVehicle);
        });
    }

    @Then("^I can verify tax details with expected values$")
    public void iCanVerifyTaxDetailsWithExpectedValues() {
        //Load expected car output file and create a map of vehicles.
        Map<String, Vehicle> expectedVehicles = FileHelper.getExpectedVehicleData();
        //Verify the obtained values from the output file
        actualVehicles.forEach(actualVehicle -> {
            Vehicle expectedVehicle = expectedVehicles.get(actualVehicle.getRegistration());
            assertThat(actualVehicle, samePropertyValuesAs(expectedVehicle));
            Vehicle expectedMake = expectedVehicles.get(actualVehicle.getMake());
            assertThat(actualVehicle, samePropertyValuesAs(expectedMake));
            Vehicle expectedModel = expectedVehicles.get(actualVehicle.getModel());
            assertThat(actualVehicle, samePropertyValuesAs(expectedModel));
            Vehicle expectedColour = expectedVehicles.get(actualVehicle.getColor());
            assertThat(actualVehicle, samePropertyValuesAs(expectedColour));
            Vehicle expectedYear = expectedVehicles.get(actualVehicle.getYear());
            assertThat(actualVehicle, samePropertyValuesAs(expectedYear));
        });
    }
}
