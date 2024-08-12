package com.mysecondcucumberproject.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		System.out.println("Does this even happen?");
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("the user enters valid credentials")
	public void the_user_enters_valid_credentials() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("What about this?");
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the home page")
	public void the_user_should_be_redirected_to_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
