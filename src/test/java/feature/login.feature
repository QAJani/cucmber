Feature: Login to the TutorialsNinja application

    This feature file contains all the scenarios related to login functionality of the application.

    Scenario: Login to the application using valid credentials
        Provide valid username and valid password into the email address and password fields to login
        Given User navigates to login page of the application
        When User enters Username "arun@qafox.com" and Password "SeleniumTester$" into the fields
        And Clicks on Login button
        Then User should successfully login