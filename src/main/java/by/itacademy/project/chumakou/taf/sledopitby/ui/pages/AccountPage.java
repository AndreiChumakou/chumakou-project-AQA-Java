package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//img[@alt='Account Details']")
    private WebElement accountEditLink;

    public void goToAccountEditPage() {
        accountEditLink.click();
    }
}
