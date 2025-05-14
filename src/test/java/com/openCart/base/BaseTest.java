package com.openCart.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
//Log4j
import org.apache.logging.log4j.Logger;  //Log4j

public class BaseTest {

	public WebDriver driver;
	
	public Logger logger;
	public Properties properties;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os , String br) throws IOException
	{
		
		//Loading Config.properties file
		
		properties = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "./src//main//resource//config.properties");
		properties.load(file);
		
		

		
        logger = LogManager.getLogger(this.getClass());
        
        switch(br.toLowerCase())
        {
        case "chrome": 
        	driver = new ChromeDriver();
        	break;
        case "edge": 
        	driver = new EdgeDriver();
        	break;
        case "firefox" : 
        	driver = new FirefoxDriver();
        	break;
        default: 
        	System.out.println("invalid browser name..");
        	return;
        }
	
	//	driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		 String generatedString = RandomStringUtils.randomAlphabetic(5);
		 return generatedString;
	}
	public String randomNumber()
	{
		 String generatedNumber = RandomStringUtils.randomNumeric(10);
		 return generatedNumber;
	}
	public String randomAlphaNumber()
	{
		 String generatedString = RandomStringUtils.randomAlphabetic(3);
		 String generatedNumber = RandomStringUtils.randomNumeric(3);
		 return (generatedString + "@"+ generatedNumber);
	}
}
