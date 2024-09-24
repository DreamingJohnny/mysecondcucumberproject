package com.mysecondcucumberproject.pageObject;

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

	// TODO: Don't like these xpaths, will want to check why I can't rewrite them
	// after seeing if these work.
	// I wish they were more easily readible than they are.

	// Page factory style locators

	@FindBy(xpath = "//*[@id='RESULT_TextField-0']")
	WebElement nameField;
	@FindBy(xpath = "//*[@id='RESULT_TextField-2']")
	WebElement DOBField;
	@FindBy(xpath = "//*[@id='q4']/span")
	WebElement calendarIcon;
	@FindBy(xpath = "//*[@id=\"RESULT_RadioButton-3\"]")
	WebElement workDropDown;

	public boolean canFindWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return (nameField.isDisplayed() && nameField.isEnabled());
			case TestConstants.FRAMEWORKDROPDOWN_ID:
				return (workDropDown.isDisplayed() && workDropDown.isEnabled());
			case TestConstants.FRAMEDOBFIELD_ID:
				return (DOBField.isDisplayed() && DOBField.isEnabled());
			default:
				System.out.println("Couldn't find the element enabled and displayed using: " + fieldID);
				return false;
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return nameField;
			case TestConstants.FRAMEWORKDROPDOWN_ID:
				return workDropDown;
			case TestConstants.FRAMEDOBFIELD_ID:
				return DOBField;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return null;
		}
	}

	public boolean trySetField(String userInput, String fieldID) {
		if (!canFindWebelement(fieldID)) {
			return false;
		}

		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				nameField.clear();
				nameField.sendKeys(userInput);
				return true;
			case TestConstants.FRAMEDOBFIELD_ID:
				DOBField.clear();
				DOBField.sendKeys(userInput);
				return true;
			default:
				System.out.println(this + " couldn't find a field with a value to set with the fieldID " + fieldID);
				return false;
		}
	}

	// TODO: Fix so that this method is an overload of a method in the parent
	// basepage.
	public String getFieldValue(String elementID) {
		if (!canFindWebelement(elementID)) {
			return "";
		}

		switch (elementID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return nameField.getAttribute("value");
			case TestConstants.FRAMEDOBFIELD_ID:
				return DOBField.getAttribute("value");
			default:
				System.out.println(this + "couldn't find an element to get the value of with the ID of: " + elementID);
				return null;
		}
	}

	public boolean trySelectInDropdown(String userSelection, String elementID) {

		if (!canFindWebelement(elementID))
			return false;

		Select dropDown;

		try {
			dropDown = new Select(getWebelement(elementID));
		} catch (UnexpectedTagNameException e) {
			System.out.println("Couldn't create a select object from the web element");
			System.out.println(e.getMessage());
			return false;
		}

		try {
			dropDown.selectByVisibleText(userSelection);
		} catch (NoSuchElementException e) {
			System.out.println("Couldn't find an element using this value.");
			System.out.println(e.getMessage());
			return false;
		}

		return true;
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
}