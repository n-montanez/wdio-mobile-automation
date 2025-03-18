package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.LoginScreen;
import com.globant.screens.Navbar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationTest extends MobileBaseTest {

    private LoginScreen loginScreen;

    /**
     * Precondition: the user should be at the Login screen
     */
    @BeforeMethod
    public void goToLogin() {
        Navbar navbar = new Navbar(driver);
        loginScreen = navbar.goToLogin();
    }

    /**
     * User params for authentication
     *
     * @return user data objects
     */
    @DataProvider(name = "userData")
    private Object[][] userData() {
        return new Object[][]{
                {"john-doe@mail.com", "securepass1234"}
        };
    }

    /**
     * Uses each data provider user to test for sign up form
     * Fills all the form data to sign up and verifies if it was completed accepting the alert
     *
     * @param email    user email
     * @param password user password
     */
    @Test(testName = "Successful Sign Up", dataProvider = "userData")
    public void signUp(String email, String password) {
        loginScreen.goToSignUpForm();
        Assert.assertTrue(loginScreen.isSignUpFormVisible());
        Assert.assertTrue(loginScreen.areFieldsPassword());

        loginScreen.fillSignUpForm(email, password);
        Assert.assertEquals(loginScreen.getAlertText(), "Signed Up!\n" +
                "You successfully signed up!");
        loginScreen.acceptAlert();
    }

    /**
     * Uses each data provider user to test for login form
     * Fills all the form data to logins and verifies if it was completed accepting the alert
     *
     * @param email    user email
     * @param password user password
     */
    @Test(testName = "Successful Login", dataProvider = "userData")
    public void logIn(String email, String password) {
        Assert.assertTrue(loginScreen.isLoginFormVisible());
        loginScreen.fillLogInForm(email, password);
        Assert.assertEquals(loginScreen.getAlertText(), "Success\n" +
                "You are logged in!");
        loginScreen.acceptAlert();
    }
}
