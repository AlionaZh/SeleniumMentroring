package by.zhydzel.test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;

   /* ExtentReports extent;
    ExtentTest test;*/

    @BeforeClass
    public void setup() {

        //Create a Chrome driver. All test and page classes use this driver.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait waiter = new WebDriverWait(driver, 5);

    }



    @AfterClass
    public void teardown() {

        driver.quit();
    }



}

