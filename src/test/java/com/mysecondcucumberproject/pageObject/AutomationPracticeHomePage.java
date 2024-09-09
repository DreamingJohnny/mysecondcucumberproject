package com.mysecondcucumberproject.pageObject;

import java.util.ArrayList;
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

	// #region Form fields
	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement nameField;
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;
	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneField;
	// #endregion

	// #region Gender checkboxes
	@FindBy(xpath = "//*[@id=\"male\"]")
	WebElement maleCheckBox;
	@FindBy(xpath = "//*[@id=\"female\"]")
	WebElement femaleCheckBox;
	// #endregion

	// #region Weekday checkboxes
	// TODO: Check if these specifics for the weekdays are actually needed.
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

	@FindBy(xpath = "//*[label[@for='days']]//input[@type='checkbox']")
	List<WebElement> weekdayCheckboxes;
	// #endregion

	// #region Book table
	@FindBy(xpath = "//*[@id=\"HTML1\"]/div[1]/table")
	WebElement bookTable;
	// #endregion

	// #region Paginated table
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
	@FindBy(xpath = "//*[@id=\"productTable\"]/tbody//td")
	WebElement topLeftmostProductTableCell;
	// #endregion

	public int getProductTableColumnIndexOf(String searchTerm) {

		int columnIndex = 0;
		for (WebElement webElement : productTableHeaders) {
			columnIndex++;
			if (webElement.getText().toLowerCase().contains(searchTerm.toLowerCase()))
				return columnIndex;
		}
		System.out.println("Couldn't find any header of column with the searchterm: " + searchTerm);
		return columnIndex = 0;
	}

	// #region Tabs
	@FindBy(xpath = "//*[@id=\"Wikipedia1\"]")
	WebElement tabsContainer;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-form\"]")
	WebElement tabsInputSearchField;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-form\"]//input[@type='submit']")
	WebElement tabsSubmitButton;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-results\"]")
	WebElement searchResults;
	// #endregion

	// #region New Browser Window
	@FindBy(xpath = "//div[h2[@class='title' and text()='New Browser Window']]")
	WebElement newBrowserWindowContainer;
	@FindBy(xpath = "//button[normalize-space()='New Browser Window']")
	WebElement newBrowserWindowButton;
	// #endregion

	// #region JS Alerts
	@FindBy(xpath = "//div[h2[@class='title' and text()='JS Alerts']]")
	WebElement jsAlertsContainer;
	@FindBy(xpath = "//div[h2[@class='title' and text()='JS Alerts']]//button[text()='Alert']")
	WebElement alertBoxButton;
	@FindBy(xpath = "//div[h2[@class='title' and text()='JS Alerts']]//button[text()='Confirm Box']")
	WebElement confirmBoxButton;
	@FindBy(xpath = "//div[h2[@class='title' and text()='JS Alerts']]//button[text()='Prompt']")
	WebElement promptButton;
	// #endregion

	// #region Double Click
	@FindBy(xpath = "//div[h2[@class='title' and text()='Double Click']]")
	WebElement doubleClickContainer;
	@FindBy(xpath = "//*[@id=\"field1\"]")
	WebElement field1;
	@FindBy(xpath = "//*[@id=\"field2\"]")
	WebElement field2;
	@FindBy(xpath = "//div[h2[@class='title' and text()='Double Click']]//button[text()='Copy Text']")
	WebElement copyTestButton;
	// #endregion

	// #region Drag and Drop
	@FindBy(xpath = "//div[h2[@class='title' and text()='Drag and Drop']]")
	WebElement dragAndDropContainer;
	@FindBy(xpath = "//*[@id=\"draggable\"]")
	WebElement draggableElement;
	@FindBy(xpath = "//*[@id=\"droppable\"]")
	WebElement droppableElement;
	// #endregion

	// #region Slider
	@FindBy(xpath = "//div[h2[@class='title' and text()='Slider']]")
	WebElement sliderContainer;

	// Slider handle? And the rest of the slider probably?

	// #endregion

	// #region Frames

	// #endregion

	// #region Resizable
	@FindBy(xpath = "//div[h2[@class='title' and text()='Resizable']]")
	WebElement resizeableContainer;
	@FindBy(xpath = "//*[@id=\"resizable\"]")
	WebElement resizableElement;
	// #endregion

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
			case "book table":
				return bookTable.isDisplayed() == true ? true : false;
			case "paginated table":
				return paginatedTable.isDisplayed() == true ? true : false;
			case "paginated button field":
				return paginationButtonsField.isDisplayed() == true ? true : false;
			case "tabs container":
				return tabsContainer.isDisplayed() == true ? true : false;
			case "tabs input search field":
				return tabsInputSearchField.isDisplayed() == true ? true : false;
			case "tabs submit button":
				return tabsSubmitButton.isDisplayed() == true ? true : false;
			case "tabs search result":
				return searchResults.isDisplayed() == true ? true : false;
			case "new browser window container":
				return newBrowserWindowContainer.isDisplayed() == true ? true : false;
			case "new browser window button":
				return newBrowserWindowButton.isDisplayed() == true ? true : false;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return false;
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
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
			case "book table":
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
			case "book table":
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

	public int getWeekdayCheckboxAmount() {
		return weekdayCheckboxes.size();
	}

	public String getElementText(String elementID) {
		switch (elementID.toLowerCase()) {
			case "name":
				return nameField.getAttribute("value");
			case "email":
				return emailField.getAttribute("value");
			case "phone":
				return phoneField.getAttribute("value");
			case "top leftmost product table cell":
				return topLeftmostProductTableCell.getText();
			default:
				System.out.println(this + "couldn't find an element to get the value of with the ID of: " + elementID);
				return null;
		}
	}

	public boolean isPaginationButtonSelected(int index) {
		return productTablePageButtons.get(index - 1).getAttribute("class").contains("active") == true ? true : false;
	}

	public int getProductPageAmount() {
		return Integer.parseInt(productTablePageButtons.getLast().getText());
	}

	// TODO: Add explanation how this handles stuff with the index,
	public void clickProductPageButton(int index) {
		index = index - 1;

		try {
			productTablePageButtons.get(index).click();

		} catch (Exception e) {
			System.out.println("Couldn't click on the Product Table Page Button with the index: " + index);
			System.out.println(e.getMessage());
		}
	}

	public boolean isWeekdayCheckBoxSelected(int index) {

		// Creates array with correct size
		WebElement[] arr = new WebElement[weekdayCheckboxes.size()];

		// Converting List to Array
		for (int i = 0; i < weekdayCheckboxes.size(); i++) {
			arr[i] = weekdayCheckboxes.get(i);
		}

		return (arr[index].isSelected()) == true ? true : false;
	}

	public String getWeekdayCheckboxValue(int index) {
		// Creates array with correct size
		WebElement[] arr = new WebElement[weekdayCheckboxes.size()];

		// Converting List to Array
		for (int i = 0; i < weekdayCheckboxes.size(); i++) {
			arr[i] = weekdayCheckboxes.get(i);
		}

		return arr[index].getAttribute("value");
	}
}
