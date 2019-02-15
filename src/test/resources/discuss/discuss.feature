Feature: Discuss Module should work properly


@smoke
Scenario: Check if link "Inbox" exists
Given open brite url
When login as purchase user
And check if Inbox is presented
And open Inbox page
Then check the page title

Scenario: Send direct Message
Given open brite url
When login as purchase user
Then click on send direct message button
And add other user
And select user in drop down menu
And check if selected user is displayed
And delete the selected user
Then check if user is deleted





