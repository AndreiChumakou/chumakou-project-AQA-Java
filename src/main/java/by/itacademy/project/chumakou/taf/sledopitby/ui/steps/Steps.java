package by.itacademy.project.chumakou.taf.sledopitby.ui.steps;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.*;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import org.openqa.selenium.WebDriver;

public class Steps {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public Steps(WebDriver driver, HomePage homePage, LoginPage loginPage) {
        this.driver = driver;
        this.homePage = homePage;
        this.loginPage = loginPage;
    }

    public void login(String email, String password, boolean isValidCredentials) {
        homePage.goToLoginPageLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.submitButtonEnterToAccount();
        if (isValidCredentials) {
            new AccountPage(driver).goToAccountEditPage();
        }
    }

    public boolean logout() {
        homePage.goToHomePage();
        loginPage.logout();
        return new LogoutPage(driver).confirmLogout();
    }

    public boolean addProductToCartCheck() {
        homePage.openCategoryGoods();
        SubcategoryProductPage subcategoryProductPage = homePage.openSubcategoryProductsPage();
        String productName = subcategoryProductPage.productGetNameBeforeAddingToCart();
        subcategoryProductPage.addFirstProductToCart();
        String addedProductName = subcategoryProductPage.goToCartPageAfterAddingProduct().getFirstProductNameInCart();
        return productName.equals(addedProductName);
    }

    public boolean addProductToCartAndRemove() {
        addProductToCartCheck();
        homePage.goToHomePage();
        homePage.removeProductFromCart();
        return homePage.isCartEmpty();
    }

    public boolean saveProductInCartWhenLogout() {
        login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        homePage.searchProduct();
        homePage.addFirstProductToCart();
        String productInCart = homePage.goToCartPageAfterAddingProduct().getFirstProductNameInCart();
        homePage.goToHomePage();
        loginPage.logout();
        homePage.goToHomePage();
        login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        homePage.goToHomePage();
        String productInCartAfterRelogin = homePage.goToCartPage().getFirstProductNameInCart();
        return productInCart.equals(productInCartAfterRelogin);
    }

}
