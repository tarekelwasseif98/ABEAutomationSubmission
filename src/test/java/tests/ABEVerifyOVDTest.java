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
	import data.ABEVerifyOVDData;

import io.qameta.allure.Allure;
	import io.qameta.allure.Attachment;
	import io.qameta.allure.Step;
	import pageobjects.FinacleLoginPage;
	
import procedures.ABEVerifyOVDProcedures;
import utils.Properties;
	import utils.ScreenshotHelper;
	import utils.WebdriverFactory;
	import utils.Paths;
	import utils.AssertionFactory;
	import utils.CSVUtils;
	import io.qameta.allure.testng.AllureTestNg;

	//@Test(groups = "verify",dependsOnGroups = "modify")
	@Listeners({AllureTestNg.class})
	
	public class ABEVerifyOVDTest {
		
		WebDriver driver = null;
		@BeforeMethod(description= "Initiating Browser")
		public void beforeTest(Object [] testData) throws Exception {
			ABEVerifyOVDData data = (ABEVerifyOVDData) testData[0];
			driver = WebdriverFactory.initiateWebDriver();
			driver.get(Properties.FINACLEURL);
			FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
			FinacleLoginPage
			.sendKeysUserNameTextField(data.getUsername())
			.sendKeysPasswordTextField(data.getPassword())
			.clickOnLoginButton(data.getPassword());
		}
		
		@DataProvider(name="Verify Over Draft Account DataProvider")
		public Object[] dpMethod() throws Exception {
	    	Workbook workbook = new Workbook(Paths.ABEVERIFYOVERDRAFTACCOUNTCSV);
			workbook.save(Paths.ABEVERIFYOVERDRAFTACCOUNTJSON);
	        Class<ABEVerifyOVDData> targetClass = ABEVerifyOVDData.class;
	        JsonReader<ABEVerifyOVDData> jsonReader = new JsonReader<>(targetClass);
	        List<ABEVerifyOVDData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYOVERDRAFTACCOUNTJSON);
	        dataList.toArray();
	        return dataList.toArray();
		}
		
		@Test(dataProvider = "Verify Over Draft Account DataProvider", dataProviderClass = ABEVerifyOVDTest.class)
		@Step("{testCaseId}")
		public void verifyOverDraftAccount(ABEVerifyOVDData data) throws Exception {
			//Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
			Allure.parameter("Data: ", data.toString());		
			ABEVerifyOVDProcedures.overDraftAccountByChecker(driver, data);
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