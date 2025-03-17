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

    public HomeScreen goToHome() {
        btnHome.click();
        return new HomeScreen(driver);
    }

    public WebViewScreen goToWebView() {
        btnWebView.click();
        return new WebViewScreen(driver);
    }

    public LoginScreen goToLogin() {
        btnLogin.click();
        return new LoginScreen(driver);
    }

    public FormsScreen goToForms() {
        btnForms.click();
        return new FormsScreen(driver);
    }

    public SwipeScreen goToSwipe() {
        btnSwipe.click();
        return new SwipeScreen(driver);
    }

    public DragScreen goToDrag() {
        btnDrag.click();
        return new DragScreen(driver);
    }
}
