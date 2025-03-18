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

    /**
     * Checks if key elements are visible
     *
     * @return whether given elements are visible within timeout or not
     */
    public boolean isLoginFormVisible() {
        return isVisible(btnLoginForm)
                && isVisible(btnSignUpForm)
                && isVisible(fldEmail)
                && isVisible(fldPassword)
                && isVisible(btnLogin)
                && !isVisible(fldRepeatPassword, 1);
    }

    /**
     * Moves active form to sign up
     */
    public void goToSignUpForm() {
        btnSignUpForm.click();
    }

    /**
     * Checks if sign up form is active
     *
     * @return whether key form elements are visible within timeout or not
     */
    public boolean isSignUpFormVisible() {
        return isVisible(btnLoginForm)
                && isVisible(btnSignUpForm)
                && isVisible(fldEmail)
                && isVisible(fldPassword)
                && isVisible(fldRepeatPassword)
                && isVisible(btnSignUp);
    }

    /**
     * Checks if password fields have password attributes
     *
     * @return whether fields have password attribute for security
     */
    public boolean areFieldsPassword() {
        return Boolean.parseBoolean(fldPassword.getDomAttribute("password"))
                && Boolean.parseBoolean(fldRepeatPassword.getDomAttribute("password"));
    }

    /**
     * Send given data in sign up form and submits
     *
     * @param email    user email
     * @param password user password
     */
    public void fillSignUpForm(String email, String password) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(password);
        fldRepeatPassword.sendKeys(password);
        btnSignUp.click();
    }

    /**
     * Send given data in log in form and submits
     *
     * @param email    user email
     * @param password user password
     */
    public void fillLogInForm(String email, String password) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(password);
        btnLogin.click();
    }

    /**
     * Gets the alert window content as text
     *
     * @return alert title and subtitle
     */
    public String getAlertText() {
        waitForAlert();
        return driver.switchTo().alert().getText();
    }

    /**
     * Selects positive option for alert window
     */
    public void acceptAlert() {
        waitForAlert();
        driver.switchTo().alert().accept();
    }
}
