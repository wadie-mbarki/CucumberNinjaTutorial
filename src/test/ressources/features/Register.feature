Feature: Registration functionnality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to register Acoount page
    When USer enters the details into below fields
      | firstName | adam           |
      | lastName  | mbarki         |
      | email     | adam@gmail.com |
      | telephone |      123456789 |
      | password  |          12345 |
    And User selects Privacy Policy
    And User click on Continue button
    Then User account should get created successfully

  Scenario: User creates an account  with all mandatory fields
    Given User navigates to register Acoount page
    When USer enters the details into below fields
      | firstName | adam           |
      | lastName  | mbarki         |
      | email     | adam@gmail.com |
      | telephone |      123456789 |
      | password  |          12345 |
    And User select yes for NEwsletter
    And User selects Privacy Policy
    And User click on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to register Acoount page
    When USer enters the details into below fields
      | firstName | adam           |
      | lastName  | mbarki         |
      | email     | adam@gmail.com |
      | telephone |      123456789 |
      | password  |          12345 |
    And User select yes for NEwsletter
    And User selects Privacy Policy
    And User click on Continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account  without filling any details
    Given User navigates to register Acoount page
    When USer dont enters any details into fields
    And User click on Continue button
    Then User should get a proper warning for every mandatory field
