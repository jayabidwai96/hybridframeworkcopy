package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
		}

	public void onTestSuccess(ITestResult result) {
	 test.log(Status.PASS,"Testcase passed with name"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		 test.log(Status.FAIL,"Testcase failed with name"+result.getName());
		 test.addScreenCaptureFromPath(captureScreenShot(result.getName()));
		 
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skipped with name"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
