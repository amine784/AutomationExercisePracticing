package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;

import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.LogUtils;
import com.automationexercise.Utilities.Utility;

import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.VerifyURL;


public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void verifyHomePage() {
        VerifyURL(getDriver(), DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
