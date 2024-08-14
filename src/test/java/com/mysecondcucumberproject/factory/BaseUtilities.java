package com.mysecondcucumberproject.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtilities {

	private static WebDriver driver;
	private static Properties properties;

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
			try (InputStream input = new FileInputStream("config.properties")) {

				properties.load(input);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		return properties;
	}
}
