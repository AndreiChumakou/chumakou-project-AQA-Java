package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubcategoryProductPage extends HomePage {

    public SubcategoryProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@itemprop='name url']")
    private WebElement firstProductName;

    public String productGetNameBeforeAddingToCart() {
        return firstProductName.getText();
    }
}
