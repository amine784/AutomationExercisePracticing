package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automationexercise.Utilities.Utility.clicking;

public class P01_HomePage {


    private final WebDriver driver;

    private final By ProductButton = By.xpath("//a[@href=\"/products\"]");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void ADS() {
        try {
            WebElement IframeElement = driver.findElement(By.cssSelector("[id=\"aswift_6\"]"));
            driver.switchTo().frame(IframeElement);
            WebElement ad = driver.findElement(By.cssSelector("[id=\"dismiss-button\"]"));
            if (ad.isDisplayed()) {
                ad.click();
                LogUtils.info("Ad clicked");
            } else {

                System.out.println("No ads appeared");
            }
        } catch (Exception e) {
            LogUtils.error("Cannot click on ads");
        }
    }


    /**
     * This method is used to click on the products button on the home page
     */
    public P02_SearchProductPage pressProductsButton() {
        clicking(driver, ProductButton);
        LogUtils.info("Clicked on product button");
        return new P02_SearchProductPage(driver);
    }
}
