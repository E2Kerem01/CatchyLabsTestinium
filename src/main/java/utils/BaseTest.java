package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import pages.LoginPage;

import java.io.ByteArrayInputStream;

public class BaseTest {
    private static WebDriver driver;
    protected LoginPage loginPage;

    @BeforeSuite
    public void setUpSuite() {
        // 🛠 **Tüm testler başlamadan önce WebDriver'ı başlat**
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        System.out.println("🚀 Test Suite başlatıldı!");
    }

    @BeforeScenario
    public void setUpScenario() {
        if (driver == null) { // Eğer driver yoksa yeni oluştur
            driver = WebDriverFactory.getDriver();
        }
        driver.get("https://catchylabs-webclient.testinium.com/signIn");
        Allure.step("Sayfa açıldı: " + driver.getTitle());
        System.out.println("🔄 Yeni senaryo başlatıldı: " + driver.getTitle());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterScenario
    public void takeScreenshot() {
        if (driver != null) {
            try {
                // 📸 **Ekran görüntüsü Allure'a ekleniyor**
                Allure.addAttachment("Test Ekran Görüntüsü", new ByteArrayInputStream(takeScreenshotAsBytes()));
                Allure.step("📸 Ekran görüntüsü alındı.");
            } catch (Exception e) {
                System.out.println("⚠️ Ekran görüntüsü alınamadı: " + e.getMessage());
            }
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        // 🔥 **Tüm testler bittikten sonra WebDriver'ı kapat**
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("✅ Test Suite tamamlandı, WebDriver kapatıldı.");
        }
    }

    @Attachment(value = "Ekran Görüntüsü", type = "image/png")
    public static byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
