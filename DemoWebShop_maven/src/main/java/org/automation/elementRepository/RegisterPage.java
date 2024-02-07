package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	@FindBy(id = "gender-male")
	private WebElement maleRadioButton;
	
	@FindBy(name = "FirstName")
	private WebElement firstName;
	
	@FindBy(name = "LastName")
	private WebElement lastName;
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;

	@FindBy(id = "ConfirmPassword")
	private WebElement confimPasswordTextField;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	private WebElement registerMsg;

	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfimPasswordTextField() {
		return confimPasswordTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	public WebElement getRegisterMsg() {
		return registerMsg;
	}
	
	
	
	
}
