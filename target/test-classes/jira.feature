Feature: Jira validation by RestAssured

  Scenario Outline: Rise defect By using Post Method
    Given user need to add payload "<summary>","<description>"
    When User need to pass post method
    Then User used validate status code 201
    Then User should validate self data "sabasv"

    Examples: 
      | summary                           | description                                          |
      | Login Button not working Properly | User cant able to click login button due to grey out |

  Scenario Outline: Update defect By using put Method
    Given user to update payload "<summary>","<description>" and "<issueID>"
    When User need to pass http method
    Then User should validate update status code 204

    Examples: 
      | summary                          | description                                              | issueID |
      | Pop up is displaying while login | User cant able to login due to displaying of pop up menu | AM-69   |

  Scenario: Get all the issue in Jira by Using GET
    When user should add  http method for gettting all issues
    Then user should verify the Status code 200

  Scenario Outline: Delete defect By using Delete Method
    Given user need to add  "<issueId>"
    When User need to pass http method as delete
    Then User used validate delete status code 204 in jira

    Examples: 
      | issueID |
      | AM-69   |
