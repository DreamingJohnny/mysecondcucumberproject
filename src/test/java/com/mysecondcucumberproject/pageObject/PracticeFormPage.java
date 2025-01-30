package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.mysecondcucumberproject.utilities.TestConstants;

public class PracticeFormPage extends BasePage {

	PracticeFormPage(WebDriver newDriver) {
		super(newDriver);
	}

	// Page factory style locators
	@FindBy(xpath = "//*[@id='RESULT_TextField-0']")
	WebElement nameField;
	

	// So, I want a getter for the element of the dropdown, so that I can use it in
	// canFind... but the parts of it... I can look at those individually. But then,
	// needs to check if null on top of dislayed etc.

	public boolean canFindWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID -> {
                            return (nameField.isDisplayed() && nameField.isEnabled());
                }
			
			default -> {
                            System.out.println("Couldn't find the element enabled and displayed using: " + fieldID);
                            return false;
                }
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			
			default -> {
                            System.out.println("Couln't find a webelement using: " + fieldID);
                            return null;
                }
		}
	}

	public boolean trySetField(String userInput, String fieldID) {
		if (!canFindWebelement(fieldID)) {
			return false;
		}

		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID -> {
                            nameField.clear();
                            nameField.sendKeys(userInput);
                            return true;
                }

			default -> {
                            System.out.println(this + " couldn't find a field with a value to set with the fieldID " + fieldID);
                            return false;
                }
		}
	}

	// TODO: Fix so that this method is an overload of a method in the parent
	// basepage.
	public String getFieldValue(String elementID) {
		if (!canFindWebelement(elementID)) {
			return "";
		}

		switch (elementID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID -> {
                            return nameField.getDomAttribute("value");
                }
			
			default -> {
                            System.out.println(this + "couldn't find an element to get the value of with the ID of: " + elementID);
                            return null;
                }
		}
	}

	

	
	public String getSelectedText(String elementID) {

		if (!canFindWebelement(elementID)) {
			return "";
		}

		Select tempSelect;
		try {
			tempSelect = new Select(getWebelement(elementID));
		} catch (UnexpectedTagNameException e) {
			// TODO: Look into what a message of this kind contains, and what value my
			// additional messages might give, if any.
			System.out.println("Couldn't create a select object from the web element");
			System.out.println(e.getMessage());
			takeScreenShot(elementID);
			return "";
		}

		try {
			return tempSelect.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			takeScreenShot(elementID);
			return "";
		}
	}

	public boolean tryClickButton(String calendarbuttonId) {
		if (!canFindWebelement(calendarbuttonId)) {
			return false;
		}

		try {
			getWebelement(calendarbuttonId).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (ElementNotInteractableException e) {
			System.out.println(e.getMessage());
			return false;
		}

		// TODO: So, ask MY here, should I have a general catch here as well? That
		// handles the cases I haven't thought of? Or is it instead better to have the
		// program throw a sever error in those cases?
		return true;
	}

	public boolean tryGetDOBDropdown() {

		// So, needs to see if it can get the dropdown then... So will need to use
		// findElement here then? So this one I want to wrap like a getter?
		// Do I even want to give this one a way of being a "Select" then? (No, that
		// might be too clever for my own good)

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'tryGetDOBDropdown'");
	}
}