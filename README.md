# CarTaxCheckAutomation

This is a sample automation framework to test the Car Registration numbers that got from Input text file and validate against Output text file.

There is one scenarios which explains the functionality of reading the text files and check the functional execution for the registration car details to get the details of the car and valid against the Car attributes.

This is a maven project which is configured accordingly to run the tests. Please use the Runner class to run the tests.

# Required Tools
Chrome Webdriver
JDK 1.8
Cucumber Plugin

# Please Follow The Below Steps To Run The Featuer File Scenarios

Follow the pre-requisites
1) you need to have JDK 1.8 in your local machine.
2) Clone the project
3) Download the chrome driver and update the path accordingly in Pom.xml and properties files

Execution Steps
4) Please use the Runner class to run the tests
5) See the results

#Problems:

While running the tests, I managed to read the input file for registration numbers
but when i try to add those numbers to a list some how it is gettin nulls inserted in the list
and when i try to compare with the output file, am getting null pointer exception. 
I can fix that in the mean time. 

Now I can able to execute the scenario listed.