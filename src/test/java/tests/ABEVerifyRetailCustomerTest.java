package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.JsonReader;
import data.ABEVerifyRetailCustomerData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyRetailCustomerProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABEVerifyRetailCustomerTest"/*,dependsOnGroups = "ABECreateRetailCustomerTest"*/)
@Listeners({AllureTestNg.class})
public class ABEVerifyRetailCustomerTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyRetailCustomerData data = (ABEVerifyRetailCustomerData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Retail CIF DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYRETAILCUSTOMERCSV);
		workbook.save(Paths.ABEVERIFYRETAILCUSTOMERJSON);
        Class<ABEVerifyRetailCustomerData> targetClass = ABEVerifyRetailCustomerData.class;
        JsonReader<ABEVerifyRetailCustomerData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyRetailCustomerData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYRETAILCUSTOMERJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Retail CIF DataProvider", dataProviderClass = ABEVerifyRetailCustomerTest.class)
	public void verifyCIFTest(ABEVerifyRetailCustomerData data) throws Exception {
	   Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcid()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyRetailCustomerProcedures.verifyCIFBychecker(driver, data);
		//AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
            }
		 if (result.getStatus() == ITestResult.FAILURE) {
			 ScreenshotHelper.captureScreenshot(driver);
			 }
		driver.quit();
	}
}