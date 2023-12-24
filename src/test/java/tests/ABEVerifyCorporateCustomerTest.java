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
import data.ABEVerifyCorporateCustomerData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCorporateCustomerProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.AssertionFactory;
import utils.Paths;

@Test(groups = "ABEVerifyCorporateCustomerTest"/*,dependsOnGroups = "ABECreateCorporateCustomerTest"*/)
@Listeners({AllureTestNg.class})
public class ABEVerifyCorporateCustomerTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCorporateCustomerData data = (ABEVerifyCorporateCustomerData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Corporate CIF DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCORPORATECUSTOMERCSV);
		workbook.save(Paths.ABEVERIFYCORPORATECUSTOMERJSON);
        Class<ABEVerifyCorporateCustomerData> targetClass = ABEVerifyCorporateCustomerData.class;
        JsonReader<ABEVerifyCorporateCustomerData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCorporateCustomerData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCORPORATECUSTOMERJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Corporate CIF DataProvider", dataProviderClass = ABEVerifyCorporateCustomerTest.class)
	public void verifyCIFTest(ABEVerifyCorporateCustomerData data) throws Exception {
	   Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcid()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyCorporateCustomerProcedures.verifyCIFBychecker(driver, data);
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