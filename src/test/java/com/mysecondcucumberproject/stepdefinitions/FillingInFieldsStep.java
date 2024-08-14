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

	@Given("I am on the form page")
	public void i_am_on_the_form_page() {

		aPHomePage = new AutomationPracticeHomePage(BaseUtilities.getWebDriver());

		Assert.assertTrue(driver != null);
	}

	@Then("the page url should equal the url in config.properties")
	public void the_page_url_should_equal_the_url_in_config_properties() {
		Assert.assertEquals("Url didn't match!",
				BaseUtilities.getConfigProperties().getProperty("db.url").toLowerCase(),
				aPHomePage.getUrl().toLowerCase());

		Assert.assertEquals("Page title didn't match! Page title was: " + aPHomePage.getTitle(),
				BaseUtilities.getConfigProperties().getProperty("db.title").toLowerCase(),
				aPHomePage.getTitle().toLowerCase());

	}

	@When("I enter {string} in the {string} field")
	public void I_enter_in_the_field(String input, String fieldID) {
		aPHomePage.setField(input, fieldID);

	}

	@Then("the {string} field should contain {string}")
	public void the_field_should_contain(String fieldID, String expected) {
		Assert.assertEquals(aPHomePage.getFieldValue(fieldID).toLowerCase(), expected);

	}

	@When("I select {string} from the {string} options")
	public void i_select_from_the_options(String input, String fieldID) {

	}

	@Then("the {string} field should have {string} selected")
	public void the_field_should_have_selected(String fieldID, String expected) {
	}
}