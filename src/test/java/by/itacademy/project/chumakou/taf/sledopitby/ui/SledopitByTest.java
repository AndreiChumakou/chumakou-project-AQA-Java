package by.itacademy.project.chumakou.taf.sledopitby.ui;

import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.LoginPage;
import by.itacademy.project.chumakou.taf.sledopitby.ui.steps.Steps;
import by.itacademy.project.chumakou.taf.sledopitby.ui.users.UserData;
import by.itacademy.project.chumakou.taf.sledopitby.ui.util.Util;
import by.itacademy.project.chumakou.taf.sledopitby.ui.pages.HomePage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SledopitByTest {

    WebDriver driver;
    Steps step;

//    @Tag("PROD")   Smoke/ non smoke

  /*  в новом пакк. Suite
   * @Suite
   * @SelectClasses(Test1.class, Test2.class) выше класса
  * новый класс Suite
   */
//    можно @SelectPackages("pack1")
//    @IncludsTags("dev")       exclude

    @BeforeEach
    public void warmUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(HomePage.URL);
        step = new Steps(driver);
    }

    @Test()
    @DisplayName("Open home page")
    @Tag("smoke")
    public void testSledopitByOpen() {
        Assertions.assertEquals(HomePage.TITLE_MAIN_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Enter. Valid credentials")
    @Tag("smoke")
    public void testEnterWithCorrectCredentials() {
        step.enterCredentialsGoToAccount(UserData.EMAIL_VALID, UserData.PASSWORD_VALID);
        step.goToAccountEditPage();
        Assertions.assertEquals(UserData.NAME_VALID, step.getActualNameFromAccount());
    }

    @Test
    @DisplayName("Enter. Invalid email")
    public void testEnterWithIncorrectEmail() {
        step.enterCredentialsGoToAccount(UserData.EMAIL_INVALIDE, UserData.PASSWORD_VALID);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                step.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Enter. Invalid password")
    public void testEnterWithIncorrectPassword() {
        step.enterCredentialsGoToAccount(UserData.EMAIL_VALID, UserData.PASSWORD_INVALIDE);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                step.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Enter. Empty email")
    public void testEnterWithEmptyEmail() {
        step.enterCredentialsGoToAccount("", UserData.PASSWORD_VALID);
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                step.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Enter. Empty password")
    public void testEnterWithEmptyPassword() {
        step.enterCredentialsGoToAccount(UserData.EMAIL_VALID, "");
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                step.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Enter. Empty fields")
    public void testEnterWithEmptyFieldsEmailAndPassword() {
        step.enterCredentialsGoToAccount("", "");
        Assertions.assertEquals(LoginPage.WARNING_INVALIDE_CREDENTIALS_TEXT,
                step.getWarningInvalidCredentials());
    }

    @Test
    @DisplayName("Exit from Account")
    public void exitFromAccount() {
        step.enterCredentialsGoToAccount(UserData.EMAIL_VALID, UserData.PASSWORD_VALID);
        step.goToAccountEditPage();
        step.goToHomePage();
        step.logout();
        Assertions.assertTrue(step.confirmLogout());
    }

    @Test
    @DisplayName("Find product")                                 // REFACTOR
    @Tag("smoke")
    public void findProductViaSearchBar() {
        driver.findElement(By.name("filter_name")).click();
        driver.findElement(By.name("filter_name")).sendKeys("Палатка");
        Util.waitForPresentation();
        driver.findElement(By.className("fa-search")).click();
        Util.waitForPresentation();                         // DElETE
        System.out.println(driver.findElement(By.className("name")).getText());
        String text = driver.findElement(By.className("name")).getText().toLowerCase();
        Assertions.assertTrue(text.contains  ("палатка".toLowerCase()));

    }

    @Test
    @DisplayName("Open site with empty cart")
    public void isCartEmptyWhenEnterFirstTime() {
        Assertions.assertTrue(driver.findElement(By.className("empty")).isDisplayed());
    }

    @Test
    @DisplayName("Add product to cart")
    @Tag("smoke")
    public void addProductToCart() {
        String productName = step.productGetNameBeforeAddingToCart(HomePage.CATEGORY_FONARI_LINK_TEXT,
                HomePage.SUBCATEGORY_FONARI_VELOFARY_LINK_TEXT);
        String addedProductName = step.productGetNameAfterAddingToCart();
        Assertions.assertEquals(productName, addedProductName);
    }

    @Test()
    @DisplayName("Remove product from cart")
    public void removeFromCart() {
        String productName = step.productGetNameBeforeAddingToCart(HomePage.CATEGORY_FONARI_LINK_TEXT,
                HomePage.SUBCATEGORY_FONARI_VELOFARY_LINK_TEXT);
        String addedProductName = step.productGetNameAfterAddingToCart();
        Assertions.assertEquals(productName, addedProductName);
        step.goToHomePage();
        step.removeProductFromCart();
        Assertions.assertTrue(driver.findElement(By.className("empty")).isDisplayed());
    }

    @Test()
    @DisplayName("COMPLICATED TEST")
    public void ct() {}


    @AfterEach
    public void tearDown() {
        Util.waitForPresentation();                // УБРАТЬ по готовности
        driver.quit();
    }
}
