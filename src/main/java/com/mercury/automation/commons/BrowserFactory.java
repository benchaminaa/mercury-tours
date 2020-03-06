package com.mercury.automation.commons;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

/**
 * A SingleTon class creating drivers for the requested browsers
 * @author bench
 *
 */
public class BrowserFactory {
	public enum Browser{NOBROWSER, FIREFOX, CHROME, OPERA, IEXPLORE, SAFARI}

	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
	private BrowserFactory() {

	}
	/**
	 * @param browser pass browser name to return driver for the specific browser
	 * @return
	 * @throws Exception
	 */
	public static WebDriver getDriver(String browser) throws Exception{
		WebDriver driver = null;
		try{
			switch(Browser.valueOf(browser.toUpperCase())){
			case NOBROWSER:
				driver = drivers.get(Browser.NOBROWSER.toString());
				if(driver == null){
					driver = new HtmlUnitDriver(true);
					drivers.put(Browser.NOBROWSER.toString(), driver);
				}
				return driver;
			case FIREFOX:
				driver = drivers.get(Browser.FIREFOX.toString());
				if(driver == null){
					System.setProperty("webdriver.gecko.driver", "src//main/resources//browser_drivers//geckodriver.exe");
					driver = new FirefoxDriver();
					drivers.put(Browser.FIREFOX.toString(),driver );
				}
				return driver;
			case CHROME:
				driver = drivers.get(Browser.CHROME.toString());
				if(driver == null){
					System.setProperty("webdriver.chrome.driver", "src//main/resources//browser_drivers//chromedriver.exe");
					driver  = new ChromeDriver();
					drivers.put(Browser.CHROME.toString(),driver );
				}				
				return driver;
			case IEXPLORE:
				driver = drivers.get(Browser.IEXPLORE.toString());
				if(driver == null){
					System.setProperty("webdriver.ie.driver", "src//main/resources//browser_drivers//IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					drivers.put(Browser.IEXPLORE.toString(), driver);
				}
				return driver;
			default: throw new RuntimeException("Browser type unsupported "+browser);
				
			}
			
		}catch(Exception e){
				System.out.println(e.getMessage());
				throw new RuntimeException("Browser type unsupported "+browser);
			}
		
		

	}
}
