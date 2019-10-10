package API;

import Pojo.projectPost;
import Utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class project {
    @Before
    public void setup() {
        baseURI = "http://www.example.dev.cc";
        basePath = "/wp-json/wp/v2";
    }
    @Test
    public void test1(){
        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .queryParam("limit", 5)
                .get("/users")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void test2(){
        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat","asiyat")
                .queryParam("order", "desc")
                .get("/users")
                .then().log().all()
                .statusCode(200);
    }





    @Test
    public void test3() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"username\": \"Alf\",\n" +
                        "\t\"email\":\"alf@gmail.com\",\n" +
                        "\t\"password\":\"frogs\"\n" +
                        "}")
                .post("/users")
                .then().log().all()
                .statusCode(201).statusCode(HttpStatus.SC_CREATED);
    }
    @Test
    public void test4(){
        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat","asiyat")
                .pathParam("id",7)
                .get("/users/{id}")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void test5() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .get("/users")
                .then().log().all()
                .statusCode(200).statusCode(HttpStatus.SC_OK);

    }
    @Test
    public void test6() throws InterruptedException {

        Driver.getDriver().get("http://www.example.dev.cc/login");
        Driver.getDriver().findElement(By.id("user_login")).sendKeys("asiyat");
        Driver.getDriver().findElement(By.id("user_pass")).sendKeys("asiyat");
        Driver.getDriver().findElement(By.id("wp-submit")).click();
        WebElement user1=Driver.getDriver().findElement(By.xpath("(//div[@class='wp-menu-name'])[8]"));
        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(user1).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.linkText("All Users")).click();
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 7)
                .get("/users/{id}");
        int ex=response.jsonPath().getInt("id");
        String expected = response.jsonPath().getString("name");
        System.out.println("Name is equals to " + expected);
        String actual=Driver.getDriver().findElement(By.xpath("(//td[@class='username column-username has-row-a" +
                "ctions " +
                "column-primary'])[1]")).getText();
        Assert.assertEquals(expected, actual);
        Driver.getDriver().close();
    }
    @Test
    public void test7() throws InterruptedException {
        Driver.getDriver().get("http://www.example.dev.cc/login");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("user_login")).sendKeys("asiyat");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("user_pass")).sendKeys("asiyat");
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("wp-submit")).click();
        WebElement user2=Driver.getDriver().findElement(By.xpath("//a[@class='wp-has-submenu " +
                "wp-not-current-submenu menu-top menu-icon-users']"));
         Thread.sleep(1000);
        Actions action=new Actions(Driver.getDriver());

        action.moveToElement(user2).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.linkText("All Users")).click();
        Response response=given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .get("/users");
        List<String>expected=response.jsonPath().getList("name", String.class);
        List<WebElement> list=Driver.getDriver().findElements(By.xpath("//td[@class='username column-username has-" +
                "row-actions column-primary']"));
        List<String>actual=new ArrayList<String>();
        for(WebElement element: list){
            actual.add(element.getText());
        }
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test8(){
        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat","asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"email\":\"emailUpdateFromRestAssured@gmail.com\",\n" +
                        "\t\"password\":\"new password\"\n" +
                        "}").pathParam("id",7)
                .put("/users/{id}")
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void test9() throws InterruptedException {
        Driver.getDriver().get("http://www.example.dev.cc/login");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("user_login")).sendKeys("asiyat");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("user_pass")).sendKeys("asiyat");
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("wp-submit")).click();
        WebElement user2=Driver.getDriver().findElement(By.xpath("//a[@class='wp-has-submenu " +
                "wp-not-current-submenu menu-top menu-icon-users']"));
        Thread.sleep(1000);
        Actions action=new Actions(Driver.getDriver());

        action.moveToElement(user2).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.linkText("All Users")).click();
       String actual= Driver.getDriver().findElement(By.linkText("Alia"))
               .getText();

        Response response=given().relaxedHTTPSValidation().auth().preemptive().
                basic("asiyat","asiyat")
                .pathParam("id",5)
                .get("/users/{id}");
        String expected=response.jsonPath().getString("name");
        Assert.assertEquals(expected,actual);
        Driver.getDriver().close();
    }
    @Test
    public void test10(){
        projectPost obj=new projectPost("alf", "newemail@gmail.com");


        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body(obj)
                .pathParam("id",7)
                .put("/users/{id}")
                .then().log().all()
                .statusCode(200);
    }

}
