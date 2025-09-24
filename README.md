# Ecommerce-Checkout-Flow
Automated tested framework for an e-commerce application on the **checkout process**, as well as **login** and **signup flows**.

## Features
- Automated tests for:
        - Checkout flow: cart updates, payment, order confirmation
        - User authentication: login and signup
        - Negative cases: incomplete fields, invalid inputs, error validation
- Page Object Model (POM) for maintainable test structure
- Centralized locators and test data for easier updates
- Generates TestNG reports after each run
## Tech Stack
Ensure you have the following installed:
- Language: Java, JavaScript
- Automation: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- Version Control: Git & Github
## Installation
Clone the repositories and install dependencies:
```bash
git clone https://github.com/AbdulMannan6643234/Ecommerce-checkout-automation.git
cd Ecommerce-checkout-automation
mvn clean install
```
## Test Run:
To run tests:
```bash
mvn test
```
## Project Structure
```text
Ecommerce-checkout-automation/
├── src/main/java/pages/        # Page Objects and Utilities
└── src/test/java/              # TestNG test classes
├── pom.xml                     # Maven dependencies
├── screenshots                 # Includes Screenshots of successfull test results
```
