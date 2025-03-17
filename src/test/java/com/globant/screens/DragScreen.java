package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends MobileBaseScreen {
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Drag-drop-screen")
    private WebElement dragContainer;

    @AndroidFindBy(uiAutomator = "text(\"Drag and Drop\")")
    private WebElement lblTitle;

    @AndroidFindBy(uiAutomator = "className(\"android.widget.ImageView\").instance(0)")
    private WebElement imgGuide;

    @AndroidFindBy(accessibility = "renew")
    private WebElement btnRestart;

    @AndroidFindBy(accessibility = "drag-l2")
    private WebElement firstPiece;

    @AndroidFindBy(accessibility = "drop-l1")
    private WebElement firstSpot;

    public boolean areAllElementsVisible() {
        return isVisible(dragContainer)
                && isVisible(lblTitle)
                && isVisible(imgGuide)
                && isVisible(btnRestart)
                && isVisible(firstPiece)
                && isVisible(firstSpot);
    }
}
