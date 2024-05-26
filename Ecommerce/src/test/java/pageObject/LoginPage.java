package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BaseClass {
 WebDriver driver;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;  
        PageFactory.initElements(driver, this);
    }
	// identify element 
	@FindBy(className ="login") 
	 WebElement signin;
	 
	@FindBy(name="email")
	 WebElement email;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(xpath ="//span[normalize-space()='Sign in']")
	WebElement submit;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/h3")
	WebElement scroll;
	 
	@FindBy(xpath="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
	WebElement username;
	
	@FindBy(xpath= "//a[@title='Log me out']")
	WebElement signOut;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div[1]")
	WebElement errorMsg;
	
	
	
	public void Clickonsignin(){
signin.click();
	}
	public void Srcollsign()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(scroll).click().perform();
	}
	
	public void EnterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void EnterPassword(String paswd) {
		password.sendKeys(paswd);
		
	}
	public void ClickOnSignButton() {
		submit.click();
	}
	public void ClickOnSignout() {
		signOut.click();
	}
	
	public String getUserName()
	{
		String text = username.getText();

		return text;
	}

	public String getloginerrormsg()
	{
		String text = errorMsg.getText();

		return text;
	}

	public String getPageTitle()
	{
		return(driver.getTitle());
	}
}

