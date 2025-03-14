package com.globant.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBaseTest {
    protected static AndroidDriver driver;

    @BeforeMethod
    @Parameters({"deviceName", "appLocation", "appiumUrl"})
    public void setUp(String deviceName, String appLocation, String appiumUrl) {
        driver = createAndroidDriver(deviceName, appLocation, appiumUrl);
    }

    private AndroidDriver createAndroidDriver(String deviceName, String appLocation, String appiumUrl) {
        URL url = null;
        try {
            url = new URL(appiumUrl);
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("15")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName(deviceName)
                    .setApp(appLocation)
                    .setAppActivity("com.wdiodemoap.MainActivity");
            return new AndroidDriver(HttpClient.Factory.create(appiumUrl), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
