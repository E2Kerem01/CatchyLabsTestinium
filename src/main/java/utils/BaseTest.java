package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;

import java.io.ByteArrayInputStream;
import java.io.File;

public class BaseTest {
    private static WebDriver driver;

    static {
        try {
            // 📂 **Allure sonuçlarının kaydedileceği klasörü oluştur**
            String allureResultsDir = System.getProperty("user.dir") + File.separator + "allure-results";
            File resultsFolder = new File(allureResultsDir);
            if (!resultsFolder.exists()) {
                System.out.println("📂 Allure results klasörü oluşturuluyor...");
                resultsFolder.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeScenario
    @Step("Test Başlatılıyor")
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://catchylabs-webclient.testinium.com/signIn");

        Allure.step("Sayfa açıldı: " + driver.getTitle());
        System.out.println("🚀 Test başlatıldı: " + driver.getTitle());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterScenario
    @Step("Test Sonlandırılıyor")
    public void tearDown() {
        if (driver != null) {
            try {
                // 📸 **Allure raporuna ekran görüntüsü ekle**
                Allure.addAttachment("Test Ekran Görüntüsü", new ByteArrayInputStream(takeScreenshotAsBytes()));
                Allure.step("📸 Ekran görüntüsü alındı.");
            } catch (Exception e) {
                System.out.println("⚠️ Ekran görüntüsü alınamadı: " + e.getMessage());
            }
            driver.quit();
        }

        System.out.println("✅ Test tamamlandı, Allure sonuçları oluşturuldu.");
    }

    /**
     * 📸 **Allure için ekran görüntüsü alır.**
     */
    @Attachment(value = "Ekran Görüntüsü", type = "image/png")
    public static byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
