package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickButton(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }


    public boolean isElementVisibleAndEnabled(By locator) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            System.out.println("Element bulunamadı veya erişilemez: " + e.getMessage());
        }
        return false;
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sendKeysToElement(By locator,String text) {
        try {
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(locator));
            inputField.clear(); // **Önce alanı temizle**
            inputField.sendKeys(text);
            System.out.println("Yeni değer girildi: " + text);
        } catch (Exception e) {
            System.out.println("Hesap ismi girilemedi: " + e.getMessage());
        }
    }

    public String getTextFromElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText().trim();
        } catch (Exception e) {
            System.out.println("Elementten metin alınamadı: " + e.getMessage());
            return "";
        }
    }


    public boolean isTextEqualToExpected(String actualText, String expectedText) {
        return actualText.equalsIgnoreCase(expectedText);
    }


    public byte[] takeScreenshot() {
        return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}
