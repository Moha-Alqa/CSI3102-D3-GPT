Feature: Update Patient File

  Scenario: medical staff member is logged in, medical staff member has privileges to modify patient file, patient id exists in system
    Given medical staff member is logged in
    And patient id exists in system
    And medical staff member has privileges to modify patient file
    When the application command updatePatientFile is invoked
    Then the patient's file is updated based on the new information given

  Scenario: medical staff member is logged in, medical staff member does not have privileges to modify patient file, patient id exists in system
    Given medical staff member is logged in
    And patient id exists in system
    And medical staff member does not have privileges to modify patient file
    When the application command updatePatientFile is invoked
    Then the patient's file is not updated
    And modification not allowed error message
