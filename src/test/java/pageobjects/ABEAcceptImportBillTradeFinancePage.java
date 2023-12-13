package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEAcceptImportBillTradeFinancePage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By tenorEditButton = By.xpath("(//span[@class='editcontent'])[1]");
	private By tenorEditButton2 = By.xpath("(//span[@class='editcontent'])[2]");
	private By messageDetailsTab = By.xpath("(//span[@id='messagetabid_textSpan'])[1]");
	private By closeButton2 = By.xpath("(//span[@id='modalCloseIcon'])[2]");						
	private By warningMessage  = By.xpath("(//span[@id='modalCloseIcon'])[1]");

	private By acceptanceDateField = By.xpath("(//input[@id='_acceptDate'])[1]");
	private By updateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By billDetailsTab = By.xpath("(//span[@id='fbmbill_textSpan'])[1]");
	private By eventDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By chargeDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By transactionDetailsTab = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By generalDetailsTab = By.id("fbmgeneral_textSpan");
	private By partyDetailsTab = By.id("fbmparty_textSpan");
	private By submitButton = By.id("_submit");
	private By accountIdSuccessMessage = By.id("_result_FinMessage1_paraMsg");
	public static String billId;

	public ABEAcceptImportBillTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@Step("Sending menu name: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEAcceptImportBillTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending bill id: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysBillId(String billId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billIdTextField );
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysTenorBillId(String tenorBillId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,tenorBillIdTextField );
		PageFunctionUtils.clickOnElement(driver,tenorBillIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,tenorBillIdTextField,tenorBillId.substring(1));
		
		return this;
	}
	
	@Step("press go button")
	public ABEAcceptImportBillTradeFinancePage pressGoButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,goButton);
		
		return this;
	}
	
	@Step("press tenor edit button")
	public ABEAcceptImportBillTradeFinancePage pressTenorEditButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorEditButton);
		
		return this;
	}
	@Step("press tenor edit button 2")
	public ABEAcceptImportBillTradeFinancePage pressTenorEditButton2() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,tenorEditButton2);
		
		return this;
	}
	@Step("press update button")
	public ABEAcceptImportBillTradeFinancePage pressUpdateButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,updateButton);
		
		return this;
	}
	
	@Step("press submit button")
	public ABEAcceptImportBillTradeFinancePage pressSubmitButton() throws Exception {
		
		try {
			// TODO: handle exception
			PageFunctionUtils.clickOnElement(driver,submitButton);
			PageFunctionUtils.acceptWarning(driver);
			billId = driver.findElement(accountIdSuccessMessage).getText().substring(45);
			System.out.println("bill Id: "+ billId);
		
		}catch (Exception e) {
			
		
	try {
			    	PageFunctionUtils.switchToParentFrame(driver);
					PageFunctionUtils.clickOnElement(driver, warningMessage);
					PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);	
					PageFunctionUtils.clickOnElement(driver,submitButton);
					PageFunctionUtils.acceptWarning(driver);		
					billId = driver.findElement(accountIdSuccessMessage).getText().substring(45);
					System.out.println("bill Id: "+ billId);
	
	}catch (Exception e1) {
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);	

		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.clickOnElement(driver,closeButton2 );
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);	
		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);		
		billId = driver.findElement(accountIdSuccessMessage).getText().substring(45);
		System.out.println("bill Id: "+ billId);
	
	}
		
		}

		
		return this;
	}
	 
	@Step("press bill Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressBillDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,billDetailsTab);
		
		return this;
	}
	
	@Step("press event Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressEventDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,eventDetailsTab);
		
		return this;
	}
	
	@Step("press charge Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressChargeDetailsTab() throws Exception {
		try {
		PageFunctionUtils.clickOnElement(driver,chargeDetailsTab);
		}catch(Exception e)
		{
			Alert alert = driver.switchTo().alert();

            // Close the alert by accepting it
            alert.accept();
    		PageFunctionUtils.clickOnElement(driver,chargeDetailsTab);

			
		}
		
		return this;
	}
	
	@Step("press transaction Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressTransactionDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,transactionDetailsTab);
		
		return this;
	}
	@Step("press message Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressMessageDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,messageDetailsTab);
		
		return this;
	}
	
	@Step("press party Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressPartyDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,partyDetailsTab);
		
		return this;
	}
	@Step("press general Details Tab")
	public ABEAcceptImportBillTradeFinancePage pressGeneralDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,generalDetailsTab);
		
		return this;
	}
	
	@Step("Sending acceptance date: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysAcceptanceDateTextField(String acceptanceDate) throws Exception {
		if(acceptanceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, acceptanceDateField);
			PageFunctionUtils.clickOnElement(driver, acceptanceDateField);
			PageFunctionUtils.enterDataInWebElement(driver, acceptanceDateField, acceptanceDate.substring(1));
			PageFunctionUtils.sleep();
		}
		return this;
	}
	
	@Step("Sending acceptance date 2: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysAcceptanceDateTextField2(String acceptanceDate) throws Exception {
		if(acceptanceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, acceptanceDateField);
			PageFunctionUtils.clickOnElement(driver, acceptanceDateField);
			PageFunctionUtils.enterDataInWebElement(driver, acceptanceDateField, acceptanceDate.substring(1));
			PageFunctionUtils.sleep();
		}
		return this;
	}
}
