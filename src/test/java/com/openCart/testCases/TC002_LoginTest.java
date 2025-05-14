package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.PageObjects.HomePage;
import com.openCart.PageObjects.LoginPage;
import com.openCart.PageObjects.MyAccountPage;
import com.openCart.base.BaseTest;

public class TC002_LoginTest extends BaseTest{
	
	@Test(description="Validate Login to cartPage with Valid Credentials")
	public void verify_login()
	{
		try
		{
			logger.info("****Starting TC_002_LoginTest ***");
			
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccountLink();
			homePage.clickOnLoginLink();
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterEmailInLoginPage(properties.getProperty("email"));
			loginPage.enterPasswordInLoginPage(properties.getProperty("password"));
			loginPage.clickOnLoginButtonInLoginPage();
			
			MyAccountPage accountPage = new MyAccountPage(driver);
			boolean targetPage = accountPage.isAccountPageHeaderExist();
			
			
			//Assert.assertEquals(targetPage, true, "Login Failed");
			Assert.assertTrue(targetPage);
			
		}
		catch(Exception e)
		{
			logger.error("Authentication Failed", e);
			Assert.fail();
		}
		
		
	}

}
