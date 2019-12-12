Feature: Homepage Feature

Background: Open the url in chrome browser

Given Open the url in chrome browser

Scenario: Validate search functionality
Given the homepage is loaded
When user clicks on the search button
Then enter the search keyword
When search results page is displayed with results
Then close the browser

Scenario: Validate the header navigation link
Given the homepage is loaded
When the user clicks on the subheading technology 
And the technology page is displayed
Then close the browser

Scenario: Validate the homepage has multiple subheadings
Given the homepage is loaded
When the homepage should have multiple subheadings
Then close the browser



