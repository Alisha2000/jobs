package API;

import Pojo.Posts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeserAdvanced {
    @Before
    public void setup() {
        baseURI = "http://www.example.dev.cc";
        basePath = "/wp-json/wp/v2";

    }

    @Test
    public void test1() throws IOException {
        RequestSpecification requestSpecification = given().relaxedHTTPSValidation().auth().
                preemptive().basic("asiyat",
                "asiyat").contentType(ContentType.JSON);
        Response response = requestSpecification.when().get("/posts/59");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> listOfMaps = objectMapper.readValue(response.asByteArray(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(listOfMaps.get("title"));


    }//0 1 1 2 3 5 8

    @Test
    public void test2() throws IOException {
        RequestSpecification requestSpecification = given().relaxedHTTPSValidation().auth().
                preemptive().basic("asiyat",
                "asiyat").contentType(ContentType.JSON);
        Response response = requestSpecification.when().get("/posts/35");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> listOfMaps = objectMapper.readValue(response.asByteArray(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(listOfMaps.get("title"));
        System.out.println(listOfMaps.get("content"));

        Assert.assertEquals(35, listOfMaps.get("id"));
    }

    @Test
    public void test3() throws IOException {
        Posts obj = new Posts("new harder way", "harder content", "publish");

        RequestSpecification request = given().relaxedHTTPSValidation().auth().
                preemptive().basic("asiyat",
                "asiyat").contentType(ContentType.JSON);

        Response response = request.when().body(obj).post("/posts");


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> listOfMaps = objectMapper.readValue(response.asByteArray(),
                new TypeReference<Map<String, Object>>() {
                });
        Assert.assertEquals(obj.getTitle(), ((Map<String, String>) listOfMaps.get("title"))
                .get("rendered"));
        System.out.println(((Map<String, String>) listOfMaps.get("title")).get("rendered"));
    }

    @Test
    public void test4() throws IOException {
        Posts obj = new Posts("new title again", "new content again", "draft");
        RequestSpecification request = given().relaxedHTTPSValidation().auth().
                preemptive().basic("asiyat",
                "asiyat").contentType(ContentType.JSON);

        Response response = request.when().body(obj).post("/posts");


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> listOfMaps = objectMapper.readValue(response.asByteArray(),
                new TypeReference<Map<String, Object>>(){});
        //System.out.println(listOfMaps.get("title"));
        Assert.assertEquals(obj.getTitle(),((Map<String, String>) listOfMaps.get("title"))
                .get("rendered"));


    }
    @Test
    public void test5() throws IOException {
        Posts obj = new Posts("new title again", "new content again", "publish");
        RequestSpecification request = given().relaxedHTTPSValidation().auth().
                preemptive().basic("asiyat",
                "asiyat").contentType(ContentType.JSON);

        Response response = request.when().body(obj).post("/posts/68");


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> listOfMaps = objectMapper.readValue(response.asByteArray(),
                new TypeReference<Map<String, Object>>(){});
        //System.out.println(listOfMaps.get("title"));
        Assert.assertEquals(obj.getTitle(),((Map<String, String>) listOfMaps.get("title"))
                .get("rendered"));
        Assert.assertEquals(obj.getStatus(),listOfMaps.get("status"));


    }
}
