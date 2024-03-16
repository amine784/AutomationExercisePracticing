package com.automationexercise.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement clickElement(By element) {
        WebElement clickableElement = driver.findElement(element);
        clickableElement.click();
        return clickableElement;
    }

    public void WaitUntilVisibleElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void WaitUntilElementBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void scrollTillVisible(By element) {
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollToTopPage() {
        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0, 0)");
    }


    public void WaitTillVisibleAndClick(By element) {
        WaitUntilVisibleElement(element);
        clickElement(element);
    }

    public void WaitTillVisibleAndSendKeys(By element, String keyword) {
        WaitUntilVisibleElement(element);
        driver.findElement(element).sendKeys(keyword);
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void selectFromDropdownByValue(WebElement element, String value) {
        Select drop = new Select(element);
        drop.selectByValue(value);
    }

    public List<String> getAllSelectedOptions(By element) {
        return findDropDownElement(element)
                .getOptions()
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Select findDropDownElement(By element) {
        return new Select(driver.findElement(element));
    }

    public void selectFromDropdownByVisibleText(WebElement element, String VisibleText) {
        Select dropdown = new Select(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, VisibleText));
        dropdown.selectByVisibleText(VisibleText);
    }

    public void sendKeys(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void doubleTab(By element) {
        driver.findElement(element).sendKeys(Keys.TAB);
        driver.findElement(element).sendKeys(Keys.TAB);
    }

    public void ClearText(By element) {
        driver.findElement(element).clear();
    }

    public void ClearAndSendKeys(By element, String text) {
        ClearText(element);
        sendKeys(element, text);
    }


}