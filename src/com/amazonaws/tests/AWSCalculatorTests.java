package com.amazonaws.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.amazonaws.pages.AwsCalculatorPage;
import com.prestashop.utilities.TestBaseClass;

public class AWSCalculatorTests extends TestBaseClass {

	AwsCalculatorPage calculator = new AwsCalculatorPage();

	@Test(priority = 0, description = "Monthly bill should be $0.00 by default")
	public void deafultMonthlyBillTest() {
		assertTrue(calculator.isAt());
		System.out.println(calculator.billLabel.getText());
		assertEquals(0.00, calculator.getMonthlyBillAmount());
	}
	
	@Test (priority=1)
	public void addedEc2DefaultValuesTest() {
		calculator.addEc2.click();
		//calculator.description.sendKeys("test"); this will fail the assert true. since we send test word its not empty anymore
		assertTrue(calculator.description.getAttribute("value").isEmpty());
		assertEquals(1, calculator.getInstanceCount());
	}
	
	
	
}
