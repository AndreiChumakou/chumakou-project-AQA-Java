package by.itacademy.project.chumakou.taf.sledopitby.api;

import by.itacademy.project.chumakou.taf.sledopitby.ui.data.UserData;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

public class ApiTest {

    @BeforeEach
    public void warmUp() {
        baseURI = HomePage.URL;
    }

    @Test
    @DisplayName("S5. Open Home page")
    public void testOpenHomePage() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("E5. Title of homepage")
    public void testGetTitleHomePage() {
        Response response = given()
                .when()
                .get()
                .then()
                .assertThat()
                .contentType(ContentType.HTML)
                .extract()
                .response();
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        Assertions.assertTrue(htmlPath.getString("html.head.title").equals(HomePage.TITLE_MAIN_PAGE));
    }

    @Test
    @DisplayName("S6. Login with correct credentials")
    public void loginAPI() {
        RestAssured
                .given()
                .contentType("multipart/form-data")
                .multiPart("email", UserData.EMAIL_VALID)
                .multiPart("password", UserData.PASSWORD_VALID)
                .when()
                .post("/login")
                .then()
                .statusCode(302);
    }
}
