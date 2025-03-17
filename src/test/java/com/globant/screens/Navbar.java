package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Navbar extends MobileBaseScreen {
    public Navbar(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Home")
    private WebElement btnHome;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement btnWebView;

    @AndroidFindBy(accessibility = "Login")
    private WebElement btnLogin;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement btnForms;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement btnSwipe;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement btnDrag;

    public void goToHome() {
        btnHome.click();
    }

    public void goToLogin() {
        btnLogin.click();
    }

    public void goToSwipe() {
        btnSwipe.click();
    }
}
