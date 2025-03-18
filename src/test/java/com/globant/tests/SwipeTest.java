package com.globant.tests;

import com.globant.base.MobileBaseTest;
import com.globant.screens.Navbar;
import com.globant.screens.SwipeScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SwipeTest extends MobileBaseTest {

    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void goToSwipe() {
        Navbar navbar = new Navbar(driver);
        swipeScreen = navbar.goToSwipe();
    }

    @Test(testName = "Swipe cards horizontally")
    public void swipeCardsHorizontally() {
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(0, 1));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(1, 2));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(2, 3));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(3, 4));
        swipeScreen.swipeCard();
        Assert.assertEquals(swipeScreen.getVisibleCards(), List.of(4, 5));
    }
}
