package com.automationexercise.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverManager {
public static WebDriver driver;
public static final String BrowserName = "chrome";
public static final String   Website="https://automationexercise.com/";


    @BeforeClass

    public void setup() {

        if (BrowserName.equalsIgnoreCase("CHROME")) {

            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            //Remove the "enable automation" Bar , also remove save passwords Menu
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            //This line for updated version for chrome
            options.addArguments("--remote-allow-origins=*");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);

        }

        else if ( BrowserName.equalsIgnoreCase("FIREFOX")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if ( BrowserName.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        else{

            System.out.println("Browser Name is not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Website);
    }
}
