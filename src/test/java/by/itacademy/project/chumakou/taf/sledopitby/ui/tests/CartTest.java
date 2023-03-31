package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.CartSteps;
import org.junit.jupiter.api.*;

public class CartTest extends BaseTest{

    CartSteps step = new CartSteps(driver, homePage, loginPage);

    @Test
    @DisplayName("Open site with empty cart")
    public void isCartEmptyWhenEnterFirstTime() {
        Assertions.assertTrue(homePage.isCartEmpty());
    }

    @Test
    @DisplayName("Add product to cart")
    public void addProductToCart() {
        Assertions.assertTrue(step.addProductToCartCheck());
    }

    @Test
    @DisplayName("Storing products in a cart")
    public void saveProductInCartWhenLogout() {
        Assertions.assertTrue(step.saveProductInCartWhenLogout());
    }

    @Test()
    @DisplayName("Remove product from cart")
    public void removeFromCart() {
        Assertions.assertTrue(step.addProductToCartAndRemove());
    }
}
