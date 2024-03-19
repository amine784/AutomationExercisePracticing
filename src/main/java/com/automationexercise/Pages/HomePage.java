package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    By ProductButton = By.xpath("//a[@href=\"/products\"]");


    public String VerifyHomePageVisible() {
        return driver.getCurrentUrl();
    }

    public String ADS() {
        WebElement ad = driver.findElement(
                By.xpath("//span[@dir=\"auto\" and contains(text(),\"Close\")]"));
        WebElement ad2 = driver.findElement
                (By.xpath("//div[@id=\"dismiss-button\"]"));

        if (ad.isDisplayed())
            ad.click();
        else if(ad2.isDisplayed()){
            ad2.click();
        }
        else{
            System.out.println("No ads appeared");
        }
        return "Ads Closed";
    }

    public SearchProductPage PressProductsButton() {
        WaitTillVisibleAndClick(ProductButton);
        return new SearchProductPage(driver);
    }


}
