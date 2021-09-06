package by.zhydzel;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartGoogleMailPage extends by.zhydzel.GoogleMailBasePage {

    public StartGoogleMailPage(WebDriver driver) {

        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://cloud.google.com/";

    //*********Web Elements Init********

    @FindBy(xpath = "//input[@aria-label=\"Search\"]")
    WebElement InputSearch;
    @FindBy(xpath = "(//a[@data-ctorig='https://cloud.google.com/products/calculator'])[1]")
    WebElement LinkPricingCalculator;


    //*********Page Methods*********
    public void goToStartGooglePage() {

        driver.get(baseURL);
    }

    //Go to CalculatorPage
    public void goToCalculatorPage() {
        InputSearch.click();
        InputSearch.sendKeys("Google Cloud Platform Pricing Calculator");
        InputSearch.sendKeys(Keys.ENTER);
        waitForWebElementVisible(LinkPricingCalculator);
    //    delayBrowser(2000);
        LinkPricingCalculator.click();

    }


}

