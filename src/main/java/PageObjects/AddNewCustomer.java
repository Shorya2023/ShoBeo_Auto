package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
public WebDriver localdriver;

   public AddNewCustomer(WebDriver rdriver)
   {
	   localdriver=rdriver;
	   PageFactory.initElements(rdriver,this);   
	   
   }
   
By link_customer= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
By link_customer_subitem= By.xpath("//a[@href='/Admin/Customer/List']//p");
By Addcustomer = By.xpath("//a[@href='/Admin/Customer/Create']");
By Email = By.id("Email");
By Firstname = By.id("FirstName");
By Lastname = By.id("LastName");
By password = By.id("Password");
By Gender_maleradio = By.id("Gender_Male");
By Gender_Femaleradio = By.id("Gender_Female");
By DateOfBirth = By.id("DateOfBirth");
By Company = By.id("Company");
By CustRoles_list = By.xpath("//input[@aria-labelledby='SelectedCustomerRoleIds_label']");
By news_list_dropdwn = By.xpath("//input[@aria-labelledby='SelectedNewsletterSubscriptionStoreIds_label']");
By admincomment = By.id("AdminComment");
By Savebtn = By.name("save");
By confrmsg = By.xpath("//div[@class='alert alert-success alert-dismissable']");

public void clickcustomer()
{
	localdriver.findElement(link_customer).click();	

}

public void clickcustomersubmenu()
{
	localdriver.findElement(link_customer_subitem).click();	

}

public void Addcustomer()
{
	localdriver.findElement(Addcustomer).click();
}

public void customerdetialsexists()
{
	WebElement f =localdriver.findElement(Firstname);
	   if (f.isEnabled()) {
		   System.out.println("fields exist");

	   }

}

public void Customer_information() throws InterruptedException
{
	localdriver.findElement(Email).sendKeys("ab122c@num.com");
	Thread.sleep(1000);
	localdriver.findElement(Firstname).sendKeys("new");	
	Thread.sleep(1000);
	localdriver.findElement(Lastname).sendKeys("xyz");
	Thread.sleep(1000);
	localdriver.findElement(password).sendKeys("welcome1234");
	Thread.sleep(1000);
	localdriver.findElement(Gender_maleradio).click();
	Thread.sleep(1000);
	localdriver.findElement(DateOfBirth).sendKeys("10/7/2023");
	Thread.sleep(1000);
	localdriver.findElement(Company).sendKeys("Newgenelectricals");
	Thread.sleep(1000);
	/*WebElement drp=localdriver.findElement(news_list_dropdwn);
	Thread.sleep(1000);
	Select s= new Select(drp);
	s.selectByIndex(2);
	localdriver.findElement(CustRoles_list).click();
	Thread.sleep(1000);*/
	localdriver.findElement(admincomment).sendKeys("info entered");
	Thread.sleep(1000);


	
}

public void save()
{
	localdriver.findElement(Savebtn).click();	

}

public void confirmmessage()
{
	String msg =localdriver.findElement(confrmsg).getText();
	System.out.println(msg);

}



}
