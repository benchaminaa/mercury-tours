package com.mercury.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.Utility;

public class LoginPage extends BasePage {

	private WebElement txtUserName;
	private WebElement txtPwd;
	private WebElement btnSubmit;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		initializeObjects();
	}
	
	public String getTxtUserName() {
		return txtUserName.getAttribute("value");
	}

	public void setTxtUserName(String userName) {
		txtUserName.clear();
		txtUserName.sendKeys(userName);
	}

	public String getTxtPwd() {
		return txtPwd.getAttribute("value");
	}

	public void setTxtPwd(String pwd) {
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
	}

	public void Submit() {
		btnSubmit.click();;
	}


	
	public void initializeObjects()
	{
		txtUserName = Utility.getElement(driver,Bootstrap.uiMap.getProperty("txtUserName"));
		txtPwd = Utility.getElement(driver,Bootstrap.uiMap.getProperty("txtPassword"));
		btnSubmit = Utility.getElement(driver,Bootstrap.uiMap.getProperty("btnSingin"));
	}
	
	public void login(String userName, String pwd){
		Utility.waitForPageLoad(driver);
		setTxtUserName(userName);
		setTxtPwd(pwd);
		Submit();
		Utility.waitForElement(driver, new FlightFinderPage(driver).btnContinue);
	}
	
	public boolean isPageLoaded(){
		try{
			Utility.waitForElement(driver, btnSubmit);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
