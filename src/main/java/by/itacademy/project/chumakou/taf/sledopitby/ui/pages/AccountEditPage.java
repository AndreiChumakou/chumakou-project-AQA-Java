package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountEditPage extends BasePage{

    public AccountEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "firstname")
    private WebElement actualAccountName;

    public String getActualNameFromAccount() {
        return actualAccountName.getAttribute("value");
    }
}
