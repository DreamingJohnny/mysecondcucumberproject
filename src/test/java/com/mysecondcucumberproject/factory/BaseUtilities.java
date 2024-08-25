package com.mysecondcucumberproject.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtilities {

	private static WebDriver driver;
	private static Properties properties = new Properties();

	public static WebDriver initializeDriver() {

		driver = new ChromeDriver();
		driver.get(getConfigProperties().getProperty("db.url"));
		// It feels very clumsy to me that we use a string here as key to get the
		// property, it doesn't feel much better than just using a
		// string straight up. I wonder what other alternatives I could have though?

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

	public static void takeScreenShot(WebElement element) {

		File sourceFile = element.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty(getConfigProperties().getProperty("screenshots.path")));
		// TODO: Setup naming screenshots based on date and time.
		System.out.println("Saving screenshot!");
		sourceFile.renameTo(targetFile);

	}
}
