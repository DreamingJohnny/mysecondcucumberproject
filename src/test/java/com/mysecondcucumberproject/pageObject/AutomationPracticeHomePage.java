package com.mysecondcucumberproject.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(xpath = "//div[h2[@class='title' and text()='Slider']]")
	WebElement sliderContainer;
	@FindBy(xpath = "//*[@id='slider']/span")
	WebElement slider;
	// #endregion

	// #region Frames
	@FindBy(xpath = "//*[@id='frame-one796456169']")
	WebElement practiceFormFrame;

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
				return maleCheckBox.isSelected();
			case TestConstants.FEMALECHECKBOX_ID:
				return femaleCheckBox.isSelected();
			case TestConstants.MONDAYCHECKBOX_ID:
				return mondayCheckBox.isSelected();
			case TestConstants.TUESDAYCHECKBOX_ID:
				return tuesdayCheckBox.isSelected();
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				return wednesdayCheckBox.isSelected();
			case TestConstants.THURSDAYCHECKBOX_ID:
				return thursdayCheckBox.isSelected();
			case TestConstants.FRIDAYCHECKBOX_ID:
				return fridayCheckbox.isSelected();
			case TestConstants.SATURDAYCHECKBOX_ID:
				return saturdayCheckbox.isSelected();
			case TestConstants.SUNDAYCHECKBOX_ID:
				return sundayCheckBox.isSelected();
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
	public boolean trySetField(String input, String fieldID) {
		if (!canFindWebelement(fieldID))
			return false;

		switch (fieldID.toLowerCase()) {
			case TestConstants.NAMEFIELD_ID:
				nameField.clear();
				nameField.sendKeys(input);
				return true;
			case TestConstants.EMAILFIELD_ID:
				emailField.clear();
				emailField.sendKeys(input);
				return true;
			case TestConstants.PHONEFIELD_ID:
				phoneField.clear();
				phoneField.sendKeys(input);
				return true;
			case TestConstants.TABINPUTSEARCHFIELD_ID:
				tabInputSearchField.clear();
				tabInputSearchField.sendKeys(input);
				return true;
			case TestConstants.FIELD_1_ID:
				field1.click();
				field1.sendKeys(input);
				return true;
			case TestConstants.FIELD_2_ID:
				field2.click();
				field2.sendKeys(input);
				return true;
			default:
				System.out.println(this + " couldn't find a field with a value to set for the input " + input);
				return false;
		}
	}

	public boolean canFindWebelement(String fieldID) {
		// TODO: Should I include Enabled here aswell?
		switch (fieldID.toLowerCase()) {
			case TestConstants.NAMEFIELD_ID:
				return nameField.isDisplayed();
			case TestConstants.EMAILFIELD_ID:
				return emailField.isDisplayed();
			case TestConstants.PHONEFIELD_ID:
				return phoneField.isDisplayed();
			case TestConstants.MALECHECKBOX_ID:
				return maleCheckBox.isDisplayed();
			case TestConstants.FEMALECHECKBOX_ID:
				return femaleCheckBox.isDisplayed();
			case TestConstants.MONDAYCHECKBOX_ID:
				return mondayCheckBox.isDisplayed();
			case TestConstants.TUESDAYCHECKBOX_ID:
				return tuesdayCheckBox.isDisplayed();
			case TestConstants.WEDNESDAYCHECKBOX_ID:
				return wednesdayCheckBox.isDisplayed();
			case TestConstants.THURSDAYCHECKBOX_ID:
				return thursdayCheckBox.isDisplayed();
			case TestConstants.FRIDAYCHECKBOX_ID:
				return fridayCheckbox.isDisplayed();
			case TestConstants.SATURDAYCHECKBOX_ID:
				return saturdayCheckbox.isDisplayed();
			case TestConstants.SUNDAYCHECKBOX_ID:
				return sundayCheckBox.isDisplayed();
			case TestConstants.BOOKTABLE_ID:
				return bookTable.isDisplayed();
			case TestConstants.PAGINATEDTABLE_ID:
				return paginatedTable.isDisplayed();
			case TestConstants.PAGINATEDTABLEBUTTONFIELD_ID:
				return paginationButtonsField.isDisplayed();
			case TestConstants.TABCONTAINER_ID:
				return tabContainer.isDisplayed();
			case TestConstants.TABINPUTSEARCHFIELD_ID:
				return tabInputSearchField.isDisplayed();
			case TestConstants.TABSUBMITBUTTON_ID:
				return tabSubmitButton.isDisplayed();
			case TestConstants.TABSEARCHRESULT_ID:
				return tabSearchResults.isDisplayed();
			case TestConstants.NEWBROWSERWINDOWCONTAINER_ID:
				return newBrowserWindowContainer.isDisplayed();
			case TestConstants.NEWBROWSERWINDOWBUTTON_ID:
				return newBrowserWindowButton.isDisplayed();
			case TestConstants.JSALERTSCONTAINER_ID:
				return jsAlertsContainer.isDisplayed();
			case TestConstants.JSALERTDISMISSBUTTON_ID:
				return alertBoxButton.isDisplayed();
			case TestConstants.CONFIRMBUTTON_ID:
				return confirmBoxButton.isDisplayed();
			case TestConstants.PROMPTBUTTON_ID:
				return promptButton.isDisplayed();
			case TestConstants.DOUBLECLICKCONTAINER_ID:
				return doubleClickContainer.isDisplayed();
			case TestConstants.FIELD_1_ID:
				return field1.isDisplayed();
			case TestConstants.FIELD_2_ID:
				return field2.isDisplayed();
			case TestConstants.COPYTEXTBUTTON_ID:
				return copyTextButton.isDisplayed();
			case TestConstants.DRAGANDDROPCONTAINER:
				return dragAndDropContainer.isDisplayed();
			case TestConstants.DRAGGABLE_ID:
				return draggableElement.isDisplayed();
			case TestConstants.DROPPABLE_ID:
				return droppableElement.isDisplayed();
			case TestConstants.SLIDERCONTAINER_ID:
				return sliderContainer.isDisplayed();
			case TestConstants.SLIDER_ID:
				return slider.isDisplayed();
			case TestConstants.PRACTICEFORMCONTAINTER_ID:
				return practiceFormFrame.isDisplayed();
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
			case TestConstants.TABCONTAINER_ID:
				return tabContainer;
			case TestConstants.TABSEARCHRESULT_ID:
				return tabSearchResults;
			case TestConstants.COPYTEXTBUTTON_ID:
				return copyTextButton;
			case TestConstants.DRAGANDDROPCONTAINER:
				return dragAndDropContainer;
			case TestConstants.DRAGGABLE_ID:
				return draggableElement;
			case TestConstants.DROPPABLE_ID:
				return droppableElement;
			case TestConstants.SLIDERCONTAINER_ID:
				return sliderContainer;
			case TestConstants.SLIDER_ID:
				return slider;
			case TestConstants.PRACTICEFORMCONTAINTER_ID:
				return practiceFormFrame;
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
			case TestConstants.FIELD_1_ID:
				return field1.getText();
			case TestConstants.FIELD_2_ID:
				return field2.getText();
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

	public boolean tryClickButton(String buttonID) {

		if (!canFindWebelement(buttonID))
			return false;
		else {
			switch (buttonID) {
				case TestConstants.TABSUBMITBUTTON_ID:
					tabSubmitButton.click();
					return true;
				case TestConstants.NEWBROWSERWINDOWBUTTON_ID:
					newBrowserWindowButton.click();
					return true;
				case TestConstants.JSALERTDISMISSBUTTON_ID:
					alertBoxButton.click();
					return true;
				case TestConstants.CONFIRMBUTTON_ID:
					confirmBoxButton.click();
					return true;
				case TestConstants.PROMPTBUTTON_ID:
					promptButton.click();
					return true;
				default:
					System.out.println("Couldn't find a case for that button using string id: " + buttonID);
					return false;

			}
		}
	}

	public boolean tryClickChildOf(String parentFieldID, int childIndex) {

		if (!canFindWebelement(parentFieldID))
			return false;
		else {
			try {
				getWebelement(parentFieldID).findElement(By.xpath("./div[" + childIndex + "]/a")).click();
				return true;

			} catch (NoSuchElementException e) {
				System.out.println("Child element not found." + e.getMessage());
				return false;
			}
		}
	}

	public boolean tryDoubleClickButton(String fieldID) {
		if (!canFindWebelement(fieldID)) {
			return false;
		} else {
			Actions action = new Actions(driver);
			try {
				action.doubleClick(getWebelement(fieldID)).perform();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
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

		if (!canFindWebelement(elementID))
			return false;
		else {
			Actions action = new Actions(driver);
			try {
				action.dragAndDropBy(getWebelement(elementID), addedPosition.getX(), addedPosition.getY()).perform();
				return true;
			} catch (MoveTargetOutOfBoundsException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
	}

	public PracticeFormPage goToPracticeForm() {
		try {
			driver.switchTo().frame(practiceFormFrame);

			// TODO: What if it is another error then? Should I always have a catch for
			// general errors?
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
			return null;
		}

		PracticeFormPage temp = new PracticeFormPage(driver);

		return temp;
	}
}