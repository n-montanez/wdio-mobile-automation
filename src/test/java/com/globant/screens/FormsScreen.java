package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends MobileBaseScreen {
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Forms-screen")
    private WebElement formsContainer;

    @AndroidFindBy(uiAutomator = "text(\"Form components\")")
    private WebElement lblTitle;

    @AndroidFindBy(accessibility = "text-input")
    private WebElement fldTextInput;

    @AndroidFindBy(accessibility = "input-text-result")
    private WebElement lblTextResult;

    @AndroidFindBy(accessibility = "switch")
    private WebElement btnSwitch;

    @AndroidFindBy(uiAutomator = "resourceId(\"text_input\")")
    private WebElement btnDropDown;

    @AndroidFindBy(accessibility = "button-Active")
    private WebElement btnActive;

    @AndroidFindBy(accessibility = "button-Inactive")
    private WebElement btnInactive;

    public boolean areAllElementsVisible() {
        return isVisible(formsContainer)
                && isVisible(lblTitle)
                && isVisible(fldTextInput)
                && isVisible(lblTextResult)
                && isVisible(btnSwitch)
                && isVisible(btnDropDown)
                && isVisible(btnActive)
                && isVisible(btnInactive);
    }

    public void flipSwitch() {
        btnSwitch.click();
    }

    public boolean isSwitchActive() {
        return Boolean.parseBoolean(btnSwitch.getDomAttribute("checked"));
    }
}
