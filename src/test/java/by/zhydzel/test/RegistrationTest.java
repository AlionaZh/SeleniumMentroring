package by.zhydzel.test;

import by.zhydzel.*;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import by.zhydzel.RegistrationPage;

import java.io.IOException;
import java.util.zip.Checksum;


public class RegistrationTest extends BaseTest {


    @Test(priority = 0,timeOut =  600000)
    public void testCheckSumOfCalculation() throws InterruptedException {

        //*************Enter Start Page Test*************
        StartGoogleMailPage StartGoogleMailPage = new StartGoogleMailPage(driver);
        StartGoogleMailPage.goToStartGooglePage();
        StartGoogleMailPage.goToCalculatorPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm();
        Assert.assertEquals(registrationPage.CheckSumFirst, registrationPage.CheckSumInLetter);


    }



}


