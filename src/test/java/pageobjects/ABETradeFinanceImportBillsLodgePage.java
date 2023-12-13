package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;


public class ABETradeFinanceImportBillsLodgePage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By cifTextField = By.xpath("(//input[@id='_cifId'])[1]");
	private By billTypeTextField = By.xpath("(//input[@id='_billType'])[1]");
	private By billCcyTextField= By.xpath("(//input[@id='_billCcy'])[1]");
	private By closeButton1 = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By underDocumentryCreditNoRadioButton = By.xpath("(//input[@id='_undno1_radio'])[1]");
	private By underDocumentryCreditYesRadioButton = By.xpath("(//input[@id='_undyes1_radio'])[1]");
	private By documentCreditNumberTextField = By.xpath("(//input[@id='_dcNo'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By operativeAcIdTextField = By.xpath("(//input[@id='_miibgen_oppAccId'])[1]");
	private By generalDetailsContinueButton = By.xpath("(//button[@id='_miibgen_miibgen_FinButton1'])[1]");
	private By billAmtTextField = By.xpath("(//input[@id='_miibgen_boeAmt$amt'])[1]");
	private By mixedBillAmtTextField = By.xpath("(//input[@id='_tenorBillAmt$amt'])[1]");
	private By lodgeDateField = By.xpath("(//input[@id='_miibgen_lodgeDate'])[1]");
	private By billCountryTextField = By.xpath("(//input[@id='_miibgen_billCountry'])[1]");
	private By otherBankRefNumTextField = By.xpath("(//input[@id='_miibgen_otherBankRefNo'])[1]");
	private By nameTextField = By.xpath("(//input[@id='_meobparty_nameDIdtl'])[1]");
	private By adress1TextField = By.xpath("(//input[@id='_meobparty_addr1DIdtl'])[1]");
	private By editButton = By.xpath("//a[@id='_tenordatagrid_editIcon_0']//span[@class='editcontent']");
	private By billDateField = By.xpath("(//input[@id='_billDate'])[1]");
	private By onboardDateField = By.xpath("(//input[@id='_shpmntDate'])[1]");
	private By partyDetailsContinueButton = By.xpath("(//span[@id='fbmtenor_textSpan'])[1]");
	private By messageEditButton = By.cssSelector("a[id='_messagedetails_mainmsgdet_FinDataGrid_editIcon_0'] span[class='editcontent']");
	private By narrativeEditButton = By.xpath("(//span[@class='editcontent'])[11]");
	private By messageDetailsIcon = By.xpath("(//img[@id='_messagedetails_dynmsg_FinTextArea$msgTextExp_image'])[1]");
	private By textArea = By.xpath("(//label[normalize-space()='Message Text Editor'])[1]");
	private By textAreaField = By.xpath("(//textarea[@id='_messagedetails_dynmsg_FinTextArea$msgText_textArea'])[1]");
	private By paysisIdTesxtField = By.xpath("(//input[@id='_miibgen_paysysId'])[1]");
	private By messageAcceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By narrativeSaveButton = By.xpath("(//button[@id='_messagedetails_dynmsg_doneBtn'])[1]");
	private By mtAcceptButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By mtUpdateButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
	private By closeButton2 = By.xpath("(//span[@id='modalCloseIcon'])[2]");						
	private By tenorDetailsContinueButton = By.xpath("(//button[@id='_meobtenor_continue'])[1]"); 
	private By invoiceAmtTextField = By.xpath("(//input[@id='_miibbill_invoiceAmt$amt'])[1]");
	private By monthTextField = By.xpath("(//input[@id='_tenorMonthDays$duration1'])[1]");
	private By dayTextField = By.xpath("(//input[@id='_tenorMonthDays$duration2'])[1]");
	private By tenorAddButton = By.xpath("(//span[@id='_tenordatagrid_AddRecBtn_label'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By updateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By billTenorDropDown = By.xpath("(//select[@id='_billTenor_select'])[1]");
	private By saveAndAddNewButton = By.xpath("(//button[@id='_tenordetails_addCreateNew'])[1]");
	private By saveAndPreviewButton =By.xpath("(//button[@id='_tenordetails_addViewSummary'])[1]");
	private By DocumentStatusDropdown = By.xpath("(//select[@id='_miibbill_docStatus_select'])[1]");
	private By messageDetailsTab = By.xpath("(//span[@id='messagetabid_textSpan'])[1]");
	private By messageDetailsWarning = By.xpath("//div[@id='finAlertDialog']//span[@id='modalCloseIcon']");
	private By messageTypeDropDown = By.xpath("(//select[@id='_messagedetails_mtNo_select'])[1]");
	private By generateButton = By.xpath("(//button[normalize-space()='Generate'])[1]");
	private By span2 = By.id("fbmevent_textSpan");
	private By span3 = By.id("tfccharge_textSpan");	
	private By span4 = By.id("fbmtran_textSpan");
	private By rateTextField = By.xpath("(//input[@id='_miibbill_notConvRateCode$rateCode'])[1]");
	private By receivingBankIdentifierField = By.xpath("(//input[@id='_messagedetails_recvBic'])[1]");
	private By drawerBankTab = By.xpath("(//h2[normalize-space()='Drawer Bank'])[1]");
	private By bankIdentifierTextField = By.xpath("(//input[@id='_meobparty_bicDBdtl'])[1]");
	public static String billId;
	private By accountIdSuccessMessage = By.id("_result_FinMessage1_paraMsg");
	public static String  referenceCsvColumnName = "reference";
	public static String  billIdCsvColumnName = "billId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String  acceptLinkedTcidCsvColumnName = "acceptLinkedTcid";
	public static String  CoAcceptLinkedTcidCsvColumnName = "coAcceptLinkedTcid";

	public static String  verifyAcceptLinkedTcidCsvColumnName = "verifyAcceptLinkedTcid";
	public static String  verifyCoAcceptLinkedTcidCsvColumnName = "verifyCoAcceptLinkedTcid";

	public static String  realizeLinkedTcidCsvColumnName = "realizeLinkedTcid";
	public static String  verifyRealizeLinkedTcidCsvColumnName = "verifyRealizeLinkedTcid";
	private By dueDateField = By.xpath("(//input[@id='_dueDate'])[1]");
	private By warningMessage  = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By dcUtil = By.xpath("(//input[@id='_lcUtilizedAmt$amt'])[1]");

	public ABETradeFinanceImportBillsLodgePage(WebDriver driver) {
		this.driver = driver;
	}
	

	@Step("Sending menu name: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABETradeFinanceImportBillsLodgePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		
		return this;	
	}
	
	@Step("Sending Cif: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysCif(String cif) throws Exception {

		PageFunctionUtils.waitOnElement(driver, cifTextField);
		PageFunctionUtils.clickOnElement(driver,cifTextField);
		PageFunctionUtils.enterDataInWebElement(driver,cifTextField,cif.substring(1));
		return this;
	}
	@Step("Sending doc credit number: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysDocumentCreditNum(String documentCreditNumber) throws Exception {

		PageFunctionUtils.clickOnElement(driver,documentCreditNumberTextField);
		PageFunctionUtils.enterDataInWebElement(driver,documentCreditNumberTextField,documentCreditNumber.substring(1));
		return this;
	}
	
	@Step("Sending bill type: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysBillType(String billType) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billTypeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billTypeTextField,billType);
		return this;
	}
	
	@Step("Sending bill Ccy: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysBillCcy(String billCcy) throws Exception {
        PageFunctionUtils.waitOnElement(driver, billCcyTextField);
		PageFunctionUtils.clickOnElement(driver,billCcyTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billCcyTextField,billCcy);
		return this;
	}
	
	@Step("Sending rate: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysRate(String rateCode) throws Exception {
		if(rateCode != null) {
		PageFunctionUtils.clickOnElement(driver,rateTextField);
		PageFunctionUtils.enterDataInWebElement(driver,rateTextField,rateCode);
	}
		return this;
	
	}
	
	@Step("Press on side tabs")
	public ABETradeFinanceImportBillsLodgePage PressSideTabs() throws Exception {
	

		
		
		PageFunctionUtils.clickOnElement(driver,span2);
		PageFunctionUtils.clickOnElement(driver,span3);
		
		try {
			PageFunctionUtils.waitOnElement(driver, span4);
			PageFunctionUtils.clickOnElement(driver,span4);
			
			
		}catch(Exception e)
		{		
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton1);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			PageFunctionUtils.waitOnElement(driver, span4);
			PageFunctionUtils.clickOnElement(driver,span4);
		}
		
		
		
		return this;
	}
	

	
	@Step("Press under Documentry Credit No Radio Button")
	public ABETradeFinanceImportBillsLodgePage PressunderDocumentryCreditNoRadioButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,underDocumentryCreditNoRadioButton);
		return this;
	}
	
	@Step("Generate message")
	public ABETradeFinanceImportBillsLodgePage generateMessage(String bankIdentfier) throws Exception {
	try {
		
		PageFunctionUtils.selectDropDownListByIndex(driver, messageTypeDropDown, 2);
		PageFunctionUtils.enterDataInWebElement(driver, receivingBankIdentifierField, bankIdentfier);
		PageFunctionUtils.clickOnElement(driver, generateButton);
		PageFunctionUtils.clickOnElement(driver, messageEditButton);
		PageFunctionUtils.clickOnElement(driver, narrativeEditButton);
		PageFunctionUtils.clickOnElement(driver, messageDetailsIcon);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.clickOnElement(driver, textArea);
		PageFunctionUtils.enterDataInWebElement(driver, textAreaField, bankIdentfier);
		PageFunctionUtils.clickOnElement(driver, messageAcceptButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.clickOnElement(driver, narrativeSaveButton);
		PageFunctionUtils.clickOnElement(driver, mtAcceptButton);
		PageFunctionUtils.clickOnElement(driver, mtUpdateButton);
	}catch(Exception e)
	{
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.clickOnElement(driver,messageDetailsWarning);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.selectDropDownListByIndex(driver, messageTypeDropDown, 2);
		PageFunctionUtils.enterDataInWebElement(driver, receivingBankIdentifierField, bankIdentfier);
		PageFunctionUtils.clickOnElement(driver, generateButton);
		PageFunctionUtils.clickOnElement(driver, messageEditButton);
		PageFunctionUtils.clickOnElement(driver, narrativeEditButton);
		PageFunctionUtils.clickOnElement(driver, messageDetailsIcon);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.clickOnElement(driver, textArea);
		PageFunctionUtils.enterDataInWebElement(driver, textAreaField, bankIdentfier);
		PageFunctionUtils.clickOnElement(driver, messageAcceptButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.clickOnElement(driver, narrativeSaveButton);
		PageFunctionUtils.clickOnElement(driver, mtAcceptButton);
		PageFunctionUtils.clickOnElement(driver, mtUpdateButton);
		
	}

		return this;
	}
	
	@Step("Press under Documentry Credit yes Radio Button")
	public ABETradeFinanceImportBillsLodgePage PressunderDocumentryCreditYesRadioButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,underDocumentryCreditYesRadioButton);
		return this;
	}
	
	@Step("Press go Button")
	public ABETradeFinanceImportBillsLodgePage PressGoButton() throws Exception {		
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	@Step("Press message details tab")
	public ABETradeFinanceImportBillsLodgePage PressMessageDetailsTab() throws Exception {		
		
		PageFunctionUtils.clickOnElement(driver, messageDetailsTab);
		
		return this;
	}
	
	@Step("Press update Button")
	public ABETradeFinanceImportBillsLodgePage PressUpdateButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,updateButton);
		return this;
	}
	
	@Step("Sending operative account Id: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysOperativeAcId(String operativeAcId) throws Exception {

		PageFunctionUtils.clickOnElement(driver,operativeAcIdTextField);
		PageFunctionUtils.clearDataInWebElement(driver, operativeAcIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,operativeAcIdTextField,operativeAcId.substring(1));
		return this;
	}
	
	@Step("Sending paysis Id: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysPaysisIdTesxtField(String paysisId) throws Exception {

		PageFunctionUtils.clickOnElement(driver,paysisIdTesxtField);
		PageFunctionUtils.clearDataInWebElement(driver, paysisIdTesxtField);
		PageFunctionUtils.enterDataInWebElement(driver,paysisIdTesxtField,paysisId);
		return this;
	}

	
	@Step("Sending bill amount: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysBillAmount(String billAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, billAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billAmtTextField,billAmount);
		return this;
	}
	@Step("Sending mixed bill amount: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysMixedBillAmount(String billAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,mixedBillAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, mixedBillAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,mixedBillAmtTextField,billAmount);
		return this;
	}
	
	@Step("Sending lodge date: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysLodgeDate(String lodgeDate) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, lodgeDateField);
		PageFunctionUtils.clickOnElement(driver,lodgeDateField);
		PageFunctionUtils.enterDataInWebElement(driver,lodgeDateField,lodgeDate);
		return this;
	}
	
	@Step("Sending due date: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysDueDate(String dueDate) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, dueDateField);
		PageFunctionUtils.clickOnElement(driver,dueDateField);
		PageFunctionUtils.enterDataInWebElement(driver,dueDateField,dueDate);
		return this;
	}
	
	@Step("Sending onboard date: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysOnboardDate(String onboardDate) throws Exception {

		PageFunctionUtils.clearDataInWebElement(driver, onboardDateField);
		PageFunctionUtils.clickOnElement(driver,onboardDateField);

		PageFunctionUtils.enterDataInWebElement(driver,onboardDateField,onboardDate);
		return this;
	}
	
	@Step("Sending bill date: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysBillDate(String billDate) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, billDateField);
		PageFunctionUtils.clickOnElement(driver,billDateField);
		PageFunctionUtils.enterDataInWebElement(driver,billDateField,billDate);
		return this;
	}
	

	@Step("Sending bill country: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysBillCountry(String billCountry) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billCountryTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billCountryTextField,billCountry);
		return this;
	}
	
	@Step("Sending other bank ref number: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysOtherBankRefNum(String otherBankRefNum) throws Exception {

		PageFunctionUtils.clickOnElement(driver,otherBankRefNumTextField);
		PageFunctionUtils.enterDataInWebElement(driver,otherBankRefNumTextField,otherBankRefNum);
		return this;
	}
	
	@Step("Press general details continue button")
	public ABETradeFinanceImportBillsLodgePage PressGeneralDetailsContinueButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,generalDetailsContinueButton);
		return this;
	}
	
	@Step("Send drawer bank identifier")
	public ABETradeFinanceImportBillsLodgePage sendDrawerBankIdentifier(String bankIdentifier) throws Exception {

		PageFunctionUtils.clickOnElement(driver,drawerBankTab);
		PageFunctionUtils.clickOnElement(driver,bankIdentifierTextField);
		PageFunctionUtils.clearDataInWebElement(driver, bankIdentifierTextField);
		PageFunctionUtils.enterDataInWebElement(driver, bankIdentifierTextField, bankIdentifier);

		return this;
	}
	
	@Step("Add mixed-sight bill tenor")
	public ABETradeFinanceImportBillsLodgePage addBill1Tenor(String billAmount, String billType, String onboardDate, String billDate, String dueDate) throws Exception {
		sendKeysMixedBillAmount(billAmount);
		PageFunctionUtils.selectDropDownListByIndex(driver, billTenorDropDown, 1);
		sendKeysOnboardDate(onboardDate);
		sendKeysBillDate(billDate);
		sendKeysDueDate(dueDate);
		try {
		PageFunctionUtils.clickOnElement(driver, dcUtil);
		PageFunctionUtils.clearDataInWebElement(driver, dcUtil);
		PageFunctionUtils.enterDataInWebElement(driver, dcUtil, billAmount);

		PageFunctionUtils.clickOnElement(driver, saveAndAddNewButton);
		}
		catch (Exception e) {
			PageFunctionUtils.clickOnElement(driver, saveAndAddNewButton);
		}
		return this;
	}
	
	@Step("Add mixed-usance bill tenor")
	public ABETradeFinanceImportBillsLodgePage addBill2Tenor(String billAmount, String billType,String month, String day, String onboardDate, String billDate, String dueDate) throws Exception {
		sendKeysMixedBillAmount(billAmount);
		PageFunctionUtils.selectDropDownListByIndex(driver, billTenorDropDown, 2);
		sendKeysTenor(month, day);
		sendKeysOnboardDate(onboardDate);
		sendKeysBillDate(billDate);
		sendKeysDueDate(dueDate);
		try {
			PageFunctionUtils.clickOnElement(driver, dcUtil);
			PageFunctionUtils.clearDataInWebElement(driver, dcUtil);
			PageFunctionUtils.enterDataInWebElement(driver, dcUtil, billAmount);

			PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);
			}
			catch (Exception e) {
				PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);
			}
		return this;
	}
	
	@Step("Press edit button")
	public ABETradeFinanceImportBillsLodgePage PressEditButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,editButton);
		return this;
	}
	@Step("Press tenor add button")
	public ABETradeFinanceImportBillsLodgePage PressTenorAddButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tenorAddButton);
		return this;
	}
	
	@Step("Sending tenor: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysTenor(String month, String day) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, monthTextField);
		PageFunctionUtils.clickOnElement(driver,monthTextField);
		PageFunctionUtils.enterDataInWebElement(driver,monthTextField,month);
		PageFunctionUtils.clearDataInWebElement(driver, dayTextField);
		PageFunctionUtils.clickOnElement(driver,dayTextField);
		PageFunctionUtils.enterDataInWebElement(driver,dayTextField,day);
		return this;
	}
	
	
	@Step("Press party Details Continue button")
	public ABETradeFinanceImportBillsLodgePage PressPartyDetailsContinueButton() throws Exception {
			PageFunctionUtils.clickOnElement(driver,partyDetailsContinueButton);
		
		return this;
	}
	@Step("Press tenor Details Continue button")
	public ABETradeFinanceImportBillsLodgePage PressTenorDetailsContinueButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tenorDetailsContinueButton);
		return this;
	}
	
	@Step("Sending invoice amount: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysinvoiceAmtTextField(String invoiceAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,invoiceAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, invoiceAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,invoiceAmtTextField,invoiceAmount);
		return this;
	}
	
	@Step("Sending Document status:")
	public ABETradeFinanceImportBillsLodgePage sendKeysDocumentStatus() throws Exception {

		PageFunctionUtils.selectDropDownListByIndex(driver, DocumentStatusDropdown, 1);
		return this;
	}
	
	@Step("Sending name: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysName(String name) throws Exception {

		PageFunctionUtils.clickOnElement(driver,nameTextField);
		PageFunctionUtils.enterDataInWebElement(driver,nameTextField,name);
		return this;
	}
	
	@Step("Sending name: {0}")
	public ABETradeFinanceImportBillsLodgePage sendKeysAdress1(String adress1) throws Exception {

		PageFunctionUtils.clickOnElement(driver,adress1TextField);
		PageFunctionUtils.enterDataInWebElement(driver,adress1TextField,adress1);
		return this;
	}
	
	@Step("Press submit button")
	public ABETradeFinanceImportBillsLodgePage PressSubmitButton() throws Exception {
		
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

	
	@Step("Save a/c. id")
	public ABETradeFinanceImportBillsLodgePage saveAccountId(String linkedId, String acceptLinkedTcid, String verifyAcceptLinkedTcid, String realizeLinkedTcid, String verifyRealizeLinkedTcid, String coAcceptLinkedTcid, String verifyCoAcceptLinkedTcid) throws Exception {
	
		  if(linkedId != null) {

              int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, linkedTcidCsvColumnName, linkedId);

              int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, tcIdCsvColumnName, linkedId);
              
              int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, referenceCsvColumnName);

              int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, billIdCsvColumnName);           
              
              
              if(rowByTcid1 != -1 && rowByTcid2 != -1) {

                     CSVUtils.insertValueInCsvCell(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, rowByTcid1, columnByColumnName1, billId);

                     CSVUtils.insertValueInCsvCell(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, rowByTcid2, columnByColumnName2, billId);

              }

       }
		if(acceptLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, acceptLinkedTcidCsvColumnName, acceptLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, acceptLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyAcceptLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, verifyAcceptLinkedTcidCsvColumnName, verifyAcceptLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyAcceptLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		
	
		if(realizeLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, realizeLinkedTcidCsvColumnName, realizeLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, realizeLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyRealizeLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, verifyRealizeLinkedTcidCsvColumnName, verifyRealizeLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyRealizeLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		if(coAcceptLinkedTcid != null) {
			int rowByTcid33 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, CoAcceptLinkedTcidCsvColumnName, coAcceptLinkedTcid);
			int rowByTcid44 = CSVUtils.getRowByTcid(Paths.ABECoAcceptImportBillsTradeFinanceCsv, tcIdCsvColumnName, coAcceptLinkedTcid);
			int columnByColumnName33 = CSVUtils.getColumnByColumnName(Paths.ABECoAcceptImportBillsTradeFinanceCsv, billIdCsvColumnName);
			if(rowByTcid33 != -1 && rowByTcid44 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABECoAcceptImportBillsTradeFinanceCsv, rowByTcid44, columnByColumnName33, billId);
			}
			if(verifyCoAcceptLinkedTcid != null) {
				int rowByTcid55 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, verifyCoAcceptLinkedTcidCsvColumnName, verifyCoAcceptLinkedTcid);
				int rowByTcid66 = CSVUtils.getRowByTcid(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, tcIdCsvColumnName, verifyCoAcceptLinkedTcid);
				int columnByColumnName55 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, billIdCsvColumnName);
				if(rowByTcid55 != -1 && rowByTcid66 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVerifyCoAcceptImportBillsTradeFinanceCsv, rowByTcid66, columnByColumnName55, billId);
				}
			}
		}
		
		return this;
	}		
}
