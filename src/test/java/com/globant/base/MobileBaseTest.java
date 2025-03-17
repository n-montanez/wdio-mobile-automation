package com.globant.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBaseTest {
    protected static AndroidDriver driver;

    @BeforeMethod
    @Parameters({"deviceName", "appiumUrl"})
    public void setUp(String deviceName, String appiumUrl) {
        driver = createAndroidDriver(deviceName, appiumUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    private AndroidDriver createAndroidDriver(String deviceName, String appiumUrl) {
        URL url;
        try {
            url = new URL(appiumUrl);
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("15")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName(deviceName)
                    .setAppPackage("com.wdiodemoapp")
                    .setAppActivity("com.wdiodemoapp.MainActivity");
            return new AndroidDriver(url, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
