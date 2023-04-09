package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import org.junit.jupiter.api.*;

public class HomeTest extends BaseTest{

    @Test()
    @DisplayName("S1. Open home page")
    @Tag("smoke")
    public void testSledopitByOpen() {
        Assertions.assertEquals(HomePage.TITLE_MAIN_PAGE, driver.getTitle());
    }
}
