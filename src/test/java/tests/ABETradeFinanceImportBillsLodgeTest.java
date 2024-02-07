package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.JsonReader;
import data.ABETradeFinanceImportBillsLodgeData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABETradeFinanceImportBillsLodgeProcedures;
import testdataupdate.ABETradeFinanceImportBillsLodge_TestDataUpdate;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;


public class ABETradeFinanceImportBillsLodgeTest {


	@BeforeClass
	public void oneTimeSetUp() throws Exception {
		//lodge
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, "mixedBillId2");
		
		//verify lodge
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, "mixedBillId2");
		
		//accept
		CSVUtils.clearColumnByName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, "mixedBillId2");
		
		//verify accept
		CSVUtils.clearColumnByName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, "mixedBillId2");
		
		//co-accept
		CSVUtils.clearColumnByName(Paths.ABECoAcceptImportBillsTradeFinanceCsv, "billId");
		CSVUtils.clearColumnByName(Paths.ABECoAcceptImportBillsTradeFinanceCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABECoAcceptImportBillsTradeFinanceCsv, "mixedBillId2");
		
		//verify co-accept
		CSVUtils.clearColumnByName(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, "billId");
		CSVUtils.clearColumnByName(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, "mixedBillId2");	
		
		//realize
		CSVUtils.clearColumnByName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, "mixedBillId2");
		
		//verify realize
		CSVUtils.clearColumnByName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, "mixedBillId2");
		
		ABETradeFinanceImportBillsLodge_TestDataUpdate.Update();
	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABETradeFinanceImportBillsLodgeData data = (ABETradeFinanceImportBillsLodgeData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV);
		workbook.save(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEJSON);
        Class<ABETradeFinanceImportBillsLodgeData> targetClass = ABETradeFinanceImportBillsLodgeData.class;
        JsonReader<ABETradeFinanceImportBillsLodgeData> jsonReader = new JsonReader<>(targetClass);
        List<ABETradeFinanceImportBillsLodgeData> dataList = jsonReader.readJsonFile(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create Trade Finance DataProvider", dataProviderClass = ABETradeFinanceImportBillsLodgeTest.class)
	public void ABE_Lodge(ABETradeFinanceImportBillsLodgeData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABETradeFinanceImportBillsLodgeProcedures.TradeFinanceImportBillsLodge(driver, data);
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
