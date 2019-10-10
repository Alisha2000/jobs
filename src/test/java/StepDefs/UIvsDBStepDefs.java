package StepDefs;

import Pages.postsLoginPage;
import Pages.postsPage;
import Pojo.NewPosts;
import Pojo.Posts;
import Utilities.Driver;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimeZone;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class UIvsDBStepDefs {
    WebDriver driver=Driver.getDriver();
    Connection connection;
    Statement statement;
    ResultSet set;
    RequestSpecification requestSpecification;
  // Static response;

    @Given("^User logged in the website$")
    public void user_logged_in_the_website() throws Throwable {

        driver.get("http://www.example.dev.cc/login");
        Thread.sleep(2000);
        driver.findElement(By.id("user_login")).sendKeys("asiyat");
        Thread.sleep(2000);
        driver.findElement(By.id("user_pass")).sendKeys("asiyat"+ Keys.ENTER);
        Thread.sleep(2000);
        //driver.findElement(By.id("wp-submit")).click();

    }

    @Given("^user authorized to make DB calles$")
    public void user_authorized_to_make_DB_calles() throws Throwable {
       connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exampleDBciw1z?serverTimezone="+ TimeZone.getDefault().getID(),
                "exampleDBciw1z","E8dSMPMrp");
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);


    }

    @When("^user adds new post$")
    public void user_adds_new_post() throws Throwable {
        driver.findElement(By.xpath("(//div[@class='wp-menu-name'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder='Add title']"))
                .sendKeys("My cool text via UI");
        Thread.sleep(2000);
        driver.findElement((By.xpath("//button[@class='components-button editor-post-publish-panel__" +
                "toggle is-button is-primary']"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Publish']")).click();

    }

    @Then("^User queries the post from DB$")



    public void user_queries_the_post_from_DB() throws Throwable {
        set=statement.executeQuery("select post_title from wp_posts where post_title='My cool text via UI'");
        int count=0;
        while (set.next()){
            if(set.getString("post_title").equals("My cool text via UI")){
                count++;
            }
        }
        Assert.assertTrue("Couldn't find any matching posts", count>0);
    }
    @Given("^User authorized to make API calls$")
    public void user_authorized_to_make_API_calls() throws Throwable {
      requestSpecification= given().relaxedHTTPSValidation().auth().preemptive()
               .basic("asiyat", "asiyat")
                .contentType(ContentType.JSON);
    }


//    @When("^User sends post request$")
//    public void user_sends_post_request() throws Throwable {
//        baseURI = "http://www.example.dev.cc";
//        basePath = "/wp-json/wp/v2";
//        Posts obj = new Posts("API and DB usage of post", "API vs DB post",
//                "publish");
//        response=requestSpecification
//
//        System.out.println(obj);
//
//                .body(obj).post("/posts").then().statusCode(201).statusCode(HttpStatus.SC_CREATED)
//                .body("status", equalTo("publish"));
//    }
    @Then("^status code is (\\d+)$")
    public void status_code_is(int arg1) throws Throwable {


    }

}
