package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class TestLoginWithReport extends BaseTest {
/*WebDriver driver;
ExtentReports report;
ExtentTest logger;
	@BeforeMethod
	public void setup()
	{ report=new ExtentReports("./Reports/TestLogin.html", true);
	logger=report.startTest("LoginTest Started");
		driver=BrowserFactory.getBrowser("firefox");
	logger.log(LogStatus.PASS, "Driver Initialized");
		String URL=DataProviderFactory.getconfigDataProvider().getURL();
		driver.get(URL);
		logger.log(LogStatus.PASS, "Application Launched");
		
	}*/
	@Test
	public void testLogin()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		//driver.findElement(By.xpath(".//input[@name='txtUsername']")).sendKeys("Admin");
		//driver.findElement(By.xpath(".//input[@name='txtPassword']")).sendKeys("admin");
		
		home.testlogin(DataProviderFactory.getExcelDataProvider().getData(0, 1,0), DataProviderFactory.getExcelDataProvider().getData(0, 1, 1));
		
		home.verifyLogin();
		logger.log(LogStatus.PASS, "testLogin Pass");
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		BrowserFactory.killBrowser(driver);
		logger.log(LogStatus.INFO, "Driver Closed");
		report.endTest(logger);
		report.flush();
	}
	*/
}
