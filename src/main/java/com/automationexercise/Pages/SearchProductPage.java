package com.automationexercise.Pages;

import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.clicking;
import static com.automationexercise.Utilities.Utility.sendData;
import static com.automationexercise.Utilities.WaitsUtils.explicitlyWaitForVisibility;

public class SearchProductPage {
    private final WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }


    WebElement AllProductsPage = getDriver().findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'All Products')]"));
    By SearchField = By.xpath("//input[@id=\"search_product\"]");
    By SearchButton = By.xpath("//button[@id=\"submit_search\"]");
    WebElement SearchedSection = getDriver().findElement
            (By.xpath("//h2[@class=\"title text-center\" and contains(text(), 'Searched Products')]"));
    List<WebElement> SearchResults = getDriver().findElements
            (By.xpath("//div[@id=\"cartModal\"]//following::div[@class=\"col-sm-4\"]"));


    //Actions

    public void EnterProduct(String product) {
        explicitlyWaitForVisibility(driver, SearchField);
        sendData(driver, SearchField, product);
    }

    public void PressSearchButton() {
        explicitlyWaitForVisibility(driver, SearchButton);
        clicking(driver, SearchButton);
    }
    //Verify

    public Boolean VerifyUserNavigatedToAllProductsPage() {
        explicitlyWaitForVisibility(driver, (By) AllProductsPage);
        return AllProductsPage.isDisplayed();
    }


    public Boolean VerifySearchedProductsSectionVisible() {
        explicitlyWaitForVisibility(driver, (By) SearchedSection);
        return SearchedSection.isDisplayed();
    }

    public int VerifyAllProductRelatedToSearchVisible() {
        return SearchResults.size();
    }


}
