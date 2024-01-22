package StepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObjects.AddNewCustomer;
import PageObjects.DiscountPage;
import PageObjects.LoginPage;


public class BaseClass {
	
	public  LoginPage lpg; 
	public AddNewCustomer adc;
    public DiscountPage dsc;
    public WebDriver driver;
    public static ExtentReports  report;
    public static ExtentTest test;
   public ExtentSparkReporter sparkreport;
	public String Report_path="C:\\Users\\91869\\eclipse-workspace\\Cucumber.bdd\\ExecutionReports";

    
		//public String chrome_path="C:\\Users\\91869\\eclipse-workspace\\Chromedriver\\chromedriver.exe";
		//public String edge_path="C:\\Users\\91869\\eclipse-workspace\\Chromedriver\\msedgedriver.exe";
    //create extent report
    public void CreateExtentReport(String Report_path)
    {
   	// create Report folder
    	Date d= new Date();
    	String spath= d.toString().substring(0);
		System.out.println(spath);
		String newPath=spath.replace(":", "_").replace(" ", "_");
		System.out.println(newPath);
		String newReportPath=Report_path+"\\"+newPath;
		System.out.println(newReportPath);
		File file= new File(newReportPath);
		System.out.println("file creted");
		file.mkdir();	
     
		 report = new ExtentReports();
		 sparkreport = new ExtentSparkReporter(file+"\\Spark.html");
		 report.attachReporter(sparkreport);
		System.out.println("report attach  creted");
		test= report.createTest("MyFirstTest");
		System.out.println(" my first  creted");

    	//create Spark extent report folder created above
		//report = new ExtentReports();
		//test=report.createTest(file);
		//sparkreport= new ExtentSparkReporter(file+"//spark.html");
    	//sparkreport.config().setTheme(Theme.DARK);
    	//sparkreport.config().setDocumentTitle("Testing Regression Execution");
    //	report.attachReporter(sparkreport); 	
    }
    
    
   /* public static String getFeatureNameFromScenario(Scenario scenario) {
    	String[] test = scenario.getUri().toString().split("/");
    	String[] longFeatureName = test[test.length - 1].split("\.");
    	return longFeatureName[0];
    	}
*/
    //test pass log for steps 
    @SuppressWarnings("static-access")
	public void logPass(String msg)
    {
    	test.log(Status.INFO.PASS, msg);
    }
    
    
    //test pass log for steps 
    @SuppressWarnings("static-access")
	public void logFail(String msg)
    {
    	test.log(Status.INFO.FAIL, msg);
    }

    //create word file will have all screenshot
    
    
    public void Desktop_Screenshot(String sFeaturefile) throws IOException
    {
    	
    	File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	File destination_path= new File("src/../ExecutionReports/Screenshot"+sFeaturefile+System.currentTimeMillis()+".png");
    	FileUtils.copyFile(srcfile, destination_path);
    }

	
	
    // method to read a json key avlue frpma ajson file  
   /* public String getValueFromJson(String featurefile, String sKey) throws IOException, ParseException
    { 	   	
    	String value = null;
    			//json parser object
    			JSONParser parser= new JSONParser();
    			//read json file
    			try(java.io.FileReader f= new java.io.FileReader(".//Jsonfiles//"+featurefile+".Json"))
    			{
    			   Object obj= parser.parse(f);	
    			   JSONObject jsonobj= (JSONObject) obj;
    			    value= (String) jsonobj.get(sKey);
    		     } 
    			catch(FileNotFoundException e) {
    				e.printStackTrace();
    				}
    			return value;		    	
    }*/
    

    
}
