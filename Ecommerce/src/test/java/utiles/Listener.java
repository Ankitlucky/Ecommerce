package utiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObject.BaseClass;

public class Listener extends BaseClass implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReport.getReporterObject();
    WebDriver driver;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        // Get the WebDriver instance from the test class
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Take screenshot and attach to report
        try {
            test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver),
                    result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        // Test skipped logic if needed
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Test failed but within success percentage logic if needed
    }

  
    public void onStart(ITestContext context) {
        // Test suite start logic if needed
    }


    public void onFinish(ITestContext context) {
        // Flush ExtentReports instance
        extent.flush();
    }
}
