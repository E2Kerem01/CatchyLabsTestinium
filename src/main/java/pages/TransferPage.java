package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {
    private WebDriver driver;

    private By sourceAccount = By.id("source-account");
    private By destinationAccount = By.id("destination-account");
    private By amountInput = By.id("amount");
    private By transferButton = By.id("transfer-btn");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSourceAccount(String account) {
        driver.findElement(sourceAccount).sendKeys(account);
    }

    public void selectDestinationAccount(String account) {
        driver.findElement(destinationAccount).sendKeys(account);
    }

    public void enterAmount(String amount) {
        driver.findElement(amountInput).sendKeys(amount);
    }

    public void clickTransfer() {
        driver.findElement(transferButton).click();
    }
}
