
Feature: Login to the omayo application
    @login
    Scenario Outline: User should only be able to login with valid credentials
        Given I navigate to omayo website
        When I enter correct username as <someusername> and password as <somepassword>
        And I click on login button
        Then User should be able to logged in based on <expected> login status
        Examples:
            | someusername   | somepassword | expected |
            | arun           | pswd1        | failure  |
            | SeleniumByArun | Test143$     | success  |
            | motoori        | pswd2        | failure  |

