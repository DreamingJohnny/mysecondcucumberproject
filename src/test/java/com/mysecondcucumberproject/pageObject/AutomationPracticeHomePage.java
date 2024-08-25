package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends BasePage {

	// Constructor
	public AutomationPracticeHomePage(WebDriver newDriver) {
		super(newDriver);
	}

	// Page factory style locators
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

	// Action methods
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
