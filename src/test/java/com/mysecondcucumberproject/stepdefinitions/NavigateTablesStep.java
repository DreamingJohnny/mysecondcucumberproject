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

public class NavigateTablesStep {

	WebDriver driver;
	AutomationPracticeHomePage aPHomePage;

	// Get the element for the web table
	// Check so that it is "displayed"
	// Check the parts of the header
	// Go through each of the books and check the things for each of them.
	// So, will need to search for one of the words and then check against the
	// others

	@Given("the user is on the webpage")
	public void the_used_is_on_the_webpage() {
		aPHomePage = new AutomationPracticeHomePage(BaseUtilities.getWebDriver());
		Assert.assertEquals("Url didn't match!",
				BaseUtilities.getConfigProperties().getProperty("db.url").toLowerCase(),
				aPHomePage.getUrl().toLowerCase());

	}

	@When("the user sees the table {string}")
	public void the_user_sees_the_table(String tableID) {
		Assert.assertTrue(aPHomePage.canFindWebelement(tableID));
	}

	@Then("the table {string} should have a header with {string}, {string}, {string} and {string}")
	public void the_table_should_have_a_header_with_and(String tableID, String bookName, String author, String subject,
			String price) {
		List<String> headers = aPHomePage.getTableHeadersContent(tableID);

		try {
			Assert.assertTrue(!headers.isEmpty());
		} catch (Exception e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot(tableID);
		}

		// TODO: This one feels really inflexible, look through if you could/should
		// improve. Perhaps create a datatable with the categories in the gherkin?
		try {
			Assert.assertEquals(bookName, headers.get(0));

		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot(tableID);
		}

		try {
			Assert.assertEquals(author, headers.get(1));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot(tableID);
		}

		try {
			Assert.assertEquals(subject, headers.get(2));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot(tableID);
		}

		try {
			Assert.assertEquals(price, headers.get(3));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot(tableID);
		}
	}

	@Then("the table {string} should display the following books with the correct information:")
	public void the_table_should_display_the_following_books_with_the_correct_information(String tableID,
			DataTable dataTable) {

		List<List<String>> tableInfo = dataTable.asLists(String.class);

		for (List<String> bookInfo : tableInfo) {
			List<String> tableRowInfo = aPHomePage.getTableRowContent(tableID, bookInfo.get(0));

			try {
				Assert.assertFalse(
						"Didn't find any table row in the table: " + tableID + ", with a cell containing: "
								+ bookInfo.get(0),
						tableRowInfo.isEmpty());

			} catch (AssertionError e) {
				System.out.println("Assertion failed: " + e.getMessage());
				aPHomePage.takeScreenShot(tableID);
			}

			// Compares the content of each string in the two lists.
			for (int i = 0; i < tableRowInfo.size(); i++) {
				try {
					Assert.assertEquals(tableRowInfo.get(i), bookInfo.get(i));
				} catch (AssertionError e) {
					System.out.println("Assertion failed: " + e.getMessage());
					aPHomePage.takeScreenShot(tableID);
				}
			}
		}
	}

	@When("the user sees the paginated table")
	public void the_user_sees_the_paginated_table() {

		Assert.assertTrue("Couldn't find the paginated table.", aPHomePage.canFindWebelement("paginated table"));
		Assert.assertTrue("Couldn't find the paginated button field.",
				aPHomePage.canFindWebelement("paginated button field"));
	}

	// TODO: Check what is printed if this one is changed to index "2"
	@Then("the first page is selected")
	public void the_first_page_is_selected() {
		int firstPageIndex = 1;

		try {
			Assert.assertTrue("Page number " + firstPageIndex + " in the paginated table wasn't selected!",
					aPHomePage.isPaginationButtonSelected(firstPageIndex));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("paginated buttons field");
		}
	}

	// TODO: Read up on if this should be a @then instead of a @when according to
	// cucumber?
	@When("the user selects all items with a price higher than {string}")
	public void the_user_selects_all_items_with_a_price_higher_than(String _price) {

		// Get all of the buttons for the pages in the table
		List<WebElement> paginationButtons = aPHomePage.getButtons("paginated button field");

		Assert.assertTrue("Couldn't find any buttons for pages in the table", paginationButtons.size() > 0);

		// for each, go through the cells under price.
		for (WebElement pageButton : paginationButtons) {
			pageButton.click();
			aPHomePage.selectProductTableObjectsWithHigherPrice(_price);

		}

	}

	@Then("a {string} amount of items should be selected.")
	public void a_amount_of_items_should_be_selected(String s) {
		// Write code here that turns the phrase above into concrete actions
	}

}
