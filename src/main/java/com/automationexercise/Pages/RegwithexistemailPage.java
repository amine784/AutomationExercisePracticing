package com.automationexercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegwithexistemailPage {
    WebDriver driver;
    public RegwithexistemailPage(WebDriver driver)
    {
        this.driver=driver;
    }
public WebElement SignupLogin_btton()
    {
        By signuplogin=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        WebElement signuploginEle=driver.findElement(signuplogin);
        return signuploginEle;
    }
    public WebElement name_text()
    {
        By nametxt=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
        WebElement nametxtEle=driver.findElement(nametxt);
        return nametxtEle;
    }
    public WebElement emailaddress_txt()
    {
        By emailaddresstxt=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
        WebElement emailaddresstxtEle=driver.findElement(emailaddresstxt);
        return emailaddresstxtEle;
    }
    public WebElement signup_bttn()
    {
        By signupbttn=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
        WebElement signupbttnEle=driver.findElement(signupbttn);
        return signupbttnEle;
    }
}
