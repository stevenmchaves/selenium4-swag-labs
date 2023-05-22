package prj.swag_labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class provides the methods to perform on the main page of the application.
 * Currently, VERY limited!
 */
public class SauceDemoMainPage extends BasePage {

    public static final String WWW_SAUCEDEMO_COM_INVENTORY_HTML = "https://www.saucedemo.com/inventory.html";
    private final By.ById menuButtonBy = new By.ById("menu_button_container");
    private final By.ByClassName appLogoBy = new By.ByClassName("app_logo");

    /**
     * Checks that the driver made it to the main URl and at least sees the
     * menu button
     * @return true if page is visible, false otherwise
     */
    public boolean isPageVisible() {
        boolean isVisible = false;
        try {
            if (driver.getCurrentUrl().equals(WWW_SAUCEDEMO_COM_INVENTORY_HTML)) {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(menuButtonBy)));
                isVisible = true;
            }
            // page not visible
        } catch (final WebDriverException ignored) {
            return false;
        }
        return isVisible;
    }

    /**
     * Checks if the Logo is Visible/Displayed
     * @return true if it does, otherwise false
     */
    public boolean isLogoVisible() {
        return driver.findElement(appLogoBy).isDisplayed();
    }


}
