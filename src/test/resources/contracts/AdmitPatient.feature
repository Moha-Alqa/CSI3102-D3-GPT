Feature: Admit Patient

  Scenario: charge nurse is logged in, division is incomplete
    Given charge nurse is logged in
    And division is incomplete
    And admission information is provided
    When the application command admitPatient is invoked
    Then patient is admitted to the charge nurse's division

  Scenario: charge nurse is logged in, division is complete
    Given charge nurse is logged in
    And division is complete
    And admission information is provided
    When the application command admitPatient is invoked
    Then charge nurse is notified their division is complete
    And gives charge nurse possibility to request patient admission