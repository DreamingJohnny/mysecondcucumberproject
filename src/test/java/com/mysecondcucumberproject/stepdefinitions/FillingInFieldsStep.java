package com.mysecondcucumberproject.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FillingInFieldsStep {

	/*
	 * This one will have a reference to the driver, and it will need to get the
	 * driver, and create the page that it wants to have.
	 * But it won't need to bother with starting webbrowser etc, because those steps
	 * have been taken care of in the Hooks-file.
	 */

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;

	@Given("the user is on the form page")
	public void i_am_on_the_form_page() {
		aPHomePage = new AutomationPracticeHomePage(BaseUtilities.getWebDriver());
	}

	@Then("the page url should equal the url in config.properties")
	public void the_page_url_should_equal_the_url_in_config_properties() {
		Assert.assertEquals("Url didn't match!",
				BaseUtilities.getConfigProperties().getProperty("db.url").toLowerCase(),
				aPHomePage.getUrl().toLowerCase());
	}

	@Then("the page title should equal the title in config.properties")
	public void the_page_title_should_equal_the_title_in_config_properties() {
		Assert.assertEquals("Page title didn't match! Page title was: " + aPHomePage.getTitle(),
				BaseUtilities.getConfigProperties().getProperty("db.title").toLowerCase(),
				aPHomePage.getTitle().toLowerCase());
	}

	@When("the user enters {string} into the {string} field")
	public void the_user_enters_into_the_field(String input, String fieldID) {

		if (aPHomePage.canFindWebelement(fieldID)) {
			aPHomePage.setField(input, fieldID);
		} else {
			Assert.fail("Couldn't find webelement with: " + fieldID);
		}
	}

	@Then("the {string} field should display {string}")
	public void the_field_should_display(String fieldID, String input) {

		if (aPHomePage.canFindWebelement(fieldID)) {
			Assert.assertEquals("Field value was not equal to the expected value. Expected: " + input + ". Actual: "
					+ aPHomePage.getFieldAttributeValue(fieldID), input, aPHomePage.getFieldAttributeValue(fieldID));
		} else {
			Assert.fail("Couldn't find webelement with: " + fieldID);
		}
	}
}