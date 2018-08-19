#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Facebook
Feature: Test face book
  I want to use this template for my feature file

  @FailedLogin
  Scenario: Title of your scenario outline
    Given Open Facebook login page
    When I enter username as "wrongUser"
    When I enter password as "wrongPassword"
    Then Login should fail
    Then Relogin option should be available
    
  @SuccuessLogin
  Scenario: Title of your scenario outline
    Given Open Facebook login page
    When I enter username as "test@gmail.com"
    When I enter password as "test"
    Then Login should pass
    
  @Post 
  Scenario: Title of your scenario outline
    Given Open Facebook login page
    When I enter username as "test@gmail.com"
    When I enter password as "test"
    Then Login should pass
    Then Post a status message: "Hello friends chai pi lo"
    

