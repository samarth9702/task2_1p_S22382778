package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "E://chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		driver.manage().window().maximize();
		
		// Find first input field which is firstname
		WebElement fName = driver.findElement(By.id("firstname"));
		fName.sendKeys("Samarth");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement lName = driver.findElement(By.id("lastname"));
		lName.sendKeys("Shah");
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]"));
		phoneNumber.sendKeys("0431864282");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("samxyz@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Samarth@123");
		WebElement rPass = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
		rPass.sendKeys("Samarth_123");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement enterKey = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
		enterKey.click();
		sleep(3);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C://Users//Samarth//Desktop//Selenium Screenshot/Screen.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		driver.close();	
	}
	
	public static void amazon_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver-win64/chromedriver.exe");
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		sleep(2);
		driver.get(url);
		driver.manage().window().maximize();
		WebElement fName = driver.findElement(By.id("ap_customer_name"));
		fName.sendKeys("Samarth Shah");
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("samxyz@gmail.com");
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Samarth@123");
		WebElement rPass = driver.findElement(By.id("ap_password_check"));
		rPass.sendKeys("Samarth_123");
		
		WebElement enterKey = driver.findElement(By.id("continue"));
		enterKey.click();
		sleep(3);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C://Users//Samarth//Desktop//Selenium Screenshot/Screen2.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		sleep(2);
		driver.close();
		
	}
	
	public static void officeworks_registration_page_relativelocator(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "E://chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		driver.manage().window().maximize();
		
		// Find first input field which is firstname
		By firstName = RelativeLocator.with(By.tagName("input")).above(By.id("lastname"));
		WebElement fName = driver.findElement(firstName);
		fName.sendKeys("Samarth");

		By lastName = RelativeLocator.with(By.tagName("input")).below(By.id("firstname"));
		WebElement lName = driver.findElement(lastName);
		lName.sendKeys("Shah");
		
		By pNumber = RelativeLocator.with(By.tagName("input")).below(By.id("lastname"));
		WebElement phoneNumber = driver.findElement(pNumber);
		phoneNumber.sendKeys("0431864282");
		
		By mail = RelativeLocator.with(By.tagName("input")).below(By.xpath("//*[@id=\"phoneNumber\"]"));
		WebElement email = driver.findElement(mail);
		email.sendKeys("samxyz@gmail.com");
		
		By pass = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
		WebElement password = driver.findElement(pass);
		password.sendKeys("Samarth@123");
		
		By cPass = RelativeLocator.with(By.tagName("input")).below(By.id("password"));
		WebElement rPass = driver.findElement(cPass);
		rPass.sendKeys("Samarth@123");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		By eKey = RelativeLocator.with(By.tagName("button")).below(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[10]/div/button[1]"));
		WebElement enterKey = driver.findElement(eKey);
		enterKey.click();
		sleep(3);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C://Users//Samarth//Desktop//Selenium Screenshot/Screen.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		// Sleep a while
		sleep(2);
		
		driver.close();	
	}
}