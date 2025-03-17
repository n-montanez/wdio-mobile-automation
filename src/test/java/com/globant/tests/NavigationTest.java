package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.HomeScreen;
import com.globant.screens.Navbar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends MobileBaseTest {

    @Test(testName = "Navigation on the bottom menu bar")
    public void navigationTest() {
        Navbar navbar = new Navbar(driver);

        HomeScreen homeScreen = navbar.goToHome();
        Assert.assertTrue(homeScreen.areAllElementsVisible(5));
    }

}
