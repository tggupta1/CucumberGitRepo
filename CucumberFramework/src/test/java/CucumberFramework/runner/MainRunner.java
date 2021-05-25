package CucumberFramework.runner;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(
		features= {"src/test/java/CucumberFramework/featureFiles/Login.feature"},
		glue= {"CucumberFramework.steps"},
		monochrome=true,
		tags={},
	//	plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
		plugin= {"pretty","html:target/cucumber-reports","json:target/cucumber-reports.json","junit:target/cucumber-reports/Cucumber.xml"}
		)

public class MainRunner extends AbstractTestNGCucumberTests
{

	
	
}
