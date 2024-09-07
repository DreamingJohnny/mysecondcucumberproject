package com.mysecondcucumberproject.pageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeHomePage extends BasePage {

	// Constructor
	public AutomationPracticeHomePage(WebDriver newDriver) {
		super(newDriver);
	}

	// Page factory style locators

	// Form fields
	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement nameField;
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;
	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneField;

	// Gender checkboxes
	@FindBy(xpath = "//*[@id=\"male\"]")
	WebElement maleCheckBox;
	@FindBy(xpath = "//*[@id=\"female\"]")
	WebElement femaleCheckBox;

	// Weekday checkboxes
	@FindBy(xpath = "//*[@id=\"monday\"]")
	WebElement mondayCheckBox;
	@FindBy(xpath = "//*[@id=\"tuesday\"]")
	WebElement tuesdayCheckBox;
	@FindBy(xpath = "//*[@id=\"wednesday\"]")
	WebElement wednesdayCheckBox;
	@FindBy(xpath = "//*[@id=\"thursday\"]")
	WebElement thursdayCheckBox;
	@FindBy(xpath = "//*[@id=\"friday\"]")
	WebElement fridayCheckbox;
	@FindBy(xpath = "//*[@id=\"saturday\"]")
	WebElement saturdayCheckbox;
	@FindBy(xpath = "//*[@id=\"sunday\"]")
	WebElement sundayCheckBox;

	// Book table
	@FindBy(xpath = "//*[@id=\"HTML1\"]/div[1]/table")
	WebElement bookTable;

	// Paginated table
	@FindBy(xpath = "//*[@id=\"productTable\"]")
	WebElement paginatedTable;
	@FindBy(xpath = "//*[@id=\"productTable\"]/tbody")
	WebElement paginatedTableBody;
	@FindBy(xpath = "//*[@id=\"pagination\"]")
	WebElement paginationButtonsField;
	@FindBy(xpath = "//*[@id=\"pagination\"]//a")
	List<WebElement> productTablePageButtons;
	@FindBy(xpath = "//*[@id=\"productTable\"]//th")
	List<WebElement> productTableHeaders;

	private int getProductTableColumnIndexOf(String searchTerm) {

		int columnIndex = 0;
		for (WebElement webElement : productTableHeaders) {
			columnIndex++;
			if (webElement.getText().toLowerCase().contains(searchTerm.toLowerCase()))
				return columnIndex;
		}
		System.out.println("Couldn't find any header of column with the searchterm: " + searchTerm);
		return columnIndex = 0;
	}

	// Action methods

	/**
	 * Returns a boolean if the checkbox is selected
	 * 
	 * @param checkboxID
	 * @return
	 */
	public boolean isCheckBoxSelected(String checkboxID) {
		switch (checkboxID.toLowerCase()) {
			case "male":
				return maleCheckBox.isSelected() == true ? true : false;
			case "female":
				return femaleCheckBox.isSelected() == true ? true : false;
			case "monday":
				return mondayCheckBox.isSelected() == true ? true : false;
			case "tuesday":
				return tuesdayCheckBox.isSelected() == true ? true : false;
			case "wednesday":
				return wednesdayCheckBox.isSelected() == true ? true : false;
			case "thursday":
				return thursdayCheckBox.isSelected() == true ? true : false;
			case "friday":
				return fridayCheckbox.isSelected() == true ? true : false;
			case "saturday":
				return saturdayCheckbox.isSelected() == true ? true : false;
			case "sunday":
				return sundayCheckBox.isSelected() == true ? true : false;
			default:
				// TODO: Check how to best print log messages, if System.out.println, is
				// disabled during testing.
				System.out.println("Couldn't find a checkbox using: " + checkboxID);
				return false;
		}
	}

	public void toggleCheckBox(String checkboxID) {
		switch (checkboxID.toLowerCase()) {
			case "male":
				maleCheckBox.click();
				break;
			case "female":
				femaleCheckBox.click();
				break;
			case "monday":
				mondayCheckBox.click();
				break;
			case "tuesday":
				tuesdayCheckBox.click();
				break;
			case "wednesday":
				wednesdayCheckBox.click();
				break;
			case "thursday":
				thursdayCheckBox.click();
				break;
			case "friday":
				fridayCheckbox.click();
				break;
			case "saturday":
				saturdayCheckbox.click();
				break;
			case "sunday":
				sundayCheckBox.click();
				break;
			default:
				System.out.println("Couldn't find a checkbox using: " + checkboxID);
				break;
		}
	}

	/**
	 * uses sendKeys to send the input to the webelement it identifies with the
	 * fieldID.
	 * 
	 * @param input
	 * @param fieldID
	 */
	public void setField(String input, String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				nameField.clear();
				nameField.sendKeys(input);
				break;
			case "email":
				emailField.clear();
				emailField.sendKeys(input);
				break;
			case "phone":
				phoneField.clear();
				phoneField.sendKeys(input);
				break;
			default:
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				break;
		}
	}

	// TODO: If you want to keep this one, you might want to expand it further,
	// otherwise, remove it, other otherwise have public getters for the locators
	// instead?
	public boolean canFindWebelement(String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				return nameField.isDisplayed() == true ? true : false;
			case "email":
				return emailField.isDisplayed() == true ? true : false;
			case "phone":
				return phoneField.isDisplayed() == true ? true : false;
			case "male":
				return maleCheckBox.isDisplayed() == true ? true : false;
			case "female":
				return femaleCheckBox.isDisplayed() == true ? true : false;
			case "monday":
				return mondayCheckBox.isDisplayed() == true ? true : false;
			case "tuesday":
				return tuesdayCheckBox.isDisplayed() == true ? true : false;
			case "wednesday":
				return wednesdayCheckBox.isDisplayed() == true ? true : false;
			case "thursday":
				return thursdayCheckBox.isDisplayed() == true ? true : false;
			case "friday":
				return fridayCheckbox.isDisplayed() == true ? true : false;
			case "saturday":
				return saturdayCheckbox.isDisplayed() == true ? true : false;
			case "sunday":
				return sundayCheckBox.isDisplayed() == true ? true : false;
			case "booktable":
				return bookTable.isDisplayed() == true ? true : false;
			case "paginated table":
				return paginatedTable.isDisplayed() == true ? true : false;
			case "paginated button field":
				return paginationButtonsField.isDisplayed() == true ? true : false;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return false;
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				return nameField;
			case "email":
				return emailField;
			case "phone":
				return phoneField;
			case "male":
				return maleCheckBox;
			case "female":
				return femaleCheckBox;
			case "monday":
				return mondayCheckBox;
			case "tuesday":
				return tuesdayCheckBox;
			case "wednesday":
				return wednesdayCheckBox;
			case "thursday":
				return thursdayCheckBox;
			case "friday":
				return fridayCheckbox;
			case "saturday":
				return saturdayCheckbox;
			case "sunday":
				return sundayCheckBox;
			case "booktable":
				return bookTable;
			case "paginated table":
				return paginatedTable;
			case "paginated button field":
				return paginationButtonsField;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return null;
		}
	}

	/**
	 * Collects the text from all elements with the tagName "th" that are children
	 * of the table.
	 * 
	 * @param tableID used to decide what table to get the children elements from.
	 * @return
	 */
	public List<String> getTableHeadersContent(String tableID) {
		switch (tableID.toLowerCase()) {
			case "booktable":
				List<WebElement> tempElements = bookTable.findElements(By.tagName("th"));
				List<String> tempStrings = new ArrayList<>();

				for (WebElement element : tempElements) {
					tempStrings.add(element.getText());
				}
				return tempStrings;
			default:
				System.out.println("Couldn't find a case in the switch matching: " + tableID);
				return new ArrayList<>();
		}
	}

	public List<String> getTableRowContent(String tableID, String searchTerm) {
		// TODO: Rethink this method considering if it is sensitive to caps
		// TODO: Is this method sensitive to exceptions thrown if not finding elements?
		// Look into that.
		switch (tableID.toLowerCase()) {
			case "booktable":
				WebElement tableRow = bookTable
						.findElement(By.xpath(".//tr[descendant::*[text()='" + searchTerm + "']]"));
				if (tableRow == null) {
					return new ArrayList<>();
				}

				List<WebElement> tempElements = tableRow.findElements(By.tagName("td"));
				if (tempElements == null) {
					return new ArrayList<>();
				}
				List<String> tableRowContent = new ArrayList<>();

				for (WebElement webElement : tempElements) {
					tableRowContent.add(webElement.getText());
				}
				return tableRowContent;
			default:
				System.out.println("Couldn't find a case in the switch matching: " + tableID);
				return new ArrayList<>();
		}
	}

	// TODO: Check if this is considered good practices? Should you send webelements
	// like this? Probably not, better to have indirect clicking.
	public List<WebElement> getAllWeekdayCheckboxes() {
		return Arrays.asList(mondayCheckBox, tuesdayCheckBox, wednesdayCheckBox, thursdayCheckBox, fridayCheckbox,
				saturdayCheckbox, sundayCheckBox);
	}

	public String getFieldAttributeValue(String fieldID) {
		switch (fieldID.toLowerCase()) {
			case "name":
				return nameField.getAttribute("value");
			case "email":
				return emailField.getAttribute("value");
			case "phone":
				return phoneField.getAttribute("value");
			default:
				System.out.println(this + "couldn't find a field to get the value of with the field ID of: " + fieldID);
				return null;
		}
	}

	// TODO: Fix this, shouldn't be sending buttons away outside of POM
	public List<WebElement> getButtons(String fieldID) {

		switch (fieldID) {
			// TODO: Look at renamning these cases.
			case "paginated button field":
				return productTablePageButtons;
			default:
				System.out.println("Couldn't find a set of buttons looking with the fieldID of: " + fieldID);
				return null;
		}
	}

	public void selectProductsWithHigherPrice(String _price) {

		// Finds everything in a string except digits and periods inbetween digits.
		String regex = "[^\\d\\.]| |\\.$";

		// TODO: Add try catch here to handle if the string isn't possible to parse.
		// Cleans the text according to the regex expression so that it can be parsed to
		// float.
		float testInputPrice = Float.parseFloat(_price.replaceAll(regex, ""));

		// TODO: These both will also need checks for if they cannot find them.
		int priceColumnIndex = getProductTableColumnIndexOf("price");
		int selectionColumnIndex = getProductTableColumnIndexOf("select");

		for (WebElement tableRow : paginatedTableBody.findElements(By.xpath(".//tr"))) {

			String priceText = tableRow.findElement(By.xpath("./td[" + priceColumnIndex + "]")).getText();
			// TODO: Add try catch here for this.
			// TODO: Also handle if string is empty.
			// Cleans the text according to the regex expression so that it can be parsed to
			// float.
			float actualPrice = Float.parseFloat(priceText.replaceAll(regex, ""));
			System.out.println("Actual price is parsed as: " + actualPrice);

			if (actualPrice > testInputPrice) {
				tableRow.findElement(By.xpath("./td[" + selectionColumnIndex + "]")).click();
			}
		}
	}

	public boolean isPaginationButtonSelected(int index) {
		return productTablePageButtons.get(index).getAttribute("class").contains("active") == true ? true : false;
	}

	public int getProductPageAmount() {
		return Integer.parseInt(productTablePageButtons.getLast().getText());
	}

	public void clickProductPageButton(int index) {

		try {
			productTablePageButtons.get(index).click();

		} catch (Exception e) {
			System.out.println("Couldn't click on the Product Table Page Button with the index: " + index);
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Search through multiple pages of table for specific object.
	 * Send search term to open tabs, control correct tab.
	 * Check if search term disappears?
	 * Open new window and navigate to it, control, close.
	 * Double click
	 * Dragable
	 * Move slider
	 * Enter date of birth
	 */
}
