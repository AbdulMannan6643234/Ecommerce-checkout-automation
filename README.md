# Ecommerce-Checkout-Flow
Automated tested framework for an e-commerce application on the **checkout process**, as well as **login** and **signup flows**.

## Features
- Validate end-to-end **checkout flows**, including cart updates, payment processing, and order confirmation.
- Tests **user authentication**, login and signup functionalities.
- Modular design for **easy maintenance**: update selectors or test data in one place (centralised locators).
- Provides **detailed test reports** for each run.
- Tests **incomplete fields** and **failure scenarios** for validation of the **error messages**.
## Tech Stack
Ensure you have the following installed:
- Language: Java, JavaScript
- Testing Framework: Selenium
- Other Tools: TestNG
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
