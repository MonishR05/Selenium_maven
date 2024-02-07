package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckBox;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;
	
	@FindBy(partialLinkText = "Log")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]")
	private WebElement digitalDowloads;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement addToCart;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getDigitalDowloads() {
		return digitalDowloads;
	}
	
	
	
}
