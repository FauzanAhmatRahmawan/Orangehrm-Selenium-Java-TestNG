package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDeleteDataPage {
    WebDriver driver;
    WebDriverWait wait;

    public AdminDeleteDataPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    By adminMenu = By.xpath("//span[normalize-space()='Admin']");
    By deleteConfirmation = By.xpath("//button[contains(@class,'label-danger')]");
    By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");

    // ===== ACTION METHODS =====
    public void navigateToAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }
    public void clickDeleteUser(String username){

        By deleteBtn = By.xpath(
                "//div[normalize-space()='"+ username +"']" +
                        "/ancestor::div[@role='row']" +
                        "//i[contains(@class,'bi-trash')]/parent::button"
        );

        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }
    public void deleteConfirmation(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmation)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
    }

    // ===== BUSINESS FLOW METHOD =====

    public void deleteUser(String username){

        navigateToAdmin();
        clickDeleteUser(username);
        deleteConfirmation();

    }

    // ===== VERIFICATION METHOD =====
    public boolean isUserExist(String username) {

        By userCell = By.xpath(
                "//div[@role='row']//div[normalize-space()='" + username + "']"
        );
        return driver.findElements(userCell).size() > 0;
    }
}