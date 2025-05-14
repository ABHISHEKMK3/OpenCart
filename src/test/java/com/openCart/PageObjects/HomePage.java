package com.openCart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountLink;
	
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginLink;
	
	
	public HomePage(WebDriver driver)
	{
		 super(driver);
	}
	
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	public void clickOnRegisterLink()
	{
		registerLink.click();
	}

	public void clickOnLoginLink()
	{
		loginLink.click();
	}
}
