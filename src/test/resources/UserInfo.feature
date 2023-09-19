Feature: User Information Retrieval

  Scenario Outline: Retrieve user information
    Given a session is established with username "<username>" and password "<password>"
    When a user requests their information
    Then the user information should be retrieved successfully with message "SUCCESS"
    Examples:
      | username  | password  |
      | giorgi    | zho       |
      | temuri    | demur     |

  Scenario: Retrieve user information when the session is not valid
    Given an invalid session is established
    When a user requests their information
    Then the user information request should fail

