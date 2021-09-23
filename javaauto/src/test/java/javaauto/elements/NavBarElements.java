package javaauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarElements {
	// wait that is used for every element
	private static WebDriverWait wait = null;
	private static String xpath = null;
	private static int standardWait = 10;
	
	// navbar tabs by name
	public static WebElement tab_ByName(WebDriver driver, String name) {
		xpath = "//nav//ul/li/a[text()='" + name + "' "
				+ "or contains(text(),'" + name + "')]";
		wait = new WebDriverWait(driver, standardWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}
	
	// navbar buttons by name
	public static WebElement button_ByName(WebDriver driver, String name) {
		xpath = "//nav//a[text()='" + name + "']";
		wait = new WebDriverWait(driver, standardWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}
}
