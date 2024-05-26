package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BaseClass;
import pageObject.LoginPage;

public class LoginTestCases extends BaseClass {

	@Test(priority = -1)
	public void TC_LF_001_VerifyLoginWithValidCredentials() {

		logger.info("***************TestCase Verify Login starts*****************");

		try {
			LoginPage login = new LoginPage(driver);
			login.Clickonsignin();
			logger.info("Clicked on sign");
			login.Srcollsign();
			login.EnterEmail("mares42294@javnoi.com");
			login.EnterPassword("password");
			login.ClickOnSignButton();
			String actualtext = login.getUserName();
			String expectedErrText = "Ankit Gupta";
			System.out
					.println("ActualError Text -" + actualtext + "\n" + "expected Err Text -" + expectedErrText + "\n");
			Assert.assertEquals(actualtext, expectedErrText);
			System.out.println(">>>>>>> Login Successfully <<<<<<");
			login.ClickOnSignout();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
		logger.info("***************TestCase Verify Login ends*****************");
	}

	@Test(priority = 0)
	public void TC_LF_002_VerifyLoginWithInvalidCredentials() {
		logger.info("***************TestCase Verify Login with Invalid Credentials start *****************");
		try {
			LoginPage login = new LoginPage(driver);
			login.Clickonsignin();
			login.Srcollsign();
			login.EnterEmail("mares42294@javnoi.com");
			login.EnterPassword("passwordSS");
			login.ClickOnSignButton();
			String actualtext = login.getloginerrormsg();
			String expectedErrText = "There is 1 error\nAuthentication failed.";
			System.out
					.println("ActualError Text -" + actualtext + "\n" + "expected Err Text -" + expectedErrText + "\n");
			Assert.assertEquals(actualtext, expectedErrText);
			System.out.println(">>>>>>> Unable to login <<<<<<");
			logger.info("***************TestCase Verify Login with Invalid Credentials ends*****************");
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void TC_LF_003_VerifySignOut() {
		logger.info("***************TestCase Verify Sign out starts*****************");
		try {
			LoginPage login = new LoginPage(driver);
			login.Clickonsignin();
			login.Srcollsign();
			login.EnterEmail("mares42294@javnoi.com");
			login.EnterPassword("password");
			login.ClickOnSignButton();
			login.ClickOnSignout();

			if (login.getPageTitle().equals("Login - My Shop")) {
				logger.info("VerifySignOut - Passed");
				Assert.assertTrue(true);
			}

			else {
				logger.info("VerifySignOut - Failed");
				getScreenshotPath("VerifySignOut", driver);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
		logger.info("***************TestCase Verify Sign out ends*****************");
	}

}
