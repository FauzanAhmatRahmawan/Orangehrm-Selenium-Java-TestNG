package com.qa.test.TestCase;
import com.qa.test.Base.BaseTest;
import com.qa.Pages.AdminDeleteDataPage;
import com.qa.Pages.LoginPage;
import com.qa.test.utils.TestData;
import com.qa.test.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest{
    LoginPage loginPage;
    AdminDeleteDataPage adminDeleteDataPage;

    @Test(dependsOnMethods = "VerifyAddUserSuccess")
    public void DeleteDataTest (){
        // Initialize Pages
        loginPage = new LoginPage(driver);
        adminDeleteDataPage = new AdminDeleteDataPage(driver);

        loginPage.open(config.getBaseUrl());
        loginPage.login(config.getUsername(),config.getPassword());

        String username = TestData.createdUsername;
        if (username == null) {
            throw new RuntimeException("Username from AddUserTest is NULL!");
        }
        adminDeleteDataPage.deleteUser(username);

        boolean result = adminDeleteDataPage.isUserExist(username);

        // ASSERTION
        Assert.assertFalse(result, "User Still Exists After Delete");
    }
}