package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyAcceptImportBillsTradeFinancePage {
	
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
	private By billDetailsTab = By.xpath("(//span[@id='fbmbill_textSpan'])[1]");
	private By eventDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By chargeDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By transactionDetailsTab = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By generalDetailsTab = By.id("fbmgeneral_textSpan");
	private By partyDetailsTab = By.id("fbmparty_textSpan");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public ABEVerifyAcceptImportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyAcceptImportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyAcceptImportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending bill id: {0}")
	public ABEVerifyAcceptImportBillsTradeFinancePage sendKeysBillId(String billId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billIdTextField );
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABEVerifyAcceptImportBillsTradeFinancePage sendKeysTenorBillId(String tenorBillId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,tenorBillIdTextField );
		PageFunctionUtils.clickOnElement(driver,tenorBillIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,tenorBillIdTextField,tenorBillId.substring(1));
		
		return this;
	}
	
	@Step("press go button")
	public ABEVerifyAcceptImportBillsTradeFinancePage pressGoButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,goButton);
		
		return this;
	}
	@Step("press submit button")
	public ABEVerifyAcceptImportBillsTradeFinancePage pressSubmitButton() throws Exception {
		
		
		PageFunctionUtils.sleep();
		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);
		
		return this;
	}
	
	@Step("press side tabs")
	public ABEVerifyAcceptImportBillsTradeFinancePage pressSideTabs() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,generalDetailsTab);
		PageFunctionUtils.clickOnElement(driver,partyDetailsTab);
		PageFunctionUtils.clickOnElement(driver,eventDetailsTab);
		PageFunctionUtils.clickOnElement(driver,chargeDetailsTab);
		PageFunctionUtils.clickOnElement(driver,billDetailsTab);
		PageFunctionUtils.clickOnElement(driver,transactionDetailsTab);


		
		return this;
	}
	

}
