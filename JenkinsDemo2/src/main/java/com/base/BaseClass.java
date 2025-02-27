package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	String gekkoDriverPath = "C:/Devops/gekkodriver/geckodriver.exe";
	String chromeDriverPath = "C:/Devops/chromedriver/chromedriver.exe";
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", gekkoDriverPath);
			driver = new FirefoxDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
	}	
	@AfterMethod
	public void tearDown() {
			driver.close();
	}	

}
