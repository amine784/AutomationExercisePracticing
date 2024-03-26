package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automationexercise.Utilities.Utility.*;

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

    //  Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    private final By SubscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By ScrollUpButton = By.cssSelector("[id=\"scrollUp\"]");
    private final By HeaderText = By.cssSelector("div[class='item active'] div[class='col-sm-6'] h2");

    /**
     * This method is used to scroll to the bottom of the home page
     */
    public P01_HomePage scrollToBottom() {
        scrollToElementAtBottom(driver, SubscriptionText);
        return this;
    }

    /**
     * This method is used to verify scroll down to the bottom of the home page
     */
    public P01_HomePage verifyScrollDown() {
        verifyElementVisible(SubscriptionText);
        LogUtils.info("SubscriptionText:" + getText(driver, SubscriptionText));
        return this;
    }

    /**
     * This method is used scrollUp on the home page
     */
    public P01_HomePage pressScrollUpButton() {
        clicking(driver, ScrollUpButton);
        return this;
    }

    /**
     * This method is used to verify scrollUP to the top of the home page
     */
    public P01_HomePage verifyScrollUp() {
        verifyElementVisible(HeaderText);
        LogUtils.info("HeaderText:" + getText(driver, HeaderText));
        return this;
    }

    public P01_HomePage scrollToUpWithOutArrowButton() {
        scrollToElementAtTop(driver, HeaderText);
        return this;

    }
}