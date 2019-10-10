package API;

import Pojo.Posts;
import Pojo.Reqres;
import Utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class restAssuredPractice {

    @Before
    public void setup() {
        baseURI = "http://www.example.dev.cc";
        basePath = "/wp-json/wp/v2";


    }

    @Test
    public void test1() {
        when().
                get("https://reqres.in/api/users/2").
                then().log().all().
                statusCode(200);

    }

    @Test
    public void test2() {
        when().
                get("https://reqres.in/api/users/100").
                then().log().all().
                statusCode(404);

    }

    @Test
    public void test3() {
        given().relaxedHTTPSValidation().
                get("/posts").
                then().log().all().
                statusCode(200).statusCode(HttpStatus.SC_OK)
                .body("[0].id", equalTo(18)).body("[0].title.rendered", equalTo(
                "NEW POST FROM Rest"));

    }

    //create new test
    //send the request to get the responce id equals 16
    //validate status code=200
    //validate status=publish
    //validate sticky=false

    @Test
    public void test4() {
        given().relaxedHTTPSValidation()

                .get("http://www.example.dev.cc/wp-json/wp/v2/posts/10").
                then().log().all().
                statusCode(200)
                .body("status", equalTo("publish")).body("sticky", equalTo(false))
                .body("type", equalTo("post"));


    }

    @Test
    public void test5() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"NEW POST FROM REST ASSURED\",\n" +
                        "\"content\": \"This is the post created by api\",\n" +
                        "\"status\": \"publish\"\n" +
                        "}")
                .post("/posts")
                .then().log().all()
                .statusCode(201).body("status", equalTo("publish"))
                .body("title.raw", equalTo("NEW POST FROM REST ASSURED"));
    }

    @Test
    public void test6() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\": \"Update Post from Rest Assured\"\n" +
                        "}").pathParam("id", 35)
                .put("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("title.raw", equalToIgnoringCase("Update Post from Rest Assured"));
    }

    @Test
    public void test50() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\": \"Asiyat\",\n" +

                        "}")
                .post("/posts")
                .then().log().all()
                .statusCode(201)
                .body("title.raw", equalToIgnoringCase("Asiyat"));
    }

    @Test
    public void test51() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 39)
                .queryParam("force", true)
                .delete("/posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("deleted", is(true));
    }

    @Test
    public void test8() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"REST_Assured LIBRARY\",\n" +
                        "\"content\": \"This is the post created by api\",\n" +
                        "\"status\": \"publish\"\n" +
                        "}")
                .post("http://www.example.dev.cc/wp-json/wp/v2/posts")
                .then().log().all()
                .statusCode(201).body("status", equalTo("publish"))
                .body("title.raw", equalTo("REST_Assured LIBRARY"));
    }

    @Test
    public void test9() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"title\":\"Update PRACTICE REST\"\n" +
                        "}g" +
                        "").pathParam("id", 25)
                .put("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("title.raw", equalToIgnoringCase("Update PRACTICE REST"));

    }

    //To be able to delete the post we need ID of the post
    @Test
    public void test10() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 27)
                .queryParam("force", true)
                .delete("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}")
                .then()
                .statusCode(200)
                .body("deleted", is(true));


    }

    @Test
    public void test11() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 25)
                .queryParam("force", true)
                .delete("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}")
                .then().log().all()
                .statusCode(200)
                .body("deleted", is(true));
    }

    @Test
    public void test13() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 29)
                .get("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}");

        int id = response.jsonPath().getInt("id");
        System.out.println("id is equals to " + id);
        String expected = response.jsonPath().getString("title.rendered");
        System.out.println("Title is equals to " + expected);
        Driver.getDriver().get("http://www.example.dev.cc");
        Driver.getDriver().manage().window().maximize();
        String actual = Driver.getDriver().findElement(By.linkText("NEW POST FROM REST ASSURED")).getText();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test100() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 35)
                .get("/posts/{id}");
        String expected = response.jsonPath().getString("content.rendered").replace("<p>", "")
                .replace("</p>", "").trim();

        Driver.getDriver().get("http://www.example.dev.cc");
        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='entry-content'])[1]")).getText();
        Assert.assertEquals(expected, actual);

    }

    //    @Test
//    public void test14(){
//        Response response=given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat","asiyat")
//                .pathParam("id",29)
//                .get("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}");
//        String expected=response.jsonPath().getString("content.rendered").replace("<p>", "")
//                .replace("</p>", "").trim();
//        System.out.println(expected);
//        Driver.getDriver().get("http://www.example.dev.cc");
//        Driver.getDriver().manage().window().maximize();
//        String actual=Driver.getDriver().findElement(By.xpath("(//div[@class='entry-content'])[1]")).getText();
//        Assert.assertEquals(expected,actual);
//
//
//    }

    @Test
    public void test15() {
        Response response = given().relaxedHTTPSValidation()
                .auth().preemptive().basic("asiyat", "asiyat")
                .get("/posts");
        System.out.println(response.jsonPath().getList("title.rendered"));
        List<String> expectedPosts = response.jsonPath().getList("title.rendered", String.class);
        //expectedPosts.remove(expectedPosts.size()-1);
        System.out.println("This is the response from List of String " + expectedPosts);
        Driver.getDriver().get("http://www.example.dev.cc/");
        List<WebElement> titles = Driver.getDriver().findElements(By.xpath("//h2[@class='entry-title']"));
        List<String> actualPosts = new ArrayList<String>();

        for (WebElement element : titles) {
            actualPosts.add(element.getText());

        }
        System.out.println("This is the posts from UI" + actualPosts);
        Assert.assertEquals(expectedPosts, actualPosts);
    }

    @Test
    public void test16() {
        Reqres obj = new Reqres("morpheus", "leader");
        given()
                .body(obj)
                .post("https://reqres.in/api/users")
                .then().statusCode(201);
    }

    @Test
    public void test17() {
        Posts obj = new Posts("POJO CLASS OBJECT", "This is post request  using pojo classes",
                "publish");
        obj.setTitle("Limbok dependency");

        System.out.println(obj);
        given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .contentType(ContentType.JSON)
                .body(obj).post("/posts").then().statusCode(201).statusCode(HttpStatus.SC_CREATED)
                .body("status", equalTo("publish"));

    }

    @Test
    public void test18() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .get("/posts/24");
        JsonPath jsonPath = response.jsonPath();
        Map<String, String> links = jsonPath.getMap("_links.self[0]", String.class, String.class);
        System.out.println(links.keySet());
        System.out.println(links.values());
    }

    @Test
    public void test54() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")

                .pathParam("id", 35)
                .get("/posts/{id}");
        int id = response.jsonPath().getInt("id");
        System.out.println("id equals to " + id);
        String title = response.jsonPath().getString("title.rendered");
        System.out.println("title " + title);
    }


}