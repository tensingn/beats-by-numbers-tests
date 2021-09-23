package forms;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javaauto.elements.CommonElements;

public class Forms {
	public static List<WebElement> login(WebDriver driver) {
		List<WebElement> form = new ArrayList<WebElement>();
		form.add(CommonElements.textField_ByLabel(driver, "Email"));
		form.add(CommonElements.textField_ByLabel(driver, "Password"));
		
		return form;
	}
	
	
	/**
	 * @author nicktensing
	 * @param elements
	 * @param values
	 * @return void
	 * @exception IllegalArgumentException
	 * @implNote Fills out a form. Enters each value into the corresponding WebElement.
	 * @implNote Lists must be same size.
	 */
	public static void fillOut(List<WebElement> elements, List<Object> values) throws IllegalArgumentException {
		// lists can't be null
		if(elements == null || values == null) {
			throw new IllegalArgumentException("Elements list and values list must not be null.");
		}
		
		// sizes must be equal
		if(elements.size() != values.size()) {
			throw new IllegalArgumentException("Elements list and values list must be same size.");
		}
		
		// fill out list
		for(int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);
			Object value = values.get(i);
			
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
