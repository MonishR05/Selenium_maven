package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility 
{
	Select s ;
	WebDriver driver;
	Actions act;
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(7000);
	}
	public void takeScreenShot(WebDriver driver , String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;	
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(frameWorkConstants.screenShot_Path+name+".png");
		FileHandler.copy(src, trg);
	}
	
	//DropDown Using JavaScriptExecutor
	public void dropDownByJavaScriptExecutor()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(1000,0);");
	}
	
	public void dropDownByUsingAction()
	{
		WebElement trg = driver.findElement(By.xpath(""));
		act = new Actions(driver);
		//Scroll Till WebElement
		act.scrollToElement(trg).perform();
	}
	//DropDown Using Select Class
	public void selectDropDownByIndex(WebElement dropDown , int indexNum)
	{
		s = new Select(dropDown);
		s.selectByIndex(indexNum);
	}
	
	public void selectDropDownByValue(WebElement dropDown , String value)
	{
		s = new Select(dropDown);
		s.selectByValue(value);
	}
	public void selectDropDownByVisibleText(WebElement dropDown , String visibleText)
	{
		s = new Select(dropDown);
		s.selectByVisibleText(visibleText);
	}
	
	//Scrolling Using Action Class
	public void scrollUsingAction()
	{
		act = new Actions(driver);
		act.scrollByAmount(0, 0).perform();
	}
	public void scrollUsingAction2()
	{
		WebElement trg = driver.findElement(By.xpath(" "));
		act = new Actions(driver);
		act.scrollToElement(trg).perform();
	}
	public void scrollUsingAction3()
	{
		ScrollOrigin Sc = ScrollOrigin.fromElement(driver.findElement(By.id(" ")));
		act = new Actions(driver);
		act.scrollFromOrigin(Sc, 0, 100).perform();
	}
}
