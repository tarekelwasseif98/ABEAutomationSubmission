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
import data.ABEVerifyAdviseInwardLCTradeFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyAdviseInwardLCTradeFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "Verify Advise Inward LC", dependsOnGroups = "Advise Inward LC")
@Listeners({ AllureTestNg.class })

public class ABEVerifyAdviseInwardLCTradeFinanceTest {

	WebDriver driver = null;

	@BeforeMethod(description = "Initiating Browser")
	public void beforeTest(Object[] testData) throws Exception {
		ABEVerifyAdviseInwardLCTradeFinanceData data = (ABEVerifyAdviseInwardLCTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage.sendKeysUserNameTextField(data.getUsername()).sendKeysPasswordTextField(data.getPassword())
				.clickOnLoginButton(data.getPassword());
	}

	@DataProvider(name = "Verify inward LC  DataProvider")
	public Object[] dpMethod() throws Exception {
		Workbook workbook = new Workbook(Paths.ABEVERIFYADVISEINWARDLCCSV);
		workbook.save(Paths.ABEVERIFYADVISEINWARDLCJSON);
		Class<ABEVerifyAdviseInwardLCTradeFinanceData> targetClass = ABEVerifyAdviseInwardLCTradeFinanceData.class;
		JsonReader<ABEVerifyAdviseInwardLCTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
		List<ABEVerifyAdviseInwardLCTradeFinanceData> dataList = jsonReader
				.readJsonFile(Paths.ABEVERIFYADVISEINWARDLCJSON);
		dataList.toArray();
		return dataList.toArray();
	}

	@Test(dataProvider = "Verify inward LC  DataProvider", dataProviderClass = ABEVerifyAdviseInwardLCTradeFinanceTest.class)
	@Step("{testCaseId}")
	public void verifyAdviseInwardLC(ABEVerifyAdviseInwardLCTradeFinanceData data) throws Exception {
		 Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " +
		 data.getTcId()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyAdviseInwardLCTradeFinanceProcedures.verifyAdviseInwardLCs(driver, data);
		AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			ScreenshotHelper.captureScreenshot(driver);
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotHelper.captureScreenshot(driver);
		}
		driver.quit();
	}

}
