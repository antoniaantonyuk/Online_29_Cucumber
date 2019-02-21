Feature: Discuss Module should work properly


#@smoke
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

#ziyoda
Scenario: Inbox folder should be visible on right menu
Given open brite url
When login as inventory user
Then user successfully should see inbox folder on right menu

Scenario:Inbox should be clickable
Given open brite url
When login as inventory user
And click on inbox
Then inbox should successfully clickable

Scenario: The title on the page should be "#Inbox"
Given open brite url
When login as inventory user
And click on inbox
Then the title on the page successfully should be inbox





