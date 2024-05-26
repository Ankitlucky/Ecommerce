package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPrice {
	WebDriver driver;

	public ProductPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
	WebElement clickproduct;

	@FindBy(xpath = "//*[@id=\"our_price_display\"]")
	WebElement getprice;

	public void ClickOnProduct() throws InterruptedException {
		Thread.sleep(2000);
		clickproduct.click();
	}

	public String getProductprice() {
		String text = getprice.getText();

		return text;
	}

}
