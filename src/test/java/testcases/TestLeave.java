package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Leave;
import pages.Tabs;
import utility.Helper;

public class TestLeave extends BaseTest {
Leave leave;	
Tabs tab;
	@BeforeClass
	public void init()
	{
		//super.initBrowser();
		this.login();
		leave=PageFactory.initElements(driver, Leave.class);
		tab=PageFactory.initElements(driver, Tabs.class);
	
	}
	
	@Test
	public void testLeave()
	{
		
		try {tab.switchTab("Leave");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "testleave")));
			Thread.sleep(2000);
			leave.clickLeaveList("5","10");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "testleave1")));
			//leave.selectdate( "5");
			Thread.sleep(2000);
			leave.selectLeaveStatus("Cancelled");
			logger.log(LogStatus.INFO, "Cancelled Checkbox selected");
			Thread.sleep(2000);
			leave.clickSearch();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
