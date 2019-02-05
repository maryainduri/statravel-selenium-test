package com.statravel.automation.automation.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Marya Manju
 * @Date 05/02/2019
 */

public class BaseStepDefinition {

	private final static Logger logger = LoggerFactory.getLogger(BaseStepDefinition.class);
	private WebDriver driver;
	private WebDriverWait webDriverWait;

	private String staTravel = "https://www.statravel.co.uk/tours-worldwide.htm";
	private String destinationCountryName = "India";

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chrome_driver/chromedriver");
		driver = new ChromeDriver();
		webDriverWait = new WebDriverWait(driver, 300);
	}

	@Given("user on STA Worldwide Tours and travel page")
	public void user_on_STA_Worldwide_Tours_and_travel_page() {
		driver.navigate().to(staTravel);
		Assert.assertEquals("Worldwide Tours | STA Travel", driver.getTitle());
		logger.info("Worldwide Tours | STA Travel page has been loaded successfully");

		//enter India in Destination Input
		if (driver.findElement(By.id("sta-cookie-save-all-button")).isDisplayed()) {
			driver.findElement(By.id("sta-cookie-save-all-button")).click();
			logger.warn("Save cookies option displayed and accepted");
		}

	}

	@Then("user choose India as destination and find a tour")
	public void user_choose_India_as_destination_and_find_a_tour() throws InterruptedException {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sta-sw-landscape-row sta-sw-tours-where']//input[@placeholder='Search Region, Country or Tour name']")));
		driver.findElement(By.xpath("//div[@class='sta-sw-landscape-row sta-sw-tours-where']//input[@placeholder='Search Region, Country or Tour name']")).sendKeys("India");
		Thread.sleep(5000);
		logger.info("Enter India in Destination input");
		//SELECT India from dropdown
		List<WebElement> countryDropDown = driver.findElements(By.xpath("//span[@class='sta-adventure_link_highlight'][contains(text(),'India')]"));
		countryDropDown.get(1).click();
		//click on Find A Tour Button
		driver.findElement(By.xpath("//p[@class='sta-contain']//button[@type='submit'][contains(text(),'Find A Tour')]")).click();
		logger.info("Find A tour Button clicked");
	}

	@Then("user should see matches found under product page")
	public void user_should_see_matches_found_under_product_page() {
		//Click Sort Order and choose Price (Low to High)
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortSelect")));
		logger.info("Products page has been displayed");
		String matchesFound = driver.findElement(By.id("lblTotalSearchResult")).getText();
		matchesFound = matchesFound.replaceAll("\\D+", "");
		logger.info("Total matches Found:" + matchesFound);

		//select Low to High
		driver.findElement(By.id("sortSelect")).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='price']")));
		driver.findElement(By.xpath("//option[@value='price']")).click();
		logger.info("Price to Low to High has been Selected from Dropdown");

		//view more Button from bottom of the page
		driver.findElement(By.id("btnViewMore")).click();
		logger.info("View more products option has been selected");

		int numberOfProducts = driver.findElements(By.className("thumbnail")).size();
		logger.info("after View more:" + numberOfProducts);
		Assert.assertEquals(numberOfProducts, Integer.parseInt(matchesFound));
		logger.info(numberOfProducts + " Matches Found");
	}

	@After
	public void tearDown() {
		// Close the driver
		if (driver != null) {
			driver.quit();
		}
	}
}
