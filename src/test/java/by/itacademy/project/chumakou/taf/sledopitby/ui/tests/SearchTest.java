package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.driver.Driver;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.Steps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class SearchTest {

    WebDriver driver = Driver.getDriver();
    Steps step;

    public static HomePage homePage;
    public static LoginPage loginPage;

    @BeforeEach
    public void warmUp() {
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        step = new Steps(driver, homePage, loginPage);
    }

    @Test
    @DisplayName("Search product")
    public void findProductViaSearchBar() {
        String product = homePage.searchProductResult();
        Assertions.assertTrue(product.contains(HomePage.PRODUCT_FOR_SEARCH.toLowerCase()));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
