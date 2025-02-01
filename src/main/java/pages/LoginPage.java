package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By userNameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("/html//div[@id='root']/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[@class='css-175oi2r r-13awgt0']/div[@class='css-175oi2r r-13awgt0']/div/div[4]/div/div[.='Login']");
    private By openMoneyButton = By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String username) {
        driver.findElement(userNameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isUserNameFieldVisibleAndEnabled() {
        try {
            WebElement usernameField = driver.findElement(userNameInput);

            if (usernameField.isDisplayed() && usernameField.isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Kullanıcı adı alanı bulunamadı veya erişilemez: " + e.getMessage());
        }
        return false;
    }

    public boolean isOpenMoneyButtonVisibleAndEnabled() {
        try {
            WebElement usernameField = driver.findElement(openMoneyButton);

            if (usernameField.isDisplayed() && usernameField.isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Open Money Transfer butonu görülmemekte " + e.getMessage());
        }
        return false;
    }

}
