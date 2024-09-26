package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")	
	WebElement click_MyAccount;
	
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement click_Register;
	
	@FindBy(xpath = "//h1[normalize-space()='Register Account']")
	WebElement txt_RegisterAccount;
	
	
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]") 
	WebElement link_login;
	
	
	
	//Action_Methods
	public void ClickMyAccount()
	{
		click_MyAccount.click();
	}
	
	public void ClickRegister()
	{
		click_Register.click();
	}
	
	public String get_RegisterAccount_text()
	{
		try 
		{
			return (txt_RegisterAccount.getText());
		}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
		
	}
	
	public void ClickLogin_Link()
	{
		link_login.click();
	}

}
