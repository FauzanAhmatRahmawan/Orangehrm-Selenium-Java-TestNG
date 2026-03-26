package com.qa.test.TestCase;

import com.qa.test.Base.BaseTest;
import com.qa.Pages.AdminAddDataPage;
import com.qa.Pages.LoginPage;
import com.qa.test.utils.TestData;
import com.qa.test.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddUserTest extends BaseTest {

    LoginPage loginPage;
    AdminAddDataPage adminAddDataPage;

    @Test
    public void VerifyAddUserSuccess () {

        // Initialize Pages
        loginPage = new LoginPage(driver);
        adminAddDataPage = new AdminAddDataPage(driver);

        // Login
        loginPage.open(config.getBaseUrl());
        loginPage.login(config.getUsername(),config.getPassword());

        // Add User
        String newUsername = adminAddDataPage.addUser(
                "Admin",
                "Enabled",
                "Ranga  Akunuri",
                "P@ssw0rd123"
        );


        // Simpan Shared variable
        TestData.createdUsername = newUsername;

        System.out.println("Generated Username: " + newUsername);

        // LIST PAGE
        adminAddDataPage.navigateToAdmin();

        // SEARCH
        adminAddDataPage.searchUser(newUsername);

        // VERIFY
        boolean result = adminAddDataPage.isUserCreated(newUsername);

        Assert.assertTrue(result, "TEST FAILED - USER NOT FOUND");
    }
}