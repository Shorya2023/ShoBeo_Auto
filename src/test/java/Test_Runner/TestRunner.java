package Test_Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


// Below imports enables , when packs needs to run in parallel
//import org.testng.annotations.DataProvider;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="C:\\Users\\91869\\eclipse-workspace\\Cucumber.bdd\\Features",
		glue="StepDefinitions",
		monochrome=true,
		dryRun=false,
		plugin={"pretty","html:test-output"},
		tags = "@production"
)


public class TestRunner  {

}


/*public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
public Object[][] scenarios()
{
			return super.scenarios();
			
}
	


}*/
