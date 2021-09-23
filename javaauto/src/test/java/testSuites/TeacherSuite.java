package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.User;
import testCases.Auth;
import utilities.Utilities;

public class TeacherSuite {
	public static User user = new User("test111", "test111@test.com", "test123!");
	public static WebDriver driver = null;
	
	@BeforeTest
	public static void setupDriver() {
		driver = Utilities.startDriver(null);
		driver.get("https://beats-by-numbers.herokuapp.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public static void login_Successful() {
		Auth.login_Successful(driver, user);
	}
	
	@Test
	public static void login_Unsuccessful_IncorrectPassword() {
		Auth.login_Unsuccessful_IncorrectPassword(driver, user);
	}
}
