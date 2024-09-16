package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

	PracticeFormPage(WebDriver newDriver) {
		super(newDriver);
	}

//So, this one, it will be possible to create it, and to do that it will... it will be created with a url, just like the other stuff.
//So where is this one given it's url then?
//So, that's actually hardcoded in the driver, so I need a way to set that somewhere/somehow else?


	//TODO: Don't like these xpaths, will want to check why I can't rewrite them after seeing if these work.
	//I wish they were more easily readible than they are.

	// Page factory style locators

	@FindBy(xpath = "//*[@id='RESULT_TextField-0']")
	WebElement nameField;
	@FindBy(xpath = "//*[@id='RESULT_TextField-2']")
	WebElement dOBFieldOld;
	@FindBy(xpath = "//*[@id='q4']/span")
	WebElement calendarIcon;
}
