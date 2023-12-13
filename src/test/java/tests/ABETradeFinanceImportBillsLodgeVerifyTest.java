package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.JsonReader;
import data.ABETradeFinanceImportBillsLodgeVerifyData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABETradeFinanceImportBillsLodgeVerifyProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

public class ABETradeFinanceImportBillsLodgeVerifyTest {
	

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABETradeFinanceImportBillsLodgeVerifyData data = (ABETradeFinanceImportBillsLodgeVerifyData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="verify Trade Finance lodge DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV);
		workbook.save(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEVERIFYJSON);
        Class<ABETradeFinanceImportBillsLodgeVerifyData> targetClass = ABETradeFinanceImportBillsLodgeVerifyData.class;
        JsonReader<ABETradeFinanceImportBillsLodgeVerifyData> jsonReader = new JsonReader<>(targetClass);
        List<ABETradeFinanceImportBillsLodgeVerifyData> dataList = jsonReader.readJsonFile(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEVERIFYJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "verify Trade Finance lodge DataProvider", dataProviderClass = ABETradeFinanceImportBillsLodgeVerifyTest.class)
	public void ABE_LodgeVerification(ABETradeFinanceImportBillsLodgeVerifyData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABETradeFinanceImportBillsLodgeVerifyProcedures.TradeFinanceImportBillsVerifyLodge(driver, data);
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
