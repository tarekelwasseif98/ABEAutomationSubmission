package tests;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;

import data.ABEOpenRetailLoanRetailLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenRetailLoanRetailLoansProcedures;
import testdataupdate.ABEOpenRetailLoanRetailLoans_TestDataUpdate;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test( groups = "openRetailLoan")
@Listeners({AllureTestNg.class})
public class ABEOpenRetailLoanRetailLoansTest {
	
	WebDriver driver = null;
	
	@BeforeClass(description= "Update CSV")
	public void oneTimeSetUp() throws Exception {
		CSVUtils.clearColumnByName(Paths.ABEOPENRETAILLOANRETAILLOANSCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYRETAILLOANRETAILLOANSCSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABEDISBURSERETAILLOANRETAILLOANSCSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, "accountId");
		
		ABEOpenRetailLoanRetailLoans_TestDataUpdate.Update();
  
	}
	
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenRetailLoanRetailLoansData data = (ABEOpenRetailLoanRetailLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Retail Loan DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENRETAILLOANRETAILLOANSCSV);
		workbook.save(Paths.ABEOPENRETAILLOANRETAILLOANSJSON);
        Class<ABEOpenRetailLoanRetailLoansData> targetClass = ABEOpenRetailLoanRetailLoansData.class;
        JsonReader<ABEOpenRetailLoanRetailLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenRetailLoanRetailLoansData> dataList = jsonReader.readJsonFile(Paths.ABEOPENRETAILLOANRETAILLOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	@Test(dataProvider = "Open Retail Loan DataProvider", dataProviderClass = ABEOpenRetailLoanRetailLoansTest.class)
	public void ABEOpenRetailLoan(ABEOpenRetailLoanRetailLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		
		Allure.parameter("Data: ", data.toString());		
		ABEOpenRetailLoanRetailLoansProcedures.ABEOpenRetailLoanRetailLoans(driver, data);
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
