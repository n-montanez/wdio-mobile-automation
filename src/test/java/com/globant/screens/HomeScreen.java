package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends MobileBaseScreen {
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Home-screen")
    private WebElement homeContainer;

    @AndroidFindBy(uiAutomator = "className(\"android.widget.ImageView\").instance(0)")
    private WebElement imgRobotLogo;

    @AndroidFindBy(uiAutomator = "text(\"WEBDRIVER\")")
    private WebElement lblAppTitle;

    @AndroidFindBy(uiAutomator = "text(\"Demo app for the appium-boilerplate\")")
    private WebElement lblDescription;

    /**
     * Checks if key elements are visible
     *
     * @return whether given elements are visible within timeout or not
     */
    public boolean areAllElementsVisible() {
        return isVisible(homeContainer)
                && isVisible(imgRobotLogo)
                && isVisible(lblAppTitle)
                && isVisible(lblDescription);
    }
}
