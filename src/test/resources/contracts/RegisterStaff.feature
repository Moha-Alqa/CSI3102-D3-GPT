Feature: Register staff

    Scenario: New staff member selects to register and all the information provided required is valid
        Given HMS is on
        And new staff member selects to register 
        And staff member provides all the information required
        When the application command registerStaff is invoked
        Then staff member is registered
        And HMS displays an acknowledgment message

    Scenario: New staff member selects to register and incomplete information is provided
        Given the HMS is on
        And new staff member selects to register 
        And staff member provides incomplete information
        When the application command registerStaff is invoked
        Then HMS displays an incomplete information error message 
        And staff member is not registered

    Scenario: New staff member selects to register and user not found in the system
        Given the HMS is on
        And new staff member selects to register 
        And user not found in the system
        When the application command registerStaff is invoked
        Then HMS displays an invalid user error message
        And staff member is not registered
