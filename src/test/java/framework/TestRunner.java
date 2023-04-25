package framework;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","framework"},
        plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber-html-report"},
        tags = "~@Ignore"
)
public class TestRunner{

}
