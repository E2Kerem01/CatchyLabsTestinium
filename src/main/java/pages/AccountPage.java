package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    private By newAccountButton = By.id("new-account");
    private By accountNameInput = By.id("account-name");
    private By saveButton = By.id("save-btn");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAccount(String accountName) {
        driver.findElement(newAccountButton).click();
        driver.findElement(accountNameInput).sendKeys(accountName);
        driver.findElement(saveButton).click();
    }
}
