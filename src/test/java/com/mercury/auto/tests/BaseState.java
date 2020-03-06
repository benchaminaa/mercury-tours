package com.mercury.auto.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.BrowserFactory;
/**
 * All the test classes extend this Class to invoke new browser and Base page
 * @author bench
 *
 */
public class BaseState {
	protected WebDriver driver;
	
	/**
	 * Instantiate driver and launches application before each test
	 * @throws Exception
	 */
	@BeforeTest
	public void launchApplication()throws Exception{
		driver = BrowserFactory.getDriver(Bootstrap.configProperties.getProperty("browser"));
		driver.navigate().to(Bootstrap.configProperties.getProperty("url"));
	}
	/**
	 * Close the browser after each tests
	 */
	@AfterTest
	public void closeDriver(){
		driver.quit();
	}
}
