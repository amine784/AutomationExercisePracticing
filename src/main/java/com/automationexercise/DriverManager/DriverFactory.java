package com.acuanix.geo.DriverUtils;

import org.openqa.selenium.WebDriver;

import static com.acuanix.geo.DriverUtils.DriverManager.setDriver;

public class DriverFactory {


    public static void createInstance(String browser) {
        WebDriver driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        setDriver(driver);
    }

}
