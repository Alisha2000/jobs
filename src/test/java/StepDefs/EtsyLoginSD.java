package StepDefs;

import Pages.EtsyLoginPages;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class EtsyLoginSD {
    WebDriver driver=new ChromeDriver();
    EtsyLoginPages pages=new EtsyLoginPages();
    @When("^User enters username \"([^\"]*)\"$")
    public void user_enters_username(String username) throws Throwable {
        pages.signIn.click();
        pages.emailBox.sendKeys(username);
    }
    @When("^User enters password \"([^\"]*)\"$")
    public void user_enters_password(String password) throws Throwable {
        pages.passwordBox.sendKeys(password + Keys.ENTER);
    }
    @Then("^Verify user successfully logs in$")
    public void verify_user_successfully_logs_in() throws Throwable {

        String expected="https://www.etsy.com/";
        Thread.sleep(3000);
        String actual= Driver.getDriver().getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(expected,actual);

    }




}
