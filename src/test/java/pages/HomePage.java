package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//input[@name='txtUsername']") WebElement username;
	@FindBy(xpath=".//input[@name='txtPassword']") WebElement Password;
	@FindBy(xpath="//input[@value='LOGIN']")WebElement login;
	
	By welcome=By.xpath(".//*[@id='welcome']");
	public void testlogin(String user,String pass)
	{
		username.sendKeys(user);
		Password.sendKeys(pass);
		login.click();
	}
	
	public void verifyLogin()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(welcome));
		Assert.assertEquals(ele.getText(),"Welcome Admin");
	}
}
