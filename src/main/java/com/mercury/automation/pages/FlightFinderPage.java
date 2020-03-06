package com.mercury.automation.pages;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.Utility;

public class FlightFinderPage extends BasePage{

	public List<WebElement> optTrip;
	public WebElement selectDepartFrom;
	public WebElement selectDestination;
	public List<WebElement> optClass;
	public WebElement btnContinue;
	
	public FlightFinderPage(WebDriver driver) {
		super(driver);
		initializeObjects();
	}

	private void initializeObjects() {
		optTrip = Utility.getElements(driver, Bootstrap.uiMap.getProperty("optTripType"));
		selectDepartFrom = Utility.getElement(driver, Bootstrap.uiMap.getProperty("lstDepart"));
		selectDestination = Utility.getElement(driver, Bootstrap.uiMap.getProperty("lstDestination"));
		optClass = Utility.getElements(driver, Bootstrap.uiMap.getProperty("optClass"));
		btnContinue = Utility.getElement(driver, Bootstrap.uiMap.getProperty("btnNextPage"));
	}
	
	public void selectType(String type){
			
		if(type.equalsIgnoreCase("roundtrip"))
			optTrip.get(0).click();
		else if(type.equalsIgnoreCase("oneway")){
			optTrip.get(0).getAttribute("value");
			optTrip.get(1).click();
		}
			
		else
			assertFalse(true,"Wrong type provided");
	}
	
	public void selectDepartFrom(String departLoc){
		Select departSelect = new Select(selectDepartFrom);
		departSelect.selectByValue(departLoc);
	}
	
	public void selectArringIn(String arrivalLoc){
		Select arrivalSelect = new Select(selectDestination);
		arrivalSelect.selectByValue(arrivalLoc);
	}
	
	public void selectClass(String travelClass){
		
		if(travelClass.equalsIgnoreCase("Coach"))
			optClass.get(0).click();
		else if(travelClass.equalsIgnoreCase("Business"))
			optClass.get(1).click();
		else if(travelClass.equalsIgnoreCase("First"))
			optClass.get(2).click();
		else 
			assertFalse(true,"Wrong travel class provided");
	}
	
	public void clickContinue(){
		btnContinue.click();
		Utility.waitForElement(driver, new FlightSelectionPage(driver).btnContinue);
		
	}
	
	public boolean isPageLoaded(){
		try{
			Utility.waitForElement(driver, btnContinue);
		}
		catch(StaleElementReferenceException e){
			return false;
		}
		return true;
	}

}
