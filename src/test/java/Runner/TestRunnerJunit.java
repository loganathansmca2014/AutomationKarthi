package Runner;


import Utility.GlobalLogic;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/Features/",
        glue={"StepDef"},
        tags = "@TC01",
        plugin = "json:target/cucumber.json",
        monochrome=true
)

public class TestRunnerJunit  {

    @After
    public void reportGenHTML()
    {
        GlobalLogic.reportGenerate();

    }
}
