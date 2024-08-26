package com.mysecondcucumberproject.pageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends BasePage {

	// Constructor
	public AutomationPracticeHomePage(WebDriver newDriver) {
		super(newDriver);
	}

	// Page factory style locators
	// TODO: Pretty sure I don't need the headers, and so can remove those locators.
	@FindBy(xpath = "//label[@for='textbox' and text()='Name']")
	WebElement nameHeader;
	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement nameField;

	@FindBy(xpath = "//label[@for='textbox' and text()='Email']")
	WebElement emailHeader;
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;

	@FindBy(xpath = "//label[@for='textbox' and text()='Phone']")
	WebElement phoneHeader;
	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneField;

	// Page factory locators for checkboxes
	@FindBy(xpath = "//*[@id=\"male\"]")
	WebElement maleCheckBox;
	@FindBy(xpath = "//*[@id=\"female\"]")
	WebElement femaleCheckBox;

	@FindBy(xpath = "//*[@id=\"monday\"]")
	WebElement mondayCheckBox;
	@FindBy(xpath = "//*[@id=\"tuesday\"]")
	WebElement tuesdayCheckBox;
	@FindBy(xpath = "//*[@id=\"wednesday\"]")
	WebElement wednesdayCheckBox;
	@FindBy(xpath = "//*[@id=\"thursday\"]")
	WebElement thursdayCheckBox;
	@FindBy(xpath = "//*[@id=\"friday\"]")
	WebElement fridayCheckbox;
	@FindBy(xpath = "//*[@id=\"saturday\"]")
	WebElement saturdayCheckbox;
	@FindBy(xpath = "//*[@id=\"sunday\"]")
	WebElement sundayCheckBox;

	// Action methods
	public boolean isCheckBoxSelected(String checkboxID) {
		switch (checkboxID.toLowerCase()) {
			case "male":
				return maleCheckBox.isSelected() == true ? true : false;
			case "female":
				return femaleCheckBox.isSelected() == true ? true : false;
			case "monday":
				return mondayCheckBox.isSelected() == true ? true : false;
			case "tuesday":
				return tuesdayCheckBox.isSelected() == true ? true : false;
			case "wednesday":
				return wednesdayCheckBox.isSelected() == true ? true : false;
			case "thursday":
				return thursdayCheckBox.isSelected() == true ? true : false;
			case "friday":
				return fridayCheckbox.isSelected() == true ? true : false;
			case "saturday":
				return saturdayCheckbox.isSelected() == true ? true : false;
			case "sunday":
				return sundayCheckBox.isSelected() == true ? true : false;
			default:
				// TODO: Check how to best print log messages, if System.out.println, is
				// disabled during testing.
				System.out.println("Couldn't find a checkbox using: " + checkboxID);
				return false;
		}
	}

	public void toggleCheckBox(String checkboxID) {
		switch (checkboxID.toLowerCase()) {
			case "male":
				maleCheckBox.click();
				break;
			case "female":
				femaleCheckBox.click();
				break;
			case "monday":
				mondayCheckBox.click();
				break;
			case "tuesday":
				tuesdayCheckBox.click();
				break;
			case "wednesday":
				wednesdayCheckBox.click();
				break;
			case "thursday":
				thursdayCheckBox.click();
				break;
			case "friday":
				fridayCheckbox.click();
				break;
			case "saturday":
				saturdayCheckbox.click();
				break;
			case "sunday":
				sundayCheckBox.click();
				break;
			default:
				System.out.println("Couldn't find a checkbox using: " + checkboxID);
				break;
		}
	}

	public void setField(String input, String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				nameField.clear();
				nameField.sendKeys(input);
				break;
			case "email":
				emailField.clear();
				emailField.sendKeys(input);
				break;
			case "phone":
				phoneField.clear();
				phoneField.sendKeys(input);
				break;
			default:
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				break;
		}
	}

	// TODO: If you want to keep this one, you might want to expand it further,
	// otherwise, remove it, other otherwise have public getters for the locators
	// instead?
	public boolean canFindWebelement(String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				return nameField.isDisplayed() == true ? true : false;
			case "email":
				return emailField.isDisplayed() == true ? true : false;
			case "phone":
				return phoneField.isDisplayed() == true ? true : false;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return false;
		}
	}

	public List<WebElement> getAllWeekdayCheckboxes() {
		return Arrays.asList(mondayCheckBox, tuesdayCheckBox, wednesdayCheckBox, thursdayCheckBox, fridayCheckbox,
				saturdayCheckbox, sundayCheckBox);
	};

	public String getFieldAttributeValue(String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				return nameField.getAttribute("value");
			case "email":
				return emailField.getAttribute("value");
			case "phone":
				return phoneField.getAttribute("value");
			default:
				System.out.println(this + "couldn't find a field to get the value of with the field ID of: " + fieldID);
				return null;
		}
	}

	/*
	 * Select gender
	 * Select weekday
	 * Select country
	 * Find book
	 */

}
