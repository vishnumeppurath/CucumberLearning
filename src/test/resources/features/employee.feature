Feature: Employee list
  This feature is to validate the employee list functionality

  @id
  Scenario Outline: Validate if employee id field is listed
    Given My application is up and running
      | field   | responseCode    |
      | <field> | <<responseCode> |
    When I request for list of employees
    Then I should get a <responseCode> response
    And The response should include "<field>" field
    Examples:
      | field  | responseCode |
      | id     | 200          |
      | name   | 200          |
      | salary | 200          |

#  @id
#  Scenario Outline: Validate if employee id field is listed
#    Given My application is up and running
#    When I request for list of employees
#    Then I should get a <responseCode> response
#    And The result should include "<field>" field
#    Examples:
#      | field  | responseCode |
#      | id     | 200          |
#      | name   | 200          |
#      | salary | 200          |


#  @name
#  Scenario: Validate if employee name field is listed
#    Given My application is up and running
#    When I request for list of employees
#    Then I should get a 200 response
#    And The response should include employee name field
#
#  @salary
#  Scenario: Validate if employee salary field is listed
#    Given My application is up and running
#    When I request for list of employees
#    Then I should get a 200 response
#    And The response should include employee salary field