package API;

import Pojo.Posts;
import Pojo.Reqres;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class api {
    @Before
    public void setup() {
        baseURI = "http://www.example.dev.cc";
        basePath = "/wp-json/wp/v2";


    }

    @Test
    public void test16() {
//        Reqres obj = new Reqres("morpheus2", "leader2");
//       RequestSpecification requestSpecification= given().relaxedHTTPSValidation().auth().preemptive()
//               .basic("asiyat","asiyat");
//       Response response=requestSpecification.body(obj)
//                .post("https://reqres.in/api/users");
//        response.then().statusCode(201);
    }
    @Test
    public void test17() {
        Posts obj = new Posts("My Post", "Asiyat",
                "publish");


        RequestSpecification requestSpecification = given().relaxedHTTPSValidation().auth().preemptive()
                .basic("asiyat", "asiyat")
                .contentType(ContentType.JSON);

        Response response = requestSpecification.when().body(obj).post("/posts");

                 response.then().statusCode(201).body("status",equalTo(obj.getStatus()));

    }

    @Test
    public void test18() {
        Posts newPost = new Posts("Cool title", "cool content",
                "draft");


        RequestSpecification request = given().relaxedHTTPSValidation().auth().preemptive()
                .basic("asiyat", "asiyat")
                .contentType(ContentType.JSON);

        Response response = request.when().body(newPost).post("/posts");

        response.then().body("title.rendered", equalTo(newPost.getTitle()));
        response.then().body("status",equalTo(newPost.getStatus()));
        response.then().body("content.rendered",equalTo(newPost.getContent()));


    }
    }
