package com.features;

import org.apache.log4j.PropertyConfigurator;

import com.utilities.Report;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseFeature 
{
	
	@Before()
	public void beforeScenarioStart(Scenario scenario)
	{
		PropertyConfigurator.configure("./resources/log4j.properties");
		Report.info("-------" + scenario.getName() + " started execution-------");
	}	

	@After()
	public void afterScenarioFinish(Scenario scenario)
	{
		Report.info("-------" + scenario.getName() + " finished execution-------");
	}	

}
