package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.driver.Driver;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.AccountEditPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.Steps;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    WebDriver driver = Driver.getDriver();
    Steps step;

    public static HomePage homePage;
    public static LoginPage loginPage;
    public static AccountEditPage accountEditPage;

    @BeforeEach
    public void warmUp() {
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountEditPage = new AccountEditPage(driver);
        step = new Steps(driver, homePage, loginPage);
    }

    @Test
    @DisplayName("Login. Valid credentials")
    @Tag("smoke")
    public void testLoginWithCorrectCredentials() {
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        Assertions.assertEquals(UserData.NAME_VALID, accountEditPage.getActualNameFromAccount());
    }

    @Test
    @DisplayName("Login. Invalid email")
    public void testLoginWithIncorrectEmail() {
        step.login(UserData.EMAIL_INVALIDE, UserData.PASSWORD_VALID, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Login. Invalid password")
    public void testLoginWithIncorrectPassword() {
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_INVALIDE, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Login. Empty email")
    public void testLoginWithEmptyEmail() {
        step.login("", UserData.PASSWORD_VALID, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Login. Empty password")
    public void testLoginWithEmptyPassword() {
        step.login(UserData.EMAIL_VALID, "", false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Login. Empty credential fields")
    public void testEnterWithEmptyFieldsEmailAndPassword() {
        step.login("", "", false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Logout")
    public void exitFromAccount() {
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        Assertions.assertTrue(step.logout());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
