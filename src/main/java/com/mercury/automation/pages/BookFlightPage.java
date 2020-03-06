package com.mercury.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.Utility;

public class BookFlightPage extends BasePage {

	public WebElement firstName;
	public WebElement lastName;
	public WebElement cardNumber;
	public WebElement ticketLessTravel;
	public WebElement bookTicket;
	
	public BookFlightPage(WebDriver driver) {
		super(driver);
		initializeObjects();
	}

	private void initializeObjects() {
		firstName = Utility.getElement(driver, Bootstrap.uiMap.getProperty("txtFirstName"));
		lastName = Utility.getElement(driver, Bootstrap.uiMap.getProperty("txtLastName"));
		cardNumber = Utility.getElement(driver, Bootstrap.uiMap.getProperty("txtCreditCardNumber"));
		ticketLessTravel = Utility.getElement(driver, Bootstrap.uiMap.getProperty("chkBoxTicketLess"));
		bookTicket = Utility.getElement(driver, Bootstrap.uiMap.getProperty("btnSecurePurchase"));
	}
	
	public void setFirsName(String fName){
		firstName.clear();
		firstName.sendKeys(fName);
		}
	
	public void setLastName(String lName){
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	public void setCardNumber(String number){
		cardNumber.clear();
		cardNumber.sendKeys(number);
	}
	
	public void SecurePurchase(){
		bookTicket.click();
	}
	
	
	public void bookTicket(String firstName, String lastName,String cardNumber){
		setFirsName(firstName);
		setLastName(lastName);
		setCardNumber(cardNumber);
		SecurePurchase();
	}

}
