package com.mercury.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Base page which other pages in the application can inherit properties and methods
 * @author bench
 *
 */
public class BasePage {
	protected WebDriver driver;
	private WebElement lnkHome;
	private WebElement lnkSignOff;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
}
