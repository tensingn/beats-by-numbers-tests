package testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import forms.Forms;
import javaauto.elements.CommonElements;
import javaauto.elements.NavBarElements;
import objects.User;

public class Auth {
	public static int standardWait = 10;
	
	/*
	 * Author: tensingn
	 * Name: Login Successful
	 * Description: Tests that a user can login with correct credentials.
	 * Prerequisites: None
	 * Notes: None
	 */
	public static void login_Successful(WebDriver driver, User tester) {
		// click login button
		NavBarElements.button_ByName(driver, "Login").click();
		
		// fill out login form
		Forms.fillOut(
				Forms.login(driver), 
				new ArrayList<Object>(Arrays.asList(tester.getEmail(), tester.getPassword()))
		);
		
		// click login
		CommonElements.button_ByText(driver, "Login").click();
		
		// verify login is successful (i.e. logout button is displayed)
		WebDriverWait wait = new WebDriverWait(driver, standardWait);
		try {
			wait.until(ExpectedConditions.visibilityOf(NavBarElements.button_ByName(driver, "Logout")));
		} catch(Exception e) {
			Assert.fail("Step 1 failed. Login unsuccessful.");
		}
	}
	
	
	/*
	 * Author: tensingn
	 * Name: Login Unsuccessful - Incorrect Password
	 * Description: Tests that a user cannot login with incorrect password.
	 * Prerequisites: None
	 * Notes: None
	 */
	public static void login_Unsuccessful_IncorrectPassword(WebDriver driver, User tester) {
		// click login button
		NavBarElements.button_ByName(driver, "Login").click();
		
		// fill out login form
		Forms.fillOut(
				Forms.login(driver), 
				new ArrayList<Object>(Arrays.asList(tester.getEmail(), tester.getPassword()))
		);
		
		// click login
		CommonElements.button_ByText(driver, "Login").click();
		
		// verify login is unsuccessful (i.e. alert is present and logout button is not displayed)
		WebDriverWait wait = new WebDriverWait(driver, standardWait);
		try {
			// check for alert
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			
			// check for logout button not displayed
			if(NavBarElements.button_ByName(driver, "Logout").isDisplayed()) {
				Assert.fail("Step 1 failed. Login successful.");
			}
		} catch(Exception e) {
			Assert.fail("Step 1 failed. Alert not displayed.");
		}
	}
	
	
	/*
	 * Author: tensingn
	 * Name: Login Unsuccessful - Incorrect Email
	 * Description: Tests that a user cannot login with incorrect password.
	 * Prerequisites: None
	 * Notes: None
	 */
	public static void login_Unsuccessful_IncorrectEmail(WebDriver driver, User tester) {
		// click login button
		NavBarElements.button_ByName(driver, "Login").click();
		
		// fill out login form
		Forms.fillOut(
				Forms.login(driver), 
				new ArrayList<Object>(Arrays.asList("wrongemail@wrong.com", tester.getPassword()))
		);
		
		// click login
		CommonElements.button_ByText(driver, "Login").click();
		
		// verify login is unsuccessful (i.e. alert is present and logout button is not displayed)
		WebDriverWait wait = new WebDriverWait(driver, standardWait);
		try {
			wait.until(ExpectedConditions.invisibilityOf(NavBarElements.button_ByName(driver, "Login")));
			Assert.fail("Step 1 failed. Login unsuccessful.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
