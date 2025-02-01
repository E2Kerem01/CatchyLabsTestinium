package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddMoneyPage extends BasePage {

    private By addMoneyButton = By.xpath("//div[contains(text(),'Add money')]");
    private By addButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93'][normalize-space()='Add']");
    private By requiredFieldMessage = By.xpath("(//div[@dir='auto'][normalize-space()='Required'])[1]");
    private By cardField = By.xpath("(//input[@autocapitalize='sentences'])[1]");
    private By cardHolderField = By.xpath("(//input[@autocapitalize='sentences'])[2]");
    private By cardExpiryDate =  By.xpath("//input[@placeholder='MM/YY']");
    private By cardCVV = By.xpath("(//input[@autocapitalize='sentences'])[4]");
    private By amountField = By.xpath("(//input[@autocapitalize='sentences'])[4]");
    private By sendAmount = By.xpath("(//div[@dir='auto'][normalize-space()='1,000.00'])[1]");

    private String sendMoneyTLL;

    public AddMoneyPage(WebDriver driver) {
        super(driver);
    }

    public void AddMoneyPageButton() {
        clickButton(addMoneyButton);
    }

    public void checkAddMoneyArea(){
        isElementVisibleAndEnabled(cardField);
    }

    public void clickAddMoneyButton() {
        clickButton(addButton);
    }

    public void checkRequiredFieldMessage() {
        isElementVisibleAndEnabled(requiredFieldMessage);
    }

    public void addMoneyToAccount(String money){
        sendKeysToElement(cardField,"1234123412341234");
        sendKeysToElement(cardHolderField,"Kerem");
        sendKeysToElement(cardExpiryDate, "1111");
        sendKeysToElement(cardCVV,"123");
        clickButton(amountField);
        sendKeysToElement(amountField, money);

    }


}
