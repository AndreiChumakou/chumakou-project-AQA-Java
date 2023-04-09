package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.CartSteps;
import org.junit.jupiter.api.*;

public class CartTest extends BaseTest{

    CartSteps step = new CartSteps(driver, homePage, loginPage);

    @Test
    @DisplayName("C2. Open site with empty cart")
    public void isCartEmptyWhenEnterFirstTime() {
        Assertions.assertTrue(homePage.isCartEmpty());
    }

    @Test
    @DisplayName("S4. Add product to cart")
    public void addProductToCart() {
        Assertions.assertTrue(step.addProductToCartCheck());
    }

    @Test
    @DisplayName("C3. Storing products in a cart")
    public void saveProductInCartWhenLogout() {
        Assertions.assertTrue(step.saveProductInCartWhenLogout());
    }

    @Test()
    @DisplayName("C4. Remove product from cart")
    public void removeFromCart() {
        Assertions.assertTrue(step.addProductToCartAndRemove());
    }
}
