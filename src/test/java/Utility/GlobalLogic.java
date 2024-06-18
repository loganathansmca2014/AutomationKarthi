package Utility;




import StepDef.AccountCreation;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GlobalLogic {
    public  static  WebDriver driver;
    public static GlobalLogic INSTANCE = new GlobalLogic();
    public static Scenario scenario;
    public static String URsL;
    public static String Username;
    public static String Password;

    @Before
    public void beforeScripts(Scenario scenario)
    {
        this.scenario = scenario;
    }

    @After
    public void teardown() {

        driver.close();
        driver.quit();
    }


    public static void takescreenshot() {
        if (scenario != null & !scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) GlobalLogic.getInstance().driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","Scrennshot");
        }

    }

    public static void BrowserOpen() throws IOException {
        propertiesLoad();
       WebDriverManager.chromedriver().setup();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.get(URsL);

    }
public static void propertiesLoad() throws IOException {
    Properties prop=new Properties();
    String filename="src/test/resources/Browser.properities";
    //est.class.getClassLoader().getResourceAsStream(filename);
    prop.load(new FileInputStream(filename));
    URsL=prop.getProperty("URL");
    Username=prop.getProperty("userName");
    Password=prop.getProperty("password");
}

    public static void reportGenerate()
    {

        File reportOutputDirectory = new File("reports");
        List<String> jsonFiles = new ArrayList<>();

        jsonFiles.add("target/cucumber.json");
        String buildNumber = "1";
        String projectName = "Karthika POC";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Environement", GlobalLogic.URsL);
        configuration.addClassifications("Branch", "release/1.0");


        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
        Reportable result=reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed
    }

    public WebDriver getDriver() {
        return driver;
    }


    public static GlobalLogic getInstance() {
        return INSTANCE;
    }

}
