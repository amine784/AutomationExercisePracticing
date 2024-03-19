package com.automationexercise.tests.Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void VerifyHomePage() {
        try {
            homePage.ADS();
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        soft.assertEquals(homePage.VerifyHomePageVisible(), "https://automationexercise.com/", "You are not in HOMEPAGE");
        soft.assertAll();

    }
}
