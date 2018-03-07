package com.prestashop.tests.contactus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ResultsPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.StringCommans;
import com.prestashop.utilities.TestBaseClass;

public class PhoneNoTest extends TestBaseClass{

	
	String callUsNowExpectedTxt="Call us now: 0123-456-789";
	String expectedPhoneNum= "0123456789";

	// test the phone number area
	@Test
	public void PhoneNumberAreaTest() {
		//create object from HomePage class:
		HomePage homePage = new HomePage(driver);
		String actualCallTxt=homePage.callUsNow.getText();
		assertTrue(homePage.callUsNow.isDisplayed());
		assertEquals(homePage.callUsNow.getText(),callUsNowExpectedTxt);
		String actualPhoneNum=StringCommans.extractNumberFromString(actualCallTxt);
//		assertEquals(actualPhoneNum,expectedPhoneNum);
		
}
	
	@Test
	public void priceTest() {
		HomePage homePage = new HomePage(driver);
		List<WebElement> price = homePage.allPrices;
		for(int i =0;i<price.size();i++) {
			String priceTxt = price.get(i).getText();
			if(priceTxt.length()!=0) {
				String textPrice =priceTxt.substring(1, priceTxt.length());
				double priceInt= Double.parseDouble(textPrice);
				
				if(priceInt>30) {
					System.out.println(priceInt);
				}
			}
		}
		
	}
}