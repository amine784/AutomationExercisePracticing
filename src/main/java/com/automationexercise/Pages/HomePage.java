package com.automationexercise.Pages;

import com.automationexercise.Utilities.Utility;
import com.automationexercise.Utilities.WaitsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.Utilities;

public class HomePage {


    private final WebDriver driver;

    By ProductButton = By.xpath("//a[@href=\"/products\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public String ADS() {
        WebElement ad = driver.findElement(
                By.xpath("//span[@dir=\"auto\" and contains(text(),\"Close\")]"));
        WebElement ad2 = driver.findElement
                (By.xpath("//div[@id=\"dismiss-button\"]"));

        if (ad.isDisplayed())
            ad.click();
        else if (ad2.isDisplayed()) {
            ad2.click();
        } else {
            System.out.println("No ads appeared");
        }
        return "Ads Closed";
    }

    public SearchProductPage PressProductsButton() {
        WaitsUtils.explicitlyWaitForClickability(driver, ProductButton);
        return new SearchProductPage(driver);
    }

    // Verify
    public String VerifyHomePageVisible() {
        return driver.getCurrentUrl();
    }


}
