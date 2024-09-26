package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="(//input[@id='input-email'])[1]")
	WebElement txt_userName;
	
	@FindBy(xpath="(//input[@id='input-password'])[1]")
	WebElement txt_passWord;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement btn_login;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") 
	WebElement btn_logout;
	
	
	
	
	//Action_Methods
		
	public void Enter_UserName(String un)
	{
		txt_userName.clear();
		txt_userName.sendKeys(un);
	}
	
	public void Enter_PassWord(String pwd)
	{
		txt_passWord.clear();
		txt_passWord.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btn_login.click();
	}
	
	

}
