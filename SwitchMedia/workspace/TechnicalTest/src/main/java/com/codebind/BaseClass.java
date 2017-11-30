/**
 * @Author: Sandeep Shriyan
 * 
 * @Date of Creation: 30/11/2017
 *
 */
package com.codebind;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static Logger logger = Logger.getLogger(BaseClass.class.getName());
	public static String emailsubject = "Test Email";
	public static String tomailid = "shriyansandy@gmail.com";
	public static String mailbody ="Hi Sandeep,"+"\n\n"+"Hope you are doing good. This is a TEST EMAIL."+"\n\n" + "Thanks,"+"\n"+"Tester";
	public static String chromeDriver = "C:\\workspace\\tea\\drivers\\chrome\\chromedriver.exe";
	public static String url = "http://www.gmail.com";
	public static String username = "testswitchmed123";
	public static String password = "Admin@123test";
	public static String wrongPassword = "Xdmin@123test";
	public static String imageFile = "C:\\SwitchMedia\\workspace\\TechnicalTest\\testdata\\ImageUpload.exe";
	public static String expectedString = "#inbox";
	public BaseClass() {
		logger.info("Default BaseClass Constructor");
	}
	static WebDriver driver;
	@BeforeMethod
	public void launchApp() throws InterruptedException{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.info("Open Gmail login page");
		driver.get(url);
		Thread.sleep(2000);
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException{
		logger.info("Closing Chrome Browser");
		Thread.sleep(300);
		driver.close();
	}
	public static boolean isElementPresent(By by) {
	    boolean isPresent = true;
	    if (driver.findElements(by).isEmpty()) {
	       isPresent = false;
	    }
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    return isPresent;
	 }
	public static void waitForTheElementToLoad(WebDriver driver, By by) {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(by));
	}
}
