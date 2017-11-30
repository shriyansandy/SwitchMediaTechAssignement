/**
 * @Author: Sandeep Shriyan
 * 
 * @Date of Creation: 30/11/2017
 *
 */
package com.codebind;
import org.openqa.selenium.By;
public class GmailSigninPage {
	public static By hiText = By.xpath(".//*[@id='headingText']");
	public static By emailInputField = By.xpath(".//*[@id='identifierId']");
	public static By passwordField = By.xpath(".//*[@id='password']/div[1]/div/div[1]/input");
	public static By emailInputNextButton = By.xpath(".//*[@id='identifierNext']/content/span");
	public static By submitButtton = By.xpath(".//*[@id='passwordNext']/content/span");
	public static By wrongCredentialText = By.xpath(".//*[@id='password']/div[2]/div[2]");
	public static By wrongUserName = By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]");
	public GmailSigninPage() {
	}	
}
