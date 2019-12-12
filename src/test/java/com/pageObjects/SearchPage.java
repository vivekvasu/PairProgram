package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='results']")
	private WebElement searchResultsSection;
	
	/**
	 * This method is to check whether the search results sections are displayed
	 * @return
	 */
	public boolean checkSearchResultSectionIsDisplayed()
	{
		boolean isDisplayed = false;
		isDisplayed = searchResultsSection.isDisplayed();
		return isDisplayed;
	}
}
