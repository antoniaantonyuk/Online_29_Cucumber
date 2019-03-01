
Feature: Direct Message Functionality
  @mina
Scenario: add other user to direct Message list
  Given open brite url
  When login as purchase user
  Then click on plus sign on direct message
  And add "Demo User" to the list
  And select user in drop down menu
  And check if selected user is displayed

Scenario: Send Direct Messages to other user
  Given open brite url
  When login as purchase user
  Then add other_user to discuss list
  And type and send the message to "Demo user"
  Then message displays on the page

Scenario: Message Marked With Star
  Given open brite url
  When login as purchase user
  Then message displayes on the page
  Then user selects message from the list
  Then message displays on the starred list
  And delete the selected user
  Then check if user is deleted