package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver,String testcasename) {
	TakesScreenshot ts =(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File Dest=new File("./Screenshots/"+testcasename+".png");
	try {
		FileUtils.copyFile(src,Dest );
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Dest.toURI().toString();

		
	}
	
	public static Boolean verifyTable(WebDriver driver,WebElement table,String text)
	{
		List<WebElement> tablerows=table.findElements(By.tagName("tr"));
		for(int i=0;i<tablerows.size();i++)
		{
			WebElement tablerow=tablerows.get(i);
			List<WebElement> cells=tablerow.findElements(By.tagName("td"));
					{
				for (int x=0;x<cells.size();x++)
				{
					System.out.println("Row no "+i+1);
					System.out.println("cell date found is "+cells.get(x).getText());
					if(cells.get(x).getText().equalsIgnoreCase(text))
					{System.out.println("Expected "+text+" But Found "+cells.get(x).getText());
						System.out.println("Found in the table");
						return true;
					}	
					
				}
					}
			
		}
		return false;
	}

}
