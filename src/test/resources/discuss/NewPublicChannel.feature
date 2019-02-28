@Antonia
Feature: Created new public channel shoul be visible for all users


Scenario: Main user should create new public channel.
Given User log in
Then Create new chanell "NewChannelToCheck"
Then User log out

Scenario Outline: All user should see new public channel
Given User should log in with "<user_email>" and "<password>"
Then Channel "NewChannelToCheck" should be visible
Then User should be able to join to channel
Examples:
|user_email|password|
|in@info.com|alsfuh7we67|
|inm2@info.com|alsfuh7we68|
|inm3@info.com|alsfuh7we69|
|inm4@info.com|alsfuh7we70|
|inm5@info.com|rt332qWW12|
|inm6@info.com|trt332qWW13|
|in2@info.com|alsfuh7we71|
|in3@info.com|alsfuh7we72|
|in4@info.com|alsfuh7we73|
|n_4@info.com|alsfuh7we74|


Scenario: Main user shoul delete tested channel
Given Main user should log in
Then Main user shoul delete created channel
