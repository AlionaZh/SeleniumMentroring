package by.zhydzel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class RegistrationPage extends by.zhydzel.GoogleMailBasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements Init********
    @FindBy(xpath = "(//input[@name=\"quantity\"])[1]")
    WebElement NumberOfInstances;
    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.os\"]")
    WebElement OperatingSystem;
    @FindBy(xpath = "//md-option[@value=\"free\"]")
    WebElement OperatingSystemOption;
    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.class\"]")
    WebElement MachineClass;
    @FindBy(xpath = "//md-option[@value=\"regular\"]")
    WebElement MachineClassOption;
    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.series\"]")
    WebElement Series;
    @FindBy(xpath = "//*[contains(text(),'N1')]//parent::md-option")
    WebElement SeriesOption;
    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.instance\"]")
    WebElement MachineType;
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]")
    WebElement MachineTypeOption;
    @FindBy(xpath = "(//md-checkbox[@aria-label=\"Add GPUs\"])[1]")
    WebElement AddGPUs;
    @FindBy(xpath = "//md-select[@placeholder=\"Number of GPUs\"]")
    WebElement NumberOfGPUs;
    @FindBy(xpath = "//md-option[@id=\"select_option_437\"]")
    WebElement NumberOfGPUsOption;
    @FindBy(xpath = "//md-select[@placeholder=\"GPU type\"]")
    WebElement GPUType;
    @FindBy(xpath = "//md-option[@value=\"NVIDIA_TESLA_V100\"]")
    WebElement GPUTypeOption;
    @FindBy(xpath = "//md-select[@placeholder=\"Local SSD\"]")
    WebElement LocalSSD;
    @FindBy(xpath = "//*[contains(text(),'2x375 GB')]//parent::md-option")
    WebElement LocalSSDOption;
    @FindBy(xpath = "//md-select[@placeholder=\"Datacenter location\"]")
    WebElement DataCenterLocation;
    @FindBy(xpath = "(//*[contains(text(),' Frankfurt (europe-west3)')]//parent::md-option)[3]")
    WebElement DataCenterLocationOption;
    @FindBy(xpath = "//md-select[@placeholder=\"Committed usage\"]")
    WebElement CommittedUsage;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/descendant::md-option[@ng-value='1'][@value='1']")
    WebElement CommittedUsageOption;
    @FindBy(xpath = "(//button[@aria-label=\"Add to Estimate\"])[1]")
    WebElement AddToEstimate;
    @FindBy(xpath = "//h2/b")
    WebElement TotalEstimatedCost;
    @FindBy(xpath = "//button[@aria-label=\"Email Estimate\"]")
    WebElement ButtonEmailEstimate;
    @FindBy(xpath = "//*[@id=\"eposta_adres\"]")
    WebElement CreatedEmailAddress;
    @FindBy(xpath = "//input[@ng-model=\"emailQuote.user.email\"]")
    WebElement EmailForLetter;
    @FindBy(xpath = "//*[@aria-label=\"Send Email\"]")
    WebElement ButtonSendEmail;
    @FindBy(xpath = "//*[@class=\"mailler\"]/li[2]/a")
    WebElement ReceivedMessage;
    @FindBy(xpath = "//*[@class=\"mailler\"]/li[2]/a")
    WebElement ReceivedMessage1;
    @FindBy(xpath = "//*[contains(text(),'Total Estimated Monthly Cost')]/parent::td/following-sibling::*/h3")
    WebElement EmailBody;

    public String CheckSumInLetter, CheckSumFirst;


    public void fillRegisterForm() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        NumberOfInstances.sendKeys("4");
        OperatingSystem.click();
        OperatingSystemOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 35);
        waitForWebElementVisible(Series);
        Series.click();
        waitForWebElementVisible(SeriesOption);
        SeriesOption.click();
        waitForWebElementVisible(MachineType);
        MachineType.click();
        waitForWebElementVisible(MachineTypeOption);
        MachineTypeOption.click();
        waitForWebElementVisible(AddGPUs);
        AddGPUs.click();
        waitForWebElementVisible(NumberOfGPUs);
        NumberOfGPUs.click();
        waitForWebElementVisible(NumberOfGPUsOption);
        NumberOfGPUsOption.click();
        waitForWebElementVisible(GPUType);
        GPUType.click();
        waitForWebElementVisible(GPUTypeOption);
        GPUTypeOption.click();
        waitForWebElementVisible(LocalSSD);
        LocalSSD.click();
        waitForWebElementVisible(LocalSSDOption);
        LocalSSDOption.click();
        waitForWebElementVisible(DataCenterLocation);
        DataCenterLocation.click();
        waitForWebElementVisible(DataCenterLocationOption);
        DataCenterLocationOption.click();
        CommittedUsage.click();
        waitForWebElementVisible(CommittedUsageOption);
        CommittedUsageOption.click();
        waitForWebElementVisible(AddToEstimate);
        AddToEstimate.click();
        waitForWebElementVisible(TotalEstimatedCost);
        CheckSumFirst = TotalEstimatedCost.getText();
        int index1 = CheckSumFirst.indexOf("USD");
        int index2 = CheckSumFirst.indexOf("per");
        CheckSumFirst = CheckSumFirst.substring(index1, index2).trim();


        // Open page with temp email
        ((JavascriptExecutor) driver).executeScript("window.open()");

        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
                   //    delayBrowser(2000);
        driver.get("https://tempail.com/ru/");
      // waitForWebElementVisible(CreatedEmailAddress);
        String Email = CreatedEmailAddress.getAttribute("value");
        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        ButtonEmailEstimate = wait.until(ExpectedConditions.elementToBeClickable(ButtonEmailEstimate));
        ButtonEmailEstimate.click();
        waitForWebElementVisible(EmailForLetter);
        EmailForLetter.click();
        EmailForLetter.sendKeys(Email);
        ButtonSendEmail = wait.until(ExpectedConditions.elementToBeClickable(ButtonSendEmail));
        ButtonSendEmail.click();
        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        ReceivedMessage=wait.until(ExpectedConditions.elementToBeClickable(ReceivedMessage));
        ReceivedMessage.click();
        driver.navigate().refresh();
        waitForWebElementVisible(ReceivedMessage1);
        ReceivedMessage1 = wait.until(ExpectedConditions.elementToBeClickable(ReceivedMessage1));
        ReceivedMessage1.click();
        driver.switchTo().frame("iframe");
        CheckSumInLetter=EmailBody.getText();

    }

}

