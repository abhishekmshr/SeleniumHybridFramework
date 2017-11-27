package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class TestLogin {
WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=BrowserFactory.getBrowser("firefox");
		String URL=DataProviderFactory.getconfigDataProvider().getURL();
		driver.get(URL);
		
	}
	@Test
	public void testLogin()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		//driver.findElement(By.xpath(".//input[@name='txtUsername']")).sendKeys("Admin");
		//driver.findElement(By.xpath(".//input[@name='txtPassword']")).sendKeys("admin");
		
		home.testlogin(DataProviderFactory.getExcelDataProvider().getData(0, 1,0), DataProviderFactory.getExcelDataProvider().getData(0, 1, 1));
		
		home.verifyLogin();	
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.killBrowser(driver);
	}
	
}
