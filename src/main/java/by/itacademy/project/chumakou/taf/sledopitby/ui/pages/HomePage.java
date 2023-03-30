package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static final String URL = "https://www.sledopit.by";
    public static final String TITLE_MAIN_PAGE = "Следопыт ®- охотничий магазин в Минске." +
            " Снаряжение для охоты, рыбалки и активного туризма с доставкой по Беларуси";

    @FindBy(linkText = "Вход")
    private WebElement loginPageEnterLinkTitle;

    @FindBy(className = "header-logo")
    private WebElement sledopitByLogo;

    @FindBy(className = "empty")
    private WebElement emptyCart;

    @FindBy(linkText = "ФОНАРИ")
    private WebElement categoryLinkTextFlashlight;

    @FindBy(linkText = "ВЕЛОФАРЫ")
    private WebElement subcategoryLinkTextBicycleFlashlight;

    @FindBy(xpath = "//span[contains(@onclick, 'removeFromCart')]")
    private WebElement removeProductFromCartXPath;

    @FindBy(name = "filter_name")
    private WebElement searchBar;

    @FindBy(className = "fa-search")
    private WebElement searchButton;

    @FindBy(className = "name")
    private WebElement searchResult;

    @FindBy(xpath = "//input[@value='В корзину']")
    private WebElement addToCartButtonXPath;

    @FindBy(linkText = "Корзина")
    private WebElement cartPageEnterLinkTitle;

    public void goToLoginPageLink() {
        loginPageEnterLinkTitle.click();
    }

    public void goToHomePage() {
        sledopitByLogo.click();
    }

    public boolean isCartEmpty() {
        return emptyCart.isDisplayed();
    }

    public void openCategoryGoods() {
        categoryLinkTextFlashlight.click();
    }

    public SubcategoryProductPage openSubcategoryProductsPage() {
        subcategoryLinkTextBicycleFlashlight.click();
        return new SubcategoryProductPage(driver);
    }

    public void removeProductFromCart() {
        removeProductFromCartXPath.click();
    }

    public void searchProduct(String product) {
        searchBar.click();
        searchBar.sendKeys(product);
        searchButton.click();
    }

    public String searchProductResult(String product) {
        searchProduct(product);
        return searchResult.getText().toLowerCase();
    }

    public void addFirstProductToCart() {
        addToCartButtonXPath.click();
    }

    public CartPage goToCartPageAfterAddingProduct() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.linkText("Корзина"))));
        cartPageEnterLinkTitle.click();
        return new CartPage(driver);
    }

    public CartPage goToCartPage() {
        cartPageEnterLinkTitle.click();
        return new CartPage(driver);
    }
}
