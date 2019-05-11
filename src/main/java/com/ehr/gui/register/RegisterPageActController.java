package com.ehr.gui.register;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageActController {

    private WebDriver driver = DriverFactory.getDriver();

    public RegisterPageActController registerUser(String username, String email, String password) {
        WebElement input;
        input = driver.findElement(By.cssSelector("#user_login"));
        input.clear();
        input.sendKeys(username);

        input = driver.findElement(By.cssSelector("#user_email"));
        input.clear();
        input.sendKeys(email);

        input = driver.findElement(By.cssSelector("#user_password"));
        input.clear();
        input.sendKeys(email);

        driver.findElement(By.cssSelector("#signup_button"));

        return this;
    }
}
