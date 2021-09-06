package by.zhydzel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleMailBasePage {


    public WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    //Constructor
    public GoogleMailBasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public WebElement waitForWebElementVisible(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    //Delay for Browser
    public static int delayBrowser(int DelayBrowser) {
        try {
            Thread.sleep(DelayBrowser);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return DelayBrowser;
    }

}