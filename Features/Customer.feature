

Feature: Customer functionality

  @production
  Scenario: Adding a new customer
    Given User launch to to chrpme browser
    When User Open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
    And User enter valid username "admin@yourstore.com" and password "admin"
    When User click on Login 
    Then  User able to login successfully and verify home page title "Dashboard / nopCommerce administration"
    When User clicks on customer Menu
    And Click on customer Menu Item
    When Click on Add new customer
    Then User can see customer page
    When User enter customer informaton
    When User click on save button
    Then User can see confirmation message "The new customer ahs been added successfully"
    And Close Browser
    
    
 