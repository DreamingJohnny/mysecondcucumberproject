package com.mysecondcucumberproject.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FillingInFields {

	/*
	 * So, this one needs to get the driver,
	 * Get the url from the config.properties file
	 * !No, the POM will do that on its own.
	 * Create the page object send it the driver as arg to constuctor
	 * Should it do this in the "I am on the forms page then?" (probably)
	 */

	@Given("I am on the form page")
	public void i_am_on_the_form_page() {
		// Check the url and perhaps page title
		throw new io.cucumber.java.PendingException();
	}

	@When("I select {string} from the {string} options")
	public void i_select_from_the_options(String string, String string2) {
		// Based on string2, it needs to find the correct element then?
		// So, the POM will have a bunch of locators, so we need a way here to select
		// one of them
		// So a switch case going by string2?
		throw new io.cucumber.java.PendingException();
	}

	@Then("the {string} field should have {string} selected")
	public void the_field_should_have_selected(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter {string} in the {string} field")
	public void I_enter_in_the_field(String s, String s2) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the {string} field should contain {string}")
	public void the_field_should_contain(String s, String s2) {
		// Write code here that turns the phrase above into concrete actions
	}
}