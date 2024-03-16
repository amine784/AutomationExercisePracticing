package com.automationexercise.tests.Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void test() {
        soft.assertEquals(homePage.VerifyHomePageVisible(), "https://automationexercise.com/", "You are not in HOMEPAGE");
        homePage.PressProductsButton();
        soft.assertTrue(homePage.VerifyUserNavigatedToAllProductsPage());
        homePage.EnterProduct("Tshirt");
        homePage.PressSearchButton();
        soft.assertTrue(homePage.VerifySearchedProductsSectionVisible());
        soft.assertEquals(homePage.VerifyAllProductRelatedToSearchVisible(), 6);

    }
}
