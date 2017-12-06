package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utility.Helper;

public class Leave {
	
	@FindBy(xpath="//a[text()='Leave List']") WebElement LeaveList;
	@FindBy(xpath=".//*[@id='calFromDate']")WebElement fromDate;
	@FindBy(xpath=".//*[@id='calToDate']")WebElement toDate;
	@FindBy(xpath=".//*[@id='ui-datepicker-div']/div/div/select[1]") WebElement monthDropdown;
	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table")WebElement dateTable;
	@FindBy(xpath=".//*[@id='leaveList_chkSearchFilter_checkboxgroup']")WebElement leaveStatus;
	@FindBy(xpath=".//*[@id='btnSearch']") WebElement searchBtn;
	public void clickLeaveList(String from,String to)
	{
		try {
			LeaveList.click();
			Thread.sleep(2000);
			fromDate.click();
			Thread.sleep(2000);
			Select selfromMonth=new Select(monthDropdown);
			selfromMonth.selectByVisibleText("Feb");
			selectdate(from);
			Thread.sleep(2000);
			toDate.click();
			Thread.sleep(1000);
			Select selToMonth=new Select(monthDropdown);
			selToMonth.selectByVisibleText("Nov");
		selectdate(to);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectdate(String day)
	{
		Helper.selectdate(dateTable, day);
	}
	public void selectLeaveStatus(String text)
	{
		Helper.selectCheckBox(leaveStatus, text);
	}
	public void clickSearch()
	{
		Helper.clickButton(searchBtn);
	}

}

