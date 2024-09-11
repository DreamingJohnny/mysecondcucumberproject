package com.mysecondcucumberproject.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mysecondcucumberproject.utilities.TestConstants;

import net.bytebuddy.implementation.bytecode.constant.TextConstant;

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
		// TODO: Check with MY, shouldn't it be better if I protected all of these with
		// the "canFind"?
		switch (checkboxID.toLowerCase()) {
			case TestConstants.MALECHECKBOX_ID:
				return maleCheckBox.isSelected() == true ? true : false;
			case TestConstants.FEMALECHECKBOX_ID:
				return femaleCheckBox.isSelected() == true ? true : false;
			case TestConstants.MONDAYCHECKBOX_ID:
				return mondayCheckBox.isSelected() == true ? true : false;
			case TestConstants.TUESDAYCHECKBOX_ID:
				return tuesdayCheckBox.isSelected() == true ? true : false;
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				return wednesdayCheckBox.isSelected() == true ? true : false;
			case TestConstants.THURSDAYCHECKBOX_ID:
				return thursdayCheckBox.isSelected() == true ? true : false;
			case TestConstants.FRIDAYCHECKBOX_ID:
				return fridayCheckbox.isSelected() == true ? true : false;
			case TestConstants.SATURDAYCHECKBOX_ID:
				return saturdayCheckbox.isSelected() == true ? true : false;
			case TestConstants.SUNDAYCHECKBOX_ID:
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
			case TestConstants.MALECHECKBOX_ID:
				maleCheckBox.click();
				break;
			case TestConstants.FEMALECHECKBOX_ID:
				femaleCheckBox.click();
				break;
			case TestConstants.MONDAYCHECKBOX_ID:
				mondayCheckBox.click();
				break;
			case TestConstants.TUESDAYCHECKBOX_ID:
				tuesdayCheckBox.click();
				break;
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				wednesdayCheckBox.click();
				break;
			case TestConstants.THURSDAYCHECKBOX_ID:
				thursdayCheckBox.click();
				break;
			case TestConstants.FRIDAYCHECKBOX_ID:
				fridayCheckbox.click();
				break;
			case TestConstants.SATURDAYCHECKBOX_ID:
				saturdayCheckbox.click();
				break;
			case TestConstants.SUNDAYCHECKBOX_ID:
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
			case TestConstants.NAMEFIELD_ID:
				nameField.clear();
				nameField.sendKeys(input);
				break;
			case TestConstants.EMAILFIELD_ID:
				emailField.clear();
				emailField.sendKeys(input);
				break;
			case TestConstants.PHONEFIELD_ID:
				phoneField.clear();
				phoneField.sendKeys(input);
				break;
			default:
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				break;
		}
	}

	public boolean canFindWebelement(String fieldID) {
		// TODO: Should I include Enabled here aswell?
		switch (fieldID.toLowerCase()) {
			case TestConstants.NAMEFIELD_ID:
				return nameField.isDisplayed() == true ? true : false;
			case TestConstants.EMAILFIELD_ID:
				return emailField.isDisplayed() == true ? true : false;
			case TestConstants.PHONEFIELD_ID:
				return phoneField.isDisplayed() == true ? true : false;
			case TestConstants.MALECHECKBOX_ID:
				return maleCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.FEMALECHECKBOX_ID:
				return femaleCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.MONDAYCHECKBOX_ID:
				return mondayCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.TUESDAYCHECKBOX_ID:
				return tuesdayCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				return wednesdayCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.THURSDAYCHECKBOX_ID:
				return thursdayCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.FRIDAYCHECKBOX_ID:
				return fridayCheckbox.isDisplayed() == true ? true : false;
			case TestConstants.SATURDAYCHECKBOX_ID:
				return saturdayCheckbox.isDisplayed() == true ? true : false;
			case TestConstants.SUNDAYCHECKBOX_ID:
				return sundayCheckBox.isDisplayed() == true ? true : false;
			case TestConstants.BOOKTABLE_ID:
				return bookTable.isDisplayed() == true ? true : false;
			case TestConstants.PAGINATEDTABLE_ID:
				return paginatedTable.isDisplayed() == true ? true : false;
			case TestConstants.PAGINATEDTABLEBUTTONFIELD_ID:
				return paginationButtonsField.isDisplayed() == true ? true : false;
			case TestConstants.TABSCONTAINER_ID:
				return tabsContainer.isDisplayed() == true ? true : false;
			case TestConstants.TABSINPUTSEARCHFIELD_ID:
				return tabsInputSearchField.isDisplayed() == true ? true : false;
			case TestConstants.TABSSUBMITBUTTON_ID:
				return tabsSubmitButton.isDisplayed() == true ? true : false;
			case TestConstants.TABSSEARCHRESULT_ID:
				return searchResults.isDisplayed() == true ? true : false;
			case TestConstants.NEWBROWSERWINDOWCONTAINER_ID:
				return newBrowserWindowContainer.isDisplayed() == true ? true : false;
			case TestConstants.NEWBROWSERWINDOWBUTTON_ID:
				return newBrowserWindowButton.isDisplayed() == true ? true : false;
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return false;
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.NAMEFIELD_ID:
				return nameField;
			case TestConstants.EMAILFIELD_ID:
				return emailField;
			case TestConstants.PHONEFIELD_ID:
				return phoneField;
			case TestConstants.MALECHECKBOX_ID:
				return maleCheckBox;
			case TestConstants.FEMALECHECKBOX_ID:
				return femaleCheckBox;
			case TestConstants.MONDAYCHECKBOX_ID:
				return mondayCheckBox;
			case TestConstants.TUESDAYCHECKBOX_ID:
				return tuesdayCheckBox;
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				return wednesdayCheckBox;
			case TestConstants.THURSDAYCHECKBOX_ID:
				return thursdayCheckBox;
			case TestConstants.FRIDAYCHECKBOX_ID:
				return fridayCheckbox;
			case TestConstants.SATURDAYCHECKBOX_ID:
				return saturdayCheckbox;
			case TestConstants.SUNDAYCHECKBOX_ID:
				return sundayCheckBox;
			case TestConstants.BOOKTABLE_ID:
				return bookTable;
			case TestConstants.PAGINATEDTABLE_ID:
				return paginatedTable;
			case TestConstants.PAGINATEDTABLEBUTTONFIELD_ID:
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
			case TestConstants.BOOKTABLE_ID:
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
			case TestConstants.NAMEFIELD_ID:
				return nameField.getAttribute("value");
			case TestConstants.EMAILFIELD_ID:
				return emailField.getAttribute("value");
			case TestConstants.PHONEFIELD_ID:
				return phoneField.getAttribute("value");
			case TestConstants.PAGINATEDTABLETOPLEFTMOSTCELL_ID:
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

	public void clicksButton(String buttonID) {

		if (canFindWebelement(buttonID)) {
			switch (buttonID) {
				case TestConstants.TABSSUBMITBUTTON_ID:
					tabsSubmitButton.click();
					break;

				default:
					System.out.println("Couldn't find a case for that button using string id: " + buttonID);
					break;

			}
		}
	}
}
