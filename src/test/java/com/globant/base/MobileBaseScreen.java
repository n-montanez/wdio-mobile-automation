package com.globant.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MobileBaseScreen {
    protected AndroidDriver driver;

    private final int DEFAULT_IMPLICIT = 10;
    private final int DEFAULT_EXPLICIT = 5;

    public MobileBaseScreen(AndroidDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Explicit wait to check for visibility. Uses default timeout
     *
     * @param element WebElement to track for visibility
     * @return Whether the element is visible in the default time window
     */
    protected boolean isVisible(WebElement element) {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT));
        }
    }

    /**
     * Explicit wait to check for visibility. Uses given timeout
     *
     * @param element WebElement to track for visibility
     * @param seconds Custom timeout seconds
     * @return Whether the element is visible in the default time window
     */
    protected boolean isVisible(WebElement element, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT));
        }
    }

    /**
     * Awaits for an element to be visible within a time window
     *
     * @param element WebElement to track for visibility
     */
    protected void waitForElementVisibility(WebElement element) {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT));
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT));
    }


    /**
     * Awaits the appearance of an alert pop up window
     */
    protected void waitForAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT));
    }

    /**
     * Performs a swipe between given coordinates and speed
     *
     * @param startX   initial horizontal coordinate
     * @param startY   initial vertical coordinate
     * @param endX     final horizontal coordinate
     * @param endY     final vertical coordinate
     * @param duration duration of the swipe. affects speed
     */
    protected void swipe(int startX, int startY, int endX, int endY, int duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(sequence));
    }
}
