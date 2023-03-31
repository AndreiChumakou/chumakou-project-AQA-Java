package by.itacademy.project.chumakou.taf.sledopitby.ui.steps;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.AccountPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LogoutPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends BaseStep {

    public LoginSteps(WebDriver driver, HomePage homePage, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    public void login(String email, String password, boolean isValidCredentials) {
        homePage.goToLoginPageLink();
        loginPage.enterEmail(email)
                .enterPassword(password)
                .submitButtonEnterToAccount();
        if (isValidCredentials) {
            new AccountPage(driver).goToAccountEditPage();
        }
    }

    public boolean logout() {
        homePage.goToHomePage();
        loginPage.logout();
        return new LogoutPage(driver).confirmLogout();
    }
}
