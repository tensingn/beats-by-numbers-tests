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
}
