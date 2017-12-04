package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int min=0;
		int max=2;
		if(min<=max)
		{
			System.out.println("Test has failed "+result.getName());
			System.out.println("Retrying the test execution for  "+ min+1+" time");
			min++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
