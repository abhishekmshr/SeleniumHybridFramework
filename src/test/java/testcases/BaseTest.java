package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.Helper;

public class BaseTest {
public static WebDriver driver;
public static ExtentReports report;
public static ExtentTest logger;
@BeforeSuite
public void setup()
{
	
	report=new ExtentReports("./Reports/TestLogin.html", true);
	
	
	
	
}
@BeforeClass
public void initBrowser()
{
	driver=BrowserFactory.getBrowser("firefox");
	String URL=DataProviderFactory.getconfigDataProvider().getURL();
	driver.get(URL);
	logger=report.startTest(getClass().getName());
	logger.log(LogStatus.PASS, "Application Launched");
	
}

@AfterSuite
public void tearDown()
{
	logger.log(LogStatus.INFO, "Killing the driver");
	//BrowserFactory.killBrowser(driver);
	logger.log(LogStatus.INFO, "Suite Execution completed");
	report.endTest(logger);
	report.flush();
	
	
}
@AfterClass
public void closeBrowser()
{
	BrowserFactory.killBrowser(driver);
	logger.log(LogStatus.INFO, "Driver Closed");
	driver=null;
	report.endTest(logger);
	report.flush();
}
@AfterMethod
public void cleanup(ITestResult res)
{
	
	if (res.getStatus()==ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.captureScreenshot(driver, res.getName())));
	}
	//report.endTest(logger);
	//report.flush();
}

}
