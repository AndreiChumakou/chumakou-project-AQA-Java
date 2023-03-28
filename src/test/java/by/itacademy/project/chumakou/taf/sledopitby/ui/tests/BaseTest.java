package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.driver.Driver;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.Steps;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getDriver();
    public static HomePage homePage;
    public static LoginPage loginPage;
    Steps step;

    @BeforeEach
    public void warmUp() {
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        step = new Steps(driver, homePage, loginPage);
    }

    @Test()
    @DisplayName("Open home page")
    @Tag("smoke")
    public void testSledopitByOpen() {
        Assertions.assertEquals(HomePage.TITLE_MAIN_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Storing products in a cart")
    @Tag("Smoke")
    public void saveProductInCartWhenLogout() {
        Assertions.assertTrue(step.saveProductInCartWhenLogout());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
