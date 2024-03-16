package Base;

import com.automationexercise.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public static final String BASE_URL = "https://automationexercise.com/";
    public WebDriver driver;
    protected SoftAssert soft;
    public HomePage homePage;

    @BeforeTest
    public void setUp()  {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        soft = new SoftAssert();

    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

//    @AfterMethod
//    public void take_screenShot(ITestResult result) throws IOException {
//        System.out.println(result.getStatus());
//        System.out.println("Taking Screenshot...");
//        TakesScreenshot sc = (TakesScreenshot) driver;
//        File photo = sc.getScreenshotAs(OutputType.FILE);
//        if (ITestResult.SUCCESS == result.getStatus()) {
//            FileUtils.copyFile(photo, new File("./SuccessTest_screenshots/" + result.getName() + ".png"));
//        } else
//            FileUtils.copyFile(photo, new File("./FAiledTests_Screenshots/" + result.getName() + ".png"));
//    }
}
