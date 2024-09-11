package com.mysecondcucumberproject.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;
import com.mysecondcucumberproject.utilities.TestConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InteractingWithOtherElements {

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;

	@Given("the user sees the container for {string}")
	public void the_user_sees_the_container_for(String elementID) {

		Assert.assertTrue("Couldn't find a webelement usig the string id: " + elementID,
				aPHomePage.canFindWebelement(elementID));
	}

	@When("the user navigates to the searchbar")
	public void the_user_navigates_to_the_searchbar() {
		// TODO: Remove this if not needed to switch frame or so for the search bar.
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user enters {string} into the searchbar")
	public void the_user_enters_into_the_searchbar(String searchInput) {

		if (aPHomePage.canFindWebelement(TestConstants.TABSINPUTSEARCHFIELD_ID)) {
			aPHomePage.setField(searchInput, TestConstants.TABSINPUTSEARCHFIELD_ID);
		} else {
			// TODO: Check if this then invalidates the whole scenario, I think it does,
			// ideally, it shouldn't try the next step.
			Assert.fail("Couldn't find the search bar with the string id: " + TestConstants.TABSINPUTSEARCHFIELD_ID);
		}
	}

	@When("the user selects the {string} result")
	public void the_user_selects_the_result(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user navigates to the new tab")
	public void the_user_navigates_to_the_new_tab() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the url of the new window is {string}")
	public void the_url_of_the_new_window_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String buttonID) {

		// TODO: Check with MY, should I rework this so that it does the check in the
		// method instead? Why not right?
		if (aPHomePage.canFindWebelement(buttonID)) {
			aPHomePage.clicksButton(buttonID);
		}
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the pop-up window opens")
	public void the_pop_up_window_opens() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user clicks on the button in the window to dismiss it")
	public void the_user_clicks_on_the_button_in_the_window_to_dismiss_it() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the {string} in the pop-up window")
	public void the_user_clicks_on_the_in_the_pop_up_window(String s) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the pop-up window has disappeared")
	public void the_pop_up_window_has_disappeared() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the pop-up window has a input field")
	public void the_pop_up_window_has_a_input_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user fills in the field with {string} and confirms")
	public void the_user_fills_in_the_field_with_and_confirms(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user inputs {string} to {string}")
	public void the_user_inputs_to(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user double clicks on the {string} button.")
	public void the_user_double_clicks_on_the_button(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("{string} and {string} should contain the same data")
	public void and_should_contain_the_same_data(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user moves the draggable object into the target object")
	public void the_user_moves_the_draggable_object_into_the_target_object() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user sees the {string}")
	public void the_user_sees_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user uses the cursor to move the slider to a new position")
	public void the_user_uses_the_cursor_to_move_the_slider_to_a_new_position() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the slider is in the new position")
	public void the_slider_is_in_the_new_position() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user switches to {string}")
	public void the_user_switches_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the {string} field should contain {string}")
	public void the_field_should_contain(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user selects {string} from the {string}")
	public void the_user_selects_from_the(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the {string} contains {string}")
	public void the_contains(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user inputs {string}")
	public void the_user_inputs(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the {string} should contain {string} according to {string}")
	public void the_should_contain_according_to(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user clicks on the calendar icon")
	public void the_user_clicks_on_the_calendar_icon() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the user selects {string}")
	public void the_user_selects(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user uses the cursor to change the size of the object")
	public void the_user_uses_the_cursor_to_change_the_size_of_the_object() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
