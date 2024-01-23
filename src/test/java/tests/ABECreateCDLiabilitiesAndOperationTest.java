package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.ABECreateDepositLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateDepositLiabilitiesAndOperationProcedures;
import testdataupdate.ABECreateCDLiabilitiesAndOperation_TestDataUpdate;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Listeners({AllureTestNg.class})
public class ABECreateCDLiabilitiesAndOperationTest {

	@BeforeClass
	public void oneTimeSetUp() throws Exception {
		
		ABECreateCDLiabilitiesAndOperation_TestDataUpdate.Update();	
		
		CSVUtils.clearColumnByName(Paths.ABECREATECDLIABILITIESANDOPERATIONCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYCDLIABILITIESANDOPERATIONCSV, "accountId");
 
	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateDepositLiabilitiesAndOperationData data = (ABECreateDepositLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create CD DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATECDLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABECREATECDLIABILITIESANDOPERATIONJSON);
        Class<ABECreateDepositLiabilitiesAndOperationData> targetClass = ABECreateDepositLiabilitiesAndOperationData.class;
        JsonReader<ABECreateDepositLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateDepositLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABECREATECDLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create CD DataProvider", dataProviderClass = ABECreateCDLiabilitiesAndOperationTest.class)
	public void ABECreateCD(ABECreateDepositLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		
		Allure.parameter("Data: ", data.toString());		
		ABECreateDepositLiabilitiesAndOperationProcedures.CreateDepositByMaker(driver, data);
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
		driver.quit();
	}

	
}
