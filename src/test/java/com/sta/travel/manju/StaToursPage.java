package com.sta.travel.manju;

import com.otd.automation.OtdQuoteTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaToursPage {
    //create object and web driver wait object
    private WebDriver driver= new ChromeDriver();
    private WebDriverWait webDriverWait ;
    private final static Logger logger = LoggerFactory.getLogger(OtdQuoteTest.class);

    //create variables
    String url = "http://www.statravel.co.uk/tours-worldwide.htm";

    //Before will always run before test
    @Before
    public void init (){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chrome_driver/chromedriver");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 100);
    }
    @Test
    public void testtourspage (){
        driver.navigate ().to(url);
        String pageTitle=driver.getTitle();
        Assert.assertEquals("Worldwide Tours | STA Travel",pageTitle);

        // wait for visibility to get a quote
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-quote-button")));
        logger.info("OTD get quote page has been displayed successfully");
    }

}
