package com.automationexercise.Pages;

import com.automationexercise.Utilities.LogUtils;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.automationexercise.Utilities.DataUtils.getEnvironmentPropertyValue;
import static com.automationexercise.Utilities.Utility.*;

public class P01_RegisterPage {

    //click button in the header
    private final By createAccountButtonHeader = By.cssSelector("a[href='/login']");

    //input feald name && email then signup button to redirect to the form page
    private final By signUpName = By.xpath("//input[@data-qa='signup-name']");
    private final By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    private final By errorMsg = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
    private final By newUserSignupMessage = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");

    //radio button for selecting gender
    private final By genderMrRadioButton = By.id("id_gender1");
    private final By genderMrsRadioButton = By.id("id_gender2");

    //password feald
    private final By passwordFeald = By.id("password");


    //selecting date  of birth
    private final By daysSelect = By.id("days");
    private final By monthsSelect = By.id("months");
    private final By yearsSelect = By.id("years");

    //newsletter && spec offers optin
    private final By signUpForNewsletter = By.id("years");
    private final By specsOffersoptin = By.id("optin");


    //first name && lastname
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");

    //cmpany company
    private final By companyNameInputFeald = By.id("company");

    private final By addressOneInput = By.id("address1");
    private final By addresstWOInput = By.id("address2");

    private final By countrySelect = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");

    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    private final By accountCreated = By.xpath("//h2[@data-qa='account-created']");

    //define Driver
    private  final WebDriver driver;

    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_RegisterPage createAccountButtonHeader(){
        clicking(driver,createAccountButtonHeader);
        return this;
    }



    public P01_RegisterPage setSignUpNewUser(String signupname, String signemail){
        sendData(driver,signUpName,signupname);
        sendData(driver,signUpEmail,signemail);
        clicking(driver,signUpButton);
        return this;
    }


    public P01_RegisterPage setFormNewUserFull(JSONObject userFull){
        //select checkbox of Mr
        clicking(driver,genderMrRadioButton);

        //Putting a password in  field paswword
        System.out.println( userFull.toString());

        //System.out.println(Optional.ofNullable(JsonPath.read(userFull, "$.userData.password")));
        String json = "{\"userData\":{\"companyNameInputFeald\":\"code cooperation\",\"yearsSelect\":\"1980\",\"addresstWOInput\":\"addresstWOInputtt\",\"monthsSelect\":\"January\",\"errorMessage\":\"Your email or password is incorrect!\",\"cityInput\":\"city input one col\",\"daysSelect\":\"12\",\"zipcodeInput\":\"zip code 8000\",\"mobileNumberInput\":\"+21620789093\",\"firstNameInput\":\"amine\",\"stateInput\":\"state input text\",\"password\":\"Ashraf\",\"countrySelect\":\"Canada\",\"lastNameInput\":\"bcf\",\"addressOneInput\":\"address one input form\",\"email\":\"testEmail_\"}}";

        String password = JsonPath.parse(userFull.toString()).read("$.userData.password");
        //String password = JsonPath.parse(json).read("$.userData.password");
        System.out.println("Password a afficher: " + password);


        sendData(driver,passwordFeald,password);

        //select date from date picker
        selectFromDropDown(driver,daysSelect,JsonPath.parse(userFull.toString()).read("$.userData.daysSelect"));
        selectFromDropDown(driver,monthsSelect,JsonPath.parse(userFull.toString()).read("$.userData.monthsSelect"));
        selectFromDropDown(driver,yearsSelect,JsonPath.parse(userFull.toString()).read("$.userData.yearsSelect"));

        // select the two checkbox  for newlatter && scpec offers
        clicking(driver,signUpForNewsletter);
        clicking(driver,specsOffersoptin);



        //putting first name
        sendData(driver,firstNameInput,JsonPath.parse(userFull.toString()).read("$.userData.firstNameInput"));

        //putting laste name
        sendData(driver,lastNameInput,JsonPath.parse(userFull.toString()).read("$.userData.lastNameInput"));

        //putting company name
        sendData(driver,companyNameInputFeald,JsonPath.parse(userFull.toString()).read("$.userData.companyNameInputFeald"));

        // putting adresse One
        sendData(driver,addressOneInput,JsonPath.parse(userFull.toString()).read("$.userData.addressOneInput"));

        // putting adresse Two
        sendData(driver,addresstWOInput,JsonPath.parse(userFull.toString()).read("$.userData.addresstWOInput"));

        //SELECT CITY
        selectFromDropDown(driver,countrySelect,JsonPath.parse(userFull.toString()).read("$.userData.countrySelect"));


        sendData(driver,stateInput,JsonPath.parse(userFull.toString()).read("$.userData.stateInput"));
        sendData(driver,cityInput,JsonPath.parse(userFull.toString()).read("$.userData.cityInput"));

        //putting zipcode
        sendData(driver,zipcodeInput,JsonPath.parse(userFull.toString()).read("$.userData.zipcodeInput"));

        //putting mobile number
        sendData(driver,mobileNumberInput,JsonPath.parse(userFull.toString()).read("$.userData.mobileNumberInput"));

        return this;
    }

    public void navigateToRegisterPage(){

        openWebsite(getEnvironmentPropertyValue("REGISTER_URL"));
    }

    public void  createAccount(){
        clicking(driver,createAccountButton);
    }


    //Validations
    public boolean checkSuccessMessageAccountCreated(String expectedText) {
        return verifyEquals(accountCreated, expectedText);
    }

    public String checkMessageAccountCreated() {
        return verifyTextAccountCreated(accountCreated);
    }






    ////////////////////////////////////////////////////////////
    public P01_RegisterPage enterSignupInfo(String nameParam, String emailParam) {
        sendData(driver, this.signUpName, nameParam);
        LogUtils.info("Name: " + nameParam);
        sendData(driver, this.signUpEmail, emailParam);
        LogUtils.info("Email: " + emailParam);
        return this;
    }

    public P01_RegisterPage clickOnSignupButton() {
        clicking(driver, signUpButton);
        return this;
    }

    //Validations
    public boolean verifyThatErrorMessageAppears(String expectedText) {
        return verifyEquals(errorMsg, expectedText);

    }

    public boolean verifyThatNewUserSignupAppears(String expectedText) {
        return verifyEquals(newUserSignupMessage, expectedText);
    }

}
