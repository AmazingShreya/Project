package automationSuite.testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	// class to run failed test cases twice to check again
	int count = 0;
	int maxTry = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}