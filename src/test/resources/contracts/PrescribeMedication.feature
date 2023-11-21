Feature: Prescribe Medication

  Scenario: Doctor prescribes medication to a patient successfully 
    Given the doctor is logged in
    And patient file is consulted using use case Consult File
    And doctor enters required information upon request
    When the application command perscribeMedication is invoked
    Then the prescription is added to the patient's file

Scenario: Doctor attempts to prescribe medication to a patient but HMS notifies Doctor that Patient is not hers
    Given the doctor is logged in
    And patient file is consulted using use case Consult File
    And the Selected Patient is not one of the Doctor's
    When the application command perscribeMedication is invoked
    Then HMS notifies Doctor that Patient is not hers

  Scenario: Doctor attempts to prescribe medication to a patient but incorrect information entered
    Given the doctor is logged in
    And patient file is consulted using use case Consult File
    And doctor enters incorrect required information upon request
    When the application command perscribeMedication is invoked
    Then HMS display incorrect prescription error message
