package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.Utility.clicking;

public class HomePage {


    private final WebDriver driver;

    By ProductButton = By.xpath("//a[@href=\"/products\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * This method is used to click on the products button on the home page
     */
    public void pressProductsButton() {
        WaitsUtils.explicitlyWaitForClickability(driver, ProductButton);
        clicking(driver, ProductButton);
        new SearchProductPage(driver);
    }


}
