package com.prestashop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	
private WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="uniform-id_contact")
	public WebElement subjectHeading;
	
	
	public WebElement email;
	
	public WebElement id_order;
	
	
	
	
	
}
