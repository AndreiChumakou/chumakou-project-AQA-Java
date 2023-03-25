package by.itacademy.project.chumakou.taf.sledopitby.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

public class ApiTest {

    @Test
    public void testGetHTML() {
        String URL = "https://www.sledopit.by";

        Response response = RestAssured.given().when().get(URL).then().contentType(ContentType.HTML).extract().response();
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        System.out.println(htmlPath.getString("html.head.title"));

        System.out.println("-----------");

        Response response1 = when().get(URL).then().extract().response();
        String bodyTxt = response1.htmlPath().getString("body");
        System.out.println(bodyTxt);



    }
}
