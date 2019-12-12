package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverUtilities;
import com.utilities.Report;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='main-navigation__secondary-login']")
	private WebElement signInButton;

	@FindBy(xpath = "//a[@class='main-navigation__secondary-search']")
	private WebElement searchButton;

	@FindBy(name = "q")
	private WebElement searchInputField;

	@FindBy(xpath = "//div[@class='main-navigation__primary']")
	private WebElement mainNavigationButton;

	@FindBy(xpath = "//nav[@role='navigation']//li//a[contains(.,'Technology')]")
	private WebElement technologyLink;
	
	private By subNewsHeadings = By.xpath("//section[@role='main']//div[@class='grid']//header");

	/**
	 * This method is to click on the Search button
	 * @return
	 */
	public boolean clickOnSearchButton() {
		Report.info("Entering HomePage::clickOnSearchButton()");
		boolean clicked = false;
		clicked = DriverUtilities.clickOnElement(searchButton);
		Report.info("Exited HomePage::clickOnSearchButton()");
		return clicked;
	}
	
	/**
	 * This method is to check whether the signInbutton is displayed
	 * @return
	 */
	public boolean checkSignInButtonIsDisplayed()
	{
		Report.info("Entering HomePage::checkSignInButtonIsDisplayed()");
		boolean isDisplayed = false;
		DriverUtilities.waitForElementToBecomeVisible(driver, signInButton, 5);
		isDisplayed = signInButton.isDisplayed();
		Report.info("Exited HomePage::checkSignInButtonIsDisplayed() with : " + isDisplayed);
		return isDisplayed;
	}

	/**
	 * This method is to enter the search keyword
	 * @param keyword
	 */
	public void enterSearchKeyword(String keyword)
	{
		DriverUtilities.enterText(searchInputField, keyword);
		searchInputField.sendKeys(Keys.ENTER);
	}

	/**
	 * This method is to click on the main top nav link
	 * @return
	 */
	public boolean clickMainNavLink()
	{
		boolean clicked = false;
		clicked = DriverUtilities.clickOnElement(mainNavigationButton);
		return clicked;
	}
	
	/**
	 * This method is to click on the technology link
	 * @return
	 */
	public Technology clickOnTechnologyLink()
	{
		DriverUtilities.waitForElementToBecomeVisible(driver, signInButton, 2);
		DriverUtilities.clickOnElement(technologyLink);
		return new Technology(driver);
	}
	
	/**
	 * This method is to get the sub heading count
	 * @return
	 */
	public int getTheSubHeadingsCount()
	{
		Report.info("Entering HomePage::getTheSubHeadingsCount()");
		int count = 0;
		count = driver.findElements(subNewsHeadings).size();
		Report.info("Exiting HomePage::getTheSubHeadingsCount() with :" + count);
		return count;
	}
}
