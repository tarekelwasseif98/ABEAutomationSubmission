package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABERealizeImportBillsTradeFinancePage {

	
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
	private By solIdTextField = By.xpath("(//input[@id='_solIdOthers'])[1]");
	private By billRealizationAmountTextField = By.xpath("(//input[@id='_miibreal_realAmt$amt'])[1]");
	private By transactionDetailsSideTabMenu = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By eventDetailsSideTabMenu = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By repeatTaskButton = By.xpath("(//button[normalize-space()='Repeat Task'])[1]");
	private By billRealizationAcountTextField = By.xpath("(//input[@id='_miibreal_realAcctId'])[1]");

	
	public ABERealizeImportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABERealizeImportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending bill id: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysBillId(String billId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billIdTextField );
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		
		return this;
	}
	
	@Step("Sending nostro account: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysBillRealizationAcount(String acount) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,billRealizationAcountTextField );
		PageFunctionUtils.clickOnElement(driver,billRealizationAcountTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billRealizationAcountTextField,acount.substring(1));
		
		return this;
	}
	@Step("Sending sol id: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysSolId(String solId) throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,solIdTextField);
		PageFunctionUtils.clearDataInWebElement(driver, solIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,solIdTextField,solId);
		
		return this;
	}
	
	@Step("sending bill realization amount: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysBillRealizationAmount(String amount) throws Exception{
	
		PageFunctionUtils.clickOnElement(driver, billRealizationAmountTextField);
		PageFunctionUtils.clearDataInWebElement(driver, billRealizationAmountTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billRealizationAmountTextField,amount.substring(1));

		return this;
	
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABERealizeImportBillsTradeFinancePage sendKeysTenorBillId(String tenorBillId) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver,tenorBillIdTextField );
		PageFunctionUtils.clickOnElement(driver,tenorBillIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,tenorBillIdTextField,tenorBillId.substring(1));
		
		return this;
	}
	
	
	

	@Step("press go button")
	public ABERealizeImportBillsTradeFinancePage pressGoButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,goButton);
		
		return this;
	}
	
	@Step("press repeat task button")
	public ABERealizeImportBillsTradeFinancePage pressRepeatTaskButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,repeatTaskButton);
		
		return this;
	}
	
	
	@Step("press event Details Tab")
	public ABERealizeImportBillsTradeFinancePage pressEventDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,eventDetailsSideTabMenu);
		
		return this;
	}
	
	@Step("press transaction Details Tab")
	public ABERealizeImportBillsTradeFinancePage pressTransactionDetailsTab() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,transactionDetailsSideTabMenu);
		
		return this;
	}
	
	@Step("Press submit button")
	public ABERealizeImportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		return this;
	}

}
