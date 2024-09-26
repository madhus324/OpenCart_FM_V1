package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import freemarker.log.Logger;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass
{
		
	@Test(priority = 1, groups = {"Regression", "Master"})
	public void Verify_Registration_Page()
	{
		logger.info("***Starting TC01 Registration Home Page******");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickRegister();
		logger.info("***Clicked on Registration Link******");
		Assert.assertEquals(hp.get_RegisterAccount_text(), "Register Account");
	}
	
	@Test(priority = 2, groups = {"Regression", "Master"})
	public void Verify_Account_Registration()
	{
		try 
		{
			logger.info("***Starting TC02 Registration******");
			AccountRegistration acc_Reg = new AccountRegistration(driver);
			logger.info("***Entering all the Mandatory fields Data******");
			acc_Reg.set_FirstName(randomeString().toUpperCase());
			acc_Reg.set_LastName(randomeString().toUpperCase());
			String username = randomeString()+"@gmail.com";
			System.out.println("Username :" + username);
			acc_Reg.set_Email(username);
			acc_Reg.set_Telephone(randomeNumber());
			String password = randomeAlphaNumber();
			System.out.println("Password :" + password);
			acc_Reg.set_Password(password);
			acc_Reg.set_ConfirmPassword(password);
			acc_Reg.set_Subscribe();
			acc_Reg.click_PrivacyPolicy();
			acc_Reg.click_Continue();
			logger.info("***Validating Expcted Message******");
			String confirm_msg = acc_Reg.get_Confirmation_text();
			if (confirm_msg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				
				logger.error("Test Failed");
				logger.debug("Debug Logs...");
				Assert.assertTrue(false);
			}

		}
		catch (Exception e) 
		{
						
			Assert.fail();
		}
		logger.info("***Test Case Finished******");
	}
	
}
