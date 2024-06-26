package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BaseClass;
import pageObject.LoginPage;
import pageObject.ProductPrice;
import pageObject.SearchProduct;

public class ProductPriceTestCases extends BaseClass {
	@Test
	public void TC_PPP_001_VerifyProductPrice() {
		logger.info("***************TestCase get text and price of Product Start*****************");

		try {
			LoginPage login = new LoginPage(driver);
			login.Clickonsignin();
			login.Srcollsign();
			login.EnterEmail("mares42294@javnoi.com");
			login.EnterPassword("password");
			login.ClickOnSignButton();
			SearchProduct search = new SearchProduct(driver);
			search.EntersearchProduct("Printed Chiffon Dress");
			logger.info("***************get product text *****************");
			search.ClickOnsearchButton();
			ProductPrice price = new ProductPrice(driver);
			price.ClickOnProduct();
			String actualtext = price.getProductprice();
			String expectedText = "$16";
			logger.info("*************** get price of Product ends*****************");
			System.out.println("Actual Text>>" + actualtext + "\n" + "Expected text>>" + expectedText + "\n");
			Assert.assertEquals(actualtext, expectedText);
			logger.info("***************TestCase get text and price of Product ends*****************");

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();
		}
	}
}
