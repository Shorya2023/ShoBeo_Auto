package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import PageObjects.AddNewCustomer;
import PageObjects.DiscountPage;
//import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class steps extends BaseClass  {
	
@Given("User launch to to chrpme browser")
public void user_launch_to_to_chrpme_browser() {
		driver= new ChromeDriver();	
		lpg = new LoginPage(driver);
 		adc = new AddNewCustomer(driver);
 		dsc = new DiscountPage(driver);
 	//	//lgr = org.apache.log4j.Logger.getLogger("nocom");
 	//	PropertyConfigurator.configure("Log4j.properties");
//	System.setProperty("webdriver.chrome.driver",chrome_path);
	System.out.println("open chrome.........");	
	//lgr.info("launching URL");
}

@When("User Open URL {string}")
public void user_open_url(String url) {
	System.out.println("URL is opening up");
	driver.get(url);
	logPass("URL passed succefully"+url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	//lgr.info(" URL launched successfully");

}

@And("User enter valid username {string} and password {string}")
public void user_enter_valid_username_and_password(String username, String password) {
	lpg.username_enter(username);
     lpg.password_enter(password);
 	logPass("User name and password enterd successfully");

     //lgr.info("credentials entered");
}

@When("User click on Login")
public void user_click_on_login() {
	
    lpg.Click_Login();
 	logPass("Login button clicked");

    //lgr.info("login button clicked");

}

@Then("User able to login successfully and verify home page title {string}")
public void user_able_to_login_successfully_and_verify_home_page_title(String pagetitle) throws InterruptedException {
	if (pagetitle.equalsIgnoreCase(driver.getTitle()))
	{
	  System.out.println("verifying title"+ pagetitle);
	 	logPass("Logged in home page title exists-"+pagetitle);

	}
	Thread.sleep(3000);
	//lgr.info("logged in successfully");
}


@When("User clicks on customer Menu")
public void user_clicks_on_customer_menu() throws InterruptedException {
	adc.clickcustomer();
 	logPass("Customer button clicked");

	Thread.sleep(3000);

}

@When("Click on customer Menu Item")
public void click_on_customer_menu_item() {
	adc.clickcustomersubmenu();
 	logPass("Customer submenu clicked");

}

@When("Click on Add new customer")
public void click_on_add_new_customer() {
	adc.Addcustomer();
	logPass("add new customer clicked");

	//lgr.info("adding new customer");
	
}

@Then("User can see customer page")
public void user_can_see_customer_page() {
	adc.customerdetialsexists();
	logPass("customer details exists");

}

@When("User enter customer informaton")
public void user_enter_customer_informaton() throws InterruptedException {
  adc.Customer_information();   
  //lgr.info("new customer detiails entered");
	logPass("customer information entered successfully");

}

@When("User click on save button")
public void user_click_on_save_button() throws InterruptedException {
  adc.save();
	logPass("save button clicked");

  Thread.sleep(3000);
}

@Then("User can see confirmation message {string}")
public void user_can_see_confirmation_message(String string) {
adc.confirmmessage();
logPass("confirmation info saved succesfully");

//lgr.info("customer addedd successfully");
}


//c=discount feature file

@When("User clicks on discount menu")
public void user_clicks_on_discount_menu() throws InterruptedException {
	dsc.clickPromotions();
}

@Then("User able to see discount fields")
public void user_able_to_see_discount_fields() {
	dsc.pagedetails();
}

@When("Select todays date as start date")
public void select_todays_date_as_start_date() {
	dsc.startdate();
}

@When("User cliks on Search")
public void user_cliks_on_search() {
	dsc.Searchbtn();
}

@Then("verify the discount is present")
public void verify_the_discount_is_present() {
	
	WebElement discountvalue=driver.findElement(By.xpath("//table[@id='discounts-grid']//tr[1]//td[3]"));
	       String  discvalue= (discountvalue.getText());
	       if (discvalue.contentEquals("discvalue"));
	       {
	    	   System.out.println("discount exists");
	       }
}

@When("Select todays date as Enddate as {string} date")
public void select_todays_date_as_enddate_as_date(String string) {
	dsc.enddate();
	
}


@Then("Close the browser")
public void close_browser() {
	driver.close();;
}

}
