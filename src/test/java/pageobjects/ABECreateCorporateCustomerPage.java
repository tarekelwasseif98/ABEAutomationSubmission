package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateCorporateCustomerPage {

	private WebDriver driver;

	// Search bar Elements
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By htmlDataFrmIFrameXpath = By.xpath("//frame[@name='HTMLDataFrm'][1]");
	private By crmABEIFrameXpath = By.xpath("//iframe[@name='CRM_ABE'][1]");
	private By loginFrameIframeXpath = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By adminButton = By.xpath("(//input[@id='login_Admin'])[1]");
	private By submitAdminButton = By.xpath("(//input[@id='submitBtn'])[1]");

	// Perform Duplicate Check Elements
	private By docTypeDropDownList = By.xpath("(//select[@id='_dedup_idCode_select'])[1]");
	private By docNumberTextField = By.xpath("(//input[@id='_dedup_idno'])[1]");
	private By corporateCusTypeDropDownList = By.xpath("(//select[@id='_subType_select'])[1]");
	private By companyNameFirstPageTextField = By.xpath("(//input[@id='_dedup_cname'])[1]");
	private By closedCIFsearchButton = By.xpath("//button[@id='_closedcif']");
	private By xbuttoncloseNoMatchFound = By.xpath("//i[@class='material-icons'][normalize-space()='close']");
	private By performDedupButton = By.xpath("//button[@id='_perform_dedup']");
	private By goButton = By.xpath("//button[@id='_bGo']");

	// Basic Details Elements
	private By commercialNameARBasicDetailsTextField = By.xpath("(//input[@id='_commName'])[1]");
	private By tradeNameArBasicDetailsTextField = By.xpath("(//input[@id='_tradeNameAr'])[1]");
	private By legalCompanyNameENBasicDetailsTextField = By.xpath("(//input[@id='_altCorpName'])[1]");
	private By commericalNameENBasicDetailsTextField = By.xpath("(//input[@id='_comnamealt'])[1]");
	private By tradeNameENBasicDetailsTextField = By.xpath("(//input[@id='_tradeNameEn'])[1]");
	private By entityTypeBasicDetailsTextField = By.xpath("(//input[@id='_legalEntityType'])[1]");
	private By subentityTypeBasicDetailsTextField = By.xpath("(//input[@id='_sublegal'])[1]");
	private By establishmentDateBasicDetailsTextField = By.xpath("(//input[@id='_dateOfIncorporation'])[1]");

	//Prospect Customer Elements
	private By legalCompanyNameArabicTextFieldProspect = By.xpath("(//input[@id='_legalarabic'])[1]");
	private By corporateNameENTextFieldProspect = By.xpath("(//input[@id='_corpoName'])[1]");
	private By corporateSegmentPropectTextField = By.xpath("(//input[@id='_corpSegment'])[1]");
	private By legalEnglishNameTextFieldProspect = By.xpath("(//input[@id='_legalenglish'])[1]");
	private By countryOfIncroprationTextFieldProspect = By.xpath("(//input[@id='_countryIncorp'])[1]");
	
	// ID Summary Elements
	private By idSummaryEditButton = By.xpath("(//i[normalize-space()='edit'])[1]");
	private By issueDateDocSummaryTextField = By.xpath("(//input[@id='_issueDate'])[1]");
	private By countryIssueProspectTextField = By.xpath("(//input[@id='_countryOfIssue'])[1]");
	private By updateButtonIDSummary = By.xpath("//button[@id='_pgdocdet_updateSummary']");

	// Address Section Elements
	private By addAddressButton = By.xpath(
			"//button[@id='_addressSum_AddRecBtn_label']//i[@class='material-icons'][normalize-space()='add_circle']");
	private By addressTypeDropDownList = By.xpath("(//select[@id='_addressType_select'])[1]");
	private By addressLine1TextField = By.xpath("(//input[@id='_addrlst_FinCRMAddr1$freeTextAddress1'])[1]");
	private By cityAddressTextField = By.xpath("(//input[@id='_addrlst_FinCRMAddr1$otherDetailsCity'])[1]");
	private By governorateTextField = By.xpath("(//input[@id='_addrlst_FinCRMAddr1$otherDetailsState'])[1]");
	private By countryCodeAddressTextField = By.xpath("(//input[@id='_addrlst_FinCRMAddr1$otherDetailsCountry'])[1]");
	private By saveAndPreviewAddressDetailsButton = By.id("_pgaddressdet_addViewSummary");

	// Phone and Email Summary
	private By addButtonPhoneandEmail = By.xpath(
			"//button[@id='_phoneEmailSum_AddRecBtn_label']//i[@class='material-icons'][normalize-space()='add_circle']");
	private By phoneTypeDropDownList = By.xpath("(//select[@id='_phType_select'])[1]");
	private By phoneNumberTextField = By.xpath("(//input[@id='_phnNo'])[1]");
	private By saveAndPreviewPhoneAndEmailDetailsButton = By.xpath("//button[@id='_pgphemail_addViewSummary']");

	// Other Details Page Elements
	private By otherDetailsNavigateButton = By.xpath("(//span[@title='Other Details'])[1]");
	private By industryTypeTextFieldOtherDetails = By.xpath("(//input[@id='_industryType'])[1]");
	private By corporateRepSubMenuOtherDetails = By
			.xpath("(//h2[normalize-space()='Corporate Representative Details'])[1]");
	private By bankRelationTypeDropDownListOtherDetails = By.xpath("(//select[@id='_bankRelationType_select'])[1]");
	private By relationCIFTextFeildOtherDeatils = By.xpath("(//input[@id='_finRetcifidlookup'])[1]");
	private By designationDropDownListOherDetails = By.xpath("(//select[@id='_designation_select'])[1]");

	// CIF Message Element
	private By saveAndEnrichButton = By.xpath("//button[@id='_saveEnrich']");
	private By cifSUCCESSMessage = By.xpath("//p[@id='_successMessage_paraMsg']");
	private By proceedToEnrichButton = By.xpath("//button[@id='_proceedEnrich']");

	// Enrich Elements
	
	//Prospect Elements
	private By generalDetailsButtonProspectENRICH = By.xpath("(//a[@id='_proslink_gd_link'])[1]");
	private By relationshipDetailsProspectENRICH = By.xpath("(//a[@id='_proslink_rd_link'])[1]");
	
	// Basic Details at General Details
	private By generalDetailsButtonlinkENRICH = By.xpath("(//a[@id='_custlink_gd_link'])[1]");
	private By screeningCheckButtonENRICH = By.xpath("(//button[normalize-space()='Screening Check'])[1]");
	private By xButtonAMLCheckENRICH = By
			.xpath("//a[@id='_closeDialog']//i[@class='material-icons'][normalize-space()='close']");
	private By businessStartDateENRICH = By.xpath("(//input[@id='_busComnDate'])[1]");
	private By statmentDropDownListENRICH = By.xpath("(//select[@id='_crpstatmnt_select'])[1]");
	private By statmentFrequencyDropDownListENRICH = By.xpath("(//select[@id='_bankstsfreq_select'])[1]");
	private By countryofEstablishmentTextFieldENRICH = By.xpath("(//input[@id='_cntryOfOrigin'])[1]");
	private By financialInclusionTypeDropDownENRICH = By.xpath("(//select[@id='_finIncType_select'])[1]");

	// Other Details
	private By otherDetailsMenuENRICH = By.xpath("(//span[@title='Other Details'])[1]");
	private By residencyStatusDropDownListENICH = By.xpath("//select[@id='_residencydetail_select']");
	private By residencyCountryTextFieldENRICH = By.xpath("(//input[@id='_residCntry'])[1]");
	private By fnrFlagDropDownListENRICH = By.xpath("(//select[@id='_nonresindicator_select'])[1]");

	// ABE Specific
	private By abeSpecificNavigationMenuButtonENRICH = By.xpath("(//span[@title='ABE Specific'])[1]");
	private By corporateSegmentDropDownListENRICH = By.xpath("(//select[@id='_compCategory_select'])[1]");
	private By correspInstructionDropDownListENRICH = By.xpath("(//select[@id='_crsInst_select'])[1]");
	private By companyQuailtyDropDownListENRICH = By.xpath("(//select[@id='_accntOpngMthd_select'])[1]");
	private By accountOpeningPurposeDropDownListENRICH = By.xpath("//select[@id='_accntOpngPurps_select']");
	private By anyOfTheCompanyDropDownListENRICH = By.xpath("(//select[@id='_newflag_select'])[1]");
	private By businessSectorDropDownListENRICH = By.xpath("(//select[@id='_businessType_select'])[1]");

	// Risk Details
	private By riskDetailsNavigationMenuButtonENRICH = By.xpath("(//span[@title='Risk Details'])[1]");
	private By searchIconCountydealingButtonENRICH = By.xpath("(//i[@id='_countryofdealingM$searcher_image'])[1]");
	private By categoryCodeTextFieldTextENRICH = By.xpath("(//input[@id='_cat_code'])[1]");
	private By searchCountryDealingButtonENRICH = By.xpath("(//button[normalize-space()='Search'])[1]");
	private By checkBoxCounrtyDealingENRICH = By.xpath("(//div[@role='checkbox'])[1]");
	private By selectButtonCountryDealingENRICH = By.xpath("(//button[normalize-space()='Select'])[1]");
	private By okCountryDealingButtonENRICH = By.xpath("(//button[normalize-space()='OK'])[1]");
	private By pepDropDownListENRICH = By.xpath("(//select[@id='_cpep1_select'])[1]");
	private By companyTypeRiskDropDownList = By.xpath("(//select[@id='_corpCustType_select'])[1]");
	private By companyTypeDropDownListProspect = By.xpath("//select[@id='_companytype_select']");
	private By hrrCompliantDropDownList = By.xpath("(//select[@id='_sasCustomer_select'])[1]");
	private By calculateRiskButtonRiskENRICH = By.xpath("//button[@id='_bCalcRisk']");
	private By riskAssment = By.xpath("(//select[@id='_riskassesmnt_select'])[1]");
	private By fieldHighRisk1 = By.xpath("(//textarea[@id='_crisk1_textArea'])[1]");
	private By fieldHighRisk2 = By.xpath("(//textarea[@id='_crisk2_textArea'])[1]");
	private By fieldHighRisk3 = By.xpath("(//input[@id='_crisk3'])[1]");
	private By fieldHighRisk4 = By.xpath("(//input[@id='_crisk6'])[1]");
	private By fieldHighRisk5 = By.xpath("(//input[@id='_crisk7'])[1]");
	private By selectDropDownHighRisk6 = By.xpath("(//select[@id='_crisk4_select'])[1]");
	private By selectDropDownHighRisk7 = By.xpath("(//select[@id='_crisk5_select'])[1]");
	private By amountHighRisk8 = By.xpath("(//input[@id='_crisk8$amt'])[1]");
	private By amountHighRisk9 = By.xpath("(//input[@id='_crisk9$amt'])[1]");
	private By amountHighRisk10 = By.xpath("(//input[@id='_crisk10$amt'])[1]");
	private By amountHighRisk11 = By.xpath("(//input[@id='_crisk11$amt'])[1]");
	private By amountHighRisk12 = By.xpath("(//input[@id='_crisk12$amt'])[1]");
	private By amountHighRisk13= By.xpath("(//input[@id='_crisk13$amt'])[1]");

	// FATCA Details
	private By fatcaDetailsNavigationMenuENRICH = By.xpath("(//span[@title='FATCA Details'])[1]");
	private By fatca1DropDownListENRICH = By.xpath("(//select[@id='_fortaxrepradgrp_select'])[1]");
	private By fatca2DropDownListENRICH = By.xpath("(//select[@id='_fatcacmp_select'])[1]");
	private By fatca3DropDownListENRICH = By.xpath("(//select[@id='_cfatca1_select'])[1]");
	private By fatca4DropDownListENRICH = By.xpath("(//select[@id='_cfatca3_select'])[1]");

	private By saveAndvalidateGeneralDetailsENRICH = By.xpath("(//button[normalize-space()='Save and Validate'])[1]");
	private By viewSummaryButtonGeneralDetailsENRICH = By.xpath("(//button[normalize-space()='View Summary'])[1]");

	// Relationship Details
	private By relationshipDetailsENRICH = By.xpath("(//a[@id='_custlink_rd_link'])[1]");
	private By editIconRelationshipENRICH = By.xpath("//i[normalize-space()='edit']");
	private By addressTypeDropDownListProspectENRICH = By.xpath("(//select[@id='_corprep_addtype_select'])[1]");
	private By updateButtonRelationshipENRICH = By.xpath("(//button[normalize-space()='Update'])[1]");
	private By saveAndValidateRelationshipDetailsENRICH = By
			.xpath("(//button[normalize-space()='Save and Validate'])[1]");
	private By viewSummaryRelationShipENRICH = By.xpath("(//button[normalize-space()='View Summary'])[1]");

	// Role of Relationship
	private By desginationDropDownListProspectENRICH = By.xpath("(//select[@id='_corprep_desig_select'])[1]");
	private By sreachIconRoleRelationShipENRICH = By.xpath("(//i[@id='_corprep_roles$searcher_image'])[1]");
	private By searchButtonInRoleWindowENRICH = By.xpath("(//button[normalize-space()='Search'])[1]");
	private By checkboxRoleButtonENRICH = By.xpath("(//div[@role='checkbox'])[1]");
	private By selectButtonRoleENRICH = By.xpath("//button[@id='_frwkLWSSelectBtn']");
	private By okRoleSelectionENRICH = By.xpath("//button[@id='_frwkLWSDone']");

	private By submitENRICH = By.xpath("(//button[@id='_landingSubmit'])[1]");
	public static String linkedTcidCsvColumnName = "linkedTcid";
	public static String tcIdCsvColumnName = "tcid";
	public static String cifCsvColumnName = "cif";
	public static String cifID;

	public ABECreateCorporateCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABECreateCorporateCustomerPage sendKeysSearchBarTextField(String menu) throws Exception {
		driver.switchTo().parentFrame();
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
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

	@Step("Select Admin View")
	public ABECreateCorporateCustomerPage openCorporateCustomerFristPage(String docNumber, String cusType) throws Exception {
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, crmABEIFrameXpath);
		PageFunctionUtils.clickOnElement(driver, adminButton);
		PageFunctionUtils.clickOnElement(driver, submitAdminButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, htmlDataFrmIFrameXpath);
		PageFunctionUtils.waitOnElement(driver, docTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, docTypeDropDownList, 1);
		PageFunctionUtils.clickOnElement(driver, docNumberTextField);
		PageFunctionUtils.enterDataInWebElement(driver, docNumberTextField, docNumber.substring(1));
		driver.findElement(companyNameFirstPageTextField).sendKeys("شركة");
		PageFunctionUtils.selectDropDownListByVisibleText(driver, corporateCusTypeDropDownList, cusType);
		PageFunctionUtils.clickOnElement(driver, closedCIFsearchButton);
		PageFunctionUtils.clickOnElement(driver, xbuttoncloseNoMatchFound);
		PageFunctionUtils.clickOnElement(driver, performDedupButton);
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, goButton);

		return this;
	}

	@Step("Enter AR Customer Name")
	public ABECreateCorporateCustomerPage enterARCustomerName() throws Exception {
		PageFunctionUtils.clickOnElement(driver, commercialNameARBasicDetailsTextField);
		driver.findElement(commercialNameARBasicDetailsTextField).sendKeys("شركة");
		PageFunctionUtils.clickOnElement(driver, tradeNameArBasicDetailsTextField);
		driver.findElement(tradeNameArBasicDetailsTextField).sendKeys("شركة");
		return this;
	}

	@Step("Enter EN Customer Name")
	public ABECreateCorporateCustomerPage enterENCustomerName(String legalComName, String commercialENName,
			String tradeNameEN) throws Exception {
		PageFunctionUtils.enterDataInWebElement(driver, legalCompanyNameENBasicDetailsTextField, legalComName);
		PageFunctionUtils.enterDataInWebElement(driver, commericalNameENBasicDetailsTextField, commercialENName);
		PageFunctionUtils.enterDataInWebElement(driver, tradeNameENBasicDetailsTextField, tradeNameEN);
		return this;
	}

	@Step("Enter Entity & Establishment Date Type")
	public ABECreateCorporateCustomerPage enterEntityType(String entityType, String subEntityType,
			String establishmentDate, String countryOfIncorp) throws Exception {
		PageFunctionUtils.clickOnElement(driver, entityTypeBasicDetailsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, entityTypeBasicDetailsTextField, entityType);
		PageFunctionUtils.clickOnElement(driver, subentityTypeBasicDetailsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, subentityTypeBasicDetailsTextField, subEntityType);
		PageFunctionUtils.enterDataInWebElement(driver, establishmentDateBasicDetailsTextField,
				establishmentDate.substring(1));
		// PageFunctionUtils.enterDataInWebElement(driver,
		// countryOfIncorpBasicDetailsTextField, countryOfIncorp);
		return this;
	}

	@Step("Edit ID Summary")
	public ABECreateCorporateCustomerPage editIDsummary(String issueDateIDSummary) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.clickOnElement(driver, idSummaryEditButton);
		PageFunctionUtils.waitOnElement(driver, issueDateDocSummaryTextField);
		PageFunctionUtils.enterDataInWebElement(driver, issueDateDocSummaryTextField, issueDateIDSummary);
		PageFunctionUtils.clickOnElement(driver, updateButtonIDSummary);
		return this;
	}
	
	@Step("Edit Prospect ID Summary")
	public ABECreateCorporateCustomerPage editProspectIDsummary(String issueDateIDSummary, String country) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.clickOnElement(driver, idSummaryEditButton);
		PageFunctionUtils.waitOnElement(driver, issueDateDocSummaryTextField);
		PageFunctionUtils.enterDataInWebElement(driver, countryIssueProspectTextField, country);
		PageFunctionUtils.enterDataInWebElement(driver, issueDateDocSummaryTextField, issueDateIDSummary);
		PageFunctionUtils.clickOnElement(driver, updateButtonIDSummary);
		return this;
	}

	@Step("Add work Address Customer")
	public ABECreateCorporateCustomerPage addWorkAddressCustomer(String addressLine1, String cityAddress,
			String governorate, String country) throws Exception {
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, addAddressButton);
		PageFunctionUtils.waitOnElement(driver, addressTypeDropDownList);
		PageFunctionUtils.enterDataInWebElement(driver, addressLine1TextField, addressLine1);
		PageFunctionUtils.enterDataInWebElement(driver, cityAddressTextField, cityAddress.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, governorateTextField, governorate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, countryCodeAddressTextField, country);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		return this;
	}

	@Step("Add Mailing Address Customer")
	public ABECreateCorporateCustomerPage addMailingAddressCustomer(String addressLine1, String cityAddress,
			String governorate, String country) throws Exception {
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, addAddressButton);
		PageFunctionUtils.waitOnElement(driver, addressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, addressTypeDropDownList, 3);
		PageFunctionUtils.enterDataInWebElement(driver, addressLine1TextField, addressLine1);
		PageFunctionUtils.enterDataInWebElement(driver, cityAddressTextField, cityAddress.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, governorateTextField, governorate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, countryCodeAddressTextField, country);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		return this;
	}

	@Step("Add Phone & Email Summary")
	public ABECreateCorporateCustomerPage addPhoneAndEmailSummary(String phoneNumber) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.clickOnElement(driver, addButtonPhoneandEmail);
		PageFunctionUtils.waitOnElement(driver, phoneTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, phoneTypeDropDownList, 1);
		PageFunctionUtils.enterDataInWebElement(driver, phoneNumberTextField, phoneNumber.substring(1));
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewPhoneAndEmailDetailsButton);
		return this;
	}

	@Step("Navigate to Other Details")
	public ABECreateCorporateCustomerPage naigavteOtherDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, otherDetailsNavigateButton);
		return this;
	}

	@Step("Select Industry Type")
	public ABECreateCorporateCustomerPage selectIndustryType(String industryType) throws Exception {
		PageFunctionUtils.clickOnElement(driver, industryTypeTextFieldOtherDetails);
		PageFunctionUtils.enterDataInWebElement(driver, industryTypeTextFieldOtherDetails, industryType.substring(1));
		return this;
	}

	@Step("Corporate Rep Details")
	public ABECreateCorporateCustomerPage corporateRepDetails(String relationShip, String cifInrelation)
			throws Exception {
		PageFunctionUtils.clickOnElement(driver, corporateRepSubMenuOtherDetails);
		PageFunctionUtils.clickOnElement(driver, corporateRepSubMenuOtherDetails);

		PageFunctionUtils.waitOnElement(driver, bankRelationTypeDropDownListOtherDetails);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, bankRelationTypeDropDownListOtherDetails,
				relationShip);
		PageFunctionUtils.enterDataInWebElement(driver, relationCIFTextFeildOtherDeatils, cifInrelation.substring(1));
		PageFunctionUtils.selectDropDownListByIndex(driver, designationDropDownListOherDetails, 1);
		return this;
	}
	
	@Step("Prospect Customer")
	public ABECreateCorporateCustomerPage prospectCustomer() throws Exception{
		PageFunctionUtils.enterDataInWebElement(driver, legalCompanyNameArabicTextFieldProspect, "الشركة" );
		PageFunctionUtils.enterDataInWebElement(driver, corporateNameENTextFieldProspect, "Company");
		PageFunctionUtils.enterDataInWebElement(driver, corporateSegmentPropectTextField , "CO");
		PageFunctionUtils.enterDataInWebElement(driver, legalEnglishNameTextFieldProspect, "Company");
		return this;
	}
	
	@Step("Select Prospect Country of Incorporation")
	public ABECreateCorporateCustomerPage enterCountryOfIncorporationProscpect() throws Exception {
		PageFunctionUtils.clickOnElement(driver, countryOfIncroprationTextFieldProspect);
		PageFunctionUtils.enterDataInWebElement(driver, countryOfIncroprationTextFieldProspect, "EG");
		return this;
	}

	@Step("Save and Enrich")
	public ABECreateCorporateCustomerPage saveAndEnrich() throws Exception {
		PageFunctionUtils.waitOnElement(driver, saveAndEnrichButton);
		PageFunctionUtils.clickOnElement(driver, saveAndEnrichButton);
		cifID = driver.findElement(cifSUCCESSMessage).getText().substring(42);
		System.out.println("CIF: " + cifID);
		return this;

	}

	@Step("Save CIF")
	public ABECreateCorporateCustomerPage saveCIF(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATECORPORATECUSTOMERCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATECORPORATECUSTOMERCSV, cifCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYCORPORATECUSTOMERCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYCORPORATECUSTOMERCSV, cifCsvColumnName);
		if (rowByTcid1 != -1  && rowByTcid2 != -1 ) {
			CSVUtils.insertValueInCsvCell(Paths.ABECREATECORPORATECUSTOMERCSV, rowByTcid1, columnByColumnName1, cifID);
			 CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYCORPORATECUSTOMERCSV,rowByTcid2, columnByColumnName2, cifID);
		}
		return this;
	}

	// ENRICH PROCESS
	@Step("Proceed to Enrich")
	public ABECreateCorporateCustomerPage proceedtoEnrich() throws Exception {
		PageFunctionUtils.waitOnElement(driver, proceedToEnrichButton);
		PageFunctionUtils.clickOnElement(driver, proceedToEnrichButton);
		return this;
	}

	@Step("Open Prospect General Details")
	public ABECreateCorporateCustomerPage generalDetailsProspectOption()
			throws Exception {
		PageFunctionUtils.clickOnElement(driver, generalDetailsButtonProspectENRICH);
		PageFunctionUtils.clickOnElement(driver, screeningCheckButtonENRICH);
		PageFunctionUtils.waitOnElement(driver, xButtonAMLCheckENRICH);
		PageFunctionUtils.clickOnElement(driver, xButtonAMLCheckENRICH);

		return this;
	}
	
	@Step("Open General Details")
	public ABECreateCorporateCustomerPage generalDetailsOption(String busStartDate, String countryEstablishment)
			throws Exception {
		PageFunctionUtils.clickOnElement(driver, generalDetailsButtonlinkENRICH);
		PageFunctionUtils.clickOnElement(driver, screeningCheckButtonENRICH);
		PageFunctionUtils.waitOnElement(driver, xButtonAMLCheckENRICH);
		PageFunctionUtils.clickOnElement(driver, xButtonAMLCheckENRICH);
		PageFunctionUtils.enterDataInWebElement(driver, businessStartDateENRICH, busStartDate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, countryofEstablishmentTextFieldENRICH, countryEstablishment);
		PageFunctionUtils.selectDropDownListByIndex(driver, financialInclusionTypeDropDownENRICH, 3);
		return this;
	}

	@Step("Bank Statment Details")
	public ABECreateCorporateCustomerPage bankStatmentDetails() throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, statmentDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, statmentFrequencyDropDownListENRICH, 1);
		return this;
	}

	// Other Details
	@Step("Residential Details")
	public ABECreateCorporateCustomerPage residentialDetails(String residenceCounrty) throws Exception {
		PageFunctionUtils.clickOnElement(driver, otherDetailsMenuENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver, residencyStatusDropDownListENICH, 1);
		PageFunctionUtils.enterDataInWebElement(driver, residencyCountryTextFieldENRICH, residenceCounrty);
		PageFunctionUtils.selectDropDownListByIndex(driver, fnrFlagDropDownListENRICH, 1);
		return this;
	}

	// ABE Specific
	@Step("ABE Specific")
	public ABECreateCorporateCustomerPage abeSpecific() throws Exception {
		PageFunctionUtils.clickOnElement(driver, abeSpecificNavigationMenuButtonENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver, corporateSegmentDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, correspInstructionDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, companyQuailtyDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, accountOpeningPurposeDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, anyOfTheCompanyDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, businessSectorDropDownListENRICH, 1);
		return this;
	}

	// Risk Details
	@Step("Counrty Dealing at Risk Details")
	public ABECreateCorporateCustomerPage countryDealingRiskDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, riskDetailsNavigationMenuButtonENRICH);
		PageFunctionUtils.waitOnElement(driver, searchIconCountydealingButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, searchIconCountydealingButtonENRICH);
		PageFunctionUtils.waitOnElement(driver, categoryCodeTextFieldTextENRICH);
		driver.findElement(categoryCodeTextFieldTextENRICH).sendKeys("EG");
		PageFunctionUtils.clickOnElement(driver, searchCountryDealingButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, checkBoxCounrtyDealingENRICH);
		PageFunctionUtils.clickOnElement(driver, selectButtonCountryDealingENRICH);
		PageFunctionUtils.clickOnElement(driver, okCountryDealingButtonENRICH);
		return this;
	}

	@Step("Calclate Risk at Risk Details Prospect")
	public ABECreateCorporateCustomerPage calculateRiskProspect(/*String industryType*/) throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, hrrCompliantDropDownList, 2);
		//PageFunctionUtils.enterDataInWebElement(driver, industryTypeProspectENRICH, industryType);
		PageFunctionUtils.selectDropDownListByIndex(driver, pepDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, companyTypeDropDownListProspect, 4);
		PageFunctionUtils.clickOnElement(driver, calculateRiskButtonRiskENRICH);
		return this;
	}
	
	@Step("Calclate Risk at Risk Details")
	public ABECreateCorporateCustomerPage calculateRisk() throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, hrrCompliantDropDownList, 2);	
		PageFunctionUtils.selectDropDownListByIndex(driver, pepDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, companyTypeRiskDropDownList, 1);
		PageFunctionUtils.clickOnElement(driver, calculateRiskButtonRiskENRICH);
		return this;
	}
	
//	@Step("High Risk Return")
//	public  String highRiskReturnValu() throws Exception{
//	String highRisk = driver.findElement(riskAssment).getText();
//	return highRisk;
//	}
	@Step("High Risk Details")
	public  ABECreateCorporateCustomerPage highRiskDetailsCustomer() throws Exception {
		try {
			PageFunctionUtils.clickOnElement(driver, fieldHighRisk1);
    		PageFunctionUtils.enterDataInWebElement(driver, fieldHighRisk1, "Test");
    		PageFunctionUtils.enterDataInWebElement(driver, fieldHighRisk2, "Test");
    		PageFunctionUtils.enterDataInWebElement(driver, fieldHighRisk3, "Test");
    		PageFunctionUtils.selectDropDownListByIndex(driver, selectDropDownHighRisk6, 2);
    		PageFunctionUtils.selectDropDownListByIndex(driver, selectDropDownHighRisk7, 2);
    		PageFunctionUtils.enterDataInWebElement(driver, fieldHighRisk4, "Test");
    		PageFunctionUtils.enterDataInWebElement(driver, fieldHighRisk5, "Test");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk8, "10");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk9, "10");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk10, "10");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk11, "10");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk12, "10");
    		PageFunctionUtils.enterDataInWebElement(driver, amountHighRisk13, "10");

		} catch (Exception e) {
		}
	        return this;
	}

	// FATCA Details
	@Step("FATCA")
	public ABECreateCorporateCustomerPage fatcaDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, fatcaDetailsNavigationMenuENRICH);
		PageFunctionUtils.waitOnElement(driver, fatca1DropDownListENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver, fatca1DropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, fatca2DropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, fatca3DropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, fatca4DropDownListENRICH, 2);
		return this;
	}

	// Save and Validate
	@Step("Save and validate General Details")
	public ABECreateCorporateCustomerPage saveAndValidateGeneralDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, saveAndvalidateGeneralDetailsENRICH);
		PageFunctionUtils.waitOnElement(driver, viewSummaryButtonGeneralDetailsENRICH);
		PageFunctionUtils.clickOnElement(driver, viewSummaryButtonGeneralDetailsENRICH);
		return this;
	}
	
	//Relationship details
	@Step("Relationship Details")
	public ABECreateCorporateCustomerPage openRelationShipDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, relationshipDetailsENRICH);
		PageFunctionUtils.waitOnElement(driver, editIconRelationshipENRICH);
		PageFunctionUtils.clickOnElement(driver, editIconRelationshipENRICH);
		PageFunctionUtils.clickOnElement(driver, sreachIconRoleRelationShipENRICH);
		PageFunctionUtils.clickOnElement(driver, searchButtonInRoleWindowENRICH);
		PageFunctionUtils.clickOnElement(driver, checkboxRoleButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, selectButtonRoleENRICH);
		PageFunctionUtils.clickOnElement(driver, okRoleSelectionENRICH);
		PageFunctionUtils.clickOnElement(driver, updateButtonRelationshipENRICH);
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, saveAndValidateRelationshipDetailsENRICH); 
		PageFunctionUtils.waitOnElement(driver, viewSummaryRelationShipENRICH);
		PageFunctionUtils.clickOnElement(driver, viewSummaryRelationShipENRICH);
		return this;
	}
	
	//Relationship details
		@Step("Relationship Details Prospect")
		public ABECreateCorporateCustomerPage openRelationShipDetailsProspect() throws Exception {
			PageFunctionUtils.clickOnElement(driver, relationshipDetailsProspectENRICH);
			PageFunctionUtils.waitOnElement(driver, editIconRelationshipENRICH);
			PageFunctionUtils.clickOnElement(driver, editIconRelationshipENRICH);
			PageFunctionUtils.selectDropDownListByIndex(driver, desginationDropDownListProspectENRICH, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, addressTypeDropDownListProspectENRICH, 4);
			PageFunctionUtils.clickOnElement(driver, sreachIconRoleRelationShipENRICH);
			PageFunctionUtils.clickOnElement(driver, searchButtonInRoleWindowENRICH);
			PageFunctionUtils.clickOnElement(driver, checkboxRoleButtonENRICH);
			PageFunctionUtils.clickOnElement(driver, selectButtonRoleENRICH);
			PageFunctionUtils.clickOnElement(driver, okRoleSelectionENRICH);
			PageFunctionUtils.clickOnElement(driver, updateButtonRelationshipENRICH);
			PageFunctionUtils.sleep2();
			PageFunctionUtils.clickOnElement(driver, saveAndValidateRelationshipDetailsENRICH);
			PageFunctionUtils.waitOnElement(driver, viewSummaryRelationShipENRICH);
			PageFunctionUtils.clickOnElement(driver, viewSummaryRelationShipENRICH);
			return this;
		}
	
	//Submit Enrich
	@Step("Submit Enrich")
	public ABECreateCorporateCustomerPage submitEnrich() throws Exception {
		System.out.println("this is submit step");
		PageFunctionUtils.waitOnElement(driver, submitENRICH);
		PageFunctionUtils.clickOnElement(driver, submitENRICH);
		return this;
	}
}