package api.utilities;


import java.text.SimpleDateFormat;

import org.apache.tools.ant.types.resources.comparators.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());//timeStamp
		repName="Test-Report-"+timeStamp+".html";

		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report

		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
		sparkReporter.config().setReportName("pet Store user API");
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet store user Api");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "pavan");
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS,"Test Passed");
	}

	public void onTestFailure1(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onFinish(ITestContext testContext)
	{
		//without flush() it will not generate the report
		extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


}
