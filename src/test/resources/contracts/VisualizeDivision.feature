Feature: Visualize division

    Scenario: Charge Nurse chooses to visualize division and enters division identifier or alternatively browses to select division
        Given the Charge Nurse is logged in
        And the Charge Nurse chooses to visualize division
        And Charge Nurse enters division identifier upon request or alternatively browses to select division
        When the application command visualizeDivision is invoked
        Then HMS is displaying information about a division

    Scenario: Charge Nurse chooses to visualize division and enters an incorrect division identifier
        Given the Charge Nurse is logged in
        And the Charge Nurse chooses to visualize division
        And Charge Nurse enters wrong division identifier upon request 
        When the application command visualizeDivision is invoked
        Then the HMS displays division not found error message
