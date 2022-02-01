package step_definitions.appname;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import step_definitions.hooks.StepHooks;

public class Steps {
    private WebDriver driver;
    private LoginPage login;

    public Steps(StepHooks stepHooks)  {
        driver = stepHooks.getDriver();
        login = new LoginPage(driver);

    }

    @Given("I Login to the application")
    public void i_login_to_the_application() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("Successful");
//        throw new io.cucumber.java.PendingException();
    }

}
