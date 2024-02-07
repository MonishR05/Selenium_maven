package org.automation.genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest1 
{
	public WebDriver driver;
	static WebDriver listenersDriver;
	DataUtility data_Utility = new DataUtility();
	public HomePage home_Page;
	public LoginPage login_Page;
	
	//
	//
	//Changes done By Monish
	//
	//
	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome") String browserName) throws IOException
	{
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter Valid Browser Name");
		}
		listenersDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void performLogin() throws IOException
	{
		home_Page = new HomePage(driver);
		home_Page.getLoginLink().click();
		
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getEmailTextField().sendKeys(data_Utility.getDataFromProperties("email"));
		login_Page.getPassword().sendKeys(data_Utility.getDataFromProperties("pwd"));
		login_Page.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void performLogout()
	{
		login_Page = new LoginPage(driver);
		login_Page.getLogoutButton().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
}
