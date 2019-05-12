package com.ehr.gui.search;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class SearchPageActController {

    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = DriverFactory.getDriverWait();

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(2000);
            wait.until(expectation);
        } catch (Throwable error) {
            fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public SearchPageActController searchForString(String text) {
        WebElement search = driver.findElement(By.cssSelector(".header-search-input"));
        search.clear();
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
        waitForPageLoaded();

        return this;
    }

    public SearchPageActController selectUserSortOrder(SortUser userSortOrder) {

        By dropDownMenu = By.cssSelector(".select-menu-button");
        wait.until(ExpectedConditions.elementToBeClickable(dropDownMenu));
        driver.findElement(dropDownMenu).click();

        // implicit wait due to transitive drop down list
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        By dropDownMenuElement = By.xpath("//div[@class='select-menu-list']//span[contains(text(),'" + userSortOrder + "')]/parent::a");
        wait.until(ExpectedConditions.elementToBeClickable(dropDownMenuElement));
        driver.findElement(dropDownMenuElement).click();

        return this;
    }

    public SearchPageActController selectNaviFilter(SearchNavi naviFilter) {

        By xpath = By.xpath("//nav[contains(@class,'menu border')]/a[contains(text(), '" + naviFilter + "') and contains(@class, 'menu-item')]");
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
        // TODO: take care if choosen navi filter is selected before,
        //  have in mind that: one element always has 'contains(@class, 'menu-item selected')

        return this;
    }

    public void goToUserSearchResult(int position) {
        By locator = By.cssSelector(".user-list-item:nth-child(" + position + ") img");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
}
