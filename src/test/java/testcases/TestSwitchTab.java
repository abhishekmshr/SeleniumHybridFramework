package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Tabs;
import utility.Helper;
import utility.Retry;

public class TestSwitchTab extends BaseTest {
	
	 Tabs tabs;
	@BeforeClass
	public void init()
	{
		//super.initBrowser();
		this.login();
		tabs=PageFactory.initElements(driver, Tabs.class);
	System.out.println(tabs.driver);
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void switchTab()
	{
		tabs.switchTab("Admin");
		logger.log(LogStatus.INFO,"Inside switchTab");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "screenshot")));
		
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void searchUser()
	{
		tabs.switchTab("Admin");
		tabs.searchUser("Admin", "Admin");
		logger.log(LogStatus.INFO,"Inside searchUser");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "searUser")));
		assertTrue(tabs.validateTable("Admin"));
	}
	

}
