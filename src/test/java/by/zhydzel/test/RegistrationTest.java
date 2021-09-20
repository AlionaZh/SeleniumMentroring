package by.zhydzel.test;

import by.zhydzel.RegistrationPage;
import by.zhydzel.StartGoogleMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest {

    @Test(priority = 0,timeOut =  90000000)
    public void testCheckSumOfCalculation() throws InterruptedException {


        //*************Enter Start Page Test*************
        StartGoogleMailPage StartGoogleMailPage = new StartGoogleMailPage(driver);
        StartGoogleMailPage.goToStartGooglePage();
        StartGoogleMailPage.goToCalculatorPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.switchToCalcIFrame();
        registrationPage.fillInCalcForm();
        registrationPage.addToEstimate();
        registrationPage.getExpectedCost();
        registrationPage.openNewTab();
        registrationPage.switchToInitialTab();
        registrationPage.getTempEmail();
        Assert.assertEquals(registrationPage.checkSumExpected, registrationPage.checkSumInLetter,"The sum in the letter is equal to sum in the form");
    }
}