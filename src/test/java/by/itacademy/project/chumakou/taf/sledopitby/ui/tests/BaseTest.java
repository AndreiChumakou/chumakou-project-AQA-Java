package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.driver.Driver;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest{

    public WebDriver driver = Driver.getDriver();
    public HomePage homePage = new HomePage(driver);
    public LoginPage loginPage = new LoginPage(driver);

    @BeforeEach
    public void warmUp() {
        driver.get(HomePage.URL);
    }

    @AfterEach
    public void tearDown(){
        Driver.close();
    }
}
