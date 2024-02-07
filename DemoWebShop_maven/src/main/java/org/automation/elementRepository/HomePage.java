package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath  = "//a[text()='Register']")
	private WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartBucket;
	
	@FindBy(xpath = "//ul[1][@class='top-menu']//a[contains(text(),'Books')]")
	private WebElement books;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListBucket;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartBucket() {
		return shoppingCartBucket;
	}

	public WebElement getBooks() {
		return books;
	}

	public WebElement getWishListBucket() {
		return wishListBucket;
	}
	
	
}
