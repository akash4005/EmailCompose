package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.FindBy;

@RunWith(Cucumber.class)
@CucumberOptions(

features = {"FeatureFile//Email.feature"},
        glue = {"StepDefination"},
dryRun = false

)
public class Testrunner {
}
