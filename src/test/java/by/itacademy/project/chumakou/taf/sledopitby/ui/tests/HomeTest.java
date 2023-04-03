package by.itacademy.project.chumakou.taf.sledopitby.ui.tests;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;
import org.junit.jupiter.api.*;

public class HomeTest extends BaseTest{

    @Test()
    @DisplayName("Open home page")
    public void testSledopitByOpen() {
        Assertions.assertEquals(HomePage.TITLE_MAIN_PAGE, driver.getTitle());
    }
}
