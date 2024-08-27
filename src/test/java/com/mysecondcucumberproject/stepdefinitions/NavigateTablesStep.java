package com.mysecondcucumberproject.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateTablesStep {

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;

	@Given("the user is on the webpage")
	public void the_used_is_on_the_webpage() {
		aPHomePage = new AutomationPracticeHomePage(BaseUtilities.getWebDriver());

		Assert.assertEquals("Url didn't match!",
				BaseUtilities.getConfigProperties().getProperty("db.url").toLowerCase(),
				aPHomePage.getUrl().toLowerCase());
	}

	@When("the user sees the paginated table")
	public void the_user_sees_the_paginated_table() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the user selects all items with a price higher than {string}")
	public void the_user_selects_all_items_with_a_price_higher_than(String s) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the table should display the following books with the correct information:")
	public void the_table_should_display_the_following_books_with_the_correct_information() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the table should have a header with {string}, {string}, and {string}")
	public void the_table_should_have_a_header_with_and(String s, String s2, String s3) {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the user sees the table of books")
	public void the_user_sees_the_table_of_books() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("the user is on the {string} webpage")
	public void the_user_is_on_the_webpage(String s) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("a {string} amount of items should be selected.")
	public void a_amount_of_items_should_be_selected(String s) {
		// Write code here that turns the phrase above into concrete actions
	}
}
