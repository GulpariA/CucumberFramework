Feature: Demo QA Scenarios
              I want to practice different scenarios on Demo QA

@DemoQADatePicker
  Scenario: I should be abke t select a date from date picker
    Given I am on the date picker page "https://demoqa.com/date-picker"
    When I enter "12/01/2006" to date picker
    Then Date entered should be selected
