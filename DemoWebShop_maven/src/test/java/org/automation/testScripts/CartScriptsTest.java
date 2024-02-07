package org.automation.testScripts;

import java.util.List;

import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.ShoppingCartPage;
import org.automation.genericLibrary.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.automation.genericLibrary.ListenersImplementation.class)
public class CartScriptsTest extends BaseTest1
{
	@Test
	public void cartTestScripts() throws InterruptedException
	{
		//Step 1 : Clicking Digital downloads in Login Page
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getDigitalDowloads().click();
		
		//Step 2 : Validating
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/digital-downloads" , "Digital Download Page Not Displayed");
		Reporter.log("Digital Download Page Displayed" , true);
		
		//Step 3 : Adding Products To Shopping Cart
		List<WebElement> addToCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for(WebElement addToCarts : addToCart)
		{
			
			addToCarts.click();
			Thread.sleep(2000);
		}
		
		//Step 4 : Clicking on ShoppingCart Icon
		HomePage home_Page = new HomePage(driver);
		home_Page.getShoppingCartBucket().click();
		
		//Step 5 : Validating Whether ShoppingCart Page Displayed or Not
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart" , "Shopping Cart Page Not Displayed");
		Reporter.log("ShoppingCart Page Displayed" , true);
		
		//Step 6 : Validating Whether All the Products Are Added To Cart Or Not
		List<WebElement> products = driver.findElements(By.xpath("//a[@class='product-name']"));
		if(addToCart.size()==products.size())
		{
			Reporter.log("All The Products Added To cart" , true);
		}
		else
			Reporter.log("try Again ,true");
		
		
		//Step 7 : Clicking on CheckBox
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for(WebElement checkboxs : checkbox)
		{
			checkboxs.click();
		}
		
		//Step 8 : Clicking on UpdateCart in ShoppingCart Page
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		shoppingCart.getUpdateCart().click();
		
		//Step 9 : Validating Whether All The Products Are Removed From Cart
		Assert.assertEquals(shoppingCart.getRemovedMsg().getText(), "Your Shopping Cart is empty!" , "All The Products Not Removed");
		Reporter.log("All The Products Are Removed" , true);
		
	}
}
