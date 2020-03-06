package com.mercury.auto.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.mercury.automation.commons.Bootstrap;
import com.mercury.automation.commons.Utility;
import com.mercury.automation.pages.BookFlightPage;
import com.mercury.automation.pages.FlightConfirmationPage;
import com.mercury.automation.pages.FlightFinderPage;
import com.mercury.automation.pages.FlightSelectionPage;
import com.mercury.automation.pages.LoginPage;

public class FlightBookingTest extends BaseState{

	@Test
	public void bookFlight()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(Bootstrap.testData.getProperty("user1.name"), Bootstrap.testData.getProperty("user1.password"));
		FlightFinderPage flightFinderPage = new FlightFinderPage(driver);
		flightFinderPage.isPageLoaded();
		assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:", "Find a flight page did not load");
		flightFinderPage.selectType("oneway");
		flightFinderPage.selectDepartFrom("Sydney");
		flightFinderPage.selectArringIn("London");
		flightFinderPage.selectClass("First");
		flightFinderPage.clickContinue();
		FlightSelectionPage flightSelect = new FlightSelectionPage(driver);
		assertEquals(driver.getTitle(), "Select a Flight: Mercury Tours", "Flight selection page is not loaded");
		flightSelect.goToBooking();
		BookFlightPage bookFlight = new BookFlightPage(driver);
		bookFlight.bookTicket("David", "Boon", "123");
		FlightConfirmationPage flightConfirmation = new FlightConfirmationPage(driver);
		assertEquals(driver.getTitle(),"Flight Confirmation: Mercury Tours","Flight booking confirmation page didn't displayed as expected");
		//Validate other required  data as necessary
		
	}

}
