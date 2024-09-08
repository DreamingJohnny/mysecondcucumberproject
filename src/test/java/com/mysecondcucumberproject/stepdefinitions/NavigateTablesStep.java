package com.mysecondcucumberproject.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
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

	@Then("the first page is selected")
	public void the_first_page_is_selected() {
		int firstPageIndex = 1;

		try {
			Assert.assertTrue("Page number " + firstPageIndex + " in the paginated table wasn't selected!",
					aPHomePage.isPaginationButtonSelected(firstPageIndex));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("paginated button field");
		}
	}

	@Then("the user can switch between pages of the table")
	public void the_user_can_switch_between_pages_of_the_table() {

		String toCompareID = "";

		for (int i = 1; i <= aPHomePage.getProductPageAmount(); i++) {

			aPHomePage.clickProductPageButton(i);

			try {
				// Checks if the correct page has been selected
				Assert.assertTrue("Page number " + i + " in the paginated table wasn't selected!",
						aPHomePage.isPaginationButtonSelected(i));
			} catch (AssertionError e) {
				System.out.println("Assertion failed: " + e.getMessage());
				aPHomePage.takeScreenShot("paginated button field");
			}

			try {
				// Compares the stored variable to the attribute of the topmost ID field. If it
				// has changed, the table has been updated since last time. If it hasn't it
				// indicates that the table hasn't been refreshed.
				Assert.assertFalse("The product table didn't seem to refresh when the next page was selected.",
						toCompareID.toLowerCase() == aPHomePage.getElementText("top leftmost product table cell")
								.toLowerCase());

				// Stores the attribute of the topmost ID field on the current page of the
				// table, to compare against the next one.
				toCompareID = aPHomePage.getElementText("top leftmost product table cell");

			} catch (AssertionError e) {
				System.out.println("Assertion failed: " + e.getMessage());
				// TODO: Ask MY, is it okay that I use strings like this? Should they be
				// gathered somewhere instead? Top of this document? Part of config file?
				aPHomePage.takeScreenShot("paginated table");
			}
		}
	}

	// TODO: Read up on if this should be a @then instead of a @when according to
	// cucumber?
	@When("the user selects all items with a price higher than {string}")
	public void the_user_selects_all_items_with_a_price_higher_than(String _price) {

		for (int i = 1; i <= aPHomePage.getProductPageAmount(); i++) {

			aPHomePage.clickProductPageButton(i);
			aPHomePage.selectProductsWithLowerPrice(_price);
			aPHomePage.takeScreenShot("paginated button field");

			/*
			 * So, I need to figure out how to test this, the marked items disappear when
			 * you switch page, so it needs to be tested on the same page then.
			 * I could set something up, so that the system also takes a screenshot if the
			 * items...
			 * But then it would take a screenshot even when things are right, which doesn't
			 * seem like it should be the way to do it.
			 */

		}
	}

	@When("the user selects items costing less than {string} on page {string}.")
	public void the_user_selects_items_costing_less_than_on_page(String priceThresholdString, String pageNumber) {
		
		//TODO: Think about moving this one to config or similar?
		String regex = "[^\\d\\.]| |\\.$";

		int pageIndex = 0;
		try {
			pageIndex = Integer.parseInt(pageNumber);
		} catch (NumberFormatException e) {
			System.err.println("Error: Unable to parse string to integer: " + pageNumber);
			Assert.fail("Test failed, unable to parse the string for pageNumber");
		}

		// Checks so that the index is within the bounds of the available pages.
		Assert.assertFalse("The index for the page was outside the available pages for the product table",
				pageIndex > 0 && pageIndex <= aPHomePage.getProductPageAmount());

		aPHomePage.clickProductPageButton(pageIndex);

		float maxPrice = 0;
		try {
			// Cleans the text according to the regex expression so that it can be parsed to
			// float.
			maxPrice = Float.parseFloat(priceThresholdString.replaceAll(regex, ""));

		} catch (NumberFormatException e) {
			System.err.println("Error: Unable to parse string to float: " + priceThresholdString);
			Assert.fail("Test failed, unable to parse the string for top price");
		}

		// TODO: These both will also need checks for if they cannot find them.
		int priceColumnIndex = aPHomePage.getProductTableColumnIndexOf("price");
		int selectionColumnIndex = aPHomePage.getProductTableColumnIndexOf("select"); 

		aPHomePage.selectProductsWithLowerPrice(maxPrice,priceColumnIndex,selectionColumnIndex);
	}

	@Then("the {string} of items should be selected according to {string}")
	public void the_of_items_should_be_selected_according_to(String s, String s2) {
		// Write code here that turns the phrase above into concrete actions
	}

}
