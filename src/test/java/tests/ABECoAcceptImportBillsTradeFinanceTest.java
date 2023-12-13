package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.ABECoAcceptImportBillsTradeFinanceData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABECoAcceptImportBillsTradeFinanceProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

public class ABECoAcceptImportBillsTradeFinanceTest {
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECoAcceptImportBillsTradeFinanceData data = (ABECoAcceptImportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Co Accept Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECoAcceptImportBillsTradeFinanceCsv);
		workbook.save(Paths.ABECoAcceptImportBillsTradeFinanceJson);
        Class<ABECoAcceptImportBillsTradeFinanceData> targetClass = ABECoAcceptImportBillsTradeFinanceData.class;
        JsonReader<ABECoAcceptImportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABECoAcceptImportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABECoAcceptImportBillsTradeFinanceJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Co Accept Trade Finance DataProvider", dataProviderClass = ABECoAcceptImportBillsTradeFinanceTest.class)
	public void ABE_CoAcceptImportBills(ABECoAcceptImportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABECoAcceptImportBillsTradeFinanceProcedures.coAcceptImportBills(driver, data);
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
