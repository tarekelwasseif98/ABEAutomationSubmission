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
	import data.ABEIssueOutwardLGTradeFinanceData;
	import io.qameta.allure.Allure;
	import io.qameta.allure.Attachment;
	import io.qameta.allure.Step;
	import pageobjects.FinacleLoginPage;
	import procedures.ABEIssueOutwardLGTradeFinanceProcedures;
	import utils.Properties;
	import utils.ScreenshotHelper;
	import utils.WebdriverFactory;
	import utils.Paths;
	import utils.AssertionFactory;
	import utils.CSVUtils;
	import io.qameta.allure.testng.AllureTestNg;

	//@Test( groups = "open")
	@Listeners({AllureTestNg.class})

	public class ABEIssueOutwardLGTradeFinanceTest {

		
		@BeforeClass
		public void oneTimeSetUp() throws IOException, CsvException {
	
			CSVUtils.clearColumnByName(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, "referenceGuarantee");
			
           
		}

		WebDriver driver = null;
		@BeforeMethod(description= "Initiating Browser")
		public void beforeTest(Object [] testData) throws Exception {
			ABEIssueOutwardLGTradeFinanceData data = (ABEIssueOutwardLGTradeFinanceData) testData[0];
			driver = WebdriverFactory.initiateWebDriver();
			driver.get(Properties.FINACLEURL);
			FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
			FinacleLoginPage
			.sendKeysUserNameTextField(data.getUsername())
			.sendKeysPasswordTextField(data.getPassword())
			.clickOnLoginButton(data.getPassword())
			;
		}
		
		@DataProvider(name="Issue outward payment LG trade fnance DataProvider")
		public Object[] dpMethod() throws Exception {
	    	Workbook workbook = new Workbook(Paths.ISSUEOUTWARDLGTRADEFINANCECSV);
			workbook.save(Paths.ISSUEOUTWARDLGTRADEFINANCEJSON);
	        Class<ABEIssueOutwardLGTradeFinanceData> targetClass = ABEIssueOutwardLGTradeFinanceData.class;
	        JsonReader<ABEIssueOutwardLGTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
	        List<ABEIssueOutwardLGTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ISSUEOUTWARDLGTRADEFINANCEJSON);
	        dataList.toArray();
	        return dataList.toArray();
		}
		
		@Test(dataProvider = "Issue outward payment LG trade fnance DataProvider", dataProviderClass = ABEIssueOutwardLGTradeFinanceTest.class)
		@Step("{testCaseId}")
		public void issueOutwardPaymentLGTradeFinance(ABEIssueOutwardLGTradeFinanceData data) throws Exception {
			//Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
			Allure.parameter("Data: ", data.toString());		
			ABEIssueOutwardLGTradeFinanceProcedures.issueOutwardPaymentLGTradeFinanceByMaker(driver, data);
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