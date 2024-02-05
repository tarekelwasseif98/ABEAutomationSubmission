package tests;

import java.io.IOException;
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
import com.opencsv.exceptions.CsvException;
import data.JsonReader;
import data.ABECreateCorporateCustomerData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateCorporateCustomerProcedures;
import testdataupdate.ABECreateCorporateCustomer_TestDataUpdate;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABECreateCorporateCustomerTest")
@Listeners({ AllureTestNg.class })

public class ABECreateCorporateCustomerTest {

	@BeforeClass
	public void oneTimeSetUp() throws Exception  {
		CSVUtils.clearColumnByName(Paths.ABECREATECORPORATECUSTOMERCSV, "cif");
		
		ABECreateCorporateCustomer_TestDataUpdate.Update();
	}

	WebDriver driver = null;
	private String testCaseId;

	@BeforeMethod(description = "Initiating Browser")
	public void beforeTest(Object[] testData) throws Exception {
		ABECreateCorporateCustomerData data = (ABECreateCorporateCustomerData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		testCaseId = CSVUtils.getTestCaseId(Paths.ABECREATECORPORATECUSTOMERCSV);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
//		FinacleLoginPage.AdvanceConnection();
		FinacleLoginPage.sendKeysUserNameTextField(data.getUsername()).sendKeysPasswordTextField(data.getPassword())
				.clickOnLoginButton(data.getPassword());
	}

	@DataProvider(name = "Create Corporate Customer DataProvider")
	public Object[] dpMethod() throws Exception {
		Workbook workbook = new Workbook(Paths.ABECREATECORPORATECUSTOMERCSV);
		workbook.save(Paths.ABECREATECORPORATECUSTOMERJSON);
		Class<ABECreateCorporateCustomerData> targetClass = ABECreateCorporateCustomerData.class;
		JsonReader<ABECreateCorporateCustomerData> jsonReader = new JsonReader<>(targetClass);
		List<ABECreateCorporateCustomerData> dataList = jsonReader.readJsonFile(Paths.ABECREATECORPORATECUSTOMERJSON);
		dataList.toArray();
		return dataList.toArray();
	}

	@Test(dataProvider = "Create Corporate Customer DataProvider", dataProviderClass = ABECreateCorporateCustomerTest.class)
	@Step("{testCaseId}")
	public void CreateCorporateCustomer(ABECreateCorporateCustomerData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("Data: ", data.toString());
		ABECreateCorporateCustomerProcedures.CreateCorporateCustomer(driver, data);
        //AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
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
		PageFunctionUtils.sleep();
		driver.quit();
	}

}
