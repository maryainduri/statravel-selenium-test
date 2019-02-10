package com.otd.automation;

import com.statravel.automation.automation.stepdefinitions.BaseStepDefinition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtdRegistrationTest {

    //creating web driver object
    private WebDriver driver=null;
    private WebDriverWait webDriverWait;
    private final static Logger logger = LoggerFactory.getLogger(OtdRegistrationTest.class);

    //create variables
    String url="https://booking.onthedot.com/home?modal=signup";


    //before will run each time before test
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chrome_driver/chromedriver");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 300);
    }

    @Test
    public void testOtdRegister() throws InterruptedException {
        driver.get(url);
        //SIGNUP_FIRST_NAME_INPUTField
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SIGNUP_FIRST_NAME_INPUTField")));
        logger.info("OTD Registration page has been displayed successfully");

        //enter first name
        driver.findElement(By.id("SIGNUP_FIRST_NAME_INPUTField")).sendKeys("Marya");
        logger.info("customer has entered the first name as Marya");

        //enter last name
        driver.findElement(By.name("SIGNUP_LAST_NAME_INPUT")).sendKeys("Induri");
        logger.info("customer has entered the last name as Induri");

        //enter email address
        driver.findElement(By.id("SIGNUP_EMAIL_INPUTField")).sendKeys("marya.induri@gmail.com");
        logger.info("enter email address as marya.induri@gmail.com");

        //enter phone number
        driver.findElement(By.id("SIGNUP_PHONE_INPUTField")).sendKeys("07393355523");
        logger.info("enter phone number as 07393355523");

        //enter password
        driver.findElement(By.id("SIGNUP_PASSWORD_INPUTField")).sendKeys("manjularaj143");
        logger.info("enter password as manjularaj143");

        //select Accept our terms and conditions check box
        driver.findElement(By.id("SIGNUP_TERMS_INPUT-SIGNUP_TERMS_INPUT-field")).click();
        logger.info("select Accept our terms and conditions");

        //select I'd like to receive tips to help my business check box
        driver.findElement(By.id("SIGNUP_MARKETING_INPUT-SIGNUP_MARKETING_INPUT-field")).click();
        logger.info("I'd like to receive tips to help my business");


        Thread.sleep(5000);




    }

    //after will run after test
    @After
    public void closeBrowser(){
        if (driver!=null){
            driver.close();
        }
    }
}
