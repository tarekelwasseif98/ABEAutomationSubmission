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
import data.ABEVerifyWakalahTUAOpeningData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyWakalahTUAOpeningProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Listeners({AllureTestNg.class})
public class ABEVerifyWakalahTUAOpeningTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyWakalahTUAOpeningData data = (ABEVerifyWakalahTUAOpeningData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Wakalah TUA Account Opening TUA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYWAKALAHTUAOPENINGCSV);
		workbook.save(Paths.ABEVERIFYWAKALAHTUAOPENINGJSON);
        Class<ABEVerifyWakalahTUAOpeningData> targetClass = ABEVerifyWakalahTUAOpeningData.class;
        JsonReader<ABEVerifyWakalahTUAOpeningData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyWakalahTUAOpeningData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYWAKALAHTUAOPENINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Wakalah TUA Account Opening TUA DataProvider", dataProviderClass = ABEVerifyWakalahTUAOpeningTest.class)
	public void verifyWakalahTUAOpeningTest(ABEVerifyWakalahTUAOpeningData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyWakalahTUAOpeningProcedures.verifyWakalahTUAOpening(driver, data);
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