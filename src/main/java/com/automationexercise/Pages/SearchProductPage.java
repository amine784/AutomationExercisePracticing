package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchProductPage extends BasePage {
    public SearchProductPage(WebDriver driver) {
        super(driver);
    }


    WebElement AllProductsPage = driver.findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'All Products')]"));
    By SearchField = By.xpath("//input[@id=\"search_product\"]");
    By SearchButton = By.xpath("//button[@id=\"submit_search\"]");
    WebElement SearchedSection = driver.findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'Searched Products')]"));
    List<WebElement> SearchResults = driver.findElements
            (By.xpath("//div[@id=\"cartModal\"]//following::div[@class=\"col-sm-4\"]"));


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
        WaitUntilVisibleElement((By) SearchedSection);
        return SearchedSection.isDisplayed();
    }

    public int VerifyAllProductRelatedToSearchVisible() {
        return SearchResults.size();
    }


}
