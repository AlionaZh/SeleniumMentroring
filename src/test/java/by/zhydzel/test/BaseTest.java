package by.zhydzel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    public WebDriver driver;


    @BeforeClass
    public void setup() {

        //Create a Chrome driver. All test and page classes use this driver.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait waiter = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

