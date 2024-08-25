package com.mysecondcucumberproject.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.mysecondcucumberproject.factory.BaseUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class StepHooks {

	// This will contain the methods that we want to run before and after various
	// tests.

	WebDriver driver;
	Properties properties;

	@Before
	public void setup() throws IOException {
		driver = BaseUtilities.initializeDriver();
		driver.manage().window().maximize();
	}

	// TODO: Add method here @AfterStep for calling method on BasePage to take
	// screenshots.

	@After
	public void teardown() {
		BaseUtilities.quitDriver();
	}
}
