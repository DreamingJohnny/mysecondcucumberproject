package com.mysecondcucumberproject.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class BaseUtilities {

	private static WebDriver driver;
	private static Properties properties = new Properties();

	public static WebDriver initializeDriver() {

		driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-search-engine-choice-screen"));

		driver.get(getConfigProperties().getProperty("db.url"));

		driver.manage().timeouts().implicitlyWait(
				Duration.ofMillis(Integer.parseInt(properties.getProperty("web.implicitWaitInMillis"))));
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static WebDriver getWebDriver() {
		return driver;
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

	public static void takeScreenShot(WebElement element) throws IOException {

		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		File targetDirectory = new File(System.getProperty("user.dir"),
				System.getProperty(getConfigProperties().getProperty("screenshots.path")));
		// Checks if directory exists.
		if (!targetDirectory.exists()) {
			// Creates directory if it doesn't exists
			// New directory is named accordning to folder structure given.
			targetDirectory.mkdirs();
		}

		File targetFile = new File(targetDirectory, getScreenShotName());
		FileHandler.copy(screenshotFile, targetFile);
		System.out.println(targetFile.getAbsolutePath());
	}

	public static String getScreenShotName() {
		return "screenshot_" + new SimpleDateFormat("yyyymmddhhmmss").format(new Date()) + ".png";
	}

	public static int getIndexOfMonth(String month) {
		// needs to return the index, probably based on what place the month has within
		// a hashmap if you can index those?
	}
}
