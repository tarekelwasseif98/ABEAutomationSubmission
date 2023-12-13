package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyCoAcceptImportBillsTradeFinancePage {
	
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
	private By transactionDetailsTab = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By eventDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By tenorTab = By.xpath("(//span[@id='fbmtenor_textSpan'])[1]");
	private By partyDetailsTab = By.id("fbmparty_textSpan");
	private By submitButton = By.id("_submit");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");


	public ABEVerifyCoAcceptImportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyCoAcceptImportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	

	@Step("Sending bill id: {0}")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage sendKeysBillId(String billId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billIdTextField );
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage sendKeysTenorBillId(String tenorBillId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,tenorBillIdTextField );
		PageFunctionUtils.clickOnElement(driver,tenorBillIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,tenorBillIdTextField,tenorBillId.substring(1));
		
		return this;
	}
	

	@Step("press go button")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressGoButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,goButton);
		
		return this;
	}
	
	@Step("press submit button")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressSubmitButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,submitButton);
		
		return this;
	}
	
	@Step("press transaction Details Tab")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressTransactionDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,transactionDetailsTab);
		
		return this;
	}
	
	@Step("press party Details Tab")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressPartyDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,partyDetailsTab);
		
		return this;
	}
	
	@Step("press event Details Tab")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressEventDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,eventDetailsTab);
		
		return this;
	}
	
	@Step("press tenor Details Tab")
	public ABEVerifyCoAcceptImportBillsTradeFinancePage pressTenorDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorTab);
		
		return this;
	}

}
