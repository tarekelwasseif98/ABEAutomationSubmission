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
import data.ABEOpenWakalahTUAData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenWakalahTUAProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class ABEOpenWakalahTUATest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABEOPENWAKALAHTUACSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYWAKALAHTUAOPENINGCSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABECLOSEWAKALAHTUACSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYWAKALAHTUACLOSURECSV, "accountId");
	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenWakalahTUAData data = (ABEOpenWakalahTUAData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Wakalah TUA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENWAKALAHTUACSV);
		workbook.save(Paths.ABEOPENWAKALAHTUAJSON);
        Class<ABEOpenWakalahTUAData> targetClass = ABEOpenWakalahTUAData.class;
        JsonReader<ABEOpenWakalahTUAData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenWakalahTUAData> dataList = jsonReader.readJsonFile(Paths.ABEOPENWAKALAHTUAJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Wakalah TUA DataProvider", dataProviderClass = ABEOpenWakalahTUATest.class)
	public void openWakalahTUATest(ABEOpenWakalahTUAData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEOpenWakalahTUAProcedures.openWakalahTUA(driver, data);
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