Feature: Discharge Patient

  Scenario: Charge Nurse discharges a patient
    Given the Charge Nurse is logged in
    And the Charge Nurse consults the patients file using use case Consult File
    And Charge Nurse selects to discharge Patient
    When the application command DischargePatient is invoked
    Then the patient should be discharged 
    And the bed should be made available 
    And the patient discharge information issued and copies slated to be sent to patient external doctor
