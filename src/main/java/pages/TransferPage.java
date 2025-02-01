package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage extends BasePage {
    private WebDriver driver;

    private By tranferMoneyButton = By.xpath("//div[contains(text(),'Transfer money')]");
    private By transferMoneyPanel = By.xpath("//div[@class='css-146c3p1 r-ubezar r-vw2c0b']");
    private By transferAmauntField = By.xpath("//input[@class='css-11aywtz r-6taxm2 r-1eh6qqt r-z2wwpe r-rs99b7 r-h3s6tt r-1qhn6m8']");
    private By sendMoneyButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93'][normalize-space()='Send']");
    private By sendMoneyTL = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1)");
    private By receiverPanel = By.xpath("//div[7]//select[1]");
    private By amountList = By.xpath("option[value='6713fd4d-48b0-4391-b88a-d658e174cfb9']");

    private String sendMoneyAmount;

    public TransferPage(WebDriver driver) {
        super(driver);
    }

    public void clickTransfer(){
        clickButton(tranferMoneyButton);
    }

    public boolean isTransferMoneyPanelVisibleAndEnabled() {
        return isElementVisibleAndEnabled(transferMoneyPanel);
    }

    public void correctTransferMoney(String money){
        clickButton(transferAmauntField);
        sendKeysToElement(transferAmauntField, money);
        clickButton(sendMoneyButton);
        String sendMoneyAmount =getTextFromElement(sendMoneyTL);
        isTextEqualToExpected(sendMoneyAmount,money);

    }

    public void chooseNewReceiver(){
        clickButton(receiverPanel);
        clickButton(amountList);
    }





}
