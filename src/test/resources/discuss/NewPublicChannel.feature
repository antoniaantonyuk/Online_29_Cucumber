Feature: Created new public channel shoul be visible for all users


Scenario: Main user should create new public channel
Given User log in
Then Create new chanell "NewChannelToCheck"
Then User log out


Scenario: All user should see new public channel
Given User should log in with "info1" and "info2" and join to "NewChannelToCheck"





Scenario: Main user shoul delete tested channel
Given User log in
Then Main user shoul delete created channel"NewChannelToCheck"


