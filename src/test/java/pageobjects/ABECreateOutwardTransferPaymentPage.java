package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateOutwardTransferPaymentPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_cFinFuncCode$funcCombo_select'])[1]");
	private By paySysTextField = By.xpath("(//input[@id='_cPaysysID'])[1]");
	private By paymentTypeDropdown = By.xpath("(//select[@id='_cPaymentType_select'])[1]");
	private By goButton = By.id("_go");
	private By accountRemTextField = By.xpath("(//input[@id='_debtorAcID'])[1]");
	private By nameRemTextField = By.xpath("(//input[@id='_debtorName'])[1]");
	private By addressRemLine1TextField = By.xpath("(//input[@id='_genDebAddLine1'])[1]");
	private By addressRemLine2TextField = By.xpath("(//input[@id='_genDebAddLine2'])[1]");
	private By purposeCode = By.xpath("(//input[@id='_genInsPurCode'])[1]");
	private By currencyTextField = By.xpath("(//input[@id='_genInsReqAmt_crncy'])[1]");
	private By amountTextField = By.xpath("(//input[@id='_genInsReqAmt$amt'])[1]");
	private By additionalInstrumentDetailsDropDown = By
			.xpath("(//h3[normalize-space()='Additional Instrument Details'])[1]");
	private By futureValueDateTextField = By.xpath(("(//input[@id='_genInsDate'])[1]"));
	private By remittanceInfoDropDown = By.xpath("(//h3[normalize-space()='Remittance Information'])[1]");
	private By line1TextField = By.xpath("(//input[@id='_remittanceInfo1'])[1]");
	private By accountBenTextField = By.id("_genCredAcID");
	private By nameBenTextField = By.id("_genCreName");
	private By addressBenLine1TextField = By.xpath("(//input[@id='_genCrAddress1'])[1]");
	private By addressBenLine2TextField = By.xpath("(//input[@id='_genCrAddress2'])[1]");
	private By bicBenTextField = By.id("_genCrBank_bic$bic");
	private By networkBenTextField = By.id("_genCrBank_bic$networkId");
	private By additionalChargeDropDown = By.xpath("(//h3[normalize-space()='Additional Charge Account Details'])[1]");
	private By chargeType = By.xpath("(//select[@id='_genInsChrgType_select'])[1]");
	private By additionalDebtorDropDown = By.xpath("(//h3[normalize-space()='Additional Debtor Details'])[1]");
	private By additionalCreditorDropDown = By.xpath("(//h3[normalize-space()='Additional Creditor Details'])[1]");
	private By countryCodeREMTextField = By.xpath("//input[@id='_genCrCountry']");
	private By enrichButton = By.id(("_fetch"));
	private By continueButton = By.id("_genContinue");
	private By waiveChargeRemarkTextField = By.xpath("(//textarea[@id='_custWaivChrgRsn_textArea'])[1]");
	private By continueChargeButton = By.xpath("(//button[@id='_chargeContinue'])[1]");
	private By submitduplicateButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By waiveChargesYes = By.xpath("(//div[@id='_waiveChrgYes_compDiv'])[1]");
	private By waiveChargesNo = By.xpath("(//div[@id='_waiveChrgNo_compDiv'])[1]");
	private By submitPayment = By.id("_submit");
	private String posCsvColumnName = "Pos";
	private String linkedTcidCsvColumnName = "VerifylinkedTcid";
	private String authLinkedTcidCsvColumnName = "AuthLinkedTcid";
	private String tcIdCsvColumnName = "tcId";
	private String poID;
	private By paymentOrderIDOutput = By.xpath("(//div[@id='_resultPOID_text'])[1]");

	public ABECreateOutwardTransferPaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABECreateOutwardTransferPaymentPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateOutwardTransferPaymentPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(("loginFrame"));
		driver.switchTo().frame(("Core_ABE"));
		driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Sending payment details: {0}")
	public ABECreateOutwardTransferPaymentPage sendKeysPaymentType(String serviceID, String paysys) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);

		// Select Drop Down Action
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(1);

		// Select Service ID
		PageFunctionUtils.clickOnElement(driver, paymentTypeDropdown);
		Select serviceIDDropdownSelector = new Select(driver.findElement(paymentTypeDropdown));
		serviceIDDropdownSelector.selectByVisibleText(serviceID);

		// Enter Paysys
		PageFunctionUtils.enterDataInWebElement(driver, paySysTextField, paysys);
		return this;

	}

	@Step("Press Go button")
	public ABECreateOutwardTransferPaymentPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}

	@Step("Sending ACH Outward Payment details: {0}")
	public ABECreateOutwardTransferPaymentPage sendKeysAchOutwardPayment(String countryCodeREM, String waiveRemark,
			String waiveChargeRadio, String chargetype, String accRem, String ccy, String nameRem, String address1_Ben,
			String address2_Ben, String purcode, String address1_Rem, String address2_Rem, String amount, String date,
			String line1, String accBen, String nameBen, String bicBen, String networkBen, String bankBen,
			String branchBen) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accountRemTextField);

		// Enter Account Debtor
		String substringAcc = accRem.substring(1);
		PageFunctionUtils.enterDataInWebElement(driver, accountRemTextField, substringAcc);

		// Enter Name Debtor
		PageFunctionUtils.clickOnElement(driver, nameRemTextField);
		PageFunctionUtils.clearDataInWebElement(driver, nameRemTextField);
		PageFunctionUtils.enterDataInWebElement(driver, nameRemTextField, nameRem);

		// Enter Address1 Debtor
		PageFunctionUtils.clickOnElement(driver, additionalDebtorDropDown);
		PageFunctionUtils.clearDataInWebElement(driver, addressRemLine1TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressRemLine1TextField, address1_Rem);

		// Enter Address2 Debtor
		PageFunctionUtils.clearDataInWebElement(driver, addressRemLine2TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressRemLine2TextField, address2_Rem);

		// Enter CCY
		PageFunctionUtils.enterDataInWebElement(driver, currencyTextField, ccy);

		// Enter Amount
		PageFunctionUtils.clearDataInWebElement(driver, amountTextField);
		String substringAmount = amount.substring(1);
		PageFunctionUtils.enterDataInWebElement(driver, amountTextField, substringAmount);

		// Select Waive Charges
		if (waiveChargeRadio.equals("YES")) {
			PageFunctionUtils.clickOnElement(driver, waiveChargesYes);
			PageFunctionUtils.clickOnElement(driver, waiveChargeRemarkTextField);
			PageFunctionUtils.enterDataInWebElement(driver, waiveChargeRemarkTextField, waiveRemark);

		} else if (waiveChargeRadio.equals("NO")) {
			PageFunctionUtils.clickOnElement(driver, waiveChargesNo);
		}
		// Enter Purpose Code
		PageFunctionUtils.clickOnElement(driver, purposeCode);
		PageFunctionUtils.enterDataInWebElement(driver, purposeCode, purcode);

		if (waiveChargeRadio.equals("NO")) {
			// Select Charge Type
			PageFunctionUtils.clickOnElement(driver, additionalChargeDropDown);
			Select renewalDropdownSelector = new Select(driver.findElement(chargeType));
			renewalDropdownSelector.selectByVisibleText(chargetype);
		}
		// Enter Future Value Date
		PageFunctionUtils.waitOnElement(driver, additionalInstrumentDetailsDropDown);
		PageFunctionUtils.clickOnElement(driver, additionalInstrumentDetailsDropDown);
		PageFunctionUtils.clickOnElement(driver, futureValueDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, futureValueDateTextField, date);

		// Enter Remittance Information
		PageFunctionUtils.clickOnElement(driver, remittanceInfoDropDown);
		PageFunctionUtils.enterDataInWebElement(driver, line1TextField, line1);

		// Enter Account Creditor
		PageFunctionUtils.enterDataInWebElement(driver, accountBenTextField, accBen);

		// Enter Name Creditor
		PageFunctionUtils.enterDataInWebElement(driver, nameBenTextField, nameBen);

		// Enter BIC Creditor
		PageFunctionUtils.enterDataInWebElement(driver, bicBenTextField, bicBen);

		// Enter Network Creditor
		PageFunctionUtils.enterDataInWebElement(driver, networkBenTextField, networkBen);

		// Enter Address1 Creditor
		PageFunctionUtils.clickOnElement(driver, additionalCreditorDropDown);
		PageFunctionUtils.clearDataInWebElement(driver, addressBenLine1TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressBenLine1TextField, address1_Ben);

		// Enter Address2 Creditor
		PageFunctionUtils.waitOnElement(driver, addressBenLine2TextField);
		PageFunctionUtils.clearDataInWebElement(driver, addressBenLine2TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressBenLine2TextField, address2_Ben);

//		Enter Country Code Creditor 
		PageFunctionUtils.sleep2();
		PageFunctionUtils.enterDataInWebElement(driver, countryCodeREMTextField, countryCodeREM);
		/*
		 * String s1 = BankBen.substring(2); String s2 = BranchBen.substring(3);
		 * 
		 * System.out.println(s1); System.out.println(s2);
		 * 
		 * driver.findElement(bankBenTextField).sendKeys(s1);
		 * 
		 * driver.findElement(branchBenTextField).sendKeys(s2);
		 */

		// Click Enrich Button
		PageFunctionUtils.clickOnElement(driver, enrichButton);

		// Click Continue Button
		PageFunctionUtils.clickOnElement(driver, continueButton);

//		//Click Charge fetch button
//		PageFunctionUtils.clickOnElement(driver,chargeFetchButton);

		// Click Continue Charge button
		//PageFunctionUtils.clickOnElement(driver, continueChargeButton);

		// Submit button
		PageFunctionUtils.clickOnElement(driver, submitPayment);

		try {
			driver.switchTo().parentFrame();
			PageFunctionUtils.clickOnElement(driver, submitduplicateButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		} catch (Exception e) {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		poID = driver.findElement(paymentOrderIDOutput).getText();
		System.out.print(poID);
		return this;
	}

	@Step("Save POID")
	public ABECreateOutwardTransferPaymentPage savePOID(String paysysId, String linkedId, String authLinkedTcid) throws Exception {
		if (paysysId.equals("ACH")) {
			int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATEACHOUTWARDCSV, linkedTcidCsvColumnName,
					linkedId);
			int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATEACHOUTWARDCSV,
					posCsvColumnName);
			int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACHOUTWARDCSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACHOUTWARDCSV,
					posCsvColumnName);
			if (rowByTcid1 != -1 && rowByTcid2 != -1 ) {
				
				CSVUtils.insertValueInCsvCell(Paths.ABECREATEACHOUTWARDCSV, rowByTcid1, columnByColumnName1,
						poID);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACHOUTWARDCSV, rowByTcid2, columnByColumnName2,
						poID);
			}
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABECREATEACHOUTWARDCSV, authLinkedTcidCsvColumnName, authLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEATHORIZEACHOUTWARDCSV, tcIdCsvColumnName, authLinkedTcid);
			int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABEATHORIZEACHOUTWARDCSV, posCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEATHORIZEACHOUTWARDCSV, rowByTcid4, columnByColumnName4, poID);
			}
			return this;
			
			
			
			
		} else if (paysysId.equals("ACHUS")) {
			int rowByTcid11 = CSVUtils.getRowByTcid(Paths.ABECREATEACHUSOUTWARDCSV, linkedTcidCsvColumnName,
					linkedId);
			int columnByColumnName11 = CSVUtils.getColumnByColumnName(Paths.ABECREATEACHUSOUTWARDCSV,
					posCsvColumnName);
			int rowByTcid22 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACHUSOUTWARDCSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName22 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACHUSOUTWARDCSV,
					posCsvColumnName);
			if (rowByTcid11 != -1 && rowByTcid22 != -1 ) {
				
				CSVUtils.insertValueInCsvCell(Paths.ABECREATEACHUSOUTWARDCSV, rowByTcid11, columnByColumnName11,
						poID);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACHUSOUTWARDCSV, rowByTcid22, columnByColumnName22,
						poID);
			}
			int rowByTcid33 = CSVUtils.getRowByTcid(Paths.ABECREATEACHUSOUTWARDCSV, authLinkedTcidCsvColumnName, authLinkedTcid);
			int rowByTcid44 = CSVUtils.getRowByTcid(Paths.ABEATHORIZEACHUSOUTWARDCSV, tcIdCsvColumnName, authLinkedTcid);
			int columnByColumnName44 = CSVUtils.getColumnByColumnName(Paths.ABEATHORIZEACHUSOUTWARDCSV, posCsvColumnName);
			if(rowByTcid33 != -1 && rowByTcid44 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEATHORIZEACHUSOUTWARDCSV, rowByTcid44, columnByColumnName44, poID);
			}
			return this;
			
			
			
			
			
		} else if (paysysId.equals("ACHER")) {
			int rowByTcid111 = CSVUtils.getRowByTcid(Paths.ABECREATEACHEROUTWARDCSV, linkedTcidCsvColumnName,
					linkedId);
			int columnByColumnName111 = CSVUtils.getColumnByColumnName(Paths.ABECREATEACHEROUTWARDCSV,
					posCsvColumnName);
			int rowByTcid222 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACHEROUTWARDCSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName222 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACHEROUTWARDCSV,
					posCsvColumnName);
			if (rowByTcid111 != -1 && rowByTcid222 != -1 ) {
				
				CSVUtils.insertValueInCsvCell(Paths.ABECREATEACHEROUTWARDCSV, rowByTcid111, columnByColumnName111,
						poID);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACHEROUTWARDCSV, rowByTcid222, columnByColumnName222,
						poID);
			}
			int rowByTcid333 = CSVUtils.getRowByTcid(Paths.ABECREATEACHEROUTWARDCSV, authLinkedTcidCsvColumnName, authLinkedTcid);
			int rowByTcid444 = CSVUtils.getRowByTcid(Paths.ABEATHORIZEACHEROUTWARDCSV, tcIdCsvColumnName, authLinkedTcid);
			int columnByColumnName444 = CSVUtils.getColumnByColumnName(Paths.ABEATHORIZEACHEROUTWARDCSV, posCsvColumnName);
			if(rowByTcid333 != -1 && rowByTcid444 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEATHORIZEACHEROUTWARDCSV, rowByTcid444, columnByColumnName444, poID);
			}
			return this;
		}
		
		
		
		
		

		else if (paysysId.equals("SWIFT")) {
			int rowByTcid1111 = CSVUtils.getRowByTcid(Paths.ABECREATESWIFTOUTWARDCSV, linkedTcidCsvColumnName,
					linkedId);
			int columnByColumnName1111 = CSVUtils.getColumnByColumnName(Paths.ABECREATESWIFTOUTWARDCSV,
					posCsvColumnName);
			int rowByTcid2222 = CSVUtils.getRowByTcid(Paths.ABEVERIFYSWIFTOUTWARDCSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName2222 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYSWIFTOUTWARDCSV,
					posCsvColumnName);
			if (rowByTcid1111 != -1 && rowByTcid2222 != -1 ) {
				
				CSVUtils.insertValueInCsvCell(Paths.ABECREATESWIFTOUTWARDCSV, rowByTcid1111, columnByColumnName1111,
						poID);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYSWIFTOUTWARDCSV, rowByTcid2222, columnByColumnName2222,
						poID);
			}
			int rowByTcid3333 = CSVUtils.getRowByTcid(Paths.ABECREATESWIFTOUTWARDCSV, authLinkedTcidCsvColumnName, authLinkedTcid);
			int rowByTcid4444 = CSVUtils.getRowByTcid(Paths.ABEATHORIZESWIFTOUTWARDCSV, tcIdCsvColumnName, authLinkedTcid);
			int columnByColumnName4444 = CSVUtils.getColumnByColumnName(Paths.ABEATHORIZESWIFTOUTWARDCSV, posCsvColumnName);
			if(rowByTcid3333 != -1 && rowByTcid4444 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEATHORIZESWIFTOUTWARDCSV, rowByTcid4444, columnByColumnName4444, poID);
			}
			return this;
		}

		else if (paysysId.equals("ESWFT")) {
			int rowByTcid11111 = CSVUtils.getRowByTcid(Paths.ABECREATEESWIFTOUTWARDCSV, linkedTcidCsvColumnName,
					linkedId);
			int columnByColumnName11111 = CSVUtils.getColumnByColumnName(Paths.ABECREATEESWIFTOUTWARDCSV,
					posCsvColumnName);
			int rowByTcid22222 = CSVUtils.getRowByTcid(Paths.ABEVERIFYESWIFTOUTWARDCSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName22222 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYESWIFTOUTWARDCSV,
					posCsvColumnName);
			if (rowByTcid11111 != -1 && rowByTcid22222 != -1 ) {
				
				CSVUtils.insertValueInCsvCell(Paths.ABECREATEESWIFTOUTWARDCSV, rowByTcid11111, columnByColumnName11111,
						poID);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYESWIFTOUTWARDCSV, rowByTcid22222, columnByColumnName22222,
						poID);
			}
			int rowByTcid33333 = CSVUtils.getRowByTcid(Paths.ABECREATEESWIFTOUTWARDCSV, authLinkedTcidCsvColumnName, authLinkedTcid);
			int rowByTcid44444 = CSVUtils.getRowByTcid(Paths.ABEATHORIZEESWIFTOUTWARDCSV, tcIdCsvColumnName, authLinkedTcid);
			int columnByColumnName44444 = CSVUtils.getColumnByColumnName(Paths.ABEATHORIZEESWIFTOUTWARDCSV, posCsvColumnName);
			if(rowByTcid33333 != -1 && rowByTcid44444 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEATHORIZEESWIFTOUTWARDCSV, rowByTcid44444, columnByColumnName44444, poID);
			}
			return this;
		}

		return this;
	}
}