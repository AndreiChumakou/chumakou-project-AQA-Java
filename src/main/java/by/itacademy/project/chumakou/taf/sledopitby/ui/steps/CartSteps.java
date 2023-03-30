package by.itacademy.project.chumakou.taf.sledopitby.ui.steps;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.SubcategoryProductPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.TestData;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import org.openqa.selenium.WebDriver;

public class CartSteps extends BaseStep {

    public CartSteps(WebDriver driver, HomePage homePage, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
        this.homePage = homePage;
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
        LoginSteps step = new LoginSteps(driver, homePage, loginPage);
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        homePage.searchProduct(TestData.PRODUCT_FOR_SEARCH);
        homePage.addFirstProductToCart();
        String productInCart = homePage.goToCartPageAfterAddingProduct().getFirstProductNameInCart();
        homePage.goToHomePage();
        loginPage.logout();
        homePage.goToHomePage();
        step.login(UserData.EMAIL_VALID, UserData.PASSWORD_VALID, true);
        homePage.goToHomePage();
        String productInCartAfterRelogin = homePage.goToCartPage().getFirstProductNameInCart();
        return productInCart.equals(productInCartAfterRelogin);
    }
}
