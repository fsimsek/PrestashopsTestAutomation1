package com.prestashop.tests.checkout;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

public class ProductCheckoutTest extends TestBaseClass{
	String productName= "Printed Summer Dress";
	
	@Test(priority = 0)        //@Test(priority = 0, enabled = false)   enables =false means skip this test.
	public void productListing() {
		HomePage homePage=new HomePage(driver);
		homePage.listing(productName).click();
		ProductPage productPage=new ProductPage(driver);
		assertEquals(productPage.name.getText(),productName);
	//	fail(); //on purpose you fail the test
	}
	
	/*
	 * open the product details page add a product to the cart
	 * verify that confirmation message is displayed
	 * */
	
	@Test(priority = 1, dependsOnMethods = "productListing")
	public void checkoutTest() {
		ProductPage productPage=new ProductPage(driver);
		productPage.addToCart.click();
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(productPage.confirmation));
		assertTrue(productPage.confirmation.isDisplayed(), "Confirmation message was not displayed");
		String confirmation="Product successfully added to your shopping cart";
		
		assertEquals(productPage.confirmation.getText().trim(),confirmation);
	}
	
}
