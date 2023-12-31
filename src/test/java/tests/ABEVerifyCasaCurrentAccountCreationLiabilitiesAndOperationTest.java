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
import data.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "VerifyCasaCurrentAc", dependsOnGroups = "OpenCasaCurrentAc")
@Listeners({AllureTestNg.class})
public class ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationTest {

	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData data = (ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	

	@DataProvider(name="Verify Casa Current Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCASACURRENTACCOUNTCREATIONLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABEVERIFYCASACURRENTACCOUNTCREATIONLIABILITIESANDOPERATIONJSON);
        Class<ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData> targetClass = ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData.class;
        JsonReader<ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCASACURRENTACCOUNTCREATIONLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Casa Current Account DataProvider", dataProviderClass = ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationTest.class)
	@Step("{testCaseId}")
	public void ABE_VerifyCaaAccount(ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationProcedures.Casa_VerifyCurrentAccountByMaker(driver, data);
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
