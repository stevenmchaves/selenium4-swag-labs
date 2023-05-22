package prj.swag_labs.webdriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

/**
 * This class assists in selecting a different browser and provides non
 * specific page operations.
 */
public class WebDriverUtils {
    private static WebDriver driver;

    public static File takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static void quit() {
        if(driver != null) {
            driver.quit();
        }
    }

    public static void close() {
        if(driver != null) {
            driver.close();
        };
    }

    public WebDriver getDriver() {
        //  return getDriver(DriverManagerType.SAFARI);
        return getDriver(DriverManagerType.CHROME);
    }

    public WebDriver getDriver(DriverManagerType driverType) {
        // creating remote driver is different
        if(driver == null) driver = createLocalDriver(driverType);
        return driver;
    }

    private WebDriver createLocalDriver(DriverManagerType driverType) {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
            case CHROMIUM:
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case IEXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + driverType);
        }

       return driver;
    }
}
