package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//tbody/tr/td[@class='name']")
    private WebElement firstProductnameInCart;

    public String getFirstProductNameInCart() {
        return firstProductnameInCart.getText();
    }
}
