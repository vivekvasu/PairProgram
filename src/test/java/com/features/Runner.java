package com.features;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"features"}, glue = {"com.features"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:reports/featureReport.html"})
public class Runner extends AbstractTestNGCucumberTests {

}
