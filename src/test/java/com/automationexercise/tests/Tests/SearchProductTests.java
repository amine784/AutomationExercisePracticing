package com.automationexercise.tests.Tests;

import Base.BaseTest;
import com.automationexercise.Pages.SearchProductPage;
import org.testng.annotations.Test;

public class SearchProductTests extends BaseTest {
    SearchProductPage search;

    @Test
    public void testSearch() {

        search = homePage.PressProductsButton();
        try {
            homePage.ADS();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        soft.assertTrue(search.VerifyUserNavigatedToAllProductsPage());
        search.EnterProduct("Tshirt");
        search.PressSearchButton();
        soft.assertTrue(search.VerifySearchedProductsSectionVisible());
        soft.assertEquals(search.VerifyAllProductRelatedToSearchVisible(), 6);
        soft.assertAll();
    }

}
