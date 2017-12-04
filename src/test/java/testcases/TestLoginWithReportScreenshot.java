package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.DynamicGraph.Status;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import utility.Helper;

public class TestLoginWithReportScreenshot extends BaseTest{

	@Test
	public void testLogin()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		
		home.testlogin(DataProviderFactory.getExcelDataProvider().getData(0, 1,0), DataProviderFactory.getExcelDataProvider().getData(0, 1, 1));
		
		home.verifyLogin();
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "screenshot")));
		logger.log(LogStatus.PASS, "testLogin Pass");
	}
	
	
	
}
