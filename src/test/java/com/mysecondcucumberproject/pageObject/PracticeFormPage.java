package com.mysecondcucumberproject.pageObject;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.mysecondcucumberproject.utilities.TestConstants;

public class PracticeFormPage extends BasePage {

	PracticeFormPage(WebDriver newDriver) {
		super(newDriver);
	}

	// Page factory style locators
	@FindBy(xpath = "//*[@id='RESULT_TextField-0']")
	WebElement nameField;
	@FindBy(xpath = "//*[@id=\"q4\"]")
	WebElement dOBContainer;
	@FindBy(xpath = "//*[@id='RESULT_TextField-2']")
	WebElement dOBField;
	@FindBy(xpath = "//span=[@class='icon_calendar']")
	WebElement calendarButton;
	@FindBy(xpath = "//*[@id=\"RESULT_RadioButton-3\"]")
	WebElement workDropDown;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']")
	WebElement dobDropdown;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")
	WebElement dobPastMonthButton;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[2]")
	WebElement dobComingMonthButton;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select")
	WebElement dobYearDropDown;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/span")
	WebElement dobCurrentMonthText;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody")
	WebElement dobTableBody;

	// So, I want a getter for the element of the dropdown, so that I can use it in
	// canFind... but the parts of it... I can look at those individually. But then,
	// needs to check if null on top of dislayed etc.

	public boolean canFindWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return (nameField.isDisplayed() && nameField.isEnabled());
			case TestConstants.DOBCONTAINER_ID:
				return (dOBContainer.isDisplayed() && dOBContainer.isEnabled());
			case TestConstants.FRAMEDOBFIELD_ID:
				return (dOBField.isDisplayed() && dOBField.isEnabled());
			case TestConstants.CALENDARBUTTON_ID:
				return (calendarButton.isDisplayed() && calendarButton.isEnabled());
			case TestConstants.FRAMEWORKDROPDOWN_ID:
				return (workDropDown.isDisplayed() && workDropDown.isEnabled());
			case TestConstants.DOBDROPDOWN_ID:
				return (dobDropdown.isDisplayed() && dobDropdown.isEnabled());
			case TestConstants.DOBDROPDOWNPASTMONTH_ID:
				return (dobPastMonthButton.isDisplayed() && dobPastMonthButton.isEnabled());
			case TestConstants.DOBDROPDOWNCOMINGMONTH_ID:
				return (dobComingMonthButton.isDisplayed() && dobComingMonthButton.isEnabled());
			case TestConstants.DOBDROPDOWNCURRENTMONTH_ID:
				return (dobComingMonthButton.isDisplayed() && dobComingMonthButton.isEnabled());
			case TestConstants.DOBDROPDOWNYEARDROPDOWN_ID:
				return (dobYearDropDown.isDisplayed() && dobYearDropDown.isEnabled());
			case TestConstants.DOBDROPDOWNTABLEBODY_ID:
				return (dobTableBody.isDisplayed() && dobTableBody.isEnabled());
			default:
				System.out.println("Couldn't find the element enabled and displayed using: " + fieldID);
				return false;
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return nameField;
			case TestConstants.DOBCONTAINER_ID:
				return dOBContainer;
			case TestConstants.FRAMEDOBFIELD_ID:
				return dOBField;
			case TestConstants.CALENDARBUTTON_ID:
				return calendarButton;
			case TestConstants.DOBDROPDOWN_ID:
				return dobDropdown;
			case TestConstants.DOBDROPDOWNPASTMONTH_ID:
				return dobPastMonthButton;
			case TestConstants.DOBDROPDOWNCOMINGMONTH_ID:
				return dobComingMonthButton;
			case TestConstants.DOBDROPDOWNCURRENTMONTH_ID:
				return dobComingMonthButton;
			case TestConstants.DOBDROPDOWNYEARDROPDOWN_ID:
				return dobYearDropDown;
			case TestConstants.DOBDROPDOWNTABLEBODY_ID:
				return dobTableBody;
			case TestConstants.FRAMEWORKDROPDOWN_ID:
				return workDropDown;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return null;
		}
	}

	public boolean trySetField(String userInput, String fieldID) {
		if (!canFindWebelement(fieldID)) {
			return false;
		}

		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				nameField.clear();
				nameField.sendKeys(userInput);
				return true;
			case TestConstants.FRAMEDOBFIELD_ID:
				dOBField.clear();
				dOBField.sendKeys(userInput);
				return true;
			default:
				System.out.println(this + " couldn't find a field with a value to set with the fieldID " + fieldID);
				return false;
		}
	}

	// TODO: Fix so that this method is an overload of a method in the parent
	// basepage.
	public String getFieldValue(String elementID) {
		if (!canFindWebelement(elementID)) {
			return "";
		}

		switch (elementID.toLowerCase().trim()) {
			case TestConstants.FRAMENAMEFIELD_ID:
				return nameField.getAttribute("value");
			case TestConstants.FRAMEDOBFIELD_ID:
				return dOBField.getAttribute("value");
			default:
				System.out.println(this + "couldn't find an element to get the value of with the ID of: " + elementID);
				return null;
		}
	}

	public boolean trySelectInDropdown(String userSelection, String elementID) {

		if (!canFindWebelement(elementID))
			return false;

		Select dropDown;

		try {
			dropDown = new Select(getWebelement(elementID));
		} catch (UnexpectedTagNameException e) {
			System.out.println("Couldn't create a select object from the web element");
			System.out.println(e.getMessage());
			return false;
		}

		try {
			dropDown.selectByVisibleText(userSelection);
		} catch (NoSuchElementException e) {
			System.out.println("Couldn't find an element using this value.");
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	public boolean trySelectInDropdown(String elementID, String year, int month, int day) {
		if (!canFindWebelement(elementID))
			return false;

		Select dropDown;

		try {
			dropDown = new Select(getWebelement(elementID));
		} catch (UnexpectedTagNameException e) {
			System.out.println("Couldn't create a select object from the web element");
			System.out.println(e.getMessage());
			return false;
		}

		if (!trySelectInDropdown(year, TestConstants.DOBDROPDOWNYEARDROPDOWN_ID)) {
			return false;
		}

		if (!trySetDOBMonth(dropDown, month)) {
			// need to see what month it is, figure out if that is past of previous and act
			// accordingly.
			return false;
		}

		if (!trySetDOBDay(dropDown, day)) {
			// need to iterate through, see if it finds one with the number, if not, return
			// false
			return false;
		}

		return true;
	}

	private boolean trySetDOBDay(Select dropDown, int day) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'trySetDOBDay'");
	}

	private boolean trySetDOBMonth(Select dropDown, int month) {
		/*
		 * SO, this one will use the main dropdown, wait, does it need that?
		 * It will need the text field for months,
		 * and the two buttons for next and previous
		 * and a way to decide what month is in what order, right?
		 * will it need to check so we do not go over to next year?
		 */
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'trySetDOBMonth'");
	}

	public String getSelectedText(String elementID) {

		if (!canFindWebelement(elementID)) {
			return "";
		}

		Select tempSelect;
		try {
			tempSelect = new Select(getWebelement(elementID));
		} catch (UnexpectedTagNameException e) {
			// TODO: Look into what a message of this kind contains, and what value my
			// additional messages might give, if any.
			System.out.println("Couldn't create a select object from the web element");
			System.out.println(e.getMessage());
			takeScreenShot(elementID);
			return "";
		}

		try {
			return tempSelect.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			takeScreenShot(elementID);
			return "";
		}
	}

	public boolean tryClickButton(String calendarbuttonId) {
		if (!canFindWebelement(calendarbuttonId)) {
			return false;
		}

		try {
			getWebelement(calendarbuttonId).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (ElementNotInteractableException e) {
			System.out.println(e.getMessage());
			return false;
		}

		// TODO: So, ask MY here, should I have a general catch here as well? That
		// handles the cases I haven't thought of? Or is it instead better to have the
		// program throw a sever error in those cases?
		return true;
	}

	public boolean tryGetDOBDropdown() {

		// So, needs to see if it can get the dropdown then... So will need to use
		// findElement here then? So this one I want to wrap like a getter?
		// Do I even want to give this one a way of being a "Select" then? (No, that
		// might be too clever for my own good)

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'tryGetDOBDropdown'");
	}
}