package org.automation.testScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.RegisterPage;
import org.automation.genericLibrary.BaseTest1;
import org.automation.genericLibrary.DataUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterScriptsTest extends BaseTest1
{
	@Test(dataProvider = "Registration")
	public void registerTestCase(String firstname , String lastname , String email , String password , String confirmpassword) throws EncryptedDocumentException, IOException, InterruptedException
	{
		Random r1 = new Random();
		//Step 1 : Clicking on Login Link In Home Page
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getLogoutButton().click();
		
		//Step 3 : Clicking on Register Link In Home Page
		HomePage home_Page = new HomePage(driver);
		home_Page.getRegisterLink().click();
		
		//Step 4 : Validating Register Page Displayed or Not
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/register" , "Register Page Not Dispalyed");
		Reporter.log("Register Page Displayed" , true);
		
		//Step 5 : Performing Registration
		RegisterPage r = new RegisterPage(driver);
		r.getMaleRadioButton().click();
		r.getFirstName().sendKeys(firstname);
		r.getLastName().sendKeys(lastname);
		r.getEmailTextField().sendKeys(r1.nextInt(200)+email);
		r.getPasswordTextField().sendKeys(password);
		r.getConfimPasswordTextField().sendKeys(confirmpassword);
		r.getRegisterButton().click();	
		
		//Step 6 : Validating Registration
		Assert.assertEquals(r.getRegisterMsg().getText(),"Your registration completed" , "Enter Valid Credentials");
		Reporter.log("Registration Successful" , true);
		
	}
	
	//Using DataProviders
	@DataProvider(name = "Registration")
	public Object[][] dataSupply() throws EncryptedDocumentException, IOException
	{
		return DataUtility.fetchingMultipledata("RegisterTestData");
	}
}
