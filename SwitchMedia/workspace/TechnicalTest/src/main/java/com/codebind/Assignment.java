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
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment extends BaseClass{
	static Logger logger = Logger.getLogger(Assignment.class.getName());
	public Assignment() {
		System.out.println("Default Constructor");
	}
	@Test(description = "Test case is to send an email with attachment")
	public void validLoginTest() throws InterruptedException{
		logger.info("Logging into Gmail account");
		Assert.assertEquals(isElementPresent(GmailSigninPage.emailInputField),true,"Email Input field exists");
		driver.findElement(GmailSigninPage.emailInputField).sendKeys(username);
		waitForTheElementToLoad(driver,GmailSigninPage.emailInputNextButton);
		driver.findElement(GmailSigninPage.emailInputNextButton).click();
		waitForTheElementToLoad(driver,GmailSigninPage.passwordField);
		Assert.assertEquals(isElementPresent(GmailSigninPage.passwordField),true,"Password field exists");
		driver.findElement(GmailSigninPage.passwordField).sendKeys(password);
		waitForTheElementToLoad(driver,GmailSigninPage.submitButtton);
		Assert.assertEquals(isElementPresent(GmailSigninPage.submitButtton),true,"Submit button exists");
		driver.findElement(GmailSigninPage.submitButtton).click();
		waitForTheElementToLoad(driver,GmailInboxPage.composeButton);
		logger.info("Verifying whether login is successful");
		if (driver.getCurrentUrl().contains(expectedString)){
			Assert.assertEquals(driver.getCurrentUrl().contains(expectedString),true,"Log in is Sucessfull");	
			logger.info("Composing an email");
			Assert.assertEquals(isElementPresent(GmailInboxPage.composeButton),true,"Compose button exists");
			driver.findElement(GmailInboxPage.composeButton).click();
			waitForTheElementToLoad(driver,GmailInboxPage.maximizeButton);
			driver.findElement(GmailInboxPage.maximizeButton).click();
			Assert.assertEquals(isElementPresent(GmailInboxPage.toField),true,"To field exists");
			driver.findElement(GmailInboxPage.toField).click();
			driver.findElement(GmailInboxPage.toField).sendKeys(tomailid);
			Assert.assertEquals(isElementPresent(GmailInboxPage.subjectField),true,"Subject field exists");
			driver.findElement(GmailInboxPage.subjectField).click();
			driver.findElement(GmailInboxPage.subjectField).sendKeys(emailsubject);
			Assert.assertEquals(isElementPresent(GmailInboxPage.emailBody),true,"Email Body exists");
			driver.findElement(GmailInboxPage.emailBody).click();
			driver.findElement(GmailInboxPage.emailBody).sendKeys(mailbody);
			waitForTheElementToLoad(driver,GmailInboxPage.attachButton);
			Assert.assertEquals(isElementPresent(GmailInboxPage.attachButton),true,"Attach button exists");
			driver.findElement(GmailInboxPage.attachButton).click();
			Thread.sleep(500);	
			logger.info("Adding an attachment");
			try {
				Runtime.getRuntime().exec(imageFile);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(5000);		
			logger.info("Sending an email");
			waitForTheElementToLoad(driver,GmailInboxPage.sendButton);
			Assert.assertEquals(isElementPresent(GmailInboxPage.sendButton),true,"Send button exists");
			driver.findElement(GmailInboxPage.sendButton).click();
			logger.info("Logging out of Gmail account");
			waitForTheElementToLoad(driver,GmailInboxPage.profilePic);
			Assert.assertEquals(isElementPresent(GmailInboxPage.profilePic),true,"Profile Pic exists");
			driver.findElement(GmailInboxPage.profilePic).click();
			waitForTheElementToLoad(driver,GmailInboxPage.signOut);
			Thread.sleep(300);	
			Assert.assertEquals(isElementPresent(GmailInboxPage.signOut),true,"Sign out button exists");
			driver.findElement(GmailInboxPage.signOut).click();		
		}
		else {
			String errorMessage = driver.findElement(GmailSigninPage.wrongCredentialText).getText();
			logger.info("Log in failed with the error message : "+errorMessage);
		}			
	}
}
