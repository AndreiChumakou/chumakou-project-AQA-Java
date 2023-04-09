package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.data.TestData;
import org.junit.jupiter.api.*;

public class SearchTest extends BaseTest {

    @Test
    @DisplayName("S3. Search product")
    public void findProductViaSearchBar() {
        String product = homePage.searchProductResult(TestData.PRODUCT_FOR_SEARCH);
        Assertions.assertTrue(product.contains(TestData.PRODUCT_FOR_SEARCH.toLowerCase()));
    }
}
