package prj.swag_labs.pages;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import prj.swag_labs.app.webdriver.WebDriverUtils;

import java.time.Duration;

/**
 * App specific Base class for page objects to extend from.
 * Provides some attributes, methods that can be used by the actual POs.
 */
public abstract class BasePage {
    private final WebDriverUtils driverUtils = new WebDriverUtils();
    public static final String BASE_URL = "https://www.saucedemo.com/";
    private static final Duration TIMEOUT_L = Duration.ofSeconds(10);

    private static final Duration SLEEP = Duration.ofMillis(100);

    final WebDriver driver;
    final WebDriverWait wait;


    public BasePage() {
        this.driver = driverUtils.getDriver();
        this.wait = new WebDriverWait(driver, TIMEOUT_L, SLEEP);
    }

    /**
     * Default WebDriver is Chrome, Use this method to choose a different type
     * @param type Browser Type string
     * @return Browser Specific driver
     */
    protected WebDriver getDriver(String type) {
        return driverUtils.getDriver(DriverManagerType.valueOf(type));
    }


    /**
     * Only tries to Click element if exists
     * @param elm object to click
     * @return true click attempt occurred, false otherwise
     */
    protected boolean clickIfVisible(WebElement elm) {
        boolean clicked = false;
        wait.until(ExpectedConditions.visibilityOf(elm));
        if (elm.isEnabled()) {
            elm.click();
            clicked = true;
        }
        return clicked;
    }

    /**
     * Only tries to get text from element if exists
     * @param elm object to get text from
     * @return String click attempt occurred, false otherwise
     */
    protected String getTextIfVisible(WebElement elm) {
        String text = null;
        wait.until(ExpectedConditions.visibilityOf(elm));
        if (elm.isEnabled()) {
            text = elm.getText();
        }
        return text;
    }

    /**
     * Enters the text into the webelement found using the selector.
     * @param selector Selector to use for the WebElement
     * @param text Chars to enter in the Element
     * @return true if the text was attempted to be enter, false otherwise
     */
    public boolean enterText(By selector, String text) {
        return enterTextIfVisible(driver.findElement(selector), text);
    }

    /**
     * Only tries to enter text from element if exists
     * @param elm object to get text from
     * @param text String representation of text to enter
     * @return String click attempt occurred, false otherwise
     */
    protected boolean enterTextIfVisible(WebElement elm, String text) {
        boolean textEntered = false;
        if (elm.isEnabled()) {
            elm.sendKeys(text);
            textEntered = true;
        }
        return textEntered;
    }

    public void quit() {
        driver.quit();
    }
}
