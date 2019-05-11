package com.ehr.gui;

import com.ehr.gui.login.LoginPage;
import com.ehr.gui.home.HomePage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSTest extends BaseSTest {

    @Ignore
    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
        WebElement signIn = ((FirefoxDriver) driver).findElementByLinkText("Sign in");
        signIn.click();
    }

    @Test
    public void correctLoginShouldPass() {
        // TODO: complete test with UserDefinedData (maybe from another class)
        Assert.assertTrue(true);
    }

    @Test
    public void incorrectLoginShouldFail() {

        HomePage.getHomePage().act().getLoginPage();

        LoginPage.getLoginPage().act().loginAs("null", "null");

        LoginPage.getLoginPage().verify().verifyFailedSignIn();
    }

    @Test
    public void incorrectLoginShouldFail2() {

        HomePage.getHomePage().act().getLoginPage();

        LoginPage.getLoginPage().act().loginAs("null", "null");

        LoginPage.getLoginPage().verify().verifyFailedSignIn();
    }
}
