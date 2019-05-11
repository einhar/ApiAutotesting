package com.ehr.gui.login;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageActController {

    private WebDriver driver = DriverFactory.getDriver();

    public void loginAs(String username, String password) {

        WebElement usernameInput = driver.findElement(By.cssSelector("#login_field"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
    }
}
