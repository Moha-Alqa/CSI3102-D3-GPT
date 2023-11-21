Feature: Admit Patient from Request List

  Scenario: Charge Nurse admits a patient from the request list
    Given the Charge Nurse is logged in
    And the patient is in the request list
    And charge nurse approves the request
    When application command AdmitPatientFromRequestList is invoked
    Then the patients in request list is admitted

  Scenario: Charge Nurse denies a patient from the request list as patient can not be admitted
    Given the Charge Nurse is logged in
    And the patient is in the request list
    And Patient can not be admitted
    And charge nurse denies patient admission
    When application command denyPatientAdmission is invoked
    Then the patient in request list is not admitted
    And HMS sends notification to Charge Nurse who requested admission
