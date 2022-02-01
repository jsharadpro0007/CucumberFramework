package tests.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue ={"step_definitions"},
        plugin = {"pretty",
                "json:target/cucumber-report.json",
                "junit:target/output.xml",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        },
        monochrome = true,
        tags = "@test"


)


public class TestRunner {

}
