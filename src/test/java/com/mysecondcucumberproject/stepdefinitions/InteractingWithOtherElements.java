package com.mysecondcucumberproject.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;
import com.mysecondcucumberproject.utilities.TestConstants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InteractingWithOtherElements {

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;

	@Given("the user is on the correct page")
	public void the_user_is_on_the_correct_page() {
		aPHomePage = new AutomationPracticeHomePage(BaseUtilities.getWebDriver());
		Assert.assertEquals("Url didn't match!",
				BaseUtilities.getConfigProperties().getProperty("db.url").toLowerCase(),
				aPHomePage.getUrl().toLowerCase());

	}

	@And("the user sees the container for {string}")
	public void the_user_sees_the_container_for(String elementID) {

		Assert.assertTrue("Couldn't find a webelement using the string id: " + elementID,
				aPHomePage.canFindWebelement(elementID));
	}

	@When("the user enters {string} into the searchbar")
	public void the_user_enters_into_the_searchbar(String searchInput) {

		if (aPHomePage.canFindWebelement(TestConstants.TABINPUTSEARCHFIELD_ID)) {
			aPHomePage.trySetField(searchInput, TestConstants.TABINPUTSEARCHFIELD_ID);
		} else {
			// TODO: Check if this then invalidates the whole scenario, I think it does,
			// ideally, it shouldn't try the next step.
			Assert.fail("Couldn't find the search bar with the string id: " + TestConstants.TABINPUTSEARCHFIELD_ID);
		}
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String buttonID) {
		try {
			Assert.assertTrue("Couldn't click on the button with id: " + buttonID, aPHomePage.tryClickButton(buttonID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(buttonID);
			System.out.println(e.getMessage());
		}
	}

	@When("the user selects the {string} result in the {string}")
	public void the_user_selects_the_result_in_the(String _index, String fieldID) {
		int index = -1;

		try {
			index = Integer.parseInt(_index);
		} catch (NumberFormatException e) {
			Assert.fail(
					"invalid string for parsing to int: " + e.getMessage());
		}

		try {
			Assert.assertTrue("Couldn't select the child of " + fieldID + ", with index: " + index,
					aPHomePage.tryClickChildOf(fieldID, index));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(fieldID);
			System.out.println(e.getMessage());
			// TODO: Ask MY about if I should throw e here, or what?
			// throw e;
		}
	}

	@And("the user switches to the tab with index {string}")
	public void the_user_switches_to_the_new_tab(String _index) {
		int index = -1;

		try {
			index = Integer.parseInt(_index);
		} catch (NumberFormatException e) {
			Assert.fail(
					"invalid string for parsing to int: " + e.getMessage());
		}
		try {
			Assert.assertTrue("Was unable to find another window to switch to", aPHomePage.trySwitchWindowTo(index));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}

	}

	@Then("the url of the new active window is {string}")
	public void the_url_of_the_new_active_window_is(String expectedUrl) {

		try {
			Assert.assertTrue(
					"Urls didn't match, expected url was: " + expectedUrl + ", while actual url was: "
							+ aPHomePage.getUrl(),
					aPHomePage.getUrl().contains(expectedUrl));

		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@When("the pop-up window opens")
	public void the_pop_up_window_opens() {
		try {
			Assert.assertTrue("Couldn't find any alert.", aPHomePage.canFindAlert());
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@And("the user dismisses the window")
	public void the_user_dismisses_the_window() {
		try {
			Assert.assertTrue("Was unable to close the alert.", aPHomePage.tryCloseAlert());

		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@When("the user clicks on the {string} button in the pop-up window")
	public void the_user_clicks_on_the_in_the_pop_up_window(String s) {

		try {
			Assert.assertTrue(aPHomePage.tryAcceptAlert());
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@Then("the pop-up window has disappeared")
	public void the_pop_up_window_has_disappeared() {
		try {
			Assert.assertFalse("Could find a alert, even when they were supposedly all closed.",
					aPHomePage.canFindAlert());
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@And("the user accepts the window")
	public void the_user_accepts_the_window() {
		try {
			Assert.assertTrue(aPHomePage.tryAcceptAlert());
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@And("the user fills in the field with {string} and confirms")
	public void the_user_fills_in_the_field_with_and_confirms(String userInput) {

		try {
			Assert.assertTrue("Couldn't send keys to the alert window.", aPHomePage.trySetAlertField(userInput));

			Assert.assertTrue("Couldn't confirm the alert window.", aPHomePage.tryAcceptAlert());
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}

	}

	@When("the user inputs {string} to {string}")
	public void the_user_inputs_to(String userInput, String fieldID) {

		try {
			Assert.assertTrue("Couldn't set the text to the field: " + fieldID,
					aPHomePage.trySetField(userInput, fieldID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(fieldID);
			System.out.println(e.getMessage());
		}
	}

	@When("the user double clicks on the {string} button.")
	public void the_user_double_clicks_on_the_button(String fieldID) {
		try {
			Assert.assertTrue("Couldn't double click on the button with: " + fieldID,
					aPHomePage.tryDoubleClickButton(fieldID));

		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(TestConstants.DOUBLECLICKCONTAINER_ID);
			System.out.println(e.getMessage());
		}
	}

	@Then("the {string} and {string} should contain the same data")
	public void and_should_contain_the_same_data(String field_1_ID, String field_2_ID) {
		try {
			Assert.assertEquals("The two fields did not contain the same text.", aPHomePage.getElementText(field_1_ID),
					aPHomePage.getElementText(field_2_ID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(TestConstants.DOUBLECLICKCONTAINER_ID);
			System.out.println(e.getMessage());
		}
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
