package utiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports extent;

	public static ExtentReports getReporterObject() {

		// ExtentReports , ExtentSparkReporter

		String path = System.getProperty("user.dir") + "//reports//EcommerceTestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("EcommerceTestReport");
		reporter.config().setDocumentTitle("Automation Test Result Report");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("dd/MM/yyyy_HH:mm:ss");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("User Name", "Ankit Gupta");
		extent.setSystemInfo("Team", "Automation QA Team");
		

		return extent;
	}
}