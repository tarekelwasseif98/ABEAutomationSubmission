package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABECoAcceptImportBillsTradeFinancePage {

	// coaccept data accept date in tenor party tenor event transaction
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By coAcceptanceData = By.xpath("(//input[@id='_miibgen_coAccDate'])[1]");
	private By tenorEditButton = By.xpath("(//span[@class='editcontent'])[1]");
	private By tenorEditButton2 = By.xpath("(//span[@class='editcontent'])[2]");

	private By acceptanceDateField = By.xpath("(//input[@id='_acceptDate'])[1]");
	private By updateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By transactionDetailsTab = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By eventDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By tenorTab = By.xpath("(//span[@id='fbmtenor_textSpan'])[1]");
	private By partyDetailsTab = By.id("fbmparty_textSpan");
	private By submitButton = By.id("_submit");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");

	
	public ABECoAcceptImportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	

	@Step("Sending menu name: {0}")
	public ABECoAcceptImportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeID);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (Exception e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public ABECoAcceptImportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending bill id: {0}")
	public ABECoAcceptImportBillsTradeFinancePage sendKeysBillId(String billId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billIdTextField );
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABECoAcceptImportBillsTradeFinancePage sendKeysTenorBillId(String tenorBillId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,tenorBillIdTextField );
		PageFunctionUtils.clickOnElement(driver,tenorBillIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,tenorBillIdTextField,tenorBillId.substring(1));
		
		return this;
	}
	

	@Step("press go button")
	public ABECoAcceptImportBillsTradeFinancePage pressGoButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,goButton);
		
		return this;
	}
	
	@Step("press tenor edit button")
	public ABECoAcceptImportBillsTradeFinancePage pressTenorEditButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorEditButton);
		
		return this;
	}
	@Step("press tenor edit button 2")
	public ABECoAcceptImportBillsTradeFinancePage pressTenorEditButton2() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorEditButton2);
		
		return this;
	}
	
	@Step("press update button")
	public ABECoAcceptImportBillsTradeFinancePage pressUpdateButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,updateButton);
		
		return this;
	}

	@Step("Sending acceptance date: {0}")
	public ABECoAcceptImportBillsTradeFinancePage sendKeysAcceptanceDateTextField(String acceptanceDate) throws Exception {
		if(acceptanceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, acceptanceDateField);
			PageFunctionUtils.clickOnElement(driver, acceptanceDateField);
			PageFunctionUtils.enterDataInWebElement(driver, acceptanceDateField, acceptanceDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending acceptance date: {0}")
	public ABECoAcceptImportBillsTradeFinancePage sendKeysCoAcceptanceDateTextField(String acceptanceDate) throws Exception {
		if(acceptanceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, coAcceptanceData);
			PageFunctionUtils.clickOnElement(driver, coAcceptanceData);
			PageFunctionUtils.enterDataInWebElement(driver, coAcceptanceData, acceptanceDate.substring(1));
		}
		return this;
	}
	
	
	@Step("press submit button")
	public ABECoAcceptImportBillsTradeFinancePage pressSubmitButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);
		
		return this;
	}
	
	@Step("press transaction Details Tab")
	public ABECoAcceptImportBillsTradeFinancePage pressTransactionDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,transactionDetailsTab);
		
		return this;
	}
	
	@Step("press party Details Tab")
	public ABECoAcceptImportBillsTradeFinancePage pressPartyDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,partyDetailsTab);
		
		return this;
	}
	
	@Step("press event Details Tab")
	public ABECoAcceptImportBillsTradeFinancePage pressEventDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,eventDetailsTab);
		
		return this;
	}
	
	@Step("press tenor Details Tab")
	public ABECoAcceptImportBillsTradeFinancePage pressTenorDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorTab);
		
		return this;
	}
	
	
	
}
