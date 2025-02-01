package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    private By userNameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//div[@id='root']//div[.='Login']");
    private By openMoneyButton = By.cssSelector("div.css-146c3p1.r-jwli3a.r-1b43r93");

    private By failLoginException = By.xpath("//div[@class='css-146c3p1 r-howw7u r-1b43r93']");

    public LoginPage(WebDriver driver) {
        super(driver); // **BasePage constructor'ına driver gönder**
    }


    public void enterEmail(String username) {
        driver.findElement(userNameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        clickButton(loginButton);
    }

    public void clickOpenMoney() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Thread.sleep(2000); // **Kısa bir bekleme**
            driver.findElement(openMoneyButton).click();
        } catch (Exception e) {

            // **JavaScript ile zorla tıkla**
            try {
                WebElement button = driver.findElement(openMoneyButton);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", button);
                System.out.println("Open Money butonuna JavaScript ile tıklandı.");
            } catch (Exception ex) {
                System.out.println("JavaScript ile de tıklanamadı: " + ex.getMessage());
            }
        }
    }

    public boolean isUserNameFieldVisibleAndEnabled() {
        return isElementVisibleAndEnabled(userNameInput);
    }

    public boolean isOpenMoneyButtonVisibleAndEnabled() {
        return isElementVisibleAndEnabled(openMoneyButton);
    }

    public boolean isFailLoginExceptionVisibleAndEnabled() {
        return isElementVisibleAndEnabled(failLoginException);
    }

    private By myAccountPage = By.xpath("//div[normalize-space()='My account']");


    public boolean isMyAccountVisibleAndEnable(){
        return isElementVisibleAndEnabled(myAccountPage);
    }
}
