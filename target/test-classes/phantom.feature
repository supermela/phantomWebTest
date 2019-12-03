@phantomWebTest
Feature: To test functionality of Phantom website

Background:
Given launch Phantom url

Scenario: testing website on Chrome
Then click on Market Finder
And click on Launch
Then click on About
When click on view open positions
And click on junior QA
And click Submit
Then fill the required fields
When click on contact
Then click on home
And quit the browser