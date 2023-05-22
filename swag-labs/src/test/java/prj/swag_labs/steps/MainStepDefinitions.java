package prj.swag_labs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import prj.swag_labs.pages.SauceDemoLoginPage;
import prj.swag_labs.pages.SauceDemoMainPage;

/**
 * Steps for the Main Page of the App
 */
public class MainStepDefinitions {
    private SauceDemoMainPage mainPage;

    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        Assert.assertFalse(loginPage.isPageVisible());
        this.mainPage = new SauceDemoMainPage();
        Assert.assertTrue("Was not redirected to Main Page", mainPage.isPageVisible());
    }

    @And("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {
        Assert.assertTrue("Was not redirected to Main Page", mainPage.isLogoVisible());
    }

}