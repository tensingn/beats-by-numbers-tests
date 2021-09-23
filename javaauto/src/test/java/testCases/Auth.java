package testCases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
		
		// enter username and password
		CommonElements.textField_ByLabel(driver, "Email").sendKeys(tester.getEmail());
		CommonElements.textField_ByLabel(driver, "Password").sendKeys(tester.getPassword());
		
		// click login
		CommonElements.button_ByText(driver, "Login").click();
		
		// verify login is successful (i.e. logout button is displayed)
		if(!NavBarElements.button_ByName(driver, "Logout").isDisplayed()) {
			Assert.fail("Step 1 failed. Login successful.");
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
		
		// enter username and password
		CommonElements.textField_ByLabel(driver, "Email").sendKeys(tester.getEmail());
		CommonElements.textField_ByLabel(driver, "Password").sendKeys("wrong password");
		
		// click login
		CommonElements.button_ByText(driver, "Login").click();
		
		// verify login is unsuccessful (i.e. logout button is not displayed)
		if(NavBarElements.button_ByName(driver, "Logout").isDisplayed()) {
			Assert.fail("Step 1 failed. Login successful.");
		}
	}
}
