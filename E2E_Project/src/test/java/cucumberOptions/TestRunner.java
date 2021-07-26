package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)   //commented as it is for JUnit
@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	/*For integrating cucumber with testNG then you need to do below things   (by passes junit for running tests)
		1. Comment out the @RunWith(Cucumber.class) on top
		2. Add interface features by adding extends keywords next TestRunner class as shown above and import the file
		
	*/

}
