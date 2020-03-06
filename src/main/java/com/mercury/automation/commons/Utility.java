package com.mercury.automation.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

/**
 * This class contains utility methods that can be reused in the project
 * @author bench
 *
 */
public class Utility {

/**
 * This method can be used to load any properties file providing file path
 * @param filePath path of the property file that need to be loaded
 * @return
 */
public static Properties loadProperties(String filePath){
	Properties prop=null;
	
	File file = new File(filePath);
	FileInputStream fileInput=null;
	try{
		fileInput = new FileInputStream(file);
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	prop = new Properties();
	
	try{
		prop.load(fileInput);
	}catch(IOException e){
		e.printStackTrace();
	}
	
	return prop;
}
/**
 * @param driver
 * @param locator of the element to be found
 * @return WebElement for the locator passed
 */
public static WebElement getElement(WebDriver driver, String locator) {
		String[] ltr = locator.split(":");
		By elementBy = null;
		try{
		switch(ltr[0]){
		case "name":
			elementBy  = By.name(ltr[1]);
			break;
		case "xpath":
			elementBy = By.xpath(ltr[1]);
			break;
		case "css":
			elementBy = By.cssSelector(ltr[1]);
			break;
		case "id":
			elementBy = By.id(ltr[1]);
			break;
		default:
			break;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return driver.findElement(elementBy);
	}

/**
 * @param driver
 * @param locator of the elements to be returned
 * @return list of WebElements
 */
public static List<WebElement> getElements(WebDriver driver, String locator) {
	String[] ltr = locator.split(":");
	By elementBy = null;
	try{
	switch(ltr[0]){
	case "name":
		elementBy  = By.name(ltr[1]);
		break;
	case "xpath":
		elementBy = By.xpath(ltr[1]);
		break;
	case "css":
		elementBy = By.cssSelector(ltr[1]);
		break;
	case "id":
		elementBy = By.id(ltr[1]);
		break;
	default:
		break;
	}
	}catch(Exception e){
		e.printStackTrace();
	}

	return driver.findElements(elementBy);
}
/**
 * Use this method to wait for a Page to load
 * @param driver
 */
public static void waitForPageLoad(WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(Bootstrap.configProperties.getProperty("page.timeout")), TimeUnit.MINUTES);
	}
/**
 * Method to wait for an element before doing any actions
 * @param driver
 * @param ele
 */
public static void waitForElement(WebDriver driver, WebElement ele){
	int timeOutInSeconds = Integer.parseInt(Bootstrap.configProperties.getProperty("element.timeout"));
	new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(ele));
}
}
