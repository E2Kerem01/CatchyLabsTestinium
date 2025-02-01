package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditAccountPage extends BasePage {

    private By myAccountPage = By.xpath("//div[normalize-space()='My account']");
    private By editAccountButton = By.xpath("//div[contains(text(),'Edit account')]");
    private By accountNameField = By.xpath("//input[@class='css-11aywtz r-6taxm2 r-1eh6qqt r-z2wwpe r-rs99b7 r-h3s6tt r-1qhn6m8']");
    private By updateButton = By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu']");
    private By accountNameArea = By.xpath("//div[@class='css-175oi2r r-14lw9ot r-z2wwpe r-edyy15']//div[1]//div[2]");

    private String oldUsername;

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountVisibleAndEnable(){
        return isElementVisibleAndEnabled(myAccountPage);
    }

    public boolean isVisiblaAndEnableEditAccountButton(){

        return isElementVisibleAndEnabled(editAccountButton);
    }

    public void clickEditMyAccountButton(){
        clickButton(editAccountButton);
    }

    public boolean isVisiblaAndEnableEditAccountInputField(){
        return isElementVisibleAndEnabled(accountNameField);
    }

    public void clickEditAccountNameField(){
        clickButton(accountNameField);
    }

    public void enterNewAccountName(String username){
        sendKeysToElement(accountNameField,username);
    }

    public void clickUpdateButton() throws InterruptedException {
        clickButton(updateButton);
    }

    public void getOldUsername() {
        oldUsername = getTextFromElement(accountNameArea);
        System.out.println("🔵 Eski Kullanıcı Adı: " + oldUsername);
    }

    public boolean isUsernameUpdated(String newUsername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement updatedField = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNameArea));
            String currentUsername = updatedField.getText().trim();
            return currentUsername.equalsIgnoreCase(newUsername);
        } catch (Exception e) {
            System.out.println("Kullanıcı adı değişiklik kontrolü başarısız: " + e.getMessage());
            return false;
        }
    }



}
