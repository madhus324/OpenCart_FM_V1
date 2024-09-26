package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage
{
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(id = "input-firstname")
	WebElement txt_Firstname;
	
	@FindBy(id = "input-lastname")
	WebElement txt_Lastname;
	
	@FindBy(id = "input-email")
	WebElement txt_Email;
	
	@FindBy(id = "input-telephone")
	WebElement txt_Telephone;
	
	@FindBy(id = "input-password")
	WebElement txt_Password;
	
	@FindBy(xpath = "(//input[@id='input-confirm'])[1]")
	WebElement txt_CnfmPswd;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement Click_Agree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	WebElement Click_Yes_NewsLetter;
	
	@FindBy(xpath = "//div[@id='account-register']/div[1]")
	WebElement txt_Duplicate_Email_Warn;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement txt_Privacy_Policy;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txt_msgConfirmation;
	
	
	
	//Action_Methods
	
	public void set_FirstName(String fname)
	{
		txt_Firstname.sendKeys(fname);
	}
	
	public void set_LastName(String lname)
	{
		txt_Lastname.sendKeys(lname);
	}
	
	public void set_Email(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void set_Telephone(String telephone)
	{
		txt_Telephone.sendKeys(telephone);
	}
	
	public void set_Password(String pswd)
	{
		txt_Password.sendKeys(pswd);
	}
	
	public void set_ConfirmPassword(String cnfmPswd)
	{
		txt_CnfmPswd.sendKeys(cnfmPswd);
	}
	
	public void set_Subscribe()
	{
		Click_Agree.click();
	}
	
	public void click_PrivacyPolicy()
	{
		txt_Privacy_Policy.click();
	}
	
	public void click_Continue()
	{
		btn_Continue.click();
	}
	
	public String get_Confirmation_text()
	{
		try 
		{
			return (txt_msgConfirmation.getText());
		}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
		
	}

}
