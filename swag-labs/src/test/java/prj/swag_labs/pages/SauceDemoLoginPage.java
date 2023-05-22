package prj.swag_labs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class provides the different operations needed to coordinate through
 * the login page of the app.
 */
public class SauceDemoLoginPage extends BasePage {
    public final By.ById passwordId = new By.ById("password");
    public final By.ById usernameId = new By.ById("user-name");

    private final By.ByCssSelector usernameError = new By.ByCssSelector("#user-name + svg");

    private final By.ByCssSelector passwordError = new By.ByCssSelector("#password + svg");

    private final SauceDemoLoginErrorContainer loginErrorContainer = new SauceDemoLoginErrorContainer();

    private final By.ById loginButtonId = new By.ById("login-button");

    // TODO provide Page Objects for login_credentials_wrap div

    /**
     * Goes to the Base url of the app
     */
    public void goToLoginPage() {
        driver.get(BASE_URL);
    }
    /**
     * Performs click of login message
     * @return true if click occurred, false otherwise
     */
    public boolean clickLogin() {
        return clickIfVisible(driver.findElement(loginButtonId));
    }

    /**
     * Returns text in error message
     * @return String of error message
     */
    public String retrieveErrorMessage() {
        return loginErrorContainer.getMessage();
    }

    /**
     * Check to confirm that we are on the login page
     * @return true if its the login page, false otherwise
     */
    public boolean isPageVisible() {
        try {
            String loginLogoClass = "login_logo";
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByClassName(loginLogoClass))));
            return true;
            // page not visible
        } catch (final WebDriverException ignored) {
            return false;
        }
    }

    /**
     * Inner class as the login error would only be displayed on the login
     * page.
     */
    public static class SauceDemoLoginErrorContainer extends BasePage {

        private final By.ByClassName errMsgContainer =
                new By.ByClassName("error-message-container");

        /**
         * Checks if the Login Error Container is visible
         * @return true if visible, false otherwise
         */
        public boolean isVisible() {
            return driver.findElement(errMsgContainer).isDisplayed();
        }

        /**
         * Gets the text of the error message
         * @return text of the err
         */
        public String getMessage() {
            return getTextIfVisible(driver.findElement(errMsgContainer));
        }

        /**
         * Close Message if visible
         * @return true if attempted to close message, false otherwise
         */
        public boolean closeMessage() {
            return clickIfVisible(driver.findElement(errMsgContainer).findElement(new By.ByClassName("error-button")));
        }

    }
}
