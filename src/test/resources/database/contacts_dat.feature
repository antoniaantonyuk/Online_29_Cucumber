Feature: Contacts menu database test
@db
Scenario: Verify contacts db test
Given open brite url
When login as purchase user
And user goes to contacts page
Then all contact names should be match with database records