package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/
public class TC03_Login_DTT_Test extends BaseClass
{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")		// getting data provider from different class
	public void verify_Login_DTT(String e_mail,  String pswd, String exp) throws InterruptedException
	{
		logger.info("***Starting TC03 Verifying Login_DTT_Test******");
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin_Link();
			
			logger.info("***Login Page Opened for DTT******");
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.Enter_UserName(e_mail);
			lp.Enter_PassWord(pswd);
			lp.ClickLogin();
			
			logger.info("***Username & Password Entered and Clicked on Login for DTT******");
			
			//MyAccount Page
			MyAccount myAcc = new MyAccount(driver);
			boolean targetElement = myAcc.is_MyAccountHeading_exit();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if (targetElement == true)
				{
					myAcc.MyAcc_Logout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if (targetElement == true)
				{
					myAcc.MyAcc_Logout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
				
			}
		}
		catch (Exception e) 
		{
			Thread.sleep(2000);
			logger.info("***Finished TC03 Verifying Login_DTT_Test******");
			Assert.fail();
		}
	}

}
