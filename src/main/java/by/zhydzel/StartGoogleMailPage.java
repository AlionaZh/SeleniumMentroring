package by.zhydzel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartGoogleMailPage extends by.zhydzel.GoogleMailBasePage {

    public StartGoogleMailPage(WebDriver driver) {

        super(driver);
    }
      //*********Web Elements Init********

    @FindBy(xpath = "//input[@aria-label=\"Search\"]")
    WebElement InputSearch;
    @FindBy(xpath = "(//a[@data-ctorig='https://cloud.google.com/products/calculator'])[1]")
    WebElement LinkPricingCalculator;


    //*********Page Methods*********
    public void goToStartGooglePage() {
            String baseURL = "https://cloud.google.com/";
            driver.get(baseURL);
    }

    //Go to CalculatorPage
    public void goToCalculatorPage() {
        InputSearch.click();
        InputSearch.sendKeys("Google Cloud Platform Pricing Calculator");
        InputSearch.sendKeys(Keys.ENTER);
        waitForWebElementVisible(LinkPricingCalculator);
        LinkPricingCalculator.click();
    }
}

