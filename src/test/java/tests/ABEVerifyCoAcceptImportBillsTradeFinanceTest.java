package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;
import data.ABEVerifyCoAcceptImportBillsTradeFinanceData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCoAcceptImportBillsTradeFinanceProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

public class ABEVerifyCoAcceptImportBillsTradeFinanceTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCoAcceptImportBillsTradeFinanceData data = (ABEVerifyCoAcceptImportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify CoAccept Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv);
		workbook.save(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceJson);
        Class<ABEVerifyCoAcceptImportBillsTradeFinanceData> targetClass = ABEVerifyCoAcceptImportBillsTradeFinanceData.class;
        JsonReader<ABEVerifyCoAcceptImportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCoAcceptImportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify CoAccept Trade Finance DataProvider", dataProviderClass = ABEVerifyCoAcceptImportBillsTradeFinanceTest.class)
	public void ABE_VerifyCoAcceptImportBills(ABEVerifyCoAcceptImportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyCoAcceptImportBillsTradeFinanceProcedures.VerifyCoAcceptImportBills(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
        }
		 if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotHelper.captureScreenshot(driver);
	        }
		Thread.sleep(2000);
		driver.quit();
	}
}
