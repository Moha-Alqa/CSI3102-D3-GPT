Feature: Register patient

    Scenario: Medical Staff Member request for new Patient registration and Medical Staff Member enters requested information
        Given The Medical Staff Member is logged in
        And Medical Staff Member enters requested information
        When the application command registerPatient is invoked
        Then HMS issues a new identification number for Patient
        And new patient is registered

    Scenario: Medical Staff Member request for new Patient registration and information is incomplete
        Given The Medical Staff Member is logged in
        And the information is incomplete
        When the application command registerPatient is invoked
        Then HMS displays incomplete information error message
        And patient is not registered
