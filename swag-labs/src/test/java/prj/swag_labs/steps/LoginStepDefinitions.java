package prj.swag_labs.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import prj.swag_labs.data.AccountInfo;
import prj.swag_labs.pages.SauceDemoLoginPage;

/**
 * This class is used for steps that would be used to validation the Login Screen
 *
 */
public class LoginStepDefinitions {

    private SauceDemoLoginPage loginPage;

    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {
        this.loginPage = new SauceDemoLoginPage();
        loginPage.goToLoginPage();
        Assert.assertTrue("Sauce Demo Login not visible", loginPage.isPageVisible());
    }

    @When("I fill the account information for account {word} into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_into_the_username_field_and_the_password_field(String username) {
        AccountInfo accountInfo = AccountInfo.findAccount(username);
        Assert.assertTrue("Failed to enter username",
                loginPage.enterText(loginPage.usernameId, accountInfo.getUsername()));
        Assert.assertTrue("Failed to enter password",
                loginPage.enterText(loginPage.passwordId, accountInfo.getPassword()));
    }

    @And("I click the Login Button")
    public void i_click_the_login_button() {
        Assert.assertTrue("Clicking login failed", loginPage.clickLogin());
    }


    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String errMessage) {
        Assert.assertEquals(errMessage, loginPage.retrieveErrorMessage());
    }
}