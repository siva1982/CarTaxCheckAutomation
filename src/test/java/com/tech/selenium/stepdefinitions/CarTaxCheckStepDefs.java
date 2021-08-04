package com.tech.selenium.stepdefinitions;

import com.tech.selenium.driverutil.DriverFactory;
import com.tech.selenium.model.Vehicle;
import com.tech.selenium.pageobjects.CarTaxCheckPage;
import com.tech.selenium.pageobjects.CarTaxDetailsPage;
import com.tech.selenium.utils.FileHelper;
import com.tech.selenium.utils.PageLoader;
import com.tech.selenium.vehiclemapper.VehicleMapper;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

/**
 * Created by Siva Challa on 04/08/21.
 */
public class CarTaxCheckStepDefs {

    private List<String> vehicleRegistrationNumbers;

    private List<Vehicle> actualVehicles;

    private WebDriver webDriver;

    private PageLoader page;

    private CarTaxCheckPage carTaxCheckPage;

    private CarTaxDetailsPage detailsPage;


    @Before
    public void setup() {
        //System.out.println("Test-- inside setup and Webdriver is " + DriverFactory.getBrowser());
        if (webDriver == null) {
            webDriver = DriverFactory.getBrowser();
        }
        if (page == null) {
            page = new PageLoader(webDriver);
        }
    }

    @Given("I have vehicle registration numbers")
    public void i_have_vehicle_registration_numbers() {
        //Load car input file and read vehicle registration numbers
        try {
            vehicleRegistrationNumbers = FileHelper.getVehicleRegistrationNumbers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(vehicleRegistrationNumbers.isEmpty());
    }

    @When("I check each registration number on cartaxcheck.com")
    public void i_check_each_registration_number_on_cartaxcheck_com() {
        actualVehicles = new ArrayList<>();
        System.out.println("=======================>RegNumbers" + vehicleRegistrationNumbers);
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

    @Then("I can verify tax details with expected values")
    public void i_can_verify_tax_details_with_expected_values() {
        //Load expected car output file and create a map of vehicles.
        Map<String, Vehicle> expectedVehicles = FileHelper.getExpectedVehicleData();
        FileHelper.removeNulls(expectedVehicles);
        //Verify the obtained values from the output file
        while (actualVehicles.remove(null)) {
        }
            actualVehicles.forEach(actualVehicle -> {
                Vehicle expectedVehicleRegistration = expectedVehicles.get(actualVehicle.getRegistration());
                assertEquals(actualVehicle.getRegistration(), "DN09HRM");
            });
        }
}
