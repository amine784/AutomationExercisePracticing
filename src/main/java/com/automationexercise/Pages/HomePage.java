package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    By ProductButton = By.xpath("//a[@href=\"/products\"]");
    WebElement AllProductsPage = driver.findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'All Products')]"));
    By SearchField = By.xpath("//input[@id=\"search_product\"]");
    By SearchButton = By.xpath("//button[@id=\"submit_search\"]");
    WebElement SearchedSection = driver.findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'Searched Products')]"));
    List<WebElement> SearchResults = driver.findElements
            (By.xpath("//div[@id=\"cartModal\"]//following::div[@class=\"col-sm-4\"]"));

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */

    public String VerifyHomePageVisible() {
        return driver.getCurrentUrl();
    }

    public void PressProductsButton() {
        WaitTillVisibleAndClick(ProductButton);
    }

    public Boolean VerifyUserNavigatedToAllProductsPage() {
        wait.until(ExpectedConditions.visibilityOf(AllProductsPage));
        return AllProductsPage.isDisplayed();
    }

    public void EnterProduct(String product) {
        WaitTillVisibleAndSendKeys(SearchField, product);
        clickElement(SearchButton);
    }

    public void PressSearchButton() {
        WaitTillVisibleAndClick(SearchButton);
    }

    public Boolean VerifySearchedProductsSectionVisible() {
        return SearchedSection.isDisplayed();
    }

    public int VerifyAllProductRelatedToSearchVisible() {
        return SearchResults.size();
    }

}
