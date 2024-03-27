package com.automationexercise.tests.Tests;

import com.automationexercise.DriverManager.DriverFactory;
import com.automationexercise.DriverManager.DriverManager;
import com.automationexercise.Pages.P01_RegisterPage;
import com.automationexercise.Utilities.Utility;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverFactory.createInstance;
import static com.automationexercise.DriverManager.DriverManager.getDriver;
import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.DataUtils.getJsonData;
import static com.automationexercise.Utilities.Utility.VerifyURL;
import static com.automationexercise.Utilities.Utility.getTimestamp;

public class TC01_RegisterTest {
    //JSONObject user = new JSONObject();
    // public final String PASSWORD = getJsonData("registerData", "password");
    private final String NAME = getJsonData("ExistedRegistrationData", "name");
    private final String EMAIL = getJsonData("ExistedRegistrationData", "email");
    private final String SIGNUP_MSG = getJsonData("ExistedRegistrationData", "message");
    private final String ERROR_MSG = getJsonData("ExistedRegistrationData", "error message");
    private final String emailTimestamp = getJsonData("ExistedRegistrationData", "emailTimestamp") + getTimestamp() + "@gmail.com";
    private final String fullNameRegister = getJsonData("ExistedRegistrationData", "fullNameRegister");

    String jsonString = """
        {
          "userData": {
            "email": "testEmail_",
            "password": "Ashraf",
            "errorMessage": "Your email or password is incorrect!",
            "daysSelect" : "12",
            "monthsSelect" : "January",
            "yearsSelect" : "1980",
            "firstNameInput": "amine",
            "lastNameInput" : "bcf",
            "companyNameInputFeald" : "code cooperation",
            "addressOneInput" : "address one input form",
            "addresstWOInput" : "addresstWOInputtt",
            "countrySelect" : "Canada",
            "stateInput" : "state input text",
            "cityInput"  : "city input one col",
            "zipcodeInput" : "zip code 8000",
            "mobileNumberInput" : "+21620789093"
          }
        };
        """;
    JSONObject jsonObject = new JSONObject(jsonString);





    //WebDriver driver = BrowserFactory.CHROME.createDriver();
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        //createInstance("chrome");
        //openWebsite("https://automationexercise.com/");
        createInstance(getEnvironmentPropertyValue("BROWSER"));
        Utility.openWebsite(getEnvironmentPropertyValue("BASE_URL"));
        new P01_RegisterPage(getDriver()).navigateToRegisterPage();

    }

    @Test
    public void RegisterSuccess(){


        new P01_RegisterPage(getDriver())
                .createAccountButtonHeader()
                .setSignUpNewUser(fullNameRegister,emailTimestamp)
                .setFormNewUserFull(jsonObject)
                .createAccount();

        Assert.assertTrue(new P01_RegisterPage(getDriver()).checkSuccessMessageAccountCreated("ACCOUNT CREATED!"));
        //String message = new RegisterUserPage(getDriver(),checkMessageAccountCreated());

        String test = new P01_RegisterPage(getDriver()).checkMessageAccountCreated();
        //System.out.println(test);
        JSONObject userData = jsonObject.getJSONObject("userData");
        //System.out.println(userData.get("daysSelect") + "SUCCESS MESSAGE READ JSON");
    }

    @Test
    public void RegisterWithExistingEmailPage() {
        Assert.assertTrue(VerifyURL(getDriver(), getEnvironmentPropertyValue("REGISTER_URL")));

        new P01_RegisterPage(getDriver())
                .clickOnSignupButton();

        Assert.assertTrue(new P01_RegisterPage(getDriver())
                .verifyThatNewUserSignupAppears(SIGNUP_MSG));

        new P01_RegisterPage(getDriver())
                .enterSignupInfo(NAME, EMAIL)
                .clickOnSignupButton();

        Assert.assertTrue(new P01_RegisterPage(getDriver())
                .verifyThatErrorMessageAppears(ERROR_MSG));

    }


    @AfterMethod
    public void quit(){
        DriverManager.quit();
    }

}



