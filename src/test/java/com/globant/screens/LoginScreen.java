package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends MobileBaseScreen {
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Login-screen")
    private WebElement loginContainer;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement btnLoginForm;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement btnSignUpForm;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement fldEmail;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement fldPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement fldRepeatPassword;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement btnLogin;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement btnSignUp;

    public boolean isLoginFormVisible() {
        return isVisible(btnLoginForm, 10)
                && isVisible(btnSignUpForm, 10)
                && isVisible(fldEmail, 10)
                && isVisible(fldPassword, 10)
                && isVisible(btnLogin, 10)
                && !isVisible(fldRepeatPassword, 1);
    }

    public void goToSignUpForm() {
        btnSignUpForm.click();
    }

    public boolean isSignUpFormVisible() {
        return isVisible(btnLoginForm, 10)
                && isVisible(btnSignUpForm, 10)
                && isVisible(fldEmail, 10)
                && isVisible(fldPassword, 10)
                && isVisible(fldRepeatPassword, 10)
                && isVisible(btnSignUp, 10);
    }
}
