package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    private static WebDriver driver;

    // WebDriver nesnesini döndüren metot
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("BROWSER", "CHROME").toUpperCase();

            switch (browser) {
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "CHROME":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    if (Boolean.parseBoolean(System.getProperty("HEADLESS", "false"))) {
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--window-size=1920,1080");
                    }

                    driver = new ChromeDriver(options);
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    // WebDriver'ı kapatmak için metot
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
