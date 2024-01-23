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
import data.ABEVerifyDepositLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyDepositLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

//@Test(groups = "verifyTd", dependsOnGroups = "OpenTd", alwaysRun = true)
@Listeners({AllureTestNg.class})

public class ABEVerifyCDLiabilitiesAndOperationTest {
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyDepositLiabilitiesAndOperationData data = (ABEVerifyDepositLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	
	}
	
	@DataProvider(name="Verify CD DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCDLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABEVERIFYCDLIABILITIESANDOPERATIONJSON);
        Class<ABEVerifyDepositLiabilitiesAndOperationData> targetClass = ABEVerifyDepositLiabilitiesAndOperationData.class;
        JsonReader<ABEVerifyDepositLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyDepositLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCDLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify CD DataProvider", dataProviderClass = ABEVerifyCDLiabilitiesAndOperationTest.class)
	@Step("{testCaseId}")
	public void ABE_VerifyCDAccount(ABEVerifyDepositLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyDepositLiabilitiesAndOperationProcedures.ABEVerifyDepositLiabilitiesAndOperationByChecker(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}
	

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
            }
		 if (result.getStatus() == ITestResult.FAILURE) {
			 ScreenshotHelper.captureScreenshot(driver);
			 }
		driver.quit();
	}

}
