package utils;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeScenario
    public static void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://catchylabs-webclient.testinium.com/signIn"); // Test edilecek URL'yi aç
    }

    @AfterScenario
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
