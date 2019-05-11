package com.ehr.gui.user;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserPageVerifyController {

    private WebDriver driver = DriverFactory.getDriver();

    public UserPageVerifyController verifyUsername(String username) {

        WebElement nickname = driver.findElement(By.cssSelector(".p-nickname"));

        assertThat(nickname.getText(), is(username));
        return this;
    }

}
