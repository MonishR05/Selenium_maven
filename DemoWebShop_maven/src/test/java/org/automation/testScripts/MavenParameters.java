package org.automation.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenParameters 
{
	public void testCase() throws InterruptedException
	{
		String url=System.getProperty("URL");
		String userName=System.getProperty("USERNAME");
		String password=System.getProperty("PASSWORD");
		
		System.out.println("Url :"+url);
		System.out.println("UserName :"+userName);
		System.out.println("Password :"+password);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
