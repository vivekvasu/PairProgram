Feature: Homepage Feature

Background: Open the url in chrome browser

Given Open the url in chrome browser

Scenario: Validate search functionality
Given the homepage is loaded
When user clicks on the search button
And enter the search keyword
Then search results page is displayed with results

Scenario: Validate the header navigation link
Given the homepage is loaded
When the user clicks on the subheading technology 
Then the technology page is displayed

Scenario: Validate the homepage has multiple subheadings
Given the homepage is loaded
When the homepage should have multiple subheadings
Then close the browser



