
Feature: Login to application with valid credentials

  @production
  Scenario: Login to https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
    Given User launch to to chrpme browser
    When User Open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
    And User enter valid username "admin@yourstore.com" and password "admin"
    When User click on Login 
    Then  User able to login successfully and verify home page title "Dashboard / nopCommerce administration"
    Then Close the browser
    
    
   