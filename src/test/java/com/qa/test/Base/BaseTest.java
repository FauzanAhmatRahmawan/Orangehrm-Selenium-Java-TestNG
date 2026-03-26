package com.qa.test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.qa.test.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;
    @BeforeMethod
    public void setup() {
        config = new ConfigReader();
        if(config.getBrowser().equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}