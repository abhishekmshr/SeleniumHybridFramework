package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utility.Helper;

public class Tabs {
	public WebDriver driver;
	/*public Tabs(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}*/
	@FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']") WebElement tabAdmin;
	@FindBy(xpath=".//*[@id='menu_pim_viewPimModule']")WebElement tabPIM;
	@FindBy(xpath=".//*[@id='menu_leave_viewLeaveModule']")WebElement tabLeave;
	@FindBy(xpath=".//*[@id='searchSystemUser_userName']") WebElement searchUserName;
	@FindBy(xpath=".//*[@id='searchSystemUser_userType']")WebElement searchUserRole;
	@FindBy(xpath=".//*[@id='searchSystemUser_employeeName_empName']")WebElement searchEMPName;
	@FindBy(xpath=".//*[@id='searchSystemUser_status']")WebElement searchStatus;
	@FindBy(xpath=".//*[@id='searchBtn']")WebElement searchBtn;
	@FindBy(xpath="//table[@id='resultTable']") WebElement searchResult;
	
	
	public void switchTab(String tabname)
	{
		if (driver==null)
		{
			System.out.println("driver is not initialized");
		}
		else
		{
			System.out.println("Driver is initialized");
		}
		try {
			if(tabname.equalsIgnoreCase("Admin"))
			{
				
				System.out.println("Admin Tab is displayed "+tabAdmin.isDisplayed());
				tabAdmin.click();
			}
			else if(tabname.equalsIgnoreCase("PIM"))
			{
				tabPIM.click();
			}
			else if(tabname.equalsIgnoreCase("Leave"))
			{
				tabLeave.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public void searchUser(String UserName,String Role)
	{
		searchUserName.sendKeys(UserName);
		Select roleDrp=new Select(searchUserRole);
		roleDrp.selectByVisibleText(Role);
		searchBtn.click();
	}
	
	public Boolean validateTable(String Text )
	{
		Boolean found=Helper.verifyTable(driver, searchResult, Text);
		return found;
	};

}
