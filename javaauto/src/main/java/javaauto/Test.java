package javaauto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javaauto.elements.Elements;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://beats-by-numbers.herokuapp.com/");
		Elements.tab_ByName(driver, "All Worksheets").click();
		Elements.tab_ByName(driver, "Home").click();
	}
}
