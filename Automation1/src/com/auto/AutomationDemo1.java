package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationDemo1
{
	static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException
	{
		

		 launchBowser();
		 loginUser();
		 clickMenu();
		 logout();
		 tearDown();
		
	}
	
	
	
	static void launchBowser()
	{
		
		String strdriverpath=System.getProperty("user.dir")+"\\Libraries\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", strdriverpath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	static void loginUser()
	{
		WebElement username=driver.findElement(By.id("user-name"));
		highlightElement(username);	
		username.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		highlightElement(password);
		password.sendKeys("secret_sauce");
		WebElement loginbtn=driver.findElement(By.name("login-button"));
		loginbtn.click();
		System.out.println("Login Successfully");
	}
	
	
	static void clickMenu() throws InterruptedException
	{
		WebElement menu=driver.findElement(By.xpath("//div[@class='bm-burger-button']/button"));
		menu.click();
		highlightElement(menu);
		Thread.sleep(5000);
		WebElement about=driver.findElement(By.xpath("//a[text()='About']"));
		highlightElement(about);
		about.click();
	}
	
	
	static void logout()
	{
		driver.navigate().back();
		WebElement menu=driver.findElement(By.xpath("//div[@class='bm-burger-button']/button"));
		highlightElement(menu);
		menu.click();
		WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
		highlightElement(logout);
		logout.click();
		
	}
	
	static void highlightElement(WebElement ele)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		
	}
	
	
	static void tearDown()
	{
		driver.close();
	}

}

