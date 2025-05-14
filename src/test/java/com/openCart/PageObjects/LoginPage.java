package com.openCart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterEmailInLoginPage(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void enterPasswordInLoginPage(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnLoginButtonInLoginPage()
	{
		loginButton.click();
	}
}
