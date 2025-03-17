package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Alert;
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

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/content\")")
    private WebElement signUpPanel;

    public boolean isLoginFormVisible() {
        return isVisible(btnLoginForm)
                && isVisible(btnSignUpForm)
                && isVisible(fldEmail)
                && isVisible(fldPassword)
                && isVisible(btnLogin)
                && !isVisible(fldRepeatPassword, 1);
    }

    public void goToSignUpForm() {
        btnSignUpForm.click();
    }

    public boolean isSignUpFormVisible() {
        return isVisible(btnLoginForm)
                && isVisible(btnSignUpForm)
                && isVisible(fldEmail)
                && isVisible(fldPassword)
                && isVisible(fldRepeatPassword)
                && isVisible(btnSignUp);
    }

    public boolean areFieldsPassword() {
        return Boolean.parseBoolean(fldPassword.getDomAttribute("password"))
                && Boolean.parseBoolean(fldRepeatPassword.getDomAttribute("password"));
    }

    public void fillSignUpForm(String email, String password) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(password);
        fldRepeatPassword.sendKeys(password);
        btnSignUp.click();
    }

    public String getAlertText() {
        waitForAlert();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        waitForAlert();
        driver.switchTo().alert().accept();
    }
}
