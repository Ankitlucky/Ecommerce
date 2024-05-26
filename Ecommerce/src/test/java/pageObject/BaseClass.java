package pageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public static Logger logger;
	

	@BeforeClass
	public void openurl() {
		driver = new FirefoxDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger = LogManager.getLogger("Ecommerce");

	}

	@AfterClass
	public void afterTest() {
		driver.quit();

	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		// Capture screenshot
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define destination file path
		String destinationFile = System.getProperty("user.dir") + "//screenShot//" + testCaseName + ".png";

		// Copy screenshot to destination file
		FileUtils.copyFile(source, new File(destinationFile));

		// Return destination file path
		return destinationFile;
	}
}
