package pageobjects;


	import java.util.List;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import io.qameta.allure.Step;
	import utils.CSVUtils;
	import utils.PageFunctionUtils;
	import utils.Paths;
	
	public class ABEAddInwardGuaranteePage {
		private WebDriver driver;
		private String loginFrameIframeId = "loginFrame";
		private String coreAbeIframeId = "Core_ABE";
		private String uxIframeId = "UX";
		private By formAreaIframeID = By.xpath("//iframe[@name='formArea']"); 
		private By searchBarTextField = By.id("menuSelect");
		private By searchButton = By.id("menuSearcherGo");
		
		private By guaranteeTypeSearchField = By.xpath("(//input[@id='_guarType'])[1]");
		private By currencyField = By.xpath("(//input[@id='_bgCcy'])[1]");
		private By cifIdTextField = By.xpath("(//input[@id='_newCifId'])[1]");
		private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
		
		private By guaranteeAmountField = By.xpath("(//input[@id='_ogmgendtls_bgAmt$amt'])[1]");
		private By generalDetailscontinueButton = By.xpath("(//button[@id='_ogmgendtls_gendet_Continue'])[1]");
		
			
		
		
		private By beneficiaryNameTextField = By.xpath("(//input[@id='_ogmpartydtls_benName'])[1]");
		private By beneficiaryAddressTextField = By.xpath("(//input[@id='_ogmpartydtls_benAddr1'])[1]");	
		
		private By addressTypeDropdownMenu = By.xpath("(//select[@id='_ogmpartydtls_advAddrtype_select'])[1]");
		private By bankIdentifierTextField = By.xpath("(//input[@id='_ogmpartydtls_advBic'])[1]");
		
		private By partyContinueButton = By.xpath("(//button[@id='_ogmpartydtls_partydet_Continue'])[1]");
		
		private By expiryDateField = By.xpath("(//input[@id='_igmguarntee_expDate'])[1]");
		private By claimDateField = By.xpath("(//input[@id='_igmguarntee_claimExpDate'])[1]");
		
		private By applicableRulesDropdownMenu = By.xpath("(//select[@id='_igmguarntee_applcRules_select'])[1]");
		
		
		private By guaranteeAdditionalDetailsButton = By.xpath("(//h2[normalize-space()='Guarantee Additional Details'])[1]");		
		private By UndertakingermsAndConditionsDescriptionIconButton = By.xpath("(//img[@id='_igmguarntee_guardetdesc$msgTextExp_image'])[1]");
		private By messageTextAreaField = By.xpath("(//textarea[@id='_igmguarntee_guardetdesc$msgText_textArea'])[1]");
		private By acceptGuaranteeButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
		
		
		
		
		
	    private By counterGuaranteeButton = By.xpath("(//h3[normalize-space()='Counter Guarantee Details'])[1]");
	    private By yesButton =By.xpath("(//input[@id='_igmguarntee_link_Counguar_Y_radio'])[1]");
		
	    private By closeCounterGuaranteeButton = By.xpath("(//h3[normalize-space()='Counter Guarantee Details'])[1]");
	    
	    
		private By guaranteeDetailsContinueButton = By.xpath("(//button[@id='_igmguarntee_guarentedet_Continue'])[1]");
		
		private By chargeBornedropdownMenu = By.xpath("(//select[@id='_igmguarntee_chrgsBornBy_select'])[1]");
		
		
		
		//continue Buttons
		private By continueLimitButton = By.xpath("(//button[@id='_limit_limit_Continue'])[1]");
		private By continueMarginButton = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
		public  By closeButtonErrorMessage = By.xpath("(//span[@id='modalCloseIcon'])[2]");
		private By chargesContinueButton = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
		private By instructionContinueButton = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
		
	
		private By textContinueButton = By.xpath("(//button[@id='_textdet_textdet_Continue'])[1]");
		
		//IFBID
		private By messageTypeDropdownMenu = By.xpath("(//select[@id='_messagedetails_mtNo_select'])[1]");
	    private By receivingBankField = By.xpath("(//input[@id='_messagedetails_recvBic'])[1]");
		private By generateButton = By.xpath("(//button[normalize-space()='Generate'])[1]");
		
		private By editFirstMessageButton = By.xpath("(//span[@class='editcontent'])[2]");
		private By acceptFirstMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
		private By updateFirstMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
		private By editSecondMessageButton = By.xpath("(//span[@class='editcontent'])[3]");
		private By editNarrativeButton = By.xpath("(//span[@class='editcontent'])[6]");
		private By narrativeTextButton = By.xpath("(//img[@id='_messagedetails_dynmsg_FinTextArea$msgTextExp_image'])[1]");
		
		private By narrativeTextField = By.xpath("(//textarea[@id='_messagedetails_dynmsg_FinTextArea$msgText_textArea'])[1]");
		
		private By acceptNarrativeButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
		private By saveButton = By.xpath("(//button[@id='_messagedetails_dynmsg_doneBtn'])[1]");
		private By acceptSecondMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
		private By updateSecondButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
		
		
		//LIBER
		private By editMessageButton = By.xpath("(//span[@class='editcontent'])[2]");
		private By acceptMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
		private By updateMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
		
		private By messageContinueButton = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	    
		
		//ILADV
		
		private By editChargesButton = By.xpath("(//span[@class='editcontent'])[1]");
		private By laterCollectionAmountField = By.xpath("(//input[@id='_charge_laterCollectionAmt$amt'])[1]");
		private By laterCollectionDateField = By.xpath("(//input[@id='_charge_laterCollectionDate'])[1]");
		private By updateChargesButton = By.xpath("(//button[@id='_charge_chargerec_updateSummary'])[1]");
		private By closeChargesButton = By.xpath("(//button[@id='_charge_chargerec_closeBtn'])[1]");
		
		
		
		
		
		private By bankAccountReferenceTextField = By.xpath("(//input[@id='_ogmgendtls_otherBankRefNo'])[1]");
		private By paySysIDTextField = By.xpath("(//input[@id='_ogmgendtls_paysysId'])[1]");
		
		
		
		private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	
		private By guaranteeId = By.xpath("(//div[@id='_success_guarNo_text'])[1]");
		
		
		public static String acId;
		public static String  guaranteeInwardCsvColumnName = "guaranteeNumberReference";
		
		public static String  guaranteeInwardNumberIdCsvColumnName = "guaranteeNumberReferenceId";
		
		public static String  guaranteeOutwardNumberIdCsvColumnName = "guaranteeNumberId";

		
		public static String  tcIdCsvColumnName2 = "tcId";
		public static String  linkedTcidInwardCsvColumnName2 = "linkedTcid2";  

		
		
		public static String  tcIdCsvColumnName1 = "tcId";
		public static String  linkedTcidInwardCsvColumnName1 = "linkedTcid1";  
		
		
		
		public ABEAddInwardGuaranteePage(WebDriver driver) {
			this.driver = driver;
		}
		
		
		@Step("Sending menu name: {0}")
		public ABEAddInwardGuaranteePage sendKeysSearchBarTextField(String menu) throws Exception {
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
		        }
	        catch (Exception e) {
	        }
	        
	        /*
	        try {
	        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	        } catch (Exception e) {
	        	
	        }
	        PageFunctionUtils.sleep();
	        try {
	        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	        } catch (Exception e) {
	        	
	        }
	        driver.findElement(By.xpath("(//input[@id='usertxt'])[1]")).sendKeys("ABE40");
	        try {
	        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	        } catch (Exception e) {
	        	
	        }
	        driver.findElement(By.xpath("(//input[@id='passtxt'])[1]")).sendKeys("Infy@123");
	        driver.findElement(By.xpath("(//input[@id='Submit'])[1]")).click();
	        */
		return this;
		}
		
		
		
		@Step("Frame switching")
		public ABEAddInwardGuaranteePage switchFormAreaFrame() throws Exception {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);	    
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			return this;		
		}
		
		
		@Step("Sending guarantee type: {0}")
		public ABEAddInwardGuaranteePage sendkeysGuaranteeTypeField(String guaranteeType) throws Exception {		
			PageFunctionUtils.waitOnElement(driver, guaranteeTypeSearchField);
			PageFunctionUtils.clickOnElement(driver, guaranteeTypeSearchField);
			PageFunctionUtils.enterDataInWebElement(driver, guaranteeTypeSearchField, guaranteeType);
			return this;
		}
		
		
		
		
		@Step("Sending currency CCY: {0}")
		public ABEAddInwardGuaranteePage sendkeysCurrencyDetails(String currency) throws Exception {		
			PageFunctionUtils.waitOnElement(driver, currencyField);
			PageFunctionUtils.clickOnElement(driver, currencyField);
			PageFunctionUtils.enterDataInWebElement(driver, currencyField, currency);
			return this;
		}
		
		
		
		@Step("Sending customer CIF: {0}")
		public ABEAddInwardGuaranteePage sendKeysCustomerDetailsCIF(String cifid) throws Exception {						
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid.substring(1));
			return this;
		}
			
		
		
		
			
		@Step("press go button")
		public ABEAddInwardGuaranteePage goButton() throws Exception {			
	    PageFunctionUtils.clickOnElement(driver, goButton);	
		return this;		
	}
		
		
		
	   @Step("Enter guarantee amount: {0}")
	   public ABEAddInwardGuaranteePage sendkeysGuaranteeAmount(String guaranteeAmount) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, guaranteeAmountField);
			PageFunctionUtils.clickOnElement(driver, guaranteeAmountField);
			PageFunctionUtils.clearDataInWebElement(driver,guaranteeAmountField );
			PageFunctionUtils.enterDataInWebElement(driver, guaranteeAmountField, guaranteeAmount.substring(1));	
			return this;
	   }	
	
	  
	   @Step("Enter other bank reference number: {0}")
	   public  ABEAddInwardGuaranteePage senkeysBankAccount(String bankAccountReference) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, bankAccountReferenceTextField);
			PageFunctionUtils.clickOnElement(driver, bankAccountReferenceTextField);
			PageFunctionUtils.enterDataInWebElement(driver, bankAccountReferenceTextField, bankAccountReference.substring(1));	
			return this;
	   }
	   
	   
	   
	   @Step("Enter PaySysID: {0}")
	   public  ABEAddInwardGuaranteePage senkeysPaySysId(String paySysID) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, paySysIDTextField);
			PageFunctionUtils.clickOnElement(driver, paySysIDTextField);
			PageFunctionUtils.enterDataInWebElement(driver, paySysIDTextField, paySysID);	
			return this;
	   } 
	
	   
	   
	   
	   
	   
	   
	   
	   @Step("Press Continue Button")
	   public ABEAddInwardGuaranteePage pressGeneralDetailsContinueButton() throws Exception{   
		    PageFunctionUtils.waitOnElement(driver, generalDetailscontinueButton);
			PageFunctionUtils.clickOnElement(driver, generalDetailscontinueButton);
		   return this;
	   }


	   @Step("Enter beneficiary name: {0}")
	   public ABEAddInwardGuaranteePage sendkeysBeneficiaryName(String name) throws Exception{
		   PageFunctionUtils.waitOnElement(driver, beneficiaryNameTextField);
		   PageFunctionUtils.clickOnElement(driver, beneficiaryNameTextField);
		   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryNameTextField, name);	
		   return this;
	   }
	   
	   
	   @Step("Enter beneficiary address: {0}")
	   public ABEAddInwardGuaranteePage sendkeysBeneficiaryAddress(String address) throws Exception{
		   PageFunctionUtils.waitOnElement(driver, beneficiaryAddressTextField);
		   PageFunctionUtils.clickOnElement(driver, beneficiaryAddressTextField);
		   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryAddressTextField, address);	
		   return this;
	   }
	   
	   
	   
	   
	   
	   @Step("Select address type: {0}")
	   public ABEAddInwardGuaranteePage selectAdressType(String addressType) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, addressTypeDropdownMenu);
			PageFunctionUtils.clickOnElement(driver, addressTypeDropdownMenu);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, addressTypeDropdownMenu, addressType);
		   return this;
	   }
	   
	   @Step("Enter bank identifier: {0}")
	   public ABEAddInwardGuaranteePage enterBankIdentifier(String bankIdentifier) throws Exception{
		   PageFunctionUtils.waitOnElement(driver, bankIdentifierTextField);
		   PageFunctionUtils.clickOnElement(driver, bankIdentifierTextField);
		   PageFunctionUtils.enterDataInWebElement(driver, bankIdentifierTextField, bankIdentifier);	
		   return this;
	   }
	   
	   
	   
	   
	   
	   
	   @Step("press on party continue button")
	   public ABEAddInwardGuaranteePage pressOnPartyContinueButton() throws Exception{		 
		   PageFunctionUtils.waitOnElement(driver, partyContinueButton);
		   PageFunctionUtils.clickOnElement(driver, partyContinueButton);		  
		   return this;
	   }

	   @Step("Enter expiry date: {0}")
	   public ABEAddInwardGuaranteePage sendkeysExpiryDate(String expiryDate) throws Exception{
	 	  PageFunctionUtils.waitOnElement(driver, expiryDateField);		
	 		PageFunctionUtils.clearDataInWebElement(driver,expiryDateField );
	 		PageFunctionUtils.clickOnElement(driver, expiryDateField);
	 		PageFunctionUtils.enterDataInWebElement(driver, expiryDateField, expiryDate.substring(1));
	 	  return this;
	   }
	    
	   @Step("Enter claim date: {0}")
	   public ABEAddInwardGuaranteePage sendkeysclaimDate(String claimDate) throws Exception{
	 	    PageFunctionUtils.waitOnElement(driver, claimDateField);		
	 		PageFunctionUtils.clearDataInWebElement(driver,claimDateField );
	 		PageFunctionUtils.clickOnElement(driver, claimDateField);
	 		PageFunctionUtils.enterDataInWebElement(driver, claimDateField, claimDate.substring(1));
	 	  return this;
	   } 
	   
	   
	   
	   @Step("select applicaple rules dropdown menu")
	   public ABEAddInwardGuaranteePage selectApplicableRules(String rulesdropdown) throws Exception{
	 	    PageFunctionUtils.waitOnElement(driver, applicableRulesDropdownMenu);
	 		PageFunctionUtils.clickOnElement(driver, applicableRulesDropdownMenu);
	 		PageFunctionUtils.selectDropDownListByVisibleText(driver, applicableRulesDropdownMenu, rulesdropdown);
	 	  return this;
	   }
	   

@Step("press on counter guarantee  button")
public ABEAddInwardGuaranteePage pressOnCounterGuaranteeButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, counterGuaranteeButton);
	PageFunctionUtils.clickOnElement(driver, counterGuaranteeButton);
	return this;
}


@Step("press on yes  button")
public ABEAddInwardGuaranteePage pressOnYesButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, yesButton);
	PageFunctionUtils.clickOnElement(driver, yesButton);
	
	return this;
}
	   
	   
@Step("press on close counter guarantee  button")
public ABEAddInwardGuaranteePage pressOnCloseCounterGuaranteeButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, counterGuaranteeButton);
	PageFunctionUtils.clickOnElement(driver, counterGuaranteeButton);
	return this;
}	   
	  


@Step("Select guarantee additional details")
public ABEAddInwardGuaranteePage selectGuaranteeAdditionalDetails() throws Exception{
	    PageFunctionUtils.waitOnElement(driver, guaranteeAdditionalDetailsButton);
		PageFunctionUtils.clickOnElement(driver, guaranteeAdditionalDetailsButton);
		return this;
}



@Step("select charge borne by dropdown menu")
public ABEAddInwardGuaranteePage selectChargeBorne(String chargeBorneMenu) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, chargeBornedropdownMenu);
		PageFunctionUtils.clickOnElement(driver, chargeBornedropdownMenu);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, chargeBornedropdownMenu, chargeBorneMenu);
	  return this;
}


@Step("Enter purpose of message: {0}")
public ABEAddInwardGuaranteePage enterpurposeOfMessage(String message) throws Exception{
	   
	    if (message != null) {	   
	    PageFunctionUtils.waitOnElement(driver, UndertakingermsAndConditionsDescriptionIconButton);
		PageFunctionUtils.clickOnElement(driver, UndertakingermsAndConditionsDescriptionIconButton);			
	    PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnElement(driver, messageTextAreaField);
	    PageFunctionUtils.clickOnElement(driver, messageTextAreaField);
	    PageFunctionUtils.enterDataInWebElement(driver, messageTextAreaField, message);
	    }
	    PageFunctionUtils.waitOnElement(driver, acceptGuaranteeButton);
	    PageFunctionUtils.clickOnElement(driver, acceptGuaranteeButton);
	   
	
		 return this;
}
 


 

@Step("press on guarantee continue button")
public ABEAddInwardGuaranteePage pressOnGuaranteeDetailsContinueButtonEUR() throws Exception{	
	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	PageFunctionUtils.waitOnElement(driver, guaranteeDetailsContinueButton);
	PageFunctionUtils.clickOnElement(driver, guaranteeDetailsContinueButton);
	
	return this;
}



@Step("press on guarantee continue button")
public ABEAddInwardGuaranteePage pressOnGuaranteeContinueButtonUSD() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, guaranteeDetailsContinueButton);
	PageFunctionUtils.clickOnElement(driver, guaranteeDetailsContinueButton);
	
	return this;
}

@Step("press limit continue button")
public ABEAddInwardGuaranteePage pressLimitContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueLimitButton);
	PageFunctionUtils.clickOnElement(driver, continueLimitButton);
	return this;
}


@Step("press margin continue button")
public ABEAddInwardGuaranteePage pressMarginContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueMarginButton);
	PageFunctionUtils.clickOnElement(driver, continueMarginButton);
	return this;
}



@Step("click on close button for error message")
public ABEAddInwardGuaranteePage pressCloseErrorMessageButton() throws Exception{
	PageFunctionUtils.switchToParentFrame(driver);
	PageFunctionUtils.waitOnElement(driver, closeButtonErrorMessage);
	PageFunctionUtils.clickOnElement(driver, closeButtonErrorMessage);
	return this;
}

@Step("press edit charges button")
public ABEAddInwardGuaranteePage pressEditChargesButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, editChargesButton);
	PageFunctionUtils.clickOnElement(driver, editChargesButton);
	return this;
}


@Step("Enter later collection amount: {0} ")
public ABEAddInwardGuaranteePage enterLaterCollectionAmount(String laterCollectionAmount) throws Exception{	
	     PageFunctionUtils.clickOnElement(driver, laterCollectionAmountField);
	     PageFunctionUtils.deleteWithControlButton(driver, laterCollectionAmountField);
         PageFunctionUtils.enterDataInWebElement(driver, laterCollectionAmountField, laterCollectionAmount.substring(1));      
         PageFunctionUtils.enterButton(driver, laterCollectionAmountField);

	return this;
}

		@Step("Enter later collection date: {0} ")
		public ABEAddInwardGuaranteePage enterLaterCollectionDate(String laterCollectionDate) throws Exception{	     	
				PageFunctionUtils.waitOnElement(driver, laterCollectionDateField);		
				PageFunctionUtils.clearDataInWebElement(driver,laterCollectionDateField );
				PageFunctionUtils.clickOnElement(driver, laterCollectionDateField);
				PageFunctionUtils.enterDataInWebElement(driver, laterCollectionDateField, laterCollectionDate.substring(1));
			return this;
		}





		@Step("press update charges button")
		public ABEAddInwardGuaranteePage pressUpdateChargesButton() throws Exception{
			PageFunctionUtils.waitOnElement(driver, updateChargesButton);
			PageFunctionUtils.clickOnElement(driver, updateChargesButton);
			return this;
		}

		@Step("press close charges button")
		public ABEAddInwardGuaranteePage pressCloseChargesButton() throws Exception{
			PageFunctionUtils.waitOnElement(driver, closeChargesButton);
			PageFunctionUtils.clickOnElement(driver, closeChargesButton);
			return this;
		}



@Step("press charges continue button")
public ABEAddInwardGuaranteePage pressChargesContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
	PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
	return this;
}




@Step("press instruction continue button")
public ABEAddInwardGuaranteePage pressInstructionContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
	PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
	return this;
}





@Step("press text continue button")
public ABEAddInwardGuaranteePage pressTextContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, textContinueButton);
	PageFunctionUtils.clickOnElement(driver, textContinueButton);
	return this;
}



//IFBID
@Step("select message type: {0}")
public ABEAddInwardGuaranteePage selectMessageType(String messageMenu) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, messageTypeDropdownMenu);
			PageFunctionUtils.clickOnElement(driver, messageTypeDropdownMenu);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, messageTypeDropdownMenu, messageMenu);
	return this;
}


@Step("Enter receiving bank identifier : {0}")
public ABEAddInwardGuaranteePage enterReceivingBank(String receivingBank) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, receivingBankField);
	  PageFunctionUtils.clickOnElement(driver, receivingBankField);
	  PageFunctionUtils.enterDataInWebElement(driver, receivingBankField, receivingBank);
	return this;
}



@Step("Click on generate button")
public ABEAddInwardGuaranteePage clickOnGenerateButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, generateButton);
	  PageFunctionUtils.clickOnElement(driver, generateButton);
	return this;
}


@Step("Click on first edit button")
public ABEAddInwardGuaranteePage clickOnFirstMessageEditButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, editFirstMessageButton);
	  PageFunctionUtils.clickOnElement(driver, editFirstMessageButton);
	return this;
}





@Step("Click on accept first message button")
public ABEAddInwardGuaranteePage clickOnAcceptFirstMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, acceptFirstMessageButton);
	  PageFunctionUtils.clickOnElement(driver, acceptFirstMessageButton);
	return this;
}

@Step("Click on update first button")
public ABEAddInwardGuaranteePage clickOnUpdateFirstMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, updateFirstMessageButton);
	  PageFunctionUtils.clickOnElement(driver, updateFirstMessageButton);
	return this;
}




@Step("Click on second edit button")
public ABEAddInwardGuaranteePage clickOnSecondEditButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, editSecondMessageButton);
	  PageFunctionUtils.clickOnElement(driver, editSecondMessageButton);
	return this;
}



@Step("Click on edit narrative button")
public ABEAddInwardGuaranteePage clickOnEditNarrativeButton() throws Exception{
	
	 PageFunctionUtils.waitOnElement(driver, editNarrativeButton);
	 PageFunctionUtils.clickOnElement(driver, editNarrativeButton);
	return this;
}



@Step("Enter narrative text field")
public ABEAddInwardGuaranteePage enterNarrativeTextField(String narrativeText) throws Exception{
	 	
	 if (narrativeText != null) {
		 PageFunctionUtils.waitOnElement(driver, narrativeTextButton);
		 PageFunctionUtils.clickOnElement(driver, narrativeTextButton);	
		    PageFunctionUtils.switchToParentFrame(driver);
		    PageFunctionUtils.waitOnElement(driver, narrativeTextField);
		    PageFunctionUtils.clickOnElement(driver, narrativeTextField);
		    PageFunctionUtils.enterDataInWebElement(driver, narrativeTextField, narrativeText);		 
		    }
	    PageFunctionUtils.waitOnElement(driver, acceptNarrativeButton);
	    PageFunctionUtils.clickOnElement(driver, acceptNarrativeButton);
		   
	return this;
}


@Step("Click on save button")
public ABEAddInwardGuaranteePage clickOnSaveButton() throws Exception{
	    PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	    PageFunctionUtils.waitOnElement(driver, saveButton);
	    PageFunctionUtils.clickOnElement(driver, saveButton);
return this;

}



@Step("Click on accept send message button")
public ABEAddInwardGuaranteePage clicOnacceptSecondMessageButton() throws Exception{
PageFunctionUtils.waitOnElement(driver, acceptSecondMessageButton);
PageFunctionUtils.clickOnElement(driver, acceptSecondMessageButton);
return this;

}


@Step("Click on update second button")
public ABEAddInwardGuaranteePage clickOnUpdateSecondButton() throws Exception{
	 
	  PageFunctionUtils.waitOnElement(driver, updateSecondButton);
	  PageFunctionUtils.clickOnElement(driver, updateSecondButton);
	return this;
}






//LIBER

@Step("Click on edit message button")
public ABEAddInwardGuaranteePage clickOnEditMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, editMessageButton);
	  PageFunctionUtils.clickOnElement(driver, editMessageButton);
	return this;
}


@Step("Click on accept message button")
public ABEAddInwardGuaranteePage clickOnAcceptMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, acceptMessageButton);
	  PageFunctionUtils.clickOnElement(driver, acceptMessageButton);
	return this;
}




@Step("Click on update message button")
public ABEAddInwardGuaranteePage clickOnUpdateMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, updateMessageButton);
	  PageFunctionUtils.clickOnElement(driver, updateMessageButton);
	return this;
}


@Step("press message continue button")
public ABEAddInwardGuaranteePage pressMessageContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, messageContinueButton);
	PageFunctionUtils.clickOnElement(driver, messageContinueButton);
	return this;
}





	
@Step("Press submit button")
public ABEAddInwardGuaranteePage pressSubmitButton() throws Exception {
	
   PageFunctionUtils.waitOnElement(driver, submitButton);
   PageFunctionUtils.clickOnElement(driver, submitButton);
   PageFunctionUtils.acceptWarning(driver);
	Thread.sleep(3500);
	acId = driver.findElement(guaranteeId).getText(); 
	System.out.println("Guarantee Number ID: "+ acId); 
	return this;
}





@Step("Save guarantee. id")
public ABEAddInwardGuaranteePage saveGuaranteeId(String linkedTcid1, String linkedTcid2) throws Exception {
int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ADDINWARDGUARANTEECSV, linkedTcidInwardCsvColumnName1, linkedTcid1);
int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ADDINWARDGUARANTEECSV, guaranteeInwardCsvColumnName);


int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VERIFYINWARDGUARANTEECSV, tcIdCsvColumnName1, linkedTcid1);
int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VERIFYINWARDGUARANTEECSV, guaranteeInwardNumberIdCsvColumnName);


int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, tcIdCsvColumnName2, linkedTcid2);
int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, guaranteeOutwardNumberIdCsvColumnName);

if(linkedTcid2 != null) {
if(rowByTcid1 != -1 && rowByTcid2 != -1 && rowByTcid3 != -1){
	CSVUtils.insertValueInCsvCell(Paths.ADDINWARDGUARANTEECSV, rowByTcid1, columnByColumnName1, acId);
	CSVUtils.insertValueInCsvCell(Paths.VERIFYINWARDGUARANTEECSV, rowByTcid2, columnByColumnName2, acId);
    CSVUtils.insertValueInCsvCell(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, rowByTcid3, columnByColumnName3, acId);
}
}
else if (linkedTcid2 == null) {
	CSVUtils.insertValueInCsvCell(Paths.ADDINWARDGUARANTEECSV, rowByTcid1, columnByColumnName1, acId);
	CSVUtils.insertValueInCsvCell(Paths.VERIFYINWARDGUARANTEECSV, rowByTcid2, columnByColumnName2, acId);
}

return this;
}

	}

