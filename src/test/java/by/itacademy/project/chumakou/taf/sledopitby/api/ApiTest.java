package by.itacademy.project.chumakou.taf.sledopitby.api;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

public class ApiTest {

    @Test
    public void testOpenHomePage() {
        String URL = "https://www.sledopit.by";
        RestAssured
                .given()
                .when()
                .get(URL)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testGetTitleHomePage() {
        String URL = "https://www.sledopit.by";
        Response response = RestAssured
                .given()
                .when()
                .get(URL)
                .then()
                .assertThat()
                .contentType(ContentType.HTML)
                .extract()
                .response();
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        Assertions.assertTrue(htmlPath.getString("html.head.title").equals(HomePage.TITLE_MAIN_PAGE));
    }
}

//        Response response1 = when().get(URL).then().extract().response();
//        String bodyTxt = response1.htmlPath().getString("body");
//        System.out.println(bodyTxt);
