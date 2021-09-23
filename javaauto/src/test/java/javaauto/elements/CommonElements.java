package javaauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElements {
	// wait that is used for every element
	private static WebDriverWait wait = null;
	private static String xpath = null;
	private static int standardWait = 10;
	
	// text field by label
	public static WebElement textField_ByLabel(WebDriver driver, String label) {
		xpath = "//label[contains(text(),'" + label + "')]/following-sibling::input";
		wait = new WebDriverWait(driver, standardWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}
	
	// button by text (not in nav)
	public static WebElement button_ByText(WebDriver driver, String text) {
		xpath = "//button[not(ancestor::nav) and text()='" + text + "']";
		wait = new WebDriverWait(driver, standardWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}
}
