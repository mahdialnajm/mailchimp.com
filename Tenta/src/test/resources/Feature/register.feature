Feature: Register
 I want to test the  Mailchimp website
 
  Scenario Outline: I want to register on the Mailchimp
    Given I go to the Mailchimp website
    And I want to write a "<email>" 
    And I want also to write a "<username>"
    And I finaly want to write a "<password>"
    When I click on sign up button
    Then I verify "<result>"

    Examples: 
      | email     | username     | password | result |
      |mahdialnajm|name|M85sal?|registed|
      |mahdialnajm|longname|M85sal5?|char100|
      |mahdialnajm|busyname|Maleh55?|trayagain|
      |?|name|Mu7!yt|missingemail|
      

  			