package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DiscountPage {

	public WebDriver localdriver;
	public DiscountPage(WebDriver rdriver)
	{
		localdriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	
	By link_Promotion= By.xpath("//a[@href='#']//p[contains(text(),'Promotion')]");
	By link_Discount_subitem= By.xpath("//a[@href='/Admin/Discount/List']//p");
	By startdatebtn= By.xpath("//span[@aria-controls='SearchStartDate_dateview']");
	By enddatebtn= By.xpath("//span[@aria-controls='SearchEndDate_dateview']");
	By coupon_code=By.id("SearchDiscountCouponCode");
	By Discountname=By.id("SearchDiscountName");
	By startdateinput= By.id("SearchStartDate");
	By enddateinput= By.id("SearchEndDate");
	By searchdiscountsttn= By.id("search-discounts");

	

	
	public void clickPromotions() throws InterruptedException
	{
		localdriver.findElement(link_Promotion).click();;
		Thread.sleep(4000);
		localdriver.findElement(link_Discount_subitem).click();

	}
	
     
	public void pagedetails()
	{
		WebElement wb = localdriver.findElement(startdateinput);
		if (wb.isDisplayed())
		{System.out.println("page details displayed");}
	}
 
	public void startdate()
	{
		localdriver.findElement(startdateinput).sendKeys("12/12/2023");;	
	}

	public void enddate()
	{
		localdriver.findElement(enddateinput).sendKeys("30/12/224");;	
	}

	public void Searchbtn()
	{
		localdriver.findElement(searchdiscountsttn).click();;	
	}
	
	
	
}
