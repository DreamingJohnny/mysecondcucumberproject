package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features", glue = "com.mysecondcucumberproject.stepdefinitions", tags = "not @skip")

public class TestRunner {

}
