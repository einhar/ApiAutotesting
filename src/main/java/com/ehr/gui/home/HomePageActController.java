package com.ehr.gui.home;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageActController {

    private WebDriver driver = DriverFactory.getDriver();

    public void getLoginPage() {
        WebElement login = driver.findElement(By.linkText("Sign in"));
        login.click();
    }

    public void getRegisterPage() {
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
    }

    public void getSearchPage(String text) {
        WebElement search = driver.findElement(By.cssSelector(".header-search-input"));

        search.sendKeys(text);

        search.sendKeys(Keys.ENTER);
    }

}
