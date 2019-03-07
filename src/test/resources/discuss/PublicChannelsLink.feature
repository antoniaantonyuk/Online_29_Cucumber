@Antonia
Feature: User should be able to see public channels

 Background:
   Given User loged in

#BRIT-1844
Scenario: user should see link Channels
Then Check if Channels is visible
Then Check if Channels is clickable


#BRIT-2060
Scenario: link Channels forwards to Public Channels Page
Then Click on link Channels
Then Assert the title of opened page with Public Channels

#BRIT-2107
Scenario: General channel should be presented on Public channels page
Then Click on link Channels
Then Assert that General channel is presented

