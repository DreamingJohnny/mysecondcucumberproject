package com.mysecondcucumberproject.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.pageObject.AutomationPracticeHomePage;
import com.mysecondcucumberproject.pageObject.PracticeFormPage;
import com.mysecondcucumberproject.utilities.TestConstants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InteractingWithOtherElements {

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;
	PracticeFormPage practiceFormPage;

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
	public void the_user_selects_the_result_in_the(String _index, String elementID) {
		int index = -1;

		try {
			index = Integer.parseInt(_index);
		} catch (NumberFormatException e) {
			Assert.fail(
					"invalid string for parsing to int: " + e.getMessage());
		}

		try {
			Assert.assertTrue("Couldn't select the child of " + elementID + ", with index: " + index,
					aPHomePage.tryClickChildOf(elementID, index));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(elementID);
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
		// TODO: Change this method to not need an argument since it is just user
		// accepts or confirms.
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
	public void the_user_double_clicks_on_the_button(String elementID) {
		try {
			Assert.assertTrue("Couldn't double click on the button with: " + elementID,
					aPHomePage.tryDoubleClickButton(elementID));

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

	@Then("the user moves the {string} object on to the {string} object")
	public void the_user_moves_the_object_on_to_the_object(String sourceID, String targetID) {
		try {
			Assert.assertTrue("Couldn't drag and drop the two elements.",
					aPHomePage.tryDragAndDropElements(sourceID, targetID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(TestConstants.DRAGANDDROPCONTAINER);
			System.out.println(e.getMessage());
		}
	}

	@Given("the user sees the {string}")
	public void the_user_sees_the(String elementID) {
		try {
			Assert.assertTrue("Couldn't find the element.",
					aPHomePage.canFindWebelement(elementID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot();
			System.out.println(e.getMessage());
		}
	}

	@And("the {string} is in the {string}")
	public void the_is_in_the(String elementID, String _expectedPosition) {

		String[] coordinates = _expectedPosition.split(",");

		Point expectedPosition = new Point(0, 0);

		try {
			expectedPosition = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
		} catch (NumberFormatException e) {
			Assert.fail(
					"invalid strings for parsing to point: " + e.getMessage());
		}

		try {
			Assert.assertEquals("The webelement was not in the expected position.", expectedPosition,
					aPHomePage.getPosition(elementID));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(TestConstants.SLIDERCONTAINER_ID);
			System.out.println(e.getMessage());
		}
	}

	@When("the user uses the cursor to move the {string} to a {string}")
	public void the_user_uses_the_cursor_to_move_the_slider_to_a_new_position(String elementID, String _addedPosition) {

		String[] coordinates = _addedPosition.split(",");

		Point expectedPosition = new Point(0, 0);

		try {
			expectedPosition = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
		} catch (NumberFormatException e) {
			Assert.fail("invalid strings for parsing to point: " + e.getMessage());
		}

		try {
			Assert.assertTrue("Couldn't move the element correctly",
					aPHomePage.tryMoveElement(elementID, expectedPosition));
		} catch (AssertionError e) {
			aPHomePage.takeScreenShot(TestConstants.SLIDERCONTAINER_ID);
			System.out.println(e.getMessage());
		}
	}

	@Then("the {string} is in the {string} and the test should {string}")
	public void the_is_in_the_and_the_test_should(String elementID, String _expectedPosition, String _expectedResult) {

		// Also should move to BaseUtils
		boolean expectedResult = false;

		if (_expectedResult.contains("pass")) {
			expectedResult = true;
		} else if (_expectedResult.contains("fail")) {
			expectedResult = false;
		} else {
			throw new IllegalArgumentException("Unknown expected result" + _expectedResult);
		}

		String[] coordinates = _expectedPosition.split(",");

		Point expectedPosition = new Point(0, 0);

		try {
			expectedPosition = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
		} catch (NumberFormatException e) {
			Assert.fail(
					"invalid strings for parsing to point: " + e.getMessage());
		}

		boolean actualResult = aPHomePage.getPosition(elementID).equals(expectedPosition);

		if (expectedResult == actualResult) {
			// TODO: Look over this, how to best handle when you have a check, and then
			// another Assert, but it should be expected to be true.
			Assert.assertTrue(expectedResult == actualResult);
		} else if (actualResult) {
			Assert.fail("The test passed when it was expected to fail");
		} else if (expectedResult) {
			Assert.fail("The test was meant to pass, but didn't.");
		} else {
			Assert.fail("The test failed due to unclear reasons");
		}

	}

	@Given("the user switches to {string}")
	public void the_user_switches_to(String string) {

		practiceFormPage = aPHomePage.goToPracticeForm();

		try {
			Assert.assertNotNull("Recieved a null page object when it attempted to go to practice form.",
					practiceFormPage);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

	@And("the user enters {string} into the {string} field in the iframe")
	public void the_user_enters_into_the_field_in_the_iframe(String userInput, String fieldID) {
		try {
			Assert.assertTrue("Couldn't set the field of the practiceFormPage with the field id: " + fieldID,
					practiceFormPage.trySetField(userInput, fieldID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(fieldID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@Then("the {string} field in the iframe should contain {string}")
	public void the_field_in_the_iframe_should_contain(String fieldID, String expectedValue) {
		try {
			// TODO: Go back through and check that you use Assert.fail() in catches.
			Assert.assertTrue(
					"The name field on the practiceFormPage did not have the expected value. Practice form: "
							+ practiceFormPage.getFieldValue(fieldID) + ", expected value: " + expectedValue,
					practiceFormPage.getFieldValue(fieldID).toLowerCase().contains(expectedValue.toLowerCase()));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(fieldID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@Given("the user selects {string} from the {string}")
	public void the_user_selects_from_the(String userSelection, String elementID) {

		try {
			Assert.assertTrue("Couldn't find the element using the id: " + elementID,
					practiceFormPage.canFindWebelement(elementID));
		} catch (AssertionError e) {
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}

		// TODO: Need to work out if the general takeScreenShot method works now or not.
		try {
			Assert.assertTrue(practiceFormPage.trySelectInDropdown(userSelection, elementID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(elementID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@Then("the {string} contains {string}")
	public void the_contains(String elementID, String expectedText) {
		try {
			Assert.assertTrue(
					"The selected option in the dropdown did not contain the expected text. Selection gave back the text: "
							+ practiceFormPage.getSelectedText(elementID) + ", and the expected text was: "
							+ expectedText,
					practiceFormPage.getSelectedText(elementID).contains(expectedText));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(elementID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@Given("the user inputs {string} into the {string}")
	public void the_user_inputs_into_the(String input, String fieldID) {
		try {
			Assert.assertTrue("Couldn't set the field found using: " + fieldID,
					practiceFormPage.trySetField(input, fieldID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(fieldID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@Then("the {string} should contain {string} according to {string}")
	public void the_should_contain_according_to(String fieldID, String expectedValue, String _expectedOutcome) {

		boolean expectedOutcome = false;
		// TODO: Move this to utilities so that you can use it more easily. And reuse
		// code.
		if (_expectedOutcome.toLowerCase().contains("pass")) {
			expectedOutcome = true;
		} else if (_expectedOutcome.toLowerCase().contains("fail")) {
			expectedOutcome = false;
		} else {
			Assert.fail("Test failed, couldn't parse expected outcome to either pass or fail.");
		}

		try {
			Assert.assertEquals(practiceFormPage.getFieldValue(fieldID).contains(expectedValue),
					expectedOutcome);
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(fieldID);
			Assert.fail("Test failed due to AssertionError: " + e.getMessage());
		}
	}

	@When("the user clicks on the calendar icon the dropdown opens")
	public void the_user_clicks_on_the_calendar_icon_the_dropdown_opens() {

		try {
			Assert.assertTrue(practiceFormPage.canFindWebelement(TestConstants.CALENDARBUTTON_ID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(TestConstants.DOBCONTAINER_ID);
			Assert.fail("Test failed due to AssertionError" + e.getMessage());
		}

		try {
			// TODO: Go back up and add explanation text to the asserts.
			Assert.assertTrue(practiceFormPage.tryClickButton(TestConstants.CALENDARBUTTON_ID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(TestConstants.DOBCONTAINER_ID);
			Assert.fail("Test failed due to AssertionError" + e.getMessage());
		}

		try {
			Assert.assertTrue("Couldn't get the DOB dropdown webelement",
					practiceFormPage.canFindWebelement(TestConstants.DOBDROPDOWN_ID));
		} catch (AssertionError e) {
			practiceFormPage.takeScreenShot(TestConstants.DOBCONTAINER_ID);
			Assert.fail("Test failed due to AssertionError" + e.getMessage());
		}
	}

	@And("the user selects {string}, {string} and {string} from the dropdown")
	public void the_user_selects_and_from_the_dropdown(String year, String month, String day) {

		// So, create has function that tries to set these then, and that returns true
		// provided it can find it and turn it into a select.
		try {
			Assert.assertTrue(practiceFormPage.trySelectInDropdown(TestConstants.DOBDROPDOWN_ID, year,
					Integer.parseInt(month), Integer.parseInt(day)));
		} catch (AssertionError e) {
			// TODO: handle exception
		}

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