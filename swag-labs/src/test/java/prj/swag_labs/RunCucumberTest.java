package prj.swag_labs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"prj.swag_labs.steps"},
        plugin = {"pretty", "summary"}
)
public class RunCucumberTest {
}
