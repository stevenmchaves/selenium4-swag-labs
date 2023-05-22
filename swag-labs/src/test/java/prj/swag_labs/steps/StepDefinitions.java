package prj.swag_labs.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriverException;
import prj.swag_labs.app.webdriver.WebDriverUtils;

import java.io.File;

/**
 *  Used this class for Uniform type of actions no matter what the scenario was.
 */
public class StepDefinitions {

    @After
    public void screenShot(Scenario scenario) throws Throwable {
        if (scenario.isFailed()) {
            final File screenshot = WebDriverUtils.takeScreenshot();
            FileUtils.copyFileToDirectory(screenshot, new File("output/" + scenario.getId()));
        }
    }

    @AfterAll
    public static void after_all() throws Throwable {
        WebDriverUtils.quit();
    }
}