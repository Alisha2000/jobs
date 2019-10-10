Feature: JDBC verification
  @uidb
  Scenario: Post in UI and Verify in DB
    Given User logged in the website
    And user authorized to make DB calles
    When user adds new post
    Then User queries the post from DB

    @apidb
    Scenario: Post in API and Verify in DB
      Given User authorized to make API calls
      When User sends post request
      Then status code is 201
      And User queries the post from DB



      Scenario: Post in DB and Verify in DB
        Given User authorized

        Scenario: Post in DB and Verify in UI

          Scenario: Post in UI and Verify in UI
