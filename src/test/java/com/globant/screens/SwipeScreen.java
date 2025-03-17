package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends MobileBaseScreen {
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Swipe-screen")
    private WebElement swipeContainer;

    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement lblTitle;

    @AndroidFindBy(accessibility = "Carousel")
    private WebElement carousel;

    public boolean areAllElementsVisible() {
        return isVisible(swipeContainer)
                && isVisible(lblTitle)
                && isVisible(carousel);
    }
}
