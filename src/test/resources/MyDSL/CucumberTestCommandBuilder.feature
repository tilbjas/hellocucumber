Feature: Command Builder

  Scenario: verify add dimension
    Given I have a valid command builder
    When I add a list of dimension
    Then I can add a single dimension and build the command

  Scenario: verify add item
    Given I have a list of dimensions
    And a new dimension
    When I add an item to the dimension
    Then I can get its value
    And there is only one dimension

  Scenario: verify add two items
    Given I have a list of dimensions
    And a new dimension
    When I add two items to the dimension
    Then I can get its values
    And there is only one dimension