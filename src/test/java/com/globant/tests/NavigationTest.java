package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends MobileBaseTest {

    @Test(testName = "Navigation on the bottom menu bar")
    public void navigationTest() {
        Navbar navbar = new Navbar(driver);

        HomeScreen homeScreen = navbar.goToHome();
        Assert.assertTrue(homeScreen.areAllElementsVisible());

        WebViewScreen webViewScreen = navbar.goToWebView();
        Assert.assertTrue(webViewScreen.isLoading());
        Assert.assertTrue(webViewScreen.isContainerScrollable());

        LoginScreen loginScreen = navbar.goToLogin();
        Assert.assertTrue(loginScreen.isLoginFormVisible());
        loginScreen.goToSignUpForm();
        Assert.assertTrue(loginScreen.isSignUpFormVisible());

        FormsScreen formsScreen = navbar.goToForms();
        Assert.assertTrue(formsScreen.areAllElementsVisible());
        Assert.assertFalse(formsScreen.isSwitchActive());
        formsScreen.flipSwitch();
        Assert.assertTrue(formsScreen.isSwitchActive());
    }

}
