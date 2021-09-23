package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {
	// starts chromedriver with appropriate config
	public static ChromeDriver startDriver(HashMap<String, String> config) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		
		// check for null config
		if(config == null) {
			return new ChromeDriver();
		}
		
		// set config properties
		for(Map.Entry<String, String> entry : config.entrySet()) {
			// TODO - set config properties
			System.out.println(entry.toString());
		}

		return new ChromeDriver();
	}
	
	public static void fillOutForm(HashMap<WebElement, Object> elementsAndValues) {
		for(Map.Entry<WebElement, Object> entry : elementsAndValues.entrySet()) {
			WebElement element = entry.getKey();
			Object value = entry.getValue();
			
			// set value based on element type
			if(element.getTagName().equals("input") 
					|| element.getTagName().equals("textarea")) {
				element.sendKeys(value.toString());
			}
			
			// TODO - drop down list
			if(element.getTagName().equals("")) {
				
			}
			
			// TODO - checkbox/radio button
			if(element.getTagName().equals("")) {
				
			}
		}
	}
}
