package Base;

import com.automationexercise.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public static final String BASE_URL = "https://automationexercise.com/";
    protected WebDriver driver;
    protected SoftAssert soft;
    public HomePage homePage;

    @BeforeTest
    public void setUp() {
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
        driver.quit();
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
