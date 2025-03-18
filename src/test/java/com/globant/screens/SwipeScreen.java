package com.globant.screens;

import com.globant.base.MobileBaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_0_READY__\")")
    private WebElement carouselItem0;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_1_READY__\")")
    private WebElement carouselItem1;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_2_READY__\")")
    private WebElement carouselItem2;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_3_READY__\")")
    private WebElement carouselItem3;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_4_READY__\")")
    private WebElement carouselItem4;

    @AndroidFindBy(uiAutomator = "resourceId(\"__CAROUSEL_ITEM_5_READY__\")")
    private WebElement carouselItem5;

    @AndroidFindBy(accessibility = "WebdriverIO logo")
    private WebElement imgRobot;

    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement lblRobotFound;

    /**
     * Checks if key elements are visible
     *
     * @return whether given elements are visible within timeout or not
     */
    public boolean areAllElementsVisible() {
        return isVisible(swipeContainer)
                && isVisible(lblTitle)
                && isVisible(carousel);
    }

    /**
     * Finds current displayed cards
     *
     * @return indexes of visible cards
     */
    public List<Integer> getVisibleCards() {
        List<WebElement> cards = List.of(carouselItem0, carouselItem1, carouselItem2, carouselItem3, carouselItem4, carouselItem5);
        List<Integer> indexes = new ArrayList<>();
        int counter = 0;
        for (WebElement card : cards) {
            if (isVisible(card, 1)) {
                indexes.add(counter);
            }
            counter++;
        }
        return indexes;
    }

    /**
     * Swipes horizontally to next card
     */
    public void swipeCard() {
        swipe(980, 1760, 124, 1760, 200);
    }

    /**
     * Swipes vertically to screen bottom
     */
    public void swipeDown() {
        swipe(540, 1100, 540, 350, 100);
    }

    /**
     * Checks if robot image is visible at screen bottom
     *
     * @return if robot image is shown
     */
    public boolean wasRobotFound() {
        return isVisible(imgRobot) &&
                isVisible(lblRobotFound);
    }

    /**
     * Gets the text of the label found at screen bottomw
     *
     * @return label under robot image
     */
    public String getLabelRobot() {
        return lblRobotFound.getText();
    }
}
