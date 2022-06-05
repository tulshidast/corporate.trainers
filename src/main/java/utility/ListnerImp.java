/**
 * 
 */
package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Administrator
 *
 */
public class ListnerImp implements ITestListener {

	
	public void onFinish(ITestContext Result) {

	}

	public void onStart(ITestContext Result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("My test case failed: " + Result.getName());
	}

	public void onTestSkipped(ITestResult Result) {

	}

	public void onTestStart(ITestResult Result) {
		System.out.println("My test case execution started");

	}

	public void onTestSuccess(ITestResult Result) {

	}

}
