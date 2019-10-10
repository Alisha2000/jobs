package StepDefs;

import Pages.EtsyHomePage;
import Pages.EtsyResultPage;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;




public class etsyStep {
    WebDriver driver= Driver.getDriver();
    EtsyHomePage etsyHomePage=new EtsyHomePage();
    EtsyResultPage etsyResultPage=new EtsyResultPage();

    @Given("^User is on Etsy homepage$")
    public void user_is_on_Etsy_homepage() throws Throwable {
        driver.get(Configuration.getProperty("etsyUrl"));
        Thread.sleep(5000);
    }

    @Then("^User verifies homepage title \"([^\"]*)\"$")
    public void user_verifies_homepage_title(String title) throws Throwable {
        Assert.assertEquals(title, driver.getTitle());
    }

    @When("^User click on \"([^\"]*)\"$")
    public void user_click_on(String section) throws Throwable {

        if(section.equalsIgnoreCase(etsyHomePage.jewelerySection.getText())){
            etsyHomePage.jewelerySection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.clothingSection.getText())){
            etsyHomePage.clothingSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.homeSection.getText())){
            etsyHomePage.homeSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.weddingSection.getText())){
            etsyHomePage.weddingSection.click();
        }else if(section.equalsIgnoreCase(etsyHomePage.toysSection.getText())){
            etsyHomePage.toysSection.click();
        }
    }

    @Then("^User verifies \"([^\"]*)\"$")
    public void user_verifies(String expectedTitle) throws Throwable {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
        etsyHomePage.searchBox.sendKeys(item+ Keys.ENTER);
    }

    @Then("^Verify that \"([^\"]*)\" is displayed in search message$")
    public void verify_that_is_displayed_in_search_message(String item) throws Throwable {
        String actualMessage = etsyResultPage.resultText.getText();
        Assert.assertEquals("The expected: "+item+" didn't match with actual: " +
                actualMessage,item, actualMessage);
    }

    @Then("^User selects over (\\d+) price range$")
    public void user_selects_over_price_range(int arg1) throws Throwable {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(etsyResultPage.over50Button));
        etsyResultPage.over50Button.click();
    }

    @Then("^User verifies that result prices are over (\\d+)$")
    public void user_verifies_that_result_prices_are_over(int expectedPrice) throws Throwable {

        for (WebElement price : etsyResultPage.listOfPrices) {
            if (!price.getText().equals("")) {
                double actualPrice = Double.parseDouble(price.getText());
                Assert.assertTrue(actualPrice >= expectedPrice);
            }
        }
    }

}
