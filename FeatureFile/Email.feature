Feature: Test the Compose Email  and send an email

  Scenario: Compose and send an email with subject and body

    Given user logged in to my Gmail account
    When user click on the "Compose" button
    And user fill in the recipient's email address as "abc@gmail.com"
    And user fill in the subject as "Incubate"
    And user fill in the body as "Automation QA test for Incubate"
    And user click on the "Send" button
    Then the email should be sent successfully
    And user should see a confirmation message that the email has been sent
