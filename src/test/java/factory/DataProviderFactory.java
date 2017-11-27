package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getconfigDataProvider()
	{
		ConfigDataProvider conf=new ConfigDataProvider();
		return conf;
			
	}
	
	public static ExcelDataProvider getExcelDataProvider()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
			
	}

}
