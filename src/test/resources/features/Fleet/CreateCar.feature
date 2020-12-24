Feature: A user, I want to be able to create new cars

 @add_car @smoke
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
     #for to enter the data, we enter as following
    # left side parameter, , right side value
     |License Plate | SDET |
     |Model Year    | 2021 |
   And user clicks on save and close button

  @add_car_scenario_outline
  Scenario Outline: Add some car for <Licence Plate> plates and <model year> year
    Given user is on the login page
    And user logs in as a "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
     #for to enter the data, we enter as following
    # left side parameter, , right side value
      |License Plate | <Licence Plate> |
      |Model Year    | <model Year> |
    And user clicks on save and close button

    Examples: auto test data
      | Licence Plate | model Year |role|
      | Florida       | 2020       |store manager |
      | QA            | 2021       |store manager |
      | Ramazan       | 2030       |store manager |
      | SDET          | 1999       |sales manager |