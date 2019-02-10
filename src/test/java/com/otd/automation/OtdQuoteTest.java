package com.otd.automation;

import org.junit.After;
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

public class OtdQuoteTest {
    //creating web driver object
    private WebDriver driver = null;
    private WebDriverWait webDriverWait;
    private final static Logger logger = LoggerFactory.getLogger(OtdQuoteTest.class);

    //create variables
    String url = "https://booking.onthedot.com/home";


    //before will run each time before test
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chrome_driver/chromedriver");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 100);
    }


    @Test
    public void testQuote() {
        driver.navigate().to(url);
        String pageTitle=driver.getTitle();
        Assert.assertEquals("Get your deliveries on the road | onthedot",pageTitle);

        // wait for visibility to get a quote
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("get-quote-button")));
        logger.info("OTD get quote page has been displayed successfully");

        //enter pick up post code
        driver.findElement(By.id("COLLECTION_POSTCODE")).sendKeys("EC2A4PH");
        logger.info("customer has entered the pick up postcode as EC2A4PH");

        //enter delivary post code
        driver.findElement(By.id("DELIVERY_POSTCODE")).sendKeys("EC2A4PH");
        logger.info("customer has entered the delivary postcode as EC2A4PH");

        //click on get a quote
        driver.findElement(By.id("get-quote-button")).click();
        logger.info("click on get a quote");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-exkUMo daTsfy sc-bdVaJa kvQpWs']")));
        logger.info("Quote Price has been displayed");

        //validate Quote price is not Null
        String quotePrice=driver.findElement(By.xpath("//div[@class='sc-exkUMo daTsfy sc-bdVaJa kvQpWs']")).getText();
        logger.info("Quote Price Here:"+quotePrice);
        Assert.assertNotNull(quotePrice);
    }

    //after will run after test
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }
}
