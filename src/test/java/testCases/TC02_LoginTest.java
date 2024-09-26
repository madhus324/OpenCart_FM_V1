package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass
{
	@Test(groups = {"Sanity", "Master"})
	public void verify_Login()
	{
		logger.info("***Starting TC02 Verifying Login Page******");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin_Link();
			
			logger.info("***Login Page Opened******");
			
			LoginPage lp = new LoginPage(driver);
			lp.Enter_UserName(p.getProperty("email"));
			lp.Enter_PassWord(p.getProperty("password"));
			lp.ClickLogin();
			
			logger.info("***Username & Password Entered and Clicked on Login******");
			
			MyAccount myAcc = new MyAccount(driver);
			boolean targetElement = myAcc.is_MyAccountHeading_exit();
			
			Assert.assertTrue(targetElement);   				//Assert.assertEquals(targetElement, true);
						
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		logger.info("***Finished TC02 Verifying Login Page******");
	}

}
