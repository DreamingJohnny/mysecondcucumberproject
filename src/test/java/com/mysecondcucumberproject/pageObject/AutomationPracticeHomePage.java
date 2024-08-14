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

	// Think through, should the tests then have other methods for that?
	// Yes, this one has the methods for setting and getting. And they are tested in
	// the testfile

	public void setField(String input, String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				nameField.sendKeys(input);
				break;
			case "email":
				emailField.sendKeys(input);
				break;
			case "phone":
				phoneField.sendKeys(input);
				break;
			default:
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				break;
		}
	}

	public String getFieldValue(String fieldID) {
		switch (fieldID) {
			case "name":
				return nameField.getText();

			case "email":
				return emailField.getText();
			case "phone":
				return phoneField.getText();

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
