package com.mysecondcucumberproject.pageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	private static Properties properties = new Properties();

	// Constructor
	BasePage(WebDriver newDriver) {
		this.driver = newDriver;
		PageFactory.initElements(newDriver, this);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public static Properties getConfigProperties() {
		if (properties.isEmpty()) {
			try (InputStream input = new FileInputStream("src/test/java/resources/features/config.properties")) {

				properties.load(input);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		return properties;
	}

	protected WebElement getWebelement(String fieldID) {
		switch (fieldID.toLowerCase()) {
			default:
				System.out.println("Couln't find a webelement using: " + fieldID);
				return null;
		}
	}

	public void takeScreenShot() {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetDirectory = new File(System.getProperty("user.dir"),
				System.getProperty(getConfigProperties().getProperty("screenshots.path")));
		// Checks if directory exists.
		if (!targetDirectory.exists()) {
			// Creates directory if it doesn't exists
			// New directory is named accordning to folder structure given.
			targetDirectory.mkdirs();
		}

		File targetFile = new File(targetDirectory, getScreenShotName());
		try {
			FileHandler.copy(screenshotFile, targetFile);
			System.out.println(targetFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("An error occurred while copying the screenshot: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void takeScreenShot(String tableID) {
		//TODO: what happens here if the element doesn't exist?
		WebElement element = getWebelement(tableID);
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		File targetDirectory = new File(System.getProperty("user.dir"),
				getConfigProperties().getProperty("screenshots.path"));
		// Checks if directory exists.
		if (!targetDirectory.exists()) {
			// Creates directory if it doesn't exists
			// New directory is named accordning to folder structure given.
			targetDirectory.mkdirs();
		}

		File targetFile = new File(targetDirectory, getScreenShotName());
		try {
			FileHandler.copy(screenshotFile, targetFile);
			System.out.println(targetFile.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("An error occurred while copying the screenshot: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getScreenShotName() {
		return "screenshot_" + new SimpleDateFormat("yyyymmddhhmmss").format(new Date()) + ".png";
	}
}
