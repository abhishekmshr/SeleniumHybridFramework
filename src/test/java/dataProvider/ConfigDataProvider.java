package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
public Properties prop;	
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occurred "+e.getMessage());
		}
		
		
	}
	
	public String getURL()
{
	return prop.getProperty("url");	
	}
	
	public String getChromeDriver()
	{
		return prop.getProperty("chromeDriver");	
		}
	
	public String getIEDriver()
	{
		return prop.getProperty("IEDriver");	
		}
}
