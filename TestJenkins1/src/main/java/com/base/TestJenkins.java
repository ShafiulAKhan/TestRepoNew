package com.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJenkins {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		if (System.getProperty("browse").equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}else if(System.getProperty("browse").equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}else if(System.getProperty("browse").equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.get("http://google.com");
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
}
