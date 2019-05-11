package com.ehr.gui.search;

import com.ehr.gui.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageActController {

    private WebDriver driver = DriverFactory.getDriver();

    public SearchPageActController searchForString(String text) {
        WebElement search = driver.findElement(By.cssSelector(".header-search-input"));
        search.clear();
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);

        return this;
    }

    public SearchPageActController selectUserSortOrder(SortUser userSortOrder) {

        WebElement dropDownMenu = driver.findElement(By.cssSelector(".select-menu-button"));
        dropDownMenu.click();

        WebElement dropDownMenuElement = driver.findElement(By.xpath("//div[@class='select-menu-list']//span[contains(text(),'" + userSortOrder + "')]/parent::a"));
        dropDownMenuElement.click();

        return this;
    }

    public SearchPageActController selectNaviFilter(SearchNavi naviFilter) {

        WebElement a = driver.findElement(
                By.xpath("//nav[contains(@class,'menu border')]/a[contains(text(), '" + naviFilter + "') and contains(@class, 'menu-item')]"));
        // TODO: take care if choosen navi filter is selected before,
        //  have in mind that: one element always has 'contains(@class, 'menu-item selected')

        a.click();

        return this;
    }

    public void goToUserSearchResult(int position) {

        WebElement element = driver.findElement(By.cssSelector(".user-list-item:nth-child(" + position + ") em"));
        element.click();
    }
}
