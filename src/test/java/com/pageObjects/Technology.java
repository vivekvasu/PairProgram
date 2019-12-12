package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverUtilities;

public class Technology {
	
	WebDriver driver;
	
	/**
	 * Constructor
	 * @param driver
	 */
	public Technology(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='channel-branding__inner']//h1[contains(text(),'Technology')]")
	private WebElement technologyHeader;
	
	/**
	 * This method is to check whether the header Technology is displayed
	 * @return True/False
	 */
	public boolean checkSearchResultSectionIsDisplayed()
	{
		boolean isDisplayed = false;
		DriverUtilities.waitForElementToBecomeVisible(driver, technologyHeader, 3);
		isDisplayed = technologyHeader.isDisplayed();
		return isDisplayed;
	}
}

