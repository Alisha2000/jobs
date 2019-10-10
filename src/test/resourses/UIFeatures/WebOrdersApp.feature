@ui @WebOrders
  Feature: Testing WebOrders Application



    @orders1
    Scenario: Verifying create order module
      Given User logs in with credential username "Tester" password "test"


      Then User click on Order
      Then User create orders
        | Quantity | Customer name | Street | City        | Zip   | Card | Card Nr   | Expire Date |
        | 1        | James         | York   | Chicago     | 60001 | Viza | 123456789 | 01/22       |
        | 1        | Chris         | Devon  | Des Plaines | 80001 | Viza | 87654321  | 03/24       |
        | 2        | Sarah         | Clark  | New York    | 63452 | Viza | 42244241  | 09/22       |
      Then User click on View Orders
      And User verifies that orders are created
      |Customer name|
      |James        |
      |Chris        |
      |Sarah        |

      @orders2
      Scenario: Verifying log in functionality with valid credentials
        Given User logs in with credential username "Tester" password "test"
        Then Verify user logs in to Web Order homepage
       @orders3
        Scenario: Verifying log in functionality with Invalid credentials
          Given User logs in with credential username "Tester" password "testt"
          Then verify user get error message "Invalid Ligin or Password."