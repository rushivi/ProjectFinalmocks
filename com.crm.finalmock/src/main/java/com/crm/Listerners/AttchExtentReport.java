package com.crm.Listerners;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DwsBase;

public class AttchExtentReport extends DwsBase implements ITestListener {
	public static File path = null;
	 public static ExtentSparkReporter spark = null;
	public static ExtentReports repot = null;
	 public static ExtentTest test = null;
	@Override
	public void onTestStart(ITestResult result) {
		String nmae = result.getMethod().getMethodName();
	  test = repot.createTest(nmae);
	  test.log(Status.INFO,nmae+ "is TestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String nmae = result.getMethod().getMethodName();
		test.log(Status.PASS,nmae+ "Is on TestSucces");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Is Fell");
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(':', '-');
		String nmae = result.getMethod().getMethodName();
		 TakesScreenshot ts = (TakesScreenshot) driver;
		   String form = ts.getScreenshotAs(OutputType.BASE64);
		 test.addScreenCaptureFromBase64String(form);
		
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String nmae = result.getMethod().getMethodName();
		test.log(Status.SKIP,nmae+"is skip");
	}

	@Override
	public void onStart(ITestContext context) {
		
		 	path = new File(".\\src\\test\\resources\\Report\\MultipalTestCase.html");
			//Create A ExtentSparkReport 
		 	spark = new ExtentSparkReporter(path);
			//Configure ExtentSparkReport
			spark.config().setDocumentTitle("DemoWebShop");
			spark.config().setReportName("Rushi Vidhate");
			spark.config().setTheme(Theme.DARK);
			//Create ExtentRepot
			 repot = new ExtentReports();
			//Provide System Information
			repot.setSystemInfo("OS", "Window-11");
			repot.setSystemInfo("Browser", "Chrome-11");
			//Attach the ExtentSparkReport to ExtentReport
			repot.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		
			repot.flush();
		 }
}
	