package Tests;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class WebDriverSettings {

    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    public static WebDriverWait wait;
    public static Screenshot screen;


    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Program File\\apache-maven-3.6.3\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        screen = new Screenshot();
        wait = new WebDriverWait(chromeDriver, 10);
        driver.register(screen);
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void TearDown() {

        driver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) {
        if (!result.isSuccess()) {
            TakeAScreenshot();
        }
    }

    @Attachment(value = "Tests.Screenshot")
    public byte[] TakeAScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

