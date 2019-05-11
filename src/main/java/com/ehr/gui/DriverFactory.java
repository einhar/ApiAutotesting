package com.ehr.gui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory() {    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriverWait getDriverWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 5);
        }
        return wait;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }
}
