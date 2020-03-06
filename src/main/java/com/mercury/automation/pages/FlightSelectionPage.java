package com.mercury.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.Utility;

public class FlightSelectionPage extends BasePage {

	public WebElement btnContinue;
	
	public FlightSelectionPage(WebDriver driver) {
		super(driver);
		initializeObjects();
	}

	private void initializeObjects() {
		btnContinue = Utility.getElement(driver, Bootstrap.uiMap.getProperty("btnReserve"));
	}
	

	
	public boolean isPageLoaded(){
		try{
			Utility.waitForElement(driver, btnContinue);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void goToBooking(){
		btnContinue.click();
		Utility.waitForElement(driver, new BookFlightPage(driver).bookTicket);
	}

}
