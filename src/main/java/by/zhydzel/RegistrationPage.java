package by.zhydzel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class RegistrationPage extends by.zhydzel.GoogleMailBasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements Init********
    @FindBy(xpath = "(//input[@name=\'quantity\'])[1]")
    WebElement numberOfInstances;
    @FindBy(xpath = "//*[@ng-model=\'listingCtrl.computeServer.os\']")
    WebElement operatingSystem;
    @FindBy(xpath = "//md-option[@value=\'free\']")
    WebElement operatingSystemOption;
    @FindBy(xpath = "//*[@ng-model=\'listingCtrl.computeServer.class\']")
    WebElement machineClass;
    @FindBy(xpath = "//md-option[@value=\'regular\']")
    WebElement machineClassOption;
    @FindBy(xpath = "//md-select[@ng-model=\'listingCtrl.computeServer.series\']")
    WebElement series;
    @FindBy(xpath = "//*[contains(text(),'N1')]//parent::md-option")
    WebElement seriesOption;
    @FindBy(xpath = "//md-select[@ng-model=\'listingCtrl.computeServer.instance\']")
    WebElement machineType;
    @FindBy(xpath = "//md-option[@value=\'CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\']")
    WebElement machineTypeOption;
    @FindBy(xpath = "(//md-checkbox[@aria-label=\'Add GPUs\'])[1]")
    WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder=\'Number of GPUs\']")
    WebElement numberOfGPUs;
    @FindBy(xpath = "//*[@id=\'select_option_442\']")
    WebElement numberOfGPUsOption;
    @FindBy(xpath = "//md-select[@placeholder=\'GPU type\']")
    WebElement GPUType;
    @FindBy(xpath = "//md-option[@value=\'NVIDIA_TESLA_V100\']")
    WebElement GPUTypeOption;
    @FindBy(xpath = "//md-select[@placeholder=\'Local SSD\']")
    WebElement localSSD;
    @FindBy(xpath = "//*[contains(text(),'2x375 GB')]//parent::md-option")
    WebElement localSSDOption;
    @FindBy(xpath = "//md-select[@placeholder=\'Datacenter location\']")
    WebElement dataCenterLocation;
    @FindBy(xpath = "(//*[contains(text(),' Frankfurt (europe-west3)')]//parent::md-option)[3]")
    WebElement dataCenterLocationOption;
    @FindBy(xpath = "//md-select[@placeholder=\'Committed usage\']")
    WebElement committedUsage;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/descendant::md-option[@ng-value='1'][@value='1']")
    WebElement committedUsageOption;
    @FindBy(xpath = "(//button[@aria-label=\'Add to Estimate\'])[1]")
    WebElement addToEstimate;
    @FindBy(xpath = "//h2/b")
    WebElement totalEstimatedCost;
    @FindBy(xpath = "//button[@aria-label=\'Email Estimate\']")
    WebElement buttonEmailEstimate;
    @FindBy(xpath = "//*[@id=\'eposta_adres\']")
    WebElement createdEmailAddress;
    @FindBy(xpath = "//input[@ng-model=\'emailQuote.user.email\']")
    WebElement emailForLetter;
    @FindBy(xpath = "//*[@aria-label=\'Send Email\']")
    WebElement buttonSendEmail;
    @FindBy(xpath = "//*[@class=\'mailler\']/li[2]/a")
    WebElement receivedMessage;
    @FindBy(xpath = "//*[@class=\'mailler\']/li[2]/a")
    WebElement receivedMessage1;
    @FindBy(xpath = "//*[contains(text(),'Total Estimated Monthly Cost')]/parent::td/following-sibling::*/h3")
    WebElement emailBody;

    public String checkSumInLetter, checkSumExpected;

    // Switch to calculator iFrame
    public void switchToCalcIFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }

    // Fill in calculator form
    public void fillInCalcForm() {
        numberOfInstances.sendKeys("4");
        operatingSystem.click();
        operatingSystemOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        waitForWebElementVisible(series);
        series.click();
        waitForWebElementVisible(seriesOption);
        seriesOption.click();
        waitForWebElementVisible(machineType);
        machineType.click();
        waitForWebElementVisible(machineTypeOption);
        machineTypeOption.click();
        waitForWebElementVisible(addGPUs);
        addGPUs.click();
        waitForWebElementVisible(numberOfGPUs);
        numberOfGPUs.click();
        waitForWebElementVisible(numberOfGPUsOption);
        numberOfGPUsOption.click();
        waitForWebElementVisible(GPUType);
        GPUType.click();
        waitForWebElementVisible(GPUTypeOption);
        GPUTypeOption.click();
        waitForWebElementVisible(localSSD);
        localSSD.click();
        waitForWebElementVisible(localSSDOption);
        localSSDOption.click();
        waitForWebElementVisible(dataCenterLocation);
        dataCenterLocation.click();
        waitForWebElementVisible(dataCenterLocationOption);
        dataCenterLocationOption.click();
        committedUsage.click();
        waitForWebElementVisible(committedUsageOption);
        committedUsageOption.click();
    }

    // Add form to estimation
    public void addToEstimate() {
        waitForWebElementVisible(addToEstimate);
        addToEstimate.click();
    }

    // Get calculated cost
    public void getExpectedCost() {
        waitForWebElementVisible(totalEstimatedCost);
        checkSumExpected = totalEstimatedCost.getText();
        int index1 = checkSumExpected.indexOf("USD");
        int index2 = checkSumExpected.indexOf("per");
        checkSumExpected = checkSumExpected.substring(index1, index2).trim();
    }

    // Open new tab
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    // Switch to new tab
    public void switchToNewTab() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    // Switch to initial tab
    public void switchToInitialTab() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
        switchToCalcIFrame();
    }

    // Get temp email
    public void getTempEmail() {
        switchToNewTab();
        driver.get("https://tempail.com/ru/");
        waitForWebElementVisible(createdEmailAddress);
        String Email = createdEmailAddress.getAttribute("value");
        switchToInitialTab();
        waitForWebElementVisible(buttonEmailEstimate);
        buttonEmailEstimate.click();
        waitForWebElementVisible(emailForLetter);
        emailForLetter.click();
        emailForLetter.sendKeys(Email);
        waitForWebElementVisible(buttonSendEmail);
        buttonSendEmail.click();
        switchToNewTab();
        waitForWebElementVisible(receivedMessage);
        receivedMessage.click();
        driver.navigate().refresh();
        waitForWebElementVisible(receivedMessage1);
        WebDriverWait wait = new WebDriverWait(driver, 35);
        receivedMessage1 = wait.until(ExpectedConditions.elementToBeClickable(receivedMessage1));
        receivedMessage1.click();
        driver.switchTo().frame("iframe");
        checkSumInLetter = emailBody.getText();
    }
}