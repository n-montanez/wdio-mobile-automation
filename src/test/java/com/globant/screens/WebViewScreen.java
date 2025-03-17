package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends MobileBaseScreen {
    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "text(\"LOADING...\")")
    private WebElement lblLoading;

    @AndroidFindBy(uiAutomator = "className(\"android.webkit.WebView\").instance(1)")
    private WebElement webContainer;

    public Boolean isLoading() {
        waitForElementVisibility(lblLoading);
        return lblLoading.isDisplayed();
    }

    public boolean isContainerScrollable() {
        waitForElementVisibility(webContainer);
        return Boolean.parseBoolean(webContainer.getDomAttribute("scrollable"));
    }
}
