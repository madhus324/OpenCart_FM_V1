package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage
{
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath ="(//h2[normalize-space()='My Account'])[1]")
	WebElement txt_myAccountHeading;
	
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]") 
	WebElement btn_logout;
	
	
	//Action_Methods
	
	public boolean is_MyAccountHeading_exit()
	{
		try 
		{
			return (txt_myAccountHeading.isDisplayed());
		}
		catch (Exception e) 
		{
			return false;
		}
		
	}

	public void MyAcc_Logout()
	{
		btn_logout.click();
	}
}
