package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends BasePage {

	//Constructor
public AutomationPracticeHomePage(WebDriver newDriver) {
	super(newDriver);
}	

//Page factory style locators
@FindBy(xpath = "//*[@id=\"name\"]")
WebElement nameField;
@FindBy(xpath = "//label[@for='textbox' and text()='Name']")
WebElement nameHeader;

@FindBy(xpath = "//*[@id=\"email\"]")
WebElement emailField;
@FindBy(xpath = "//label[@for='textbox' and text()='Email']")
WebElement emailElement;

@FindBy(xpath = "//*[@id=\"phone\"]")
WebElement phoneField;
@FindBy(xpath = "//label[@for='textbox' and text()='Phone']")
WebElement phoneHeader;

//Action methods

/*
 * Fill in namefield
 * Fill in email-field
 * Fill in phone-field
 * Select gender
 * Select weekday
 * Select country
 * Find book
 */

}
