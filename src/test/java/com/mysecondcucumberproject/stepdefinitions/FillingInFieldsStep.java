package com.mysecondcucumberproject.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FillingInFieldsStep {

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
					+ aPHomePage.getElementText(fieldID), input, aPHomePage.getElementText(fieldID));
		} else {
			Assert.fail("Couldn't find webelement with: " + fieldID);
		}
	}

	@Then("neither {string} nor {string} option should be selected")
	public void neither_option_should_be_selected(String male, String female) {
		boolean noCheckBoxesSelected = !aPHomePage.isCheckBoxSelected(male) && !aPHomePage.isCheckBoxSelected(female);
		Assert.assertTrue("Not all checkboxes for gender were unselected", noCheckBoxesSelected);
	}

	@When("the user selects the {string} option")
	public void the_user_selects_the_option(String checkboxID) {
		aPHomePage.toggleCheckBox(checkboxID);
	}

	@Then("the {string} option should be selected")
	public void the_option_should_be_selected(String checkboxID) {
		Assert.assertTrue("The checkbox was not selected: " + checkboxID, aPHomePage.isCheckBoxSelected(checkboxID));
	}

	@Then("the {string} option should not be selected")
	public void the_option_should_not_be_selected(String checkboxID) {
		Assert.assertTrue("This checkbox was selected when it shouldn't be: " + checkboxID,
				!aPHomePage.isCheckBoxSelected(checkboxID));
	}

	@When("the user selects the following weekdays:")
	public void the_user_selects_the_following_weekdays(DataTable dataTable) {
		List<String> weekdays = dataTable.asList(String.class);
		for (String weekday : weekdays) {
			if (aPHomePage.canFindWebelement(weekday)) {
				aPHomePage.toggleCheckBox(weekday);
			}
		}
	}

	@Then("none of the weekdays except for the following should be selected")
	public void none_of_the_weekdays_except_for_the_following_should_be_selected(DataTable dataTable) {

		List<String> selectedDays = dataTable.asList(String.class);
		for (String string : selectedDays) {
			string = string.toLowerCase();
		}

		List<WebElement> weekdayCheckboxes = aPHomePage.getAllWeekdayCheckboxes();

		Assert.assertFalse("Unable to find any of the checkboxes for weekdays", weekdayCheckboxes.isEmpty());

		// Iterates through the list of webelements for the checkboxes, if one is
		// selected, it checks if it has an attribute "value" that is one of the days
		// that should be selected. If not it Asserts.fail().
		for (WebElement webElement : weekdayCheckboxes) {
			if (webElement.isSelected()) {
				if (!selectedDays.contains(webElement.getAttribute("value").toLowerCase())) {
					Assert.fail("The weekday with the following attribute was selected even when it shouldn't: "
							+ webElement.getAttribute("value"));
				}
			}
		}
	}

	@Then("the following weekdays should be selected:")
	public void the_following_weekdays_should_be_selected(DataTable dataTable) {
		List<String> selectedDays = dataTable.asList(String.class);
		// Write code here that turns the phrase above into concrete actions
		for (String string : selectedDays) {
			Assert.assertTrue("The checkbox found with the following string wasn't selected: " + string,
					!aPHomePage.isCheckBoxSelected(string));
		}
	}

	@When("the user also selects the following weekdays:")
	public void the_user_also_selects_the_following_weekdays(DataTable dataTable) {
		List<String> weekdays = dataTable.asList(String.class);
		for (String weekday : weekdays) {
			if (aPHomePage.canFindWebelement(weekday))
				aPHomePage.toggleCheckBox(weekday);
			else
				System.out.println("Couldn't find a webElement for the weekday: " + weekday);
		}
	}

	@When("the user deselects the following weekdays:")
	public void the_user_deselects_the_following_weekdays(DataTable dataTable) {
		List<String> weekdays = dataTable.asList(String.class);
		for (String weekday : weekdays) {
			if (aPHomePage.canFindWebelement(weekday))
				aPHomePage.toggleCheckBox(weekday);
			else
				System.out.println("Couldn't find a webElement for the weekday: " + weekday);
		}
	}

	@Then("none of the weekdays should be selected")
	public void none_of_the_weekdays_should_be_selected() {

		List<WebElement> weekdayCheckboxes = aPHomePage.getAllWeekdayCheckboxes();

		for (WebElement webElement : weekdayCheckboxes) {
			if (webElement.isSelected()) {
				Assert.fail("the following webelement was selected when it shouldn't: "
						+ webElement.getAttribute(("value")));
			}
		}
	}
}