package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }


    public boolean isElementVisibleAndEnabled(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e) {
            System.out.println("Element bulunamadı veya erişilemez: " + e.getMessage());
        }
        return false;
    }


    public byte[] takeScreenshot() {
        return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}
