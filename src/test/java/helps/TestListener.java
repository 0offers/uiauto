package helps;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import pages.BasePage;


public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) { }
    
	@Override
	public void onFinish(ITestContext context) {}
  
    @Override
	public void onTestStart(ITestResult result) {   }
  
    @Override
	public void onTestSuccess(ITestResult result) {   }

    @Override
	public void onTestSkipped(ITestResult result) {   }

    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    @Override
	public void onStart(ITestContext context) {   }
}
