package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_HomePage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.Utility.VerifyURL;

public class ScrollTests {
    SoftAssert soft = new SoftAssert();

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
 */
    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void verifyHomePage() {
        VerifyURL(getDriver(), DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void verifyScrollDown() {
        new P01_HomePage(getDriver()).VerifyScrollDown();

    }

    @Test
    public void verifyScrollUp() {
        new P01_HomePage(getDriver()).VerifyScrollUp();

    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}

