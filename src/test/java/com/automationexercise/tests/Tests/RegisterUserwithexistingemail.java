package com.automationexercise.tests.Tests;
import com.automationexercise.Pages.RegwithexistemailPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.automationexercise.DriverManager.DriverManager.getDriver;

public  class RegisterUserwithexistingemail
{
  @BeforeTest
    public void navigatetomywebpage()
  {

  }
  @Test(priority = 1)
    public void verifyhomepagevisiblesuccess()
  {
      String actualurl= getDriver().getCurrentUrl();
      System.out.println("Actual page is:"+actualurl);
      String expectedurl="https://automationexercise.com/#google_vignette";
      Assert.assertEquals(actualurl,expectedurl,"actual url not match with expected url");
  }
@Test(priority = 2)
    public void clickonsignupsignin_bttn()
{
    RegwithexistemailPage regwithexistemailPage=new RegwithexistemailPage(getDriver());
    regwithexistemailPage.SignupLogin_btton().click();
}
@Test(priority = 3)
    public void VerifyNewUserSignupvisible()
{

}
@Test(priority = 4)
    public void Enternameandalreadyregisteredemailaddress()
{
    RegwithexistemailPage regwithexistemailPage=new RegwithexistemailPage(getDriver());
    regwithexistemailPage.name_text().sendKeys("martina");
    regwithexistemailPage.emailaddress_txt().sendKeys("martina.jak22@gmail.com");

}
@Test(priority = 5)
    public void clickonsignupbttn()
{
    RegwithexistemailPage regwithexistemailPage=new RegwithexistemailPage(getDriver());
    regwithexistemailPage.signup_bttn().click();
}
@Test(priority = 6)
    public void verifyEmailAddressalreadyexist()
{

}
}



