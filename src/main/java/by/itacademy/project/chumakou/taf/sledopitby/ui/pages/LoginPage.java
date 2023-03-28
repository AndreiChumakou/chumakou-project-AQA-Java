package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static final String WARNING_INVALIDE_CREDENTIALS_TEXT = "Неправильно заполнены поля E-Mail и/или пароль!";

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonEnterToAccount;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement warningInvalidCredentialsXPath;

    @FindBy(linkText = "Выход")
    private WebElement logoutLinkTitle;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitButtonEnterToAccount() {
        buttonEnterToAccount.click();
    }

    public String getWarningInvalidCredentials() {
        return warningInvalidCredentialsXPath.getText();
    }

    public void logout() {
        logoutLinkTitle.click();
    }
}
