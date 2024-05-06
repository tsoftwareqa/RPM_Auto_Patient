Feature: Manage case and patient data

@SmokeTest
  Scenario: Validate Vitals Data
    Given Clinician is on Home page of application and login
    When Clinician continue with case
    Then Verify Vitals Data
    
@SmokeTest
  Scenario: Validate chart recent history
    Given Clinician is on Home page of application and login
    When Clinician continue with case
    Then Verify Chart Data
    
@SmokeTest1
  Scenario: Validate complete documentation
    Given Clinician is on Home page of application and login
    When Clinician continue with case
    Then Verify complete documentation