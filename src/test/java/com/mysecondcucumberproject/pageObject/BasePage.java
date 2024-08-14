package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	// Constructor
	BasePage(WebDriver newDriver) {
		this.driver = newDriver;
		PageFactory.initElements(newDriver, this);
	}

}
