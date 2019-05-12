package com.ehr.gui.user;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserPageVerifyController {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getDriverWait();

    public UserPageVerifyController verifyUsername(String username) {

        By locator = By.cssSelector(".p-nickname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement nickname = driver.findElement(locator);

        assertThat(nickname.getText(), is(username));
        return this;
    }

}
