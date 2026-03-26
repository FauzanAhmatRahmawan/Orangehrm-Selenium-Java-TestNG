# Selenium Automation Testing - OrangeHRM (TestNG Framework)

This project is an advanced automation testing framework built using **Selenium WebDriver with Java and TestNG** to validate core functionalities of the OrangeHRM demo application.

The framework is designed using the **Page Object Model (POM)** pattern and enhanced with **TestNG features**, configuration management, and dynamic test data handling.

---

## 📌 Application Under Test

OrangeHRM Demo Website  
https://opensource-demo.orangehrmlive.com/

---

## 🚀 Automation Scope

The following end-to-end test scenarios are automated:

1. **Login Test**
   - Login using credentials from configuration file
   - Validate successful login

2. **Add User**
   - Navigate to Admin module
   - Add new user with dynamic data
   - Validate user creation by searching the user in table (since table is not auto-refreshed)

3. **Delete User**
   - Delete user that was previously created
   - Uses shared data from Add User test
   - Ensures proper cleanup of test data

---

## 🧠 Key Automation Concepts Implemented

- Selenium WebDriver
- Java
- TestNG Framework
- Page Object Model (POM)
- Configuration Management (config.properties)
- Test Dependency (dependsOnMethods)
- Shared Test Data Between Test Cases
- Dynamic Validation Strategy (Search-based validation)
- Modular & Scalable Test Structure

---

## 🛠️ Tech Stack

| Technology | Description |
|------------|-------------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test framework |
| Maven | Dependency management |
| IntelliJ IDEA | IDE used |

---

## ⚙️ Configuration

Test configuration is managed using:

Example:
- baseUrl=https://opensource-demo.orangehrmlive.com/
- username=Admin
- password=admin123

This allows better flexibility and avoids hardcoded credentials.

---

## 🔄 Test Flow
Login → Add User → Validate User (Search) → Delete User

- User is dynamically created
- Validation is done via search (due to UI limitation)
- Same user is deleted using shared test data

---

## ▶️ How to Run the Project

1. Clone the repository 
2. Open in IntelliJ IDEA
3. Install dependencies via Maven
4. Run using TestNG XML:testng.xml


---

## 📸 Test Execution Result

<img width="1600" height="825" alt="image" src="https://github.com/user-attachments/assets/75a4f997-6619-4ec9-88b8-02fb14162c60" />


---

## 👨‍💻 Author

**Fauzan Rahmawan**  
Software Quality Assurance Engineer
