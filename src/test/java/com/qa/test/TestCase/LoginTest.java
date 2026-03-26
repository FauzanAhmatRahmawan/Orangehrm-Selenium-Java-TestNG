package com.qa.test.TestCase;
import com.qa.test.Base.BaseTest;
import com.qa.Pages.LoginPage;
import com.qa.test.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test(dataProvider = "loginData")
    public void logindata(String Username, String Password, Boolean Expected){
        loginPage = new LoginPage(driver);
        loginPage.open(config.getBaseUrl());
        loginPage.login(Username,Password);
        boolean actual = loginPage.isDashboardVisible();
        Assert.assertEquals(actual, Expected, "Login result mismatch");
    }

    @DataProvider(name = "loginData")
    public Object[][] logindata (){

        return new Object[][]{
                {"Admin","admin123", true},   // valid login
                {"Admin","wrongpass", false}, // wrong password
                {"wrong","admin123", false}   // wrong username
        };
    }
}