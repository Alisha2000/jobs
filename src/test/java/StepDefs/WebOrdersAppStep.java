package StepDefs;

import Pages.WebOrdersHomePage;
import Pages.WebOrdersLoginPage;
import Pages.OrderPage;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class WebOrdersAppStep {
    WebDriver driver= Driver.getDriver();
    WebOrdersLoginPage webOrdersPage=new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage=new WebOrdersHomePage();
    OrderPage orderPage=new OrderPage();

    @Given("^User logs in with credential username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_credential_username_password(String username, String password) throws Throwable {
        driver.get(Configuration.getProperty("WebOrdersUrl"));
        webOrdersPage.username.sendKeys(username);
        webOrdersPage.password.sendKeys(password);
        webOrdersPage.loginButton.click();
    }

    @Then("^User click on Order$")
    public void user_click_on_Order() throws Throwable {
        webOrdersHomePage.OrdersButton.click();
        Thread.sleep(3000);
    }

    @Then("^User create orders$")
    public void user_create_orders(DataTable dataTable) throws Throwable {
        List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class,Object.class);

        int numberOfLists= listOfMaps.size();
        int numberOfMaps= listOfMaps.get(0).size();
        System.out.println("Number of Lists: "+numberOfLists);
        System.out.println("Number of Maps: "+numberOfMaps);

        for(int i=0; i<listOfMaps.size();i++){
            orderPage.quantity.clear();
            orderPage.quantity.sendKeys(listOfMaps.get(i).get("Quantity").toString());
            orderPage.customerName.sendKeys(listOfMaps.get(i).get("Customer name").toString());
            orderPage.street.sendKeys(listOfMaps.get(i).get("Street").toString());
            orderPage.city.sendKeys(listOfMaps.get(i).get("City").toString());
            orderPage.zip.sendKeys(listOfMaps.get(i).get("Zip").toString());
            orderPage.cardType.click();
            orderPage.cardNr.sendKeys(listOfMaps.get(i).get("Card Nr").toString());
            orderPage.expireDate.sendKeys(listOfMaps.get(i).get("Expire Date").toString());
            orderPage.processButton.click();
        }

    }

    @Then("^User click on View Orders$")
    public void user_click_on_View_Orders() throws Throwable {
        orderPage.viewOrders.click();
        Thread.sleep(5000);
    }

    public void user_verifies_that_orders_are_created(DataTable dataTable) throws Throwable {
        List<Map<String, Object>> listOfMaps=dataTable.asMaps(String.class,Object.class) ;

        int numberOfLists=listOfMaps.size();
        int numberOfMaps=listOfMaps.get(0).size();

        System.out.println(numberOfLists);
        System.out.println(numberOfMaps);

        int createdCustomerNamesCount=0;
        for(int i=0; i<listOfMaps.size();i++){
            String customerName=listOfMaps.get(i).get("Customer name").toString();

            for(int i2=0; i2< webOrdersHomePage.customerNames.size(); i2++){
                if(webOrdersHomePage.customerNames.get(i2).getText().equals(customerName)){
                    createdCustomerNamesCount++;
                }
            }

        }
        Assert.assertEquals(3,createdCustomerNamesCount);
    }

    @Then("^Verify user logs in to Web Order homepage$")
    public void verify_user_logs_in_to_Web_Order_homepage() throws Throwable {
        String actualTitle=driver.getTitle();
        String expectedTitle="Web Orders";
        Assert.assertEquals("The "+expectedTitle+" didn't match with "+actualTitle, expectedTitle, actualTitle);
        Thread.sleep(5000);
    }

    @Then("^Verify user get error message \"([^\"]*)\"$")
    public void verify_user_get_error_message(String expectedMessage) throws Throwable {
        String actualMessage = webOrdersPage.errorMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        Thread.sleep(5000);
    }






}
