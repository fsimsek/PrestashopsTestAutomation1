package com.prestashop.tests.search;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.pages.ResultsPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

public class ProductDetailsTest extends TestBaseClass{

	String searchQuery= "Printed Summer Dress";
	
	@Test(priority=0)
	public void searchTest() {
		//create object from Page class:
	HomePage homePage = new HomePage(driver);
	homePage.search_query.sendKeys(searchQuery+Keys.ENTER);
	ResultsPage resultsPage=new ResultsPage(driver);
	assertTrue(resultsPage.result(searchQuery).isDisplayed());
}
	
	//on the search result page click on a result for "Printed Summer Dress" displayed 
	//verify that product name is displayed correctly in the product page
	
	@Test(priority=1)
	public void productDetailsTest() {
		ResultsPage resultsPage=new ResultsPage(driver);
		resultsPage.result(searchQuery).click();
		ProductPage productPage=new ProductPage(driver);
		assertEquals(productPage.name.getText(), searchQuery);
	}
	
//	@Test(priority=2)
//	public void AnotherTest() {
//		ResultsPage resultsPage=new ResultsPage(driver);
//		resultsPage.result(searchQuery).click();
//		ProductPage productPage=new ProductPage(driver);
//		assertEquals(productPage.name.getText(), searchQuery);
//	}
	
}