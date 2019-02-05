@sta-travel-test
Feature: sta travel india products

  AS A ProductOwner
  I WANT to see India Products
  SO THAT i can choose my travel destination

  Scenario: sta travel India start adventure product validation
    Given user on STA Worldwide Tours and travel page
    Then user choose India as destination and find a tour
    And user should see matches found under product page