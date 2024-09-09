package com.mysecondcucumberproject.stepdefinitions;

import java.util.List;

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

	@When("the user sees the table {string}")
	public void the_user_sees_the_table(String tableID) {
		Assert.assertTrue("Couln't find a table with the tableID: " + tableID, aPHomePage.canFindWebelement(tableID));
	}

	@Then("the book table should have a header with {string}, {string}, {string} and {string}")
	public void the_book_table_should_have_a_header_with_and(String bookName, String author, String subject,
			String price) {
		List<String> headers = aPHomePage.getTableHeadersContent("book table");

		try {
			Assert.assertTrue(!headers.isEmpty());
		} catch (Exception e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("book table");
		}

		// TODO: This one feels really inflexible, look through if you could/should
		// improve. Perhaps create a datatable with the categories in the gherkin?
		try {
			Assert.assertEquals(bookName, headers.get(0));

		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("book table");
		}

		try {
			Assert.assertEquals(author, headers.get(1));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("book table");
		}

		try {
			Assert.assertEquals(subject, headers.get(2));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("book table");
		}

		try {
			Assert.assertEquals(price, headers.get(3));
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			aPHomePage.takeScreenShot("book table");
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

}
