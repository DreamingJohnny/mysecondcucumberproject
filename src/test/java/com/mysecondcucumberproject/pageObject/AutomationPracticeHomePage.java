package com.mysecondcucumberproject.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import com.mysecondcucumberproject.factory.BaseUtilities;
import com.mysecondcucumberproject.utilities.TestConstants;

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
		columnIndex = 0;
		return columnIndex;
	}

	// #region Tabs
	@FindBy(xpath = "//*[@id=\"Wikipedia1\"]")
	WebElement tabContainer;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-input\"]")
	WebElement tabInputSearchField;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-form\"]//input[@type='submit']")
	WebElement tabSubmitButton;
	@FindBy(xpath = "//*[@id=\"Wikipedia1_wikipedia-search-results\"]")
	WebElement tabSearchResults;
	// *[@id="Wikipedia1_wikipedia-search-results"]/div[4]/a
	// #endregion

	// #region New Browser Window
	@FindBy(xpath = "//*[@id=\"HTML4\"]/div[1]")
	WebElement newBrowserWindowContainer;
	@FindBy(xpath = "//*[@id=\"HTML4\"]/div[1]/button")
	WebElement newBrowserWindowButton;
	// #endregion

	// #region JS Alerts
	// return the element that holds a child with the title class that contains the
	// text "Alerts & Popups"
	@FindBy(xpath = "//*[@id=\"HTML9\"][h2[@class=\"title\" and normalize-space(text())=\"Alerts & Popups\"]]\n")
	WebElement AlertsAndPopupsContainer;
	@FindBy(xpath = "//*[@id=\"alertBtn\"]")
	WebElement simpleAlertButton;
	@FindBy(xpath = "//*[@id=\"confirmBtn\"]")
	WebElement confirmationAlertButton;
	@FindBy(xpath = "//*[@id=\"promptBtn\"]")
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
	WebElement copyTextButton;
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
	@FindBy(xpath = "//*[@id=\"HTML7\"][h2[@class=\"title\" and normalize-space(text())=\"Slider\"]]")
	WebElement sliderContainer;
	@FindBy(xpath = "//*[@id=\"slider-range\"]/span[1]")
	WebElement minimumSlider;
	// #endregion

	// #region Form
	@FindBy(xpath = "//h2[contains(@class, \"title\") and contains(text(), \"Form\")]/..")
	WebElement practiceFormFrame;
	// Returns all descendants of Form's parent, who have the class "input-field"
	@FindBy(xpath = "//h2[contains(@class, \"title\") and contains(text(), \"Form\")]/..//*[contains(@class, \"input-field\")]")
	List<WebElement> inputSections;
	// Returns all descendants of Form's parent, who have the class "rectangular
	// button"
	@FindBy(xpath = "//h2[contains(@class, \"title\") and contains(text(), \"Form\")]/..//*[contains(@class, \"rectangular-button\")]")
	List<WebElement> inputSubmitButtons;
	// #endregion

	// #region date of birth
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
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/td")
	List<WebElement> dateBoxes;
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
		switch (checkboxID.toLowerCase().trim()) {
			case TestConstants.MALECHECKBOX_ID -> {
				return maleCheckBox.isSelected();
			}
			case TestConstants.FEMALECHECKBOX_ID -> {
				return femaleCheckBox.isSelected();
			}
			case TestConstants.MONDAYCHECKBOX_ID -> {
				return mondayCheckBox.isSelected();
			}
			case TestConstants.TUESDAYCHECKBOX_ID -> {
				return tuesdayCheckBox.isSelected();
			}
			case TestConstants.WEDNESDAYCHECKBOX_ID -> {
				return wednesdayCheckBox.isSelected();
			}
			case TestConstants.THURSDAYCHECKBOX_ID -> {
				return thursdayCheckBox.isSelected();
			}
			case TestConstants.FRIDAYCHECKBOX_ID -> {
				return fridayCheckbox.isSelected();
			}
			case TestConstants.SATURDAYCHECKBOX_ID -> {
				return saturdayCheckbox.isSelected();
			}
			case TestConstants.SUNDAYCHECKBOX_ID -> {
				return sundayCheckBox.isSelected();
			}
			default -> {
				// TODO: Check how to best print log messages, if System.out.println, is
				// disabled during testing.
				System.out.println("Couldn't find a checkbox using: " + checkboxID);
				return false;
			}
		}
	}

	public void toggleCheckBox(String checkboxID) {
		switch (checkboxID.toLowerCase().trim()) {
			case TestConstants.MALECHECKBOX_ID -> maleCheckBox.click();
			case TestConstants.FEMALECHECKBOX_ID -> femaleCheckBox.click();
			case TestConstants.MONDAYCHECKBOX_ID -> mondayCheckBox.click();
			case TestConstants.TUESDAYCHECKBOX_ID -> tuesdayCheckBox.click();
			case TestConstants.WEDNESDAYCHECKBOX_ID -> wednesdayCheckBox.click();
			case TestConstants.THURSDAYCHECKBOX_ID -> thursdayCheckBox.click();
			case TestConstants.FRIDAYCHECKBOX_ID -> fridayCheckbox.click();
			case TestConstants.SATURDAYCHECKBOX_ID -> saturdayCheckbox.click();
			case TestConstants.SUNDAYCHECKBOX_ID -> sundayCheckBox.click();
			default -> System.out.println("Couldn't find a checkbox using: " + checkboxID);
		}
	}

	/**
	 * uses sendKeys to send the input to the webelement it identifies with the
	 * fieldID.
	 * 
	 * @param input
	 * @param fieldID
	 */
	public boolean trySetField(String input, String fieldID) {
		if (!canFindWebelement(fieldID))
			return false;

		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.NAMEFIELD_ID -> {
				nameField.clear();
				nameField.sendKeys(input);
				return true;
			}
			case TestConstants.EMAILFIELD_ID -> {
				emailField.clear();
				emailField.sendKeys(input);
				return true;
			}
			case TestConstants.PHONEFIELD_ID -> {
				phoneField.clear();
				phoneField.sendKeys(input);
				return true;
			}
			case TestConstants.TABINPUTSEARCHFIELD_ID -> {
				tabInputSearchField.clear();
				tabInputSearchField.sendKeys(input);
				return true;
			}
			case TestConstants.FIELD_1_ID -> {
				field1.click();
				field1.sendKeys(input);
				return true;
			}
			case TestConstants.FIELD_2_ID -> {
				field2.click();
				field2.sendKeys(input);
				return true;
			}
			case TestConstants.FRAMEDOBFIELD_ID -> {
				dOBField.clear();
				dOBField.sendKeys(input);
				return true;
			}
			default -> {
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				return false;
			}
		}
	}

	public boolean canFindWebelement(String fieldID) {
		// TODO: Should I include Enabled here aswell?
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.NAMEFIELD_ID -> {
				return nameField.isDisplayed();
			}
			case TestConstants.EMAILFIELD_ID -> {
				return emailField.isDisplayed();
			}
			case TestConstants.PHONEFIELD_ID -> {
				return phoneField.isDisplayed();
			}
			case TestConstants.MALECHECKBOX_ID -> {
				return maleCheckBox.isDisplayed();
			}
			case TestConstants.FEMALECHECKBOX_ID -> {
				return femaleCheckBox.isDisplayed();
			}
			case TestConstants.MONDAYCHECKBOX_ID -> {
				return mondayCheckBox.isDisplayed();
			}
			case TestConstants.TUESDAYCHECKBOX_ID -> {
				return tuesdayCheckBox.isDisplayed();
			}
			case TestConstants.WEDNESDAYCHECKBOX_ID -> {
				return wednesdayCheckBox.isDisplayed();
			}
			case TestConstants.THURSDAYCHECKBOX_ID -> {
				return thursdayCheckBox.isDisplayed();
			}
			case TestConstants.FRIDAYCHECKBOX_ID -> {
				return fridayCheckbox.isDisplayed();
			}
			case TestConstants.SATURDAYCHECKBOX_ID -> {
				return saturdayCheckbox.isDisplayed();
			}
			case TestConstants.SUNDAYCHECKBOX_ID -> {
				return sundayCheckBox.isDisplayed();
			}
			case TestConstants.BOOKTABLE_ID -> {
				return bookTable.isDisplayed();
			}
			case TestConstants.PAGINATEDTABLE_ID -> {
				return paginatedTable.isDisplayed();
			}
			case TestConstants.PAGINATEDTABLEBUTTONFIELD_ID -> {
				return paginationButtonsField.isDisplayed();
			}
			case TestConstants.TABCONTAINER_ID -> {
				return tabContainer.isDisplayed();
			}
			case TestConstants.TABINPUTSEARCHFIELD_ID -> {
				return tabInputSearchField.isDisplayed();
			}
			case TestConstants.TABSUBMITBUTTON_ID -> {
				return tabSubmitButton.isDisplayed();
			}
			case TestConstants.TABSEARCHRESULT_ID -> {
				return tabSearchResults.isDisplayed();
			}
			case TestConstants.NEWBROWSERWINDOWCONTAINER_ID -> {
				return newBrowserWindowContainer.isDisplayed();
			}
			case TestConstants.NEWBROWSERWINDOWBUTTON_ID -> {
				return newBrowserWindowButton.isDisplayed();
			}
			case TestConstants.JSALERTSCONTAINER_ID -> {
				return AlertsAndPopupsContainer.isDisplayed();
			}
			case TestConstants.JSALERTDISMISSBUTTON_ID -> {
				return simpleAlertButton.isDisplayed();
			}
			case TestConstants.CONFIRMBUTTON_ID -> {
				return confirmationAlertButton.isDisplayed();
			}
			case TestConstants.PROMPTBUTTON_ID -> {
				return promptButton.isDisplayed();
			}
			case TestConstants.DOUBLECLICKCONTAINER_ID -> {
				return doubleClickContainer.isDisplayed();
			}
			case TestConstants.FIELD_1_ID -> {
				return field1.isDisplayed();
			}
			case TestConstants.FIELD_2_ID -> {
				return field2.isDisplayed();
			}
			case TestConstants.COPYTEXTBUTTON_ID -> {
				return copyTextButton.isDisplayed();
			}
			case TestConstants.DRAGANDDROPCONTAINER -> {
				return dragAndDropContainer.isDisplayed();
			}
			case TestConstants.DRAGGABLE_ID -> {
				return draggableElement.isDisplayed();
			}
			case TestConstants.DROPPABLE_ID -> {
				return droppableElement.isDisplayed();
			}
			case TestConstants.SLIDERCONTAINER_ID -> {
				return sliderContainer.isDisplayed();
			}
			case TestConstants.SLIDER_ID -> {
				return minimumSlider.isDisplayed();
			}
			case TestConstants.PRACTICEFORMCONTAINTER_ID -> {
				return practiceFormFrame.isDisplayed();
			}
			case TestConstants.DOBCONTAINER_ID -> {
				return (dOBContainer.isDisplayed() && dOBContainer.isEnabled());
			}
			case TestConstants.FRAMEDOBFIELD_ID -> {
				return (dOBField.isDisplayed() && dOBField.isEnabled());
			}
			case TestConstants.CALENDARBUTTON_ID -> {
				return (calendarButton.isDisplayed() && calendarButton.isEnabled());
			}
			case TestConstants.FRAMEWORKDROPDOWN_ID -> {
				return (workDropDown.isDisplayed() && workDropDown.isEnabled());
			}
			case TestConstants.DOBDROPDOWN_ID -> {
				return (dobDropdown.isDisplayed() && dobDropdown.isEnabled());
			}
			case TestConstants.DOBDROPDOWNPASTMONTH_ID -> {
				return (dobPastMonthButton.isDisplayed() && dobPastMonthButton.isEnabled());
			}
			case TestConstants.DOBDROPDOWNCOMINGMONTH_ID -> {
				return (dobComingMonthButton.isDisplayed() && dobComingMonthButton.isEnabled());
			}
			case TestConstants.DOBDROPDOWNCURRENTMONTH_ID -> {
				return (dobComingMonthButton.isDisplayed() && dobComingMonthButton.isEnabled());
			}
			case TestConstants.DOBDROPDOWNYEARDROPDOWN_ID -> {
				return (dobYearDropDown.isDisplayed() && dobYearDropDown.isEnabled());
			}
			case TestConstants.DOBDROPDOWNTABLEBODY_ID -> {
				return (dobTableBody.isDisplayed() && dobTableBody.isEnabled());
			}
			default -> {
				System.out.println("Couln't find a webelement using: " + fieldID);
				return false;
			}
		}
	}

	@Override
	protected List<WebElement> getWebelements(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.FORMINPUTFIELDS_ID -> {
				return inputSections;
			}
			case TestConstants.FORMSUBMITBUTTONS_ID -> {
				return inputSubmitButtons;
			}
			default -> {
				System.out.println("Couln't find a list of webelements using: " + fieldID);
				return null;
			}
		}
	}

	@Override
	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase().trim()) {
			case TestConstants.NAMEFIELD_ID -> {
				return nameField;
			}
			case TestConstants.EMAILFIELD_ID -> {
				return emailField;
			}
			case TestConstants.PHONEFIELD_ID -> {
				return phoneField;
			}
			case TestConstants.MALECHECKBOX_ID -> {
				return maleCheckBox;
			}
			case TestConstants.FEMALECHECKBOX_ID -> {
				return femaleCheckBox;
			}
			case TestConstants.MONDAYCHECKBOX_ID -> {
				return mondayCheckBox;
			}
			case TestConstants.TUESDAYCHECKBOX_ID -> {
				return tuesdayCheckBox;
			}
			case TestConstants.WEDNESDAYCHECKBOX_ID -> {
				return wednesdayCheckBox;
			}
			case TestConstants.THURSDAYCHECKBOX_ID -> {
				return thursdayCheckBox;
			}
			case TestConstants.FRIDAYCHECKBOX_ID -> {
				return fridayCheckbox;
			}
			case TestConstants.SATURDAYCHECKBOX_ID -> {
				return saturdayCheckbox;
			}
			case TestConstants.SUNDAYCHECKBOX_ID -> {
				return sundayCheckBox;
			}
			case TestConstants.BOOKTABLE_ID -> {
				return bookTable;
			}
			case TestConstants.PAGINATEDTABLE_ID -> {
				return paginatedTable;
			}
			case TestConstants.PAGINATEDTABLEBUTTONFIELD_ID -> {
				return paginationButtonsField;
			}
			case TestConstants.TABCONTAINER_ID -> {
				return tabContainer;
			}
			case TestConstants.TABSEARCHRESULT_ID -> {
				return tabSearchResults;
			}
			case TestConstants.COPYTEXTBUTTON_ID -> {
				return copyTextButton;
			}
			case TestConstants.DRAGANDDROPCONTAINER -> {
				return dragAndDropContainer;
			}
			case TestConstants.DRAGGABLE_ID -> {
				return draggableElement;
			}
			case TestConstants.DROPPABLE_ID -> {
				return droppableElement;
			}
			case TestConstants.SLIDERCONTAINER_ID -> {
				return sliderContainer;
			}
			case TestConstants.SLIDER_ID -> {
				return minimumSlider;
			}
			case TestConstants.PRACTICEFORMCONTAINTER_ID -> {
				return practiceFormFrame;
			}
			case TestConstants.FRAMENAMEFIELD_ID -> {
				return nameField;
			}
			case TestConstants.DOBCONTAINER_ID -> {
				return dOBContainer;
			}
			case TestConstants.FRAMEDOBFIELD_ID -> {
				return dOBField;
			}
			case TestConstants.CALENDARBUTTON_ID -> {
				return calendarButton;
			}
			case TestConstants.DOBDROPDOWN_ID -> {
				return dobDropdown;
			}
			case TestConstants.DOBDROPDOWNPASTMONTH_ID -> {
				return dobPastMonthButton;
			}
			case TestConstants.DOBDROPDOWNCOMINGMONTH_ID -> {
				return dobComingMonthButton;
			}
			case TestConstants.DOBDROPDOWNCURRENTMONTH_ID -> {
				return dobComingMonthButton;
			}
			case TestConstants.DOBDROPDOWNYEARDROPDOWN_ID -> {
				return dobYearDropDown;
			}
			case TestConstants.DOBDROPDOWNTABLEBODY_ID -> {
				return dobTableBody;
			}
			case TestConstants.FRAMEWORKDROPDOWN_ID -> {
				return workDropDown;
			}
			default -> {
				System.out.println("Couln't find a webelement using: " + fieldID);
				return null;
			}
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
		switch (tableID.toLowerCase().trim()) {
			case TestConstants.BOOKTABLE_ID -> {
				List<WebElement> tempElements = bookTable.findElements(By.tagName("th"));
				List<String> tempStrings = new ArrayList<>();

				for (WebElement element : tempElements) {
					tempStrings.add(element.getText());
				}
				return tempStrings;
			}
			default -> {
				System.out.println("Couldn't find a case in the switch matching: " + tableID);
				return new ArrayList<>();
			}
		}
	}

	public int getWeekdayCheckboxAmount() {
		return weekdayCheckboxes.size();
	}

	public String getElementText(String elementID) {
		switch (elementID.toLowerCase().trim()) {
			case TestConstants.NAMEFIELD_ID -> {
				return nameField.getDomProperty("value");
			}
			case TestConstants.EMAILFIELD_ID -> {
				return emailField.getDomProperty("value");
			}
			case TestConstants.PHONEFIELD_ID -> {
				return phoneField.getDomProperty("value");
			}
			case TestConstants.PAGINATEDTABLETOPLEFTMOSTCELL_ID -> {
				return topLeftmostProductTableCell.getText();
			}
			case TestConstants.FIELD_1_ID -> {
				return field1.getText();
			}
			case TestConstants.FIELD_2_ID -> {
				return field2.getText();
			}
			case TestConstants.FRAMEDOBFIELD_ID -> {
				return dOBField.getDomAttribute("value");
			}
			default -> {
				System.out.println(this + "couldn't find an element to get the value of with the ID of: " + elementID);
				return null;
			}
		}
	}

	public boolean isPaginationButtonSelected(int index) {
		return productTablePageButtons.get(index - 1).getDomAttribute("class").contains("active") == true;
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

		return (arr[index].isSelected()) == true;
	}

	public String getWeekdayCheckboxValue(int index) {
		// Creates array with correct size
		WebElement[] arr = new WebElement[weekdayCheckboxes.size()];

		// Converting List to Array
		for (int i = 0; i < weekdayCheckboxes.size(); i++) {
			arr[i] = weekdayCheckboxes.get(i);
		}

		return arr[index].getDomAttribute("value");
	}

	public boolean tryClickButton(String buttonID) {

		if (!canFindWebelement(buttonID)) {
			return false;
		}

		switch (buttonID.toLowerCase().trim()) {
			case TestConstants.TABSUBMITBUTTON_ID -> {
				tabSubmitButton.click();
				return true;
			}
			case TestConstants.NEWBROWSERWINDOWBUTTON_ID -> {
				newBrowserWindowButton.click();
				return true;
			}
			case TestConstants.JSALERTDISMISSBUTTON_ID -> {
				simpleAlertButton.click();
				return true;
			}
			case TestConstants.CONFIRMBUTTON_ID -> {
				confirmationAlertButton.click();
				return true;
			}
			case TestConstants.PROMPTBUTTON_ID -> {
				promptButton.click();
				return true;
			}
			default -> {
				System.out.println("Couldn't find a case for that button using string id: " + buttonID);
				return false;
			}

		}
	}

	public boolean tryClickChildOf(String parentFieldID, int childIndex) {

		if (!canFindWebelement(parentFieldID)) {
			return false;
		}

		try {
			getWebelement(parentFieldID).findElement(By.xpath("./div[" + childIndex + "]/a")).click();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Child element not found." + e.getMessage());
			return false;
		}
	}

	public boolean tryDoubleClickButton(String fieldID) {
		if (!canFindWebelement(fieldID)) {
			return false;
		}

		Actions action = new Actions(driver);
		try {
			action.doubleClick(getWebelement(fieldID)).perform();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean tryDragAndDropElements(String dragID, String dropID) {
		if (!canFindWebelement(dragID) || !canFindWebelement(dropID)) {
			return false;
		} else {
			Actions action = new Actions(driver);
			action.dragAndDrop(getWebelement(dragID), getWebelement(dropID)).perform();
			return true;
		}

	}

	public Point getPosition(String elementID) {
		if (!canFindWebelement(elementID)) {
			return null;
		}
		return getWebelement(elementID).getLocation();
	}

	public boolean tryMoveElement(String elementID, Point addedPosition) {

		if (!canFindWebelement(elementID)) {
			return false;
		}

		Actions action = new Actions(driver);
		try {
			action.dragAndDropBy(getWebelement(elementID), addedPosition.getX(), addedPosition.getY()).perform();
			return true;
		} catch (MoveTargetOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
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

	public boolean trySelectInDropdown(String elementID, String year, int month, String date) {
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

		// The takeScreenShot() below is just during testing/working
		takeScreenShot(TestConstants.DOBDROPDOWN_ID);

		if (!trySetDOBMonth(dropDown, month)) {
			return false;
		}

		// The takeScreenShot() below is just during testing/working
		takeScreenShot(TestConstants.DOBDROPDOWN_ID);

		if (!trySetDOBDay(dropDown, date)) {
			return false;
		}

		// The takeScreenShot() below is just during testing/working
		takeScreenShot(TestConstants.DOBDROPDOWN_ID);

		return true;
	}

	private boolean trySetDOBDay(Select dropDown, String date) {

		/*
		 * See if it can find the needed elements.
		 * Will otherwise have a list of data cells
		 * go through them one by one, find it they have the right value.
		 * If they do, do something to set it?
		 */

		/*
		 * Rethink if this works, considering that these are a whole list of elements,
		 * Also consider if the path for the body is even needed then?
		 * Also consider if I can use a getter here, or it that doesn't work then?
		 * Also consider, might not need dropDown here then I suppose?
		 * Alse REMEMEBER that you want to go into each box child of type <a> to get the
		 * inner text to get the date.
		 */
		if (!canFindWebelement(TestConstants.DOBDATEBOXES)) {
			return false;
		}

		for (WebElement dateBox : dateBoxes) {
			if (dateBox.findElement(By.xpath("/<a>")).getText().equals(date)) {
				dateBox.click();
				return true;
			}
		}

		return false;
	}

	private boolean trySetDOBMonth(Select dropDown, int monthToSet) {
		/*
		 * SO, this one will use the main dropdown, wait, does it need that?
		 * It will need the text field for months,
		 * 
		 * gets the month, as text, uses that to get the value of that month
		 * compares to month
		 */
		while (BaseUtilities.getIndexOfMonth(dobCurrentMonthText.getText()) != monthToSet) {
			if (BaseUtilities.getIndexOfMonth(dobCurrentMonthText.getText()) > monthToSet) {
				// Decreases the current month by clicking on the button for past month
				dobPastMonthButton.click();
			} else if (BaseUtilities.getIndexOfMonth(dobCurrentMonthText.getText()) < monthToSet) {
				// Increases the current month by clicking on the button for coming month
				dobComingMonthButton.click();
			}

			System.out.println("The current month is(and we are working on changing that): " + dobCurrentMonthText);
		}
		// Will return true when the month has the correct value.
		return true;
	}

}