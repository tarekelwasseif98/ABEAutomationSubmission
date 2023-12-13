package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;

import data.ABEVerifyRealizeImportBillsTradeFinanceData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyRealizeImportBillsTradeFinanceProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

public class ABEVerifyRealizeImportBillsTradeFinanceTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyRealizeImportBillsTradeFinanceData data = (ABEVerifyRealizeImportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify realize Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV);
		workbook.save(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCEJSON);
        Class<ABEVerifyRealizeImportBillsTradeFinanceData> targetClass = ABEVerifyRealizeImportBillsTradeFinanceData.class;
        JsonReader<ABEVerifyRealizeImportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyRealizeImportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify realize Trade Finance DataProvider", dataProviderClass = ABEVerifyRealizeImportBillsTradeFinanceTest.class)
	public void ABE_VerifyRealizeImportBills(ABEVerifyRealizeImportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyRealizeImportBillsTradeFinanceProcedures.VerifyRealizeImportBillsTradeFinance(driver, data);
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
