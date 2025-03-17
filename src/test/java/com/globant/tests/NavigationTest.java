package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.Navbar;
import org.testng.annotations.Test;

public class NavigationTest extends MobileBaseTest {

    @Test(testName = "Navigation on the bottom menu bar")
    public void navigationTest() {
        Navbar navbar = new Navbar(driver);
        navbar.goToHome();
        navbar.goToLogin();
        navbar.goToSwipe();
    }

}
