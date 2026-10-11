
# Test Automation Framework

A data-driven UI test automation framework built with **Java 11**,
**Selenium WebDriver**, and **TestNG**. It supports test data from CSV,JSON, and Excel files; synthetic test data generation with Java Faker;local or LambdaTest cloud execution; headless browser execution; and test reporting and logging.

## 🚀 About Me
My name is Xavier Betty and I have 8+ years of expereince in software testing using technologies like Selenium WebDriver,Postman,Playwright.
I have expereince in the languages Java and Typescript. I have updated the python language.

## Authors

- [@BettyRavi10](https://github.com/BettyRavi10)
- EmailAddress: betty.sn@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/BettyRavi10)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/xavier-betty-singarayan-249b9724)



## Prerequisites

- Java JDK 11 
- Git
- Apache Maven
- supported browser
- LambdaTest account for cloud execution

1. Framework overview

- Explains Java 11, Selenium WebDriver, TestNG, Maven Surefire, OpenCSV, Gson, Apache POI, Java Faker, Extent Reports, and Log4j.



2. Setup and execution commands

- Shows how to execute tests from the command line with browser selection, LambdaTest cloud execution, and headless mode.



3. Data-driven testing

- Describes how the framework uses CSV, JSON, and Excel files, along with Faker for generating test data.



4. Reporting and logging

- Explains where to find reports.html and the logs/ directory, and how to use them to investigate failures.



5. Troubleshooting and best practices

- Covers common setup problems, Maven properties, browser configuration, LambdaTest credentials, and CI/CD usage.


## Commands

**Clone the repository**
- Git clone https://github.com/BettyRavi10/Test-Automation-Framework.git

- cd Test-Automation-Framework

**Run locally with Chrome**
- mvn clean test -Dbrowser=chrome -DislambdaTest=false -DisHeadless=false -X


**Run locally in chrome browser in headless mode**
- mvn clean test -Dbrowser=chrome -DislambdaTest=false -DisHeadless=true -X


**Run on LambdaTest**
- mvn clean test -Dbrowser=chrome -DislambdaTest=true -DisHeadless=false -X


## Reports and Logs
- Reports: After execution,a detailed HTML report will be generated at ./report.html.

  The reports contains an information on test cases executed,passed, failed, and skipped, along with screenshots for failed test cases.

## Logs
- Logs are created while executing the testcases and stored in the ./logs /directory.
  
  Each run generates a new log file with the detailed information of the test flow.

## Integrated the project with Github Actions
- This automation framework is integrated with Github actions. The test will be executed at 11:30 PM IST on every single day.

The reports will be archieved in gh-pages branch. You can view the html reports at :

 https://bettyravi10.github.io/Test-Automation-Framework/report.html
