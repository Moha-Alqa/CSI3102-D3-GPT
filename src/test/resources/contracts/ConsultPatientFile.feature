Feature: Consult Patient File

  Scenario: medical staff member is logged in, patient id exists in system
    Given medical staff member is logged in
    And patient id exists in system
    When staff consults patient file
    Then return patient file

  Scenario: medical staff member is logged in, patient id does not exist in system
    Given medical staff member is logged in
    And patient id does not exist in system
    When staff consults patient file
    Then patient not found error message