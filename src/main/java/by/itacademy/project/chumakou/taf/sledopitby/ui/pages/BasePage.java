package by.itacademy.project.chumakou.taf.sledopitby.ui.pages;

import by.itacademy.project.chumakou.taf.sledopitby.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }
}
