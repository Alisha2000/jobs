

Feature: Etsy page
  @login
  Scenario Outline: Verify login functionality
    Given User is on Etsy homepage
    When User enters username "<username>"
    And  User enters password "<password>"
    Then Verify user successfully logs in

    Examples:

      | username        | password |
      | amely1988@bk.ru | cyplenok |
      | aska            | 1988     |
      | amina           | adzhieva |

