package com.prestashop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseClass{
	
	protected static WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	
	@Parameters("browser")
	public void setUp(@Optional String browser) {
		driver=Driver.getDriver(browser);
		driver.switchTo().window(driver.getWindowHandle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("aws_calculator_url"));
	}

	//@AfterClass(alwaysRun=true)
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		Driver.quit();
	}
	
}
