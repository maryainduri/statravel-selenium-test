package com.sta.travel.manju;

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


public class StaTravelTest {
    //create variables
    private WebDriver driver = null;
    private WebDriverWait webDriverWait;
    private final static Logger logger = LoggerFactory.getLogger(StaTravelTest.class);

    //create variables
    String url="https://www.statravel.co.uk/tours-worldwide.htm";


    //before will run each time before test
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chrome_driver/chromedriver");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 300);
    }

    @Test
    public void testDestination(){
        driver.navigate().to(url);
        String pageTitle=driver.getTitle();
        Assert.assertEquals("Worldwide Tours | STA Travel",pageTitle);

        //accept cookies and close
        driver.findElement(By.id("sta-cookie-save-all-button")).click();
        logger.info("accept cookies and close");


    }

    //after will run after the test
    @After
    public void closeBrowser() {
       if (driver !=null) {
           driver.quit();
       }

    }
}
