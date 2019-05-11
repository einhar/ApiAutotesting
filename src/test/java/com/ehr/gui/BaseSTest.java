package com.ehr.gui;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void startUpBrowser() {
        driver = DriverFactory.getDriver();
        wait = DriverFactory.getDriverWait();
    }

    @Before
    public void goHomePage() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://github.com");
        Thread.sleep(1000);
    }

    @AfterClass
    public static void closeBrowser() {
        DriverFactory.closeDriver();
    }
}
