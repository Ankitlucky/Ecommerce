package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BaseClass;
import pageObject.LoginPage;
import pageObject.SearchProduct;

public class SearchTestCase extends BaseClass {

	@Test
	public void VerifySearchProduct() {
		logger.info("\n***************TestCase Search Product started*****************"); 
		
		try{
			LoginPage login = new LoginPage(driver);
		
		login.Clickonsignin();
		login.Srcollsign();
		login.EnterEmail("mares44294@javnoi.com");
		login.EnterPassword("password");
		logger.info("User Email and Password entered.");
		login.ClickOnSignButton();
		
		SearchProduct search = new SearchProduct(driver);
		search.EntersearchProduct("Printed Chiffon Dress");
		search.ClickOnsearchButton();
		String actualtext = search.getproductname();
		String expectedErrText ="Printed Chiffon Dress";
		System.out.println("ActualError Text -"+ actualtext +"\n" +"expected Err Text -"+expectedErrText+"\n");
		Assert.assertEquals(actualtext,expectedErrText);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
			
		}
		logger.info("***************TestCase Search Product ends*****************"); 
	}
}
