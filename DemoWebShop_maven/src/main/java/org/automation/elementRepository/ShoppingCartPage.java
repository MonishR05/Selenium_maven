package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage 
{
	@FindBy(name = "updatecart")
	private WebElement updateCart;
	
	@FindBy(xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")
	private WebElement removedMsg;
	

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}
	
	public WebElement getRemovedMsg() {
		return removedMsg;
	}
}
