package StepDefs;

import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class ultsStep {
    WebDriver driver= Driver.getDriver();

    @Given("^user is on ulta web page$")
    public void user_is_on_ulta_web_page() throws Throwable {
        driver.get("https://www.ulta.com/");

    }

    @When("^user searches for \"([^\"]*)\"$")
    public void user_searches_for(String arg1) throws Throwable {
        driver.findElement(By.id("searchInput")).sendKeys("Mascara"+ Keys.ENTER);

    }

    @Then("^verify that \"([^\"]*)\" is displayed in search message$")
    public void verify_that_is_displayed_in_search_message(String arg1) throws Throwable {
        String expected="Mascara";
        String actual=driver.findElement(By.xpath("//h1[@class='breadcrumb-heading']")).getText();
       Assert.assertEquals(expected, actual);


    }

}
