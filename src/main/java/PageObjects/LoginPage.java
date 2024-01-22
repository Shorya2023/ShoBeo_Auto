package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	
	public WebDriver localdriver;
	
	public LoginPage(WebDriver rdriver)
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(id= "Email")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(id= "Password")
	@CacheLookup
	WebElement password;
	

	@FindBy(xpath= "//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement Login_btn;
	
	
	public void username_enter(String sname)
	{
		username.clear();
		username.sendKeys(sname);		
	}
	
	
	public void password_enter(String spassword)
	{
		password.clear();
		password.sendKeys(spassword);
		
	}
	
	
	public void Click_Login()
	{
		
		if (Login_btn.isEnabled())
		{
		Login_btn.click();
		}
		else
		{
			System.out.println("login button is disabled");
		}
		
	}
	
	
	

	
	
	
	
	
	

}
