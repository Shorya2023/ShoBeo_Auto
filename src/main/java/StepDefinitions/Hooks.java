package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass  {
	Hooks hk;
	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario***************");
        if (hk== null);
        {
        hk = new Hooks();
        }
        
        hk.CreateExtentReport(Report_path);


	}	
	
	@After
    public void afterScenario(){
		//report.flush();
		 report.flush();
		
        System.out.println("This will run after the Scenario****************8");
    }

}
