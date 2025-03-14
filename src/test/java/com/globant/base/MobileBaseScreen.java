package com.globant.base;

import io.appium.java_client.android.AndroidDriver;

public class MobileBaseScreen {
    AndroidDriver driver;

    public MobileBaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }
}
