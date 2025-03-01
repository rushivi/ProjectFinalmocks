package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DwsBase {
	
	public static WebDriver driver = null;
	public static String browser ="chrome";
	
	@BeforeClass
	public void preeconditon() throws IOException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		else {
			
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		
		
		driver.findElement(By.className("ico-login")).click();
		
		driver.findElement(By.id("Email")).sendKeys("admin01@gmail.com");
		
		driver.findElement(By.id("Password")).sendKeys("admin01");
		
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
		System.out.println("login successfull");
	}
	@AfterMethod
	public void logout() {
		
		driver.findElement(By.className("ico-logout")).click();
		
		System.out.println("logout successfull");
	}
	@AfterClass
	public void postcondition() {
		
		driver.quit();
	}
	
	
	
	}


