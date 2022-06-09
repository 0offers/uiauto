package helps;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import pages.BasePage;


public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+"is running");
    }
    
	@Override
	public void onFinish(ITestContext context) {
        System.out.println("finish");
    }
  
    @Override
	public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+"is running");
    }
  
    @Override
	public void onTestSuccess(ITestResult result) {
        System.out.println("success test");
    }

    @Override
	public void onTestSkipped(ITestResult result) {
        System.out.println("skip test");
    }

    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("fail but success percentage test");
    }

    @Override
	public void onStart(ITestContext context) {
        System.out.println("start");
    }
}
