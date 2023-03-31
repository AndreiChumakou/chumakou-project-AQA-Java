package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.AccountEditPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.LoginSteps;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import org.junit.jupiter.api.*;

public class LoginTest extends BaseTest{

    LoginSteps step = new LoginSteps(driver, homePage, loginPage);

    @Test
    @DisplayName("Login. Valid credentials")
    @Tag("smoke")
    public void testLoginWithCorrectCredentials() {
        AccountEditPage accountEditPage = new AccountEditPage(driver);
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        Assertions.assertEquals(UserData.NAME_VALID, accountEditPage.getActualNameFromAccount());
    }

    @Test
    @DisplayName("Login. Invalid email")
    public void testLoginWithIncorrectEmail() {
        step.login(UserData.EMAIL_INVALIDE, UserData.PASSWORD_VALID, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentialsText());
    }

    @Test
    @DisplayName("Login. Invalid password")
    public void testLoginWithIncorrectPassword() {
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_INVALIDE, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentialsText());
    }

    @Test
    @DisplayName("Login. Empty email")
    public void testLoginWithEmptyEmail() {
        step.login("", UserData.PASSWORD_VALID, false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentialsText());
    }

    @Test
    @DisplayName("Login. Empty password")
    public void testLoginWithEmptyPassword() {
        step.login(UserData.EMAIL_VALID, "", false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentialsText());
    }

    @Test
    @DisplayName("Login. Empty credential fields")
    public void testEnterWithEmptyFieldsEmailAndPassword() {
        step.login("", "", false);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                loginPage.getWarningInvalidCredentialsText());
    }

    @Test
    @DisplayName("Logout")
    public void exitFromAccount() {
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        Assertions.assertTrue(step.logout());
    }
}
