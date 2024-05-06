Feature: Manage login and logout session for clinician

@SmokeTest
  Scenario: Validate clinician login with valid credentials
    Given Clinician is on Home page of application and login
    When Clinician verify dashboard label
   
@SmokeTest
  Scenario: Validate clinician login with valid credentials and logout
    Given Clinician is on Home page of application and login
    When Clinician clicks on logout option
    Then Clinician should logout from application and navigate to login screen
    
@SmokeTest
  Scenario: Validate clinician login for invalid credentials
    Given Clinician is on Home page of application and login with invalid credentials
    When Clinician verify error validation message