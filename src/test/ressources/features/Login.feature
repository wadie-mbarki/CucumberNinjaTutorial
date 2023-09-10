Feature: Login functionnality

Scenario: Login with valid credentials
Given User has navigated to login page
When User entered valid mail "wadie@gmail.com"
And User entered valid password "12345"
And Userclick on login button
Then User should get successfuly logged in

Scenario: Login with invalid credentials
Given User has navigated to login page
When User entered invalid mail "wadie1234@gmail.com"
And User entered invalid password "123451234"
And User click on login button
Then User should get a proper warning message

Scenario: Login with valid mail and invalid password
Given User has navigated to login page
When User entered valid mail "wadie@gmail.com"
And User entered invalid password "123451234"
And User click on login button
Then User should get a proper warning message

Scenario: Login with invalid mail and valid password
Given User has navigated to login page
When User entered invalid mail "wadie1234@gmail.com"
And User entered valid password "12345"
And User click on login button
Then User should get a proper warning message

Scenario: Login without any credentials
Given User has navigated to login page
When User dont entered mail
And User dont entered password
And User click on login button
Then User should get a proper warning message