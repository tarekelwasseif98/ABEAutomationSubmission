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
import data.ABEAdviseInwardLCTradeFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABEAdviseInwardLCTradeFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.AssertionFactory;
import utils.Paths;

import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "Advise Inward LC")
@Listeners({AllureTestNg.class})

public class ABEAdviseInwardLCTradeFinanceTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEAdviseInwardLCTradeFinanceData data = (ABEAdviseInwardLCTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Advise Inward LC DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEADVISEINWARDLCCSV);
		workbook.save(Paths.ABEADVISEINWARDLCJSON);
        Class<ABEAdviseInwardLCTradeFinanceData> targetClass = ABEAdviseInwardLCTradeFinanceData.class;
        JsonReader<ABEAdviseInwardLCTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEAdviseInwardLCTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEADVISEINWARDLCJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Advise Inward LC DataProvider", dataProviderClass = ABEAdviseInwardLCTradeFinanceTest.class)
	@Step("{testCaseId}")
	public void adviseInwardLC(ABEAdviseInwardLCTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEAdviseInwardLCTradeFinanceProcedures.AdviseInwardLCByMaker(driver, data);
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