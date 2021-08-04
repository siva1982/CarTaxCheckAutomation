$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Google.feature");
formatter.feature({
  "name": "Selenium Cucumber Java Example",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate Car Tax details",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have vehicle registration numbers",
  "keyword": "Given "
});
formatter.match({
  "location": "CarTaxCheckStepDefs.i_have_vehicle_registration_numbers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check each registration number on cartaxcheck.com",
  "keyword": "When "
});
formatter.match({
  "location": "CarTaxCheckStepDefs.i_check_each_registration_number_on_cartaxcheck_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can verify tax details with expected values",
  "keyword": "Then "
});
formatter.match({
  "location": "CarTaxCheckStepDefs.i_can_verify_tax_details_with_expected_values()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat com.tech.selenium.stepdefinitions.CarTaxCheckStepDefs.lambda$i_can_verify_tax_details_with_expected_values$1(CarTaxCheckStepDefs.java:99)\n\tat java.base/java.util.ArrayList.forEach(ArrayList.java:1541)\n\tat com.tech.selenium.stepdefinitions.CarTaxCheckStepDefs.i_can_verify_tax_details_with_expected_values(CarTaxCheckStepDefs.java:97)\n\tat ✽.I can verify tax details with expected values(features/Google.feature:6)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});