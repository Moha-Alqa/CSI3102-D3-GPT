Feature: Request Patient Admission

  Scenario: Charge Nurse requests patient admission to a division
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    When the Charge Nurse chooses to request patient admission
    And provides division and patient information
    Then the application command requestPatientAdmission is invoked
    And the patient is added to the request list for the specified division
    And a notification is sent to the requested ward's Charge Nurse

  Scenario: Charge Nurse provides incorrect information for patient admission
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    When the Charge Nurse chooses to request patient admission
    And provides incorrect division or patient information
    Then the application command requestPatientAdmission is invoked
    And an error message about incorrect information is displayed
    And the patient is not added to any request list

  Scenario: Charge Nurse requests admission for a patient already admitted
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    When the Charge Nurse chooses to request patient admission
    And the patient is already admitted to a service
    Then the application command requestPatientAdmission is invoked
    And an error message about the patient already being admitted is displayed
