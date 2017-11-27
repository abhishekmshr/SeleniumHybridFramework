package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

}
