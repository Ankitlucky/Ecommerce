package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddandPayment{
	WebDriver driver;
	
	public AddandPayment(WebDriver driver) {
		
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//*[@id=\"group_1\"]")
WebElement dropdown;
@FindBy(xpath="//span[normalize-space()='Add to cart']")
WebElement scrolladdtocat;

@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
WebElement gettextaddtocart;//get method
@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
WebElement Proceedtocheckout;
@FindBy(xpath ="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
WebElement checkoutsignin;
@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
WebElement checkoutaddress;
@FindBy(xpath="//input[@id='cgv']")
WebElement tccheckbox;
@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
WebElement checkoutshipping;
@FindBy(xpath="//a[@title='Pay by bank wire']")
WebElement paybybank;
@FindBy(xpath="//span[normalize-space()='I confirm my order']")
WebElement confirmorder;
@FindBy(xpath = "//p[@class='alert alert-success']")
WebElement orderplaced; //get method

public void selectByValue(String value) {
    Select select = new Select(dropdown);
    select.selectByValue(value);

}
public void scrollcart()
{
	Actions actions=new Actions(driver);
	actions.moveToElement(scrolladdtocat).click().perform();
}
public void clikonaddtocart() {
	
	scrolladdtocat.click();
}

public String getTextAddToCart() throws InterruptedException {
	Thread.sleep(2000);
    String text = gettextaddtocart.getText();
    return text;
}





public void clickonProceedtocheckout() throws InterruptedException {
	Thread.sleep(2000);
	Proceedtocheckout.click();
}

public void clickoncheckoutsignin() throws InterruptedException {
	Thread.sleep(1000);
	checkoutsignin.click();
}

public void clickoncheckoutaddress() {
	checkoutaddress.click();
}

public void clickontccheckbox() {
	tccheckbox.click();
}

public void clickoncheckoutshipping() {
	checkoutshipping.click();
}

public void clickonConfirmorder() {
	confirmorder.click();
}


public void clickonpaybybank() {
	paybybank.click();
}

public String Getorderplacedtext() throws InterruptedException {
	Thread.sleep(1500);
	String text = orderplaced.getText();
	return text;
}

}
