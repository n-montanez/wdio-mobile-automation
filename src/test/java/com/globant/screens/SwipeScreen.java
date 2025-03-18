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

    public boolean areAllElementsVisible() {
        return isVisible(swipeContainer)
                && isVisible(lblTitle)
                && isVisible(carousel);
    }

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

    public void swipeCard() {
        swipe(980, 1760, 124, 1760, 200);
    }
}
