package testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddandPayment;
import pageObject.BaseClass;
import pageObject.LoginPage;
import pageObject.ProductPrice;
import pageObject.SearchProduct;

public class AddandPaymentTestCases extends BaseClass {

	@Test
	public void VerifyBuyProduct() {
		logger.info("\n***************TestCase Buy Product started*****************");

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			AddandPayment addpayment = new AddandPayment(driver);
			LoginPage login = new LoginPage(driver);
			login.Clickonsignin();
			login.Srcollsign();
			login.EnterEmail("mares44294@javnoi.com");
			login.EnterPassword("password");
			logger.info("User Email and Password entered.");
			login.ClickOnSignButton();
			SearchProduct search = new SearchProduct(driver);
			logger.info("Printed Chiffon Dress entered in search box");
			search.EntersearchProduct("Printed Chiffon Dress");
			search.ClickOnsearchButton();
			ProductPrice price = new ProductPrice(driver);
			price.ClickOnProduct();
			addpayment.selectByValue("3");
			logger.info("size L selected");
			addpayment.clikonaddtocart();
			logger.info("Clicked on add to cart");
			String actualtext = addpayment.getTextAddToCart();
			logger.info("Clicked on proceed to checkout on product page");
			String expectedErrText = "Product successfully added to your shopping cart";
			System.out.println("Actual Text -" + actualtext + "\n" + "Expected Text -" + expectedErrText + "\n");
			Assert.assertEquals(actualtext, expectedErrText);
			logger.info("Product successfully added to your shopping cart");
			addpayment.clickonProceedtocheckout();
			logger.info("Clicked on proceed to checkout page");
			addpayment.clickoncheckoutsignin();
			logger.info("Clicked on proceed to checkout on signin page");
			addpayment.clickoncheckoutaddress();
			logger.info("Clicked on proceed to checkout on order address page");
			addpayment.clickontccheckbox();
			logger.info("selecged term of service check box");
			addpayment.clickoncheckoutshipping();
			logger.info("Clicked on proceed to checkout on order shipping page");
			addpayment.clickonpaybybank();
			logger.info("Clicked on pay by cheque");
			addpayment.clickonConfirmorder();
			String actualtexts = addpayment.Getorderplacedtext();
			String expectedTexts = "Your order on My Shop is complete.";
			System.out
					.println("ActualError Text -" + actualtexts + "\n" + "expected Err Text -" + expectedTexts + "\n");
			Assert.assertEquals(actualtexts, expectedTexts);
			logger.info("Clicked on confirmed order");
			login.ClickOnSignout();
		} catch (Exception e) {
			e.printStackTrace();
			// Handle any exceptions here
		}
		logger.info("***************TestCase BuyProduct ends*****************");

	}

	@Test()
	public void VerifyAddToWishlistWithoutLogin() throws IOException {
		try {
			AddandPayment addpayment = new AddandPayment(driver);
			LoginPage login = new LoginPage(driver);
			SearchProduct search = new SearchProduct(driver);
			logger.info("Printed Chiffon Dress entered in search box");
			search.EntersearchProduct("Printed Chiffon Dress");
			search.ClickOnsearchButton();
			ProductPrice price = new ProductPrice(driver);
			price.ClickOnProduct();
			addpayment.selectByValue("3");
			logger.info("size L selected");
			addpayment.clikonaddtocart();
			logger.info("Clicked on add to cart");
			
			addpayment.clickonProceedtocheckout();
			
			addpayment.clickoncheckoutsignin();
			
			if (login.getPageTitle().equals("Login - My Shop")) {
				logger.info("verifyAddToWishlistWithoutLogin - passed");
				Assert.assertTrue(true);
			}

			else {
				logger.info("verifyAddToWishlistWithoutLogin - failed");
				getScreenshotPath("verifyAddToWishlistWithoutLogin", driver);
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}

	}
}