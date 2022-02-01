package step_definitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import logger.Log;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import static constants.AutomationConstants.IS_STEP_SCREENSHOT;

public class StepHooks {
    private WebDriver driver;

    @Before
    public void launch(Scenario scenario) throws MalformedURLException{
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9\\.\\-]","_");
        Log.info("Starting "+ scenarioName+ " Scenario...");
        driver = DriverFactory.setupDriver(scenario.getName());
        System.out.println("driver initiated");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

    }

    @AfterStep
    public void addScreenShot(Scenario scenario)
    {
        if(IS_STEP_SCREENSHOT)
        {
            final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","image");
        }
    }

    @After
    public void teardown(Scenario scenario) throws IOException{
        if(driver!=null)
        {
            if(scenario.isFailed()){
                try{
                    byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot,"image/png","failure screenshot");

                }catch (Exception ignored){}
            }
        }
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
