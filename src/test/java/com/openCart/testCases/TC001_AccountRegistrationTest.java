package com.openCart.testCases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.openCart.PageObjects.AccountRegistrationPage;
import com.openCart.PageObjects.HomePage;
import com.openCart.base.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest{

	
	
	
	@Test(description="Validate end to end Testing of Account Registration")
	public void verify_account_Registration()
	{
		try
		{
	
			logger.info(" ***** Starting TC001_AccountRegistrationTest ****");
			
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccountLink();
			hp.clickOnRegisterLink();
			
			AccountRegistrationPage accountPage = new AccountRegistrationPage(driver);
			accountPage.setFirstName(randomString().toUpperCase());
			accountPage.setLastName(randomString().toUpperCase());
		//	accountPage.setEmail("abhishek3.mk@gmail.com");
			accountPage.setEmail(randomString() + "@tupmail.com");
			accountPage.setTelephone(randomNumber());
			
			String password  = randomAlphaNumber();
			accountPage.setPassword(password);
			accountPage.setConfirmPassword(password);
			
			accountPage.setPolicy();
			accountPage.continueButton();
			
			String confirmMessage = accountPage.getConfirmationMsg();
			if(confirmMessage.equals("Your Accoun Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("execption... ");
				logger.debug("Debug logs...");
				Assert.assertFalse(false);
			}
			
			Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
	}
	
	
	
}
