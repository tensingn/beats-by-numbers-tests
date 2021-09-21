package javaauto.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
	public static WebElement tab_ByName(WebDriver driver, String name) {
		return driver.findElement(By.xpath("//nav//ul/li/a[text()='" + name + "' "
				+ "or contains(text(),'" + name + "')]"));
	}
}
