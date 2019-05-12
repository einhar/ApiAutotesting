package com.ehr.gui.user;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserPageActController {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getDriverWait();

    public String getUserName() {
        By locator = By.cssSelector(".p-nickname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement nickname = driver.findElement(locator);
        return nickname.getText();
    }

    public int getUserFollowers() {
        By xpath = By.xpath("//div[contains(@class, 'UnderlineNav')]//a[contains(text(), 'Followers')]//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement followers = driver.findElement(xpath);
        String text = followers.getText();
        text = text.replaceAll("\\D+", "");
        return Integer.parseInt(text);
    }

    public LocalDateTime getUserJoinedDate() {
        By xpath = By.xpath("//div[@class='js-profile-editable-area']//relative-time");

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement dateElement = driver.findElement(xpath);
        String text = dateElement.getAttribute("datetime").replaceAll("Z", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        return LocalDateTime.parse(text, formatter);
    }

    public void backPage() {
        ((FirefoxDriver) driver).executeScript("window.history.go(-1)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
