package org.automation.testScripts;

import java.util.List;

import org.automation.elementRepository.BooksPage;
import org.automation.elementRepository.FictionExPage;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.ShoppingCartPage;
import org.automation.elementRepository.WishlistPage;
import org.automation.genericLibrary.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WishListScriptsTest extends BaseTest1
{
	public HomePage home_Page;
	@Test
	public void wishListScripts()
	{
		//Step 1 : Clicking on Books Tab
		home_Page = new HomePage(driver);
		home_Page.getBooks().click();
		
		//Step 2 : Validating Whether Books Page Displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books" , "Books Page Not Displayed");
		Reporter.log("Books Page Displayed " , true);
		
		//Step 3 : Clicking on FictionEx ProductLink
		BooksPage book_Page = new BooksPage(driver);
		book_Page.getFictionExlink().click();
		
		//Step 4 : Validating Whether FictionEx Product Displayed
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Fiction EX')]")).getText(),"Fiction EX" , "Product Not Visible");
		Reporter.log("Fiction Ex Product Displayed" , true);
		
		//Step 5 : Adding Product To WishList Cart
		FictionExPage add_To_Wishlist = new FictionExPage(driver);
		add_To_Wishlist.getAddToWishlist().click();
		
		//Step 6 : Clicking on WishList Bucket
		home_Page = new HomePage(driver);
		home_Page.getWishListBucket().click();
		
		//Step 7 : Validating Whether FictionEx Displayed In WishList Page
		Assert.assertEquals(book_Page.getFictionExlink().getText(),"Fiction EX" , "FictionEx is Not Displayed In Wishlist Page");
		Reporter.log("FictionEx Displayed in Wishlist Page" , true);
		
		//Step 8 : Clicking on CheckBox
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for(WebElement checkboxs : checkbox)
		{
			checkboxs.click();
		}
		
		//Step 9 : Clicking on UpdateWishlist
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		shoppingCart.getUpdateCart().click();
		
		//Step 10 : Validating Whether FictionEx Removed From Cart
		WishlistPage wishlist = new WishlistPage(driver);
		Assert.assertEquals(wishlist.getRemovedWishlist().getText(),"The wishlist is empty!" , "FictionEx Not Removed From Wishlist");
		Reporter.log("FictionEx Removed From Wishlist", true);
	}
}
