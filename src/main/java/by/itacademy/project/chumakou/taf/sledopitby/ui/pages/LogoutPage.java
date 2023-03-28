package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public WebDriver driver;

    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[text()='Выход']")
    private WebElement logoutConfirmationXPath;

    public boolean confirmLogout() {
        return logoutConfirmationXPath.isDisplayed();
    }
}
