package com.tech.selenium.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Siva Challa on 04/08/21.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/Google.feature"},
        glue = {"com.tech.selenium.stepdefinitions"},
        plugin = {"json:target/cucumber-report.json","html:target/cucumber-html"})
public class TestRunner {
}
