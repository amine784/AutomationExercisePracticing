package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

import static io.opentelemetry.semconv.SemanticAttributes.EventDomainValues.BROWSER;
import static org.openqa.selenium.devtools.v122.fedcm.FedCm.openUrl;

public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void verifyHomePage() {
        Assert.assertEquals(new HomePage(DriverManager.getDriver()).VerifyHomePageVisible(),
                "https://automationexercise.com/", "You are not in HOMEPAGE");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
