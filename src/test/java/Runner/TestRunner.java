package Runner;


import Utility.GlobalLogic;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.After;
import org.testng.annotations.AfterSuite;

@CucumberOptions(

        features = "src/test/resources/Features/",
        glue={"StepDef","Utility"},
        tags = "@TC01",
        plugin = {"json:target/cucumber.json"},
        monochrome=true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void reportGenHTML()
    {
        GlobalLogic.reportGenerate();

    }
}
