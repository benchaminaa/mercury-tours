package com.mercury.automation.commons;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
/**
 * This class loads configuration files during test suite execution
 * @author bench
 *
 */
public class Bootstrap {
	public static Properties configProperties;
	public static Properties testData;
	public static Properties uiMap;

	/**
	 * Loads properties which can be accessed from other classes
	 * @throws Exception
	 */
@BeforeSuite
public static void loadConfigurations()throws Exception{

	configProperties = Utility.loadProperties(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
	testData = Utility.loadProperties(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties");
	uiMap = Utility.loadProperties(System.getProperty("user.dir")+"\\src\\main\\resources\\UIMap.properties");
	
	}

	
}
