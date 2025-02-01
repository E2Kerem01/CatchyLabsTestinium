package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;

import java.io.ByteArrayInputStream;

public class BaseTest {
    private static WebDriver driver;

    @BeforeScenario
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://catchylabs-webclient.testinium.com/signIn");
        System.out.println("🚀 Test başlatıldı: " + driver.getTitle());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            try {
                // 📸 **Allure için ekran görüntüsü ekle**
                Allure.addAttachment("Ekran Görüntüsü", new ByteArrayInputStream(takeScreenshotAsBytes()));
            } catch (Exception e) {
                System.out.println("⚠️ Ekran görüntüsü alınamadı: " + e.getMessage());
            }
            driver.quit();
        }
        System.out.println("✅ Test tamamlandı, Allure sonuçları oluşturuldu.");
    }

    @Attachment(value = "Ekran Görüntüsü", type = "image/png")
    public static byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
