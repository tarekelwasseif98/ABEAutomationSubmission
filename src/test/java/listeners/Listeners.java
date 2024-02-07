package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class Listeners implements ITestListener , IAnnotationTransformer {
	int steps = 0;
	public void onTestStart(ITestResult result) {
	}  
	  
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success of test cases and its details are : "+result.getInstance());  
	} 
	  
	public void onTestFailure(ITestResult result) {  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	public void onTestSkipped(ITestResult result) {  
		System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}   
	  
	public void onStart(ITestContext context) {
	}  
	  
	  
	public void onFinish(ITestContext context) {
	}  
	
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryListener.class);
	}
	
	
}
