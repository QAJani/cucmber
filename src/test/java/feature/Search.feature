Feature: Searching of various categories should be possible along with product search
    #adding description will give a good idea to understand
    It is good to provide an option to our end users where they can search for the products
    based on their category, rather than only searching a product.This will increase our
    business and make end users happy.

    Background: Visiting the website as guest user
        Given I visit the website as a guest user
    @Smoke
    Scenario: Search for the products under Books category

        When I select the books option from the dropdown
        And I click on Search icon
        Then I should see the books page loaded
        And I should see Books at Amazon as heading
        But I should not see other category products
    @All
    Scenario: Search for the products under Baby category

        When I select the Baby option from the dropdown
        And I click on Search icon
        Then I should see the Baby page loaded
        And I should see The baby store as heading
        But I should not see other category products