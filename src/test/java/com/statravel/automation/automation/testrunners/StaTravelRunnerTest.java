package com.statravel.automation.automation.testrunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Marya Manju
 * @Date 05/02/2019
 */
@CucumberOptions(
		monochrome = true,
		tags = {"@sta-travel-test"},
		features = "src/test/resources/featurefiles",
		glue = {"com.statravel.automation"})
@RunWith(Cucumber.class)
public class StaTravelRunnerTest {
}
