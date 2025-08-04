# Library_Management_system
Automated testing suite for a library management website 
This project is an automated testing suite built using Selenium, TestNG, and Cucumber to validate the core functionalities of a Library Management website.

Technologies Used
Java
Selenium WebDriver
TestNG
BDD Cucumber
Maven

Project Structure
A Maven project was created with all necessary dependencies configured in the pom.xml file.
A testng.xml file is used to run test cases using TestNG.
The project follows Behavior Driven Development (BDD) with .feature files written in Gherkin syntax.
We have not used PageFactory in this project.
Data-driven testing is not implemented; data is hardcoded and executed directly.

Team Contributions
Our group consists of three members, and the work was divided based on the website's functionalities.

Riddhita Chakraborty(Scrum master) – LibraryCard Feature
Created LibraryCard.feature file with test scenarios in Gherkin.
Developed LibraryCardSteps.java under the stepDefinitions package to map step definitions.
Built LibraryCardPage.java under the pages package to handle web element interactions (e.g., sendKeys, clear, locators, and constructors).

Vanshika Garg – Services Feature
Created Services.feature file with Gherkin-based test cases.
Developed ServicesSteps.java under stepDefinitions.
Implemented ServicesPage.java in the pages package to perform web actions related to services functionality

Afreen Alam – AdvancedSearch Feature
Created AdvancedSearch.feature file with relevant scenarios.
Built AdvancedSearchSteps.java in the stepDefinitions package.
Developed AdvancedSearchPage.java to manage all interactions with the Advanced Search web elements

Reusable Components
Hooks.java (in stepDefinitions):
Initializes the browser
Takes screenshots of failed test cases
Tears down the browser session after each scenario

TestRunner.java (in runners package):
Executes the entire test suite

Agile Documentation
Included:
Product Backlog
Sprint Backlog



Afreen Alam worked on the AdvancedSerach feature so for that she has created AdvancedSerach.fetaure file and wrote the testcases in gherkin language and based on that testcases she has created AdvancedSerachSteps.java under stepDefinitions package which contains all the methods to access webpage of the website. Then she has created AdvancedSerachPage.java file under pages package to interact with webpage like clear the responses then then send values through sendKeys and other required website locators and constructor
We have not done data driven testing we have provided data beforehand and run it directly
We have added product Backlog and sprint Backlog files with that also
