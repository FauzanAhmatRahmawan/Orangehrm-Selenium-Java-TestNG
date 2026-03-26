package com.qa.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class AdminAddDataPage {

    WebDriver driver;
    WebDriverWait wait;

    public AdminAddDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====

    By adminMenu = By.xpath("//span[normalize-space()='Admin']");
    By addButton = By.xpath("//button[contains(.,'Add')]");

    By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]");
    By statusDropdown = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
    By employeeNameField = By.xpath("//label[text()='Employee Name']/following::input[1]");
    By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
    By passwordField = By.xpath("//label[text()='Password']/following::input[1]");
    By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    By saveButton = By.xpath("//button[normalize-space()='Save']");
    By spinner = By.className("oxd-loading-spinner");

    // Search
    By searchUsernameField = By.xpath("//label[text()='Username']/following::input[1]");
    By searchButton = By.xpath("//button[normalize-space()='Search']");

    // ===== ACTION METHODS =====

    public void navigateToAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void selectUserRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
        By option = By.xpath("//div[@role='option']//span[text()='" + role + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void selectStatus(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
        By option = By.xpath("//div[@role='option']//span[text()='" + status + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void selectEmployee(String employeeName) {
        wait.until(ExpectedConditions.elementToBeClickable(employeeNameField)).sendKeys(employeeName);
        By option = By.xpath("//div[@role='option']//span[contains(text(),'" + employeeName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void fillUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);
    }

    public void fillPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void fillConfirmPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField)).sendKeys(password);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

    // ===== BUSINESS FLOW =====

    public String addUser(String role, String status, String employeeName, String password) {

        String generatedUsername = "zan" + System.currentTimeMillis();

        navigateToAdmin();
        clickAdd();
        selectUserRole(role);
        selectStatus(status);
        selectEmployee(employeeName);
        fillUsername(generatedUsername);
        fillPassword(password);
        fillConfirmPassword(password);
        clickSave();

        return generatedUsername;
    }

    // ===== SEARCH USER =====

    public void searchUser(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(searchUsernameField)).clear();
        driver.findElement(searchUsernameField).sendKeys(username);
        driver.findElement(searchButton).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

    // ===== VERIFY USER =====

    public boolean isUserCreated(String username) {

        By userCell = By.xpath("//div[@role='row']//div[contains(text(),'" + username + "')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(userCell));

        return driver.findElements(userCell).size() > 0;
    }
}