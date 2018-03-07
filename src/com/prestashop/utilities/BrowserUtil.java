package com.prestashop.utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrowserUtil {

	public static void verifyTitle(String actual, String expected) {
		if(actual.equals(expected)) {
			  System.out.println("Pass");
		  }else {
			  System.out.println("Fail");
			  System.out.println("Expected: " + expected);
			  System.out.println("Actual: " + actual);
		  }
	}
	
	public static void verifyTxtContains(String actual, String expected) {
		if(actual.contains(expected)) {
			  System.out.println("Pass");
		  }else {
			  System.out.println("Fail");
			  System.out.println("Expected: " + expected);
			  System.out.println("Actual: " + actual);
		  }
	}
	
	public static void verifyTxtNotContains(String actual, String expected) {
		if(!actual.contains(expected)) {
			  System.out.println("Pass");
		  }else {
			  System.out.println("Fail");
			  System.out.println("Expected: " + expected);
			  System.out.println("Actual: " + actual);
		  }
	}
	
	public static void verifyTxtEquals(String actual, String expected) {
		if(actual.equals(expected)) {
			  System.out.println("Pass");
		  }else {
			  System.out.println("Fail");
			  System.out.println("Expected: " + expected);
			  System.out.println("Actual: " + actual);
		  }
	}
	
	
	public static void verifyTitleMatches(WebDriver driver, String expected, String actual) {
		actual=driver.getTitle();
		if(expected.equals(actual)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			System.out.println("Expected title is: "+expected);
			System.out.println("Actual title is: "+actual);
		}
	}
	
	public static void verifyTitleNotMatches(WebDriver driver, String expected, String actual) {
		actual=driver.getTitle();
		if(!expected.equals(actual)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			System.out.println("Expected title is: "+expected);
			System.out.println("Actual title is: "+actual);
		}
	}
	

	public static void verifyUrlMatches(WebDriver driver, String expected, String actual) {
		 actual=driver.getCurrentUrl();
		if(expected.equals(actual)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			System.out.println("Expected is: "+expected);
			System.out.println("Actual is: "+actual);
		}
	}

	public static void verifyElementExists(WebDriver driver,By by) {
		try {
			assertTrue(driver.findElement(by).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.fail("Element was not found");
		}
	}
	public static void verifyCheckBoxSelected(WebElement checkbox) {
		if(checkbox.isSelected()) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
}
	
	
	public static void verifyCheckboxNotSelected(WebElement ligthingBulbs) {
		if(!ligthingBulbs.isSelected()) {
			  System.out.println("Pass");
		  }else {
			  System.out.println("Fail");
		  }
	}
	
	public static void verifyRadioButtonselected(WebElement trip) {
		if (trip.isSelected()) {
			System.out.println(" Pass");
		} else {
			System.out.println("failed");
		}

	}	
	public static void verifyRadioButtonNotSelected(WebElement trip) {
		if (!trip.isSelected()) {
			System.out.println("not selected by default Pass");
		} else {
			System.out.println("failed");
		}
	}
	
	
	public static void changeWindow(WebDriver driver,String targetTitle) {
		String origin=driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(targetTitle)) {
				
				return; //stop the whole method
			}
			driver.switchTo().window(handle);
		}
	}
	
	public static void convertToDouble(String totalPrice) {
		totalPrice=totalPrice.replace("$", "").replace(" USD", "");
		double totalPriceInt=Integer.parseInt(totalPrice)/100.0;
	
}
	
}
