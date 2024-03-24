package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P02_RegisterWithExistingEmailPage;
import com.automationexercise.Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.VerifyURL;

public class TC05_RegisterWithExistingEmailTest {
    private final String NAME = getJsonData("ExistedRegistrationData", "name");
    private final String EMAIL = getJsonData("ExistedRegistrationData", "email");
    private final String SIGNUP_MSG = getJsonData("ExistedRegistrationData", "message");
    private final String ERROR_MSG = getJsonData("ExistedRegistrationData", "error message");

    @BeforeMethod
    public void setUp() {
        DriverFactory.createInstance(getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(getEnvironmentPropertyValue("BASE_URL"));
    }

    @Test
    public void navigate_to_signup_page() {
        Assert.assertTrue(VerifyURL(getDriver(), getEnvironmentPropertyValue("BASE_URL")));

        new P02_RegisterWithExistingEmailPage(getDriver())
                .clickOnSignupLoginButton();

        Assert.assertTrue(new P02_RegisterWithExistingEmailPage(getDriver())
                .verifyThatNewUserSignupAppears(SIGNUP_MSG));

        new P02_RegisterWithExistingEmailPage(getDriver())
                .enterSignupInfo(NAME, EMAIL)
                .clickOnSignupButton();

        Assert.assertTrue(new P02_RegisterWithExistingEmailPage(getDriver())
                .verifyThatErrorMessageAppears(ERROR_MSG));

    }


    @AfterMethod
    public void quit() {
        DriverManager.quit();
    }
}



