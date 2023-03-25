package by.itacademy.project.chumakou.taf.sledopitby.ui.steps;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.findElement(By.linkText(HomePage.LOGIN_PAGE_ENTER_LINK_TITLE)).click();
    }

    public void logout() {
        driver.findElement(By.linkText(HomePage.LOGOUT_LINK_TITLE)).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.name(LoginPage.EMAIL_FIELD_NAME_IN_HTML))
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name(LoginPage.PASSWORD_FIELD_NAME_IN_HTML))
                .sendKeys(password);
    }

    public void submitButtonEnterToAccount() {
        driver.findElement(By.xpath(LoginPage.BUTTON_ENTER_TO_ACCOUNT)).click();
    }

    public void enterCredentialsGoToAccount(String email, String password) {
        goToLoginPage();
        enterEmail(email);
        enterPassword(password);
        submitButtonEnterToAccount();
    }

    public String getWarningInvalidCredentials() {
        return driver.findElement(By.xpath(LoginPage.WARNING_INVALIDE_CREDENTIALS_XPATH))
                .getText();
    }

    public void goToAccountEditPage() {
        driver.findElement(By.xpath(AccountPage.ACCOUNT_EDIT_LINK)).click();
    }

    public String getActualNameFromAccount() {
        return driver.findElement(By.name("firstname")).getAttribute("value");
    }

    public void openCategoryGoods(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    public void openSubcategoryProducts(String subcategory) {
        driver.findElement(By.linkText(subcategory)).click();
    }

    public String getFirstProductNameBeforeAddingToCart() {
        return driver.findElement(By.xpath(HomePage.FIRST_PRODUCT_NAME)).getText();
    }

    public String productGetNameBeforeAddingToCart(String category, String subcategory) {
        openCategoryGoods(category);
        openSubcategoryProducts(subcategory);
        return getFirstProductNameBeforeAddingToCart();
    }

    public void addFirstProductToCart() {
        driver.findElement(By.xpath(HomePage.ADD_TO_CART_BUTTON)).click();
    }

    public void goToCartPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .stalenessOf(driver.findElement(By.linkText(HomePage.CART_PAGE_ENTER_LINK_TITLE))));
        driver.findElement(By.linkText(HomePage.CART_PAGE_ENTER_LINK_TITLE)).click();
    }

    public String getFirstProductNameInCart() {
        return driver.findElement(By.xpath(CartPage.FIRST_PRODUCT_NAME_IN_CART)).getText();
    }

    public String productGetNameAfterAddingToCart() {
        addFirstProductToCart();
        goToCartPage();
        return getFirstProductNameInCart();
    }

    public void goToHomePage() {
        driver.findElement(By.className("header-logo")).click();
    }

    public void removeProductFromCart() {
        driver.findElement(By.xpath(HomePage.REMOVE_PRODUCT_FROM_CART_PATH)).click();
    }

    public boolean confirmLogout() {
        return driver.findElement(By.xpath(LogoutPage.LOGOUT_CONFIRMATION_PATH)).isDisplayed();
    }
}
