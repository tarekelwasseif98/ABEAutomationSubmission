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

public class ABEAdviseInwardLCTradeFinancePage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");

	// Search Criteria
	private By documentaryCreditTypeTextField = By.xpath("(//input[@id='_odcmType'])[1]");
	private By ccyTextField = By.xpath("(//input[@id='_dcCurrency_1'])[1]");
	private By cifIDTextFieldSearchCriteria = By.xpath("(//input[@id='_cifId_1'])[1]");
	private By goButtonSearchCriteria = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By errorXButton = By.xpath("(//button[@id='errorTitleBtn'])[1]");
	// General Details
	private By documentaryCreditOpenValue = By.xpath("(//input[@id='_odcmgendet_dcOpenValue$amt'])[1]");
	private By issueDateTextField = By.xpath("(//input[@id='_odcmgendet_issueDate'])[1]");
	private By otherDeatilsSideMenuGeneralDetails = By
			.xpath("(//h2[@id='_odcmgendet_odcmgendet_FinSection3_headerTitle'])[1]");
	private By paySysIDTextFieldOtherDetails = By.xpath("(//input[@id='_odcmgendet_paysysID'])[1]");
	private By otherbankRefNoTextField = By.xpath("(//input[@id='_odcmgendet_otherBankRef'])[1]");

	// Related Party details
	private By relatedPartySideNavigation = By.xpath("(//span[@id='partydetid_textSpan'])[1]");
	// Applicant Details
	private By cifIDApplicantDetailsTextField = By.xpath("(//input[@id='_odcmpartydet_benfCifId'])[1]");
	// Advising Bank
	private By advisingBankSubMenu = By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[25]/div[4]/div[1]/div/div[2]/div[1]/div/span[5]");
	private By bankIdentifierAdvisingBank = By.xpath("(//input[@id='_odcmpartydet_advBic'])[1]");
	// Issuing Bank
	private By issuingBankSubMenu = By.xpath("(//span[@id='_odcmpartydet_partydet_FinSection23_button_title'])[1]");
	private By addressTypeDropDownListIssuingBank = By
			.xpath("(//select[@id='_odcmpartydet_issuingBankAddType_select'])[1]");
	private By bankIdentifierTextField = By.xpath("(//input[@id='_odcmpartydet_issueBic'])[1]");

	// Documentary Credit Details
	private By documentarycreditDetailsSideNavigation = By.xpath("(//span[@id='doccredetid_textSpan'])[1]");
	private By checkTransferable = By.xpath("(//input[@id='_odcmdoccredet_transferrable_checkBox'])[1]");
	private By tenorTypeDropDownList = By.xpath("(//select[@id='_odcmdoccredet_tenor_select'])[1]");
	private By tenorPeriodMonth = By.xpath("(//input[@id='_odcmdoccredet_tenorMonthDay$duration1'])[1]");
	private By tenorPeriodDays = By.xpath("(//input[@id='_odcmdoccredet_tenorMonthDay$duration2'])[1]");

	// Mixed Payment
	private By tenorwiseDetailsImage = By.xpath("(//img[@id='_odcmdoccredet_tenorWiseExp$linkBtn_image'])[1]");
	private By percentageMixed1 = By.xpath("(//input[@id='_odcmdoccredet_tenorPcnt1'])[1]");
	private By percentageMixed2 = By.xpath("(//input[@id='_odcmdoccredet_tenorPcnt2'])[1]");
	private By tenorMixedBalance1 = By.xpath("(//input[@id='_odcmdoccredet_availBal1$amt'])[1]");
	private By tenorMixedBalance2 = By.xpath("(//input[@id='_odcmdoccredet_availBal2$amt'])[1]");
	private By tenorMixedMonth1 = By.xpath("(//input[@id='_odcmdoccredet_tenorMonthDay1$duration1'])[1]");
	private By tenorMixedMonth2 = By.xpath("(//input[@id='_odcmdoccredet_tenorMonthDay2$duration1'])[1]");
	private By dueDateIndicatorDropDown1 = By.xpath("(//select[@id='_odcmdoccredet_dueDateInd1_select'])[1]");
	private By dueDateIndicatorDropDown2 = By.xpath("(//select[@id='_odcmdoccredet_dueDateInd2_select'])[1]");
	private By periodDate1Button = By.xpath("(//button[@id='_odcmdoccredet_startEndDate1$period'])[1]");
	private By period1SelectdropDown = By.xpath("(//select[@id='_odcmdoccredet_startEndDate1$datePeriod_select'])[1]");
	private By periodDate2Button = By.xpath("(//button[@id='_odcmdoccredet_startEndDate2$period'])[1]");
	private By period2SelectDropDown = By.xpath("(//select[@id='_odcmdoccredet_startEndDate2$datePeriod_select'])[1]");
	private By acceptMixedPaymentButton = By.xpath("//button[@id='_odcmdoccredet_btnAccept']");
	private By dueDateIndicatorUsnace = By.xpath("(//select[@id='_odcmdoccredet_dueDateIndctr_select'])[1]");
	
	//Expiry Details
	private By expiryDetailsSubMenu = By.xpath("(//h2[@id='_odcmdoccredet_sc_expiryDetails_headerTitle'])[1]");
	private By expiryDateDocumentaryCreditDetails = By.xpath("(//input[@id='_odcmdoccredet_expDate'])[1]");
	private By placeofExpiryTextField = By.xpath("(//input[@id='_odcmdoccredet_placeofExpiry'])[1]");
	private By counrtyofExpiryTextField = By.xpath("(//input[@id='_odcmdoccredet_countryOfExpiry'])[1]");
	private By confirmationDetailsSideMenu = By.xpath("(//h2[@id='_odcmdoccredet_sc_confDetails_headerTitle'])[1]");
	private By confirmRadioButton = By.xpath("(//input[@id='_odcmdoccredet_confirm_radio'])[1]");
	private By confirmationByDropDown = By.xpath("(//select[@id='_odcmdoccredet_confirmationBy_select'])[1]");
	private By addFullconfirmationRadioButton = By.xpath("(//input[@id='_odcmdoccredet_addConfimatn_F_radio'])[1]");

	// Assignment Details
//	private By assigmentDetailsSideNavigation = By.xpath("(//span[@id='assignid_textSpan'])[1]");
//	private By addAssignmentDetailsButton = By.xpath("(//span[@id='_assignDataGrid_AddRecBtn_label'])[1]");
//	private By cifIDAssigmentDetailsTextField = By.xpath("(//input[@id='_cifId_assign'])[1]");
//	private By ccyAssigmentSettlementAmt = By.xpath("(//input[@id='_assign_SettleAmt_crncy'])[1]");
//	private By settlementAmt = By.xpath("(//input[@id='_assign_SettleAmt$amt'])[1]");
//	private By settlementModeDropDownList = By.xpath("(//select[@id='_assign_SettleMode_select'])[1]");
//	private By chargesBorneByDropDownList = By.xpath("(//select[@id='_assign_chargBrnBy_select'])[1]");
//	private By partyDetailsImageAssigmentDetails = By.xpath("(//img[@id='_partyExp$linkBtn_image'])[1]");
//	private By acceptPartyDetailsButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
//	private By paySysIDAssigmentDetailsTextField = By.xpath("(//input[@id='_paysysId'])[1]");
//	private By saveAndPreviewAssigmentDetailsButton = By.xpath("(//button[@id='_assigndet_addViewSummary'])[1]");

	// Charges Details
	private By chargesSideNavigationButton = By.xpath("(//span[@id='chargeid_textSpan'])[1]");
	private By fetchChargesButton = By.xpath("(//button[@id='_charge_charge_Fetch'])[1]");
	private By continueButtonCharges = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");

	// Message Details
	private By outwardMessageDetailsSideNavigation = By.xpath("(//span[@id='messagetabid_textSpan'])[1]");
	private By xpopErrorMessage = By.xpath("//div[@id='finErrorPopup']//span[@id='modalCloseIcon']");
	private By messageTypeDropDownList = By.xpath("(//select[@id='_messagedetails_mtNo_select'])[1]");
	private By receivingBankIdentifier = By.xpath("(//input[@id='_messagedetails_recvBic'])[1]");
	private By generateMessageButton = By.xpath("(//button[normalize-space()='Generate'])[1]");
	private By editButtonMessageGenerate1 = By.xpath("//a[@id='_messagedetails_mainmsgdet_FinDataGrid_editIcon_0']//span[@class='editcontent']");
	private By editButtonRelatedRefButton = By.xpath("//a[@id='_messagedetails_nameValueLLgrid_editIcon_1']//span[@class='editcontent']");
	private By valueRelatedRefTextField = By.xpath("(//input[@id='_messagedetails_dynmsg_text'])[1]");
	private By saveButtonRelatedRef = By.xpath("(//button[@id='_messagedetails_dynmsg_doneBtn'])[1]");
	private By editbuttonNarrative = By.xpath("//a[@id='_messagedetails_nameValueLLgrid_editIcon_2']//span[@class='editcontent']");
	private By messageNarrativeButton = By
			.xpath("(//img[@id='_messagedetails_dynmsg_FinTextArea$msgTextExp_image'])[1]");
	private By messageNarrativeTextEditor = By
			.xpath("(//textarea[@id='_messagedetails_dynmsg_FinTextArea$msgText_textArea'])[1]");
	private By acceptMessagetextEditor = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By saveButtonMessagetextEditor = By.xpath("(//button[@id='_messagedetails_dynmsg_doneBtn'])[1]");
	private By acceptButtonMessageDetails = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By updateButtonMessageDetails = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By messageTypeGenerateRadioButton = By.xpath("(//input[@id='_messagedetails_mesdet_msgTypeS_radio'])[1]");
	private By submitholidayButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	// Record Summary
//	private By succussMessage = By.xpath("(//p[@id='_resultMsg_paraMsg'])[1]");
	private By DocumentaryCreditNo = By.xpath("(//div[@id='_resultMsg1_text'])[1]");

	public static String docCredit;
	public static String documentaryCreditIdCsvColumnName = "documentaryCreditId";
	public static String tcIdCsvColumnName = "tcId";
	public static String linkedTcidCsvColumnName = "linkedTcId";

	public ABEAdviseInwardLCTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name")
	public ABEAdviseInwardLCTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
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
	public ABEAdviseInwardLCTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Sending documentaryCredit type")
	public ABEAdviseInwardLCTradeFinancePage sendkeysdocumentaryCreditTypeField(String documentaryCreditType,
			String ccySearch, String cifBen) throws Exception {
		PageFunctionUtils.waitOnElement(driver, documentaryCreditTypeTextField);
		PageFunctionUtils.clickOnElement(driver, documentaryCreditTypeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, documentaryCreditTypeTextField, documentaryCreditType);
		PageFunctionUtils.enterDataInWebElement(driver, ccyTextField, ccySearch);
		PageFunctionUtils.enterDataInWebElement(driver, cifIDTextFieldSearchCriteria, cifBen.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButtonSearchCriteria);
		try {
			driver.switchTo().parentFrame();
			PageFunctionUtils.clickOnElement(driver, errorXButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			PageFunctionUtils.clickOnElement(driver, goButtonSearchCriteria);

		} catch (Exception e) {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		
		return this;
	}

	@Step("Enter documentary Credit amount")
	public ABEAdviseInwardLCTradeFinancePage sendkeysdocumentaryCreditAmount(String documentaryCreditAmount,
			String issueDate, String otherDetailsbankRefNo, String paySysID) throws Exception {
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clearDataInWebElement(driver, documentaryCreditOpenValue);
		PageFunctionUtils.enterDataInWebElement(driver, documentaryCreditOpenValue, documentaryCreditAmount);
		PageFunctionUtils.clickOnElement(driver, issueDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, issueDateTextField, issueDate.substring(1));
		PageFunctionUtils.clickOnElement(driver, otherDeatilsSideMenuGeneralDetails);
		PageFunctionUtils.waitOnElement(driver, otherbankRefNoTextField);
		PageFunctionUtils.enterDataInWebElement(driver,otherbankRefNoTextField , otherDetailsbankRefNo);
		PageFunctionUtils.enterDataInWebElement(driver, paySysIDTextFieldOtherDetails, paySysID);
		return this;
	}

	@Step("Enter Related Party Details")
	public ABEAdviseInwardLCTradeFinancePage senkeysRelatedPartyDetails(String cifApplicant,
			String bankIdentifierAdvising, String bankIdentifierIssuingBank) throws Exception {
		PageFunctionUtils.clickOnElement(driver, relatedPartySideNavigation);
		PageFunctionUtils.waitOnElement(driver, cifIDApplicantDetailsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIDApplicantDetailsTextField, cifApplicant.substring(1));
		PageFunctionUtils.clickOnElement(driver, advisingBankSubMenu);
		PageFunctionUtils.clickOnElement(driver, advisingBankSubMenu);
		PageFunctionUtils.waitOnElement(driver, bankIdentifierAdvisingBank);
		PageFunctionUtils.enterDataInWebElement(driver, bankIdentifierAdvisingBank, bankIdentifierAdvising);
		PageFunctionUtils.clickOnElement(driver, issuingBankSubMenu);
		PageFunctionUtils.selectDropDownListByIndex(driver, addressTypeDropDownListIssuingBank, 1);
		PageFunctionUtils.enterDataInWebElement(driver, bankIdentifierTextField, bankIdentifierIssuingBank);
		return this;
	}

	@Step("Select Transferable")
	public ABEAdviseInwardLCTradeFinancePage senkeysCheckTransferable() throws Exception {
		PageFunctionUtils.clickOnElement(driver, documentarycreditDetailsSideNavigation);
		PageFunctionUtils.waitOnElement(driver, checkTransferable);
		PageFunctionUtils.clickOnElement(driver, checkTransferable);
		return this;
	}

	@Step("Select Tenor")
	public ABEAdviseInwardLCTradeFinancePage selectTenor(String tenorType) throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, tenorTypeDropDownList, tenorType);
		return this;
	}
	
	@Step("Enter Mixed Payment Tenor")
	public ABEAdviseInwardLCTradeFinancePage enterMixedPaymentTenor() throws Exception {
		PageFunctionUtils.clickOnElement(driver, tenorwiseDetailsImage);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnElement(driver, percentageMixed1);
		PageFunctionUtils.enterDataInWebElement(driver, percentageMixed1, "50");
		PageFunctionUtils.enterDataInWebElement(driver, percentageMixed2, "50");
		PageFunctionUtils.enterDataInWebElement(driver, tenorMixedBalance1, "5");
		PageFunctionUtils.enterDataInWebElement(driver, tenorMixedBalance2, "5");
		PageFunctionUtils.enterDataInWebElement(driver, tenorMixedMonth1, "5");
		PageFunctionUtils.enterDataInWebElement(driver, tenorMixedMonth2, "10");
		PageFunctionUtils.selectDropDownListByIndex(driver, dueDateIndicatorDropDown1, 6);
		PageFunctionUtils.selectDropDownListByIndex(driver, dueDateIndicatorDropDown2, 6);
		PageFunctionUtils.clickOnElement(driver, periodDate1Button);
		PageFunctionUtils.waitOnElement(driver, period1SelectdropDown);
		PageFunctionUtils.selectDropDownListByIndex(driver, period1SelectdropDown, 3);
		PageFunctionUtils.clickOnElement(driver, periodDate2Button);
		PageFunctionUtils.waitOnElement(driver, period2SelectDropDown);
		PageFunctionUtils.selectDropDownListByIndex(driver, period2SelectDropDown, 3);
		PageFunctionUtils.clickOnElement(driver, acceptMixedPaymentButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Enter Tenor Period")
	public ABEAdviseInwardLCTradeFinancePage enterPeriod() throws Exception {
		driver.findElement(tenorPeriodMonth).sendKeys("1");
		driver.findElement(tenorPeriodDays).sendKeys("1");
		PageFunctionUtils.selectDropDownListByIndex(driver, dueDateIndicatorUsnace, 6);
		return this;
	}

	@Step("Enter Expiry Details")
	public ABEAdviseInwardLCTradeFinancePage expiryDateDetails(String expiryDate, String counrtyOfExpiry) throws Exception {
		PageFunctionUtils.clickOnElement(driver, expiryDetailsSubMenu);
		PageFunctionUtils.clickOnElement(driver, expiryDateDocumentaryCreditDetails);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateDocumentaryCreditDetails, expiryDate.substring(1));
		driver.findElement(placeofExpiryTextField).sendKeys("cairo");
		PageFunctionUtils.enterDataInWebElement(driver, counrtyofExpiryTextField, counrtyOfExpiry);
		return this;
	}
	
	@Step("Select Type of confirmation")
	public ABEAdviseInwardLCTradeFinancePage selectTypeOfConfirmation() throws Exception {
		PageFunctionUtils.clickOnElement(driver, confirmationDetailsSideMenu);
		PageFunctionUtils.waitOnElement(driver, confirmRadioButton);
		PageFunctionUtils.clickOnElement(driver, confirmRadioButton);
		PageFunctionUtils.selectDropDownListByIndex(driver, confirmationByDropDown, 4);
		PageFunctionUtils.clickOnElement(driver, addFullconfirmationRadioButton);
		return this;
	}
	

	@Step("Fetch Charges")
	public ABEAdviseInwardLCTradeFinancePage fetchCharges() throws Exception {
		PageFunctionUtils.clickOnElement(driver, chargesSideNavigationButton);
		PageFunctionUtils.waitOnElement(driver, fetchChargesButton);
		PageFunctionUtils.clickOnElement(driver, fetchChargesButton);
		PageFunctionUtils.clickOnElement(driver, continueButtonCharges);
		return this;
	}

	@Step("Outward Message Details")
	public ABEAdviseInwardLCTradeFinancePage enterMessageDetails(String recBankIdentifier) throws Exception {
		PageFunctionUtils.clickOnElement(driver, outwardMessageDetailsSideNavigation);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnElement(driver, xpopErrorMessage);
		PageFunctionUtils.clickOnElement(driver, xpopErrorMessage);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.waitOnElement(driver, messageTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver,messageTypeDropDownList , 2);
		PageFunctionUtils.enterDataInWebElement(driver, receivingBankIdentifier, recBankIdentifier);
		PageFunctionUtils.clickOnElement(driver, generateMessageButton);
		PageFunctionUtils.waitOnElement(driver, editButtonMessageGenerate1);
		PageFunctionUtils.clickOnElement(driver, editButtonMessageGenerate1);
		PageFunctionUtils.clickOnElement(driver, messageTypeGenerateRadioButton);
		return this;
	}

	@Step("Edit Related Ref")
	public ABEAdviseInwardLCTradeFinancePage editRelatedRef(String valueRelatedRef) throws Exception {
		PageFunctionUtils.clickOnElement(driver, editButtonRelatedRefButton);
		PageFunctionUtils.waitOnElement(driver, valueRelatedRefTextField);
		PageFunctionUtils.enterDataInWebElement(driver, valueRelatedRefTextField, valueRelatedRef);
		PageFunctionUtils.clickOnElement(driver, saveButtonRelatedRef);
		return this;
	}
	
	@Step("Edit Narrative")
	public ABEAdviseInwardLCTradeFinancePage editNarrativeMessage(String textMessageEditor) throws Exception {
		PageFunctionUtils.clickOnElement(driver, editbuttonNarrative);
		PageFunctionUtils.waitOnElement(driver, messageNarrativeButton);
		PageFunctionUtils.clickOnElement(driver, messageNarrativeButton);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnElement(driver, messageNarrativeTextEditor);
		PageFunctionUtils.enterDataInWebElement(driver, messageNarrativeTextEditor, textMessageEditor);
		PageFunctionUtils.clickOnElement(driver, acceptMessagetextEditor);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.clickOnElement(driver,saveButtonMessagetextEditor);
		return this;
	}
	
	@Step("Press Accept Message")
	public ABEAdviseInwardLCTradeFinancePage clickAcceptAndUpdate() throws Exception {
		PageFunctionUtils.clickOnElement(driver, acceptButtonMessageDetails);
		PageFunctionUtils.clickOnElement(driver, updateButtonMessageDetails);
		PageFunctionUtils.clickOnElement(driver, chargesSideNavigationButton);
		PageFunctionUtils.clickOnElement(driver, outwardMessageDetailsSideNavigation);
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnElement(driver, xpopErrorMessage);
		PageFunctionUtils.clickOnElement(driver, xpopErrorMessage);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Press submit button")
	public ABEAdviseInwardLCTradeFinancePage pressSubmitButton() throws Exception {

		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		try {
			driver.switchTo().parentFrame();
			PageFunctionUtils.clickOnElement(driver, submitholidayButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		} catch (Exception e) {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		docCredit = driver.findElement(DocumentaryCreditNo).getText();
		System.out.println("documentaryCredit ID: " + docCredit);
		return this;
	}

	@Step("Save Documentary Credit No")
	public ABEAdviseInwardLCTradeFinancePage saveDocumentaryCreditNo(String linkedTcid) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEADVISEINWARDLCCSV, linkedTcidCsvColumnName, linkedTcid);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEADVISEINWARDLCCSV,documentaryCreditIdCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYADVISEINWARDLCCSV, tcIdCsvColumnName, linkedTcid);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYADVISEINWARDLCCSV,documentaryCreditIdCsvColumnName);
		if (rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEADVISEINWARDLCCSV, rowByTcid1, columnByColumnName1, docCredit);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYADVISEINWARDLCCSV, rowByTcid2, columnByColumnName2, docCredit);
		}
		return this;
	}
}