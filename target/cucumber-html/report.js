$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CarTaxCheck.feature");
formatter.feature({
  "name": "Car Tax Check",
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
  "status": "passed"
});
});