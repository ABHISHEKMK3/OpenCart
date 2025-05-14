package com.openCart.PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath ="//input[@name='agree']")
	private WebElement agreePolicyCheckbox;
	
	@FindBy(xpath ="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;
	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void setFirstName(String firstName)
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		lastNameField.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void setTelephone(String telephoneNumber)
	{
		telephoneField.sendKeys(telephoneNumber);
	}
	
	public void setPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		confirmPasswordField.sendKeys(confirmPassword);
	}
	public void setPolicy()
	{
		agreePolicyCheckbox.click();
		
	}
	public void continueButton()
	{
	   continueButton.click();
		
/*
	   continueButton.submit();
	   
	   
	   Actions act = new Actions(driver);
	   act.moveToElement(continueButton).click().perform();
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", continueButton);
	   
	   
	   continueButton.sendKeys(Keys.RETURN);
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.elementToBeClickable(continueButton));
	   
	*/   
	}  
	   public String getConfirmationMsg()
	   {
		   try
		   {
			   return (msgConfirmation.getText());
		   }
		   catch(Exception e)
		   {
			   return (e.getMessage());
		   }
		   
	   }
		
	}

