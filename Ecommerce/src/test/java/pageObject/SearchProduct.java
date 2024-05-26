package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_query")
	WebElement search;

	@FindBy(name = "submit_search")
	WebElement submitsearch;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")
	WebElement searchProductName;

	public void EntersearchProduct(String product) {
		search.sendKeys(product);

	}

	public void ClickOnsearchButton() {
		submitsearch.click();
	}

	public String getproductname() {
		String text = searchProductName.getText();
		return text;
	}
}
