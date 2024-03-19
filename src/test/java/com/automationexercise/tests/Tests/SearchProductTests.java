package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.HomePage;
import com.automationexercise.Pages.SearchProductPage;
import com.automationexercise.Utilities.DataUtils;
import com.automationexercise.Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public class SearchProductTests {

    /**
     * Sets up the test by creating a new instance of the WebDriver and navigating to the website.
     */
    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(DataUtils.getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(DataUtils.getEnvironmentPropertyValue("BASE_URL"));
    }

    /**
     * Tests the search functionality of the website.
     */
    @Test
    public void userSearchForProduct() {
        // navigate to the products page
        new HomePage(getDriver()).PressProductsButton();

        // verify that the user is navigated to the all products page
        Assert.assertTrue(new SearchProductPage(getDriver()).VerifyUserNavigatedToAllProductsPage());

        // search for a product
        new SearchProductPage(getDriver()).EnterProduct("T-shirt");
        new SearchProductPage(getDriver()).PressSearchButton();

        // verify that the searched products section is visible
        Assert.assertTrue(new SearchProductPage(getDriver()).VerifySearchedProductsSectionVisible());

        // verify that all the products related to the search are visible
        Assert.assertEquals(new SearchProductPage(getDriver()).VerifyAllProductRelatedToSearchVisible(), 6);
    }

    /**
     * Cleans up the state of the test by quitting the WebDriver instance.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
