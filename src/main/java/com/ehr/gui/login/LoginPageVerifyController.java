package com.ehr.gui.login;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class LoginPageVerifyController {

    private WebDriver driver = DriverFactory.getDriver();

    public LoginPageVerifyController verifyFailedSignIn() {

        String text = driver.findElement(By.cssSelector(".flash > .container")).getText();

        assertThat(text, equalToIgnoringCase("Incorrect username or password."));

        return this;
    }

}
