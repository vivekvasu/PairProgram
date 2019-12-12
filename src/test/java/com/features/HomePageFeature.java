package com.features;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pageObjects.HomePage;
import com.pageObjects.SearchPage;
import com.pageObjects.Technology;
import com.utilities.DriverManager;
import com.utilities.DriverUtilities;
import com.utilities.PropertyUtils;
import com.utilities.Report;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageFeature {

	public WebDriver driver;
	public static Properties inputProperties;

	@Given("^Open the url in chrome browser$")
	public void openURL()
	{
		inputProperties = PropertyUtils.readPropertyFile("./resources/global.properties");
		driver = DriverManager.getWebDriver(inputProperties.getProperty("browser"));
		DriverUtilities.openUrl(driver, inputProperties.getProperty("url"));
	}

	@Given("^the homepage is loaded$")
	public void validateTheHomepageIsDisplayed()
	{
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.checkSignInButtonIsDisplayed());
	}


	@When("^user clicks on the search button$")
	public void clickOnSearchButton()
	{
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchButton();
	}

	@When("^the user clicks on the subheading technology $")
	public void clickOnSubheading()
	{
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchButton();
	}

	@And("^enter the search keyword$")
	public void enterSearchKeyword()
	{
		HomePage homepage = new HomePage(driver);
		homepage.enterSearchKeyword("News");
	}

	@Then("^search results page is displayed with results$")
	public void validateTheSearchResultsPageIsDisplayed()
	{
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.checkSearchResultSectionIsDisplayed());
	}

	@Then("^the technology page is displayed$")
	public void validateTheTechnologypageIsDisplayed()
	{
		HomePage homepage = new HomePage(driver);
		Technology technology;
		homepage.clickMainNavLink();
		technology = homepage.clickOnTechnologyLink();
		Assert.assertTrue(technology.checkSearchResultSectionIsDisplayed());

	}

	@When("^the homepage should have multiple subheadings$")
	public void validateThatSubHeaderCount()
	{
		HomePage homepage = new HomePage(driver);
		int count = 0;
		count = homepage.getTheSubHeadingsCount();
		Report.info("Headers displayed :" + count);
		Assert.assertTrue(count > 0);
	}

	@Then("^close the browser$")
	public void closeBrowser()
	{
		DriverUtilities.deleteCookies(driver);
		DriverUtilities.closeBrowser(driver);
		DriverUtilities.quitDriver(driver);
	}

}
