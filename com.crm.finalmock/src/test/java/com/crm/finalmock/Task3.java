package com.crm.finalmock;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;

public class Task3  extends DwsBase{
	
	 @Test(priority = 1)
	    public void verifyPageUrl() {
	        String expectedUrl = "https://demowebshop.tricentis.com/";
	        String Actual_result = driver.getCurrentUrl();
			 assertEquals(expectedUrl, Actual_result,"I Am Not DWS");
			 Reporter.log("I Am DWS Page",true);
	        
	       
	    }

	    @Test(priority = 2)
	    public void clickLoginLink() {
	    	//driver.findElement(By.xpath("//a[text()='Log in']")).click();
	    	WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
	        loginLink.click();
	        assertTrue(driver.getCurrentUrl().contains("/login"),"Search Button Is Not Enable");
			 Reporter.log("Search Button Is Enable");
	       
	    }

	    @Test(priority = 3)
	    public void verifyDropdownElements() {
	        driver.get("https://demowebshop.tricentis.com/books"); // Navigate to a page with dropdowns

	        // Verify Sort By dropdown
	        WebElement sortByDropdown = driver.findElement(By.id("products-orderby"));
	        printDropdownOptions(sortByDropdown, "Sort By");

	        // Verify Display dropdown
	        WebElement displayDropdown = driver.findElement(By.id("products-pagesize"));
	        printDropdownOptions(displayDropdown, "Display");

	        // Verify View As dropdown
	        WebElement viewAsDropdown = driver.findElement(By.id("products-viewmode"));
	        printDropdownOptions(viewAsDropdown, "View As");
	    }
	    
	    
	    public  void printDropdownOptions(WebElement dropdownElement, String dropdownName) {
	        Select dropdown = new Select(dropdownElement);
	        List<WebElement> options = dropdown.getOptions();

	        System.out.println("Options in " + dropdownName + " dropdown:");
	        for (WebElement option : options) {
	            System.out.println(" - " + option.getText());
	        }
	    }
}