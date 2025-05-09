package Base;

import Utilities.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {

    public WebDriver driver ;

    @Parameters("browser")
    @BeforeMethod
    public void preconditions(@Optional("edge") String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Parameters("browser")
    @AfterMethod
    public void takeScreenShot(ITestResult testResult , @Optional("edge") String browser)
    {
        if(ITestResult.FAILURE == testResult.getStatus())
        {
            ScreenShots.takeScreenShot(driver , testResult.getName() , browser);
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}



