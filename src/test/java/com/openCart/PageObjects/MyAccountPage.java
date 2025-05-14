package com.openCart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	private WebElement myAccountHeaderMsg;
	
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean isAccountPageHeaderExist()
	{
		try
		{
			return (myAccountHeaderMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
	
	
