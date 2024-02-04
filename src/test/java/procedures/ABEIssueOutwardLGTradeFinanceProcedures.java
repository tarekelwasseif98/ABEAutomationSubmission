package procedures;

import org.openqa.selenium.WebDriver;

import utils.FinacleFieldsUtils;
import data.ABEIssueOutwardLGTradeFinanceData;
import pageobjects.ABEIssueOutwardLGTradeFinancePage;
import utils.PageFunctionUtils;

public class ABEIssueOutwardLGTradeFinanceProcedures {
	
	public static void issueOutwardPaymentLGTradeFinanceByMaker(WebDriver driver, ABEIssueOutwardLGTradeFinanceData data) throws Exception {
		ABEIssueOutwardLGTradeFinancePage IssueOutwardLGTradeFinancePage = new ABEIssueOutwardLGTradeFinancePage(driver);
		IssueOutwardLGTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
		                                  .switchFormAreaFrame();
		   IssueOutwardLGTradeFinancePage.sendkeysGuaranteeTypeField(data.getGuaranteeType())
		                                  .sendkeysCurrencyDetails(data.getCurrency())
		                                  .sendKeysCustomerDetailsCIF(data.getCif())
		                                  .goButton()
		                                  .sendkeysGuaranteeAmount(data.getGuaranteeAmount());		                                                
		    FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
		    
		    //LOBID //LOPER //LOADV
		                 if(data.getGuarantee().equals(FinacleFields.GUARANTEETYPELOBID) || data.getGuarantee().equals(FinacleFields.GURANATEETYPELOPER) || data.getGuarantee().equals(FinacleFields.GURANATEETYPELOADV)) {		    
		                	 if(data.getOperationalAmount() != null && data.getNonOperationalAmount() != null) {
		      	               IssueOutwardLGTradeFinancePage.enterOperationalAmounts(data.getOperationalAmount())
		      	                 .enterNonOperationalAmounts(data.getNonOperationalAmount());
		                }
		     IssueOutwardLGTradeFinancePage.pressGeneralDetailsContinueButton()		    
		                                  .sendkeysBeneficiaryName(data.getName())
		                                  .sendkeysBeneficiaryAddress(data.getAddress())
		                                  .pressOnPartyContinueButton()
		                                  .enterPurposeOfGuarantee(data.getPurposeGuarantee())
		                                  .sendkeysExpiryDate(data.getExpiryDate())
		                                  .sendkeysclaimDate(data.getClaimDate())
		                                  .selectApplicableRules(data.getRulesdropdown())		                                 
		                                  .pressOnGuaranteeContinueButtonL()
		                                  .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
		                                  .pressLimitContinueButton()
		                                  .pressMarginContinueButton()
		                                  .pressChargesContinueButton()
		                                  .pressInstructionContinueButton()
		                                  .pressTracerContinueButton()
		                                  .pressTextContinueButton()
                                          .pressMessageContinueButton()	                                
		                                  .pressSubmitButton()
                                          .saveAccountId(data.getLinkedTcid());
		    //FBIDG //FPERG  //FADVG
	             } if(data.getGuarantee().equals(FinacleFields.GURANATEETYPEFBIDG) || data.getGuarantee().equals(FinacleFields.GURANATEETYPEFPERG) ||  data.getGuarantee().equals(FinacleFields.GURANATEETYPEFADVG)) {
	            	  if(data.getOperationalAmount() != null && data.getNonOperationalAmount() != null) {
			               IssueOutwardLGTradeFinancePage.enterOperationalAmounts(data.getOperationalAmount())
			                 .enterNonOperationalAmounts(data.getNonOperationalAmount());
		             }else if ( data.getOperationalAmount() != null && data.getNonOperationalAmount() == null) {
		            	  IssueOutwardLGTradeFinancePage.enterOperationalAmounts(data.getOperationalAmount());
		             }
	            		 IssueOutwardLGTradeFinancePage.senkeysBankAccount(data.getBankAccountReference())
		                 .senkeysPaySysId(data.getPaySysID())		               
		                 .pressGeneralDetailsContinueButton()
                         .sendkeysBeneficiaryName(data.getName())
                         .sendkeysBeneficiaryAddress(data.getAddress());
              if (data.getAddressType().equals(FinacleFields.ADDRESSTYPEBANKIDENTIFIER)) {          	            		
            	 IssueOutwardLGTradeFinancePage.enterBankIdentifier(data.getBankIdentifier());
              }else if(data.getAddressType().equals(FinacleFields.ADDRESSTYPENAMEANDADDRESS)) {
            	  IssueOutwardLGTradeFinancePage.enterAdvisingName(data.getAdvisingName())
            	                                .enterAdvisingAddress(data.getAdvisingAddress())
            	                                .enterCityField(data.getCity())
            	                                .enterStateField(data.getState())
            	                                .enterCountryField(data.getCountry())
            	                                .enterPostalCodeField(data.getPostalCode());
            	               
              }
            	 IssueOutwardLGTradeFinancePage.pressOnPartyContinueButton();
            	if(data.getPurposeGuarantee() !=null) {
            		IssueOutwardLGTradeFinancePage.enterPurposeOfGuarantee(data.getPurposeGuarantee());
            	}
            	IssueOutwardLGTradeFinancePage.sendkeysExpiryDate(data.getExpiryDate())
                         .sendkeysclaimDate(data.getClaimDate())                         
                         .selectApplicableRules(data.getRulesdropdown())
            	 .selectGuaranteeAdditionalDetails()		                               
                 .enterpurposeOfMessage(data.getMessage());
            	 
 	             IssueOutwardLGTradeFinancePage.pressOnGuaranteeDetailsContinueButton()
 	             .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
                        .pressLimitContinueButton()
                        .pressMarginContinueButton()
                        .pressChargesContinueButton()
                        .pressInstructionContinueButton()
                        .pressTracerContinueButton()
                        .pressTextContinueButton()
                        .selectMessageType(data.getMessageMenu())
                        .enterReceivingBank(data.getReceivingBank())
                        .clickOnGenerateButton();
                        if(data.getGuarantee().equals(FinacleFields.GURANATEETYPEFBIDG)) {
                        	IssueOutwardLGTradeFinancePage.clickOnFirstEditButtonFBIDG()
                        .clickOnAcceptFirstMessageButton()
                        .clickOnUpdateFirstButton()
                        .clickOnSecondEditButtonFBIDG()
                        .clickOnEditNarrativeButtonFBIDG()                       
                        .enterNarrativeTextField(data.getNarrativeText())
                        .clickOnSaveButton()
                        .acceptSecondMessageButton()
                        .clickOnUpdateSecondButton()
                        	.pressMessageContinueButton()	                                
                            .pressSubmitButton()
                            .saveAccountId(data.getLinkedTcid());
                        	}
                         if(data.getGuarantee().equals(FinacleFields.GURANATEETYPEFPERG) || data.getGuarantee().equals(FinacleFields.GURANATEETYPEFADVG) ) {
                        	IssueOutwardLGTradeFinancePage.clickOnFirstEditButtonFPERG()
                        .clickOnAcceptFirstMessageButton()
                        .clickOnUpdateFirstButton()
                        .clickOnSecondEditButtonFPERG()
                        .clickOnEditNarrativeButtonFPERG()                       
                        .enterNarrativeTextField(data.getNarrativeText())
                        .clickOnSaveButton()
                        .acceptSecondMessageButton()
                        .clickOnUpdateSecondButton()
                        .pressMessageContinueButton()	                                
                            .pressSubmitButton()
                            .saveAccountId(data.getLinkedTcid());
                        	}
                        
         //OCBID   	
	             }if( data.getGuarantee().equals(FinacleFields.GURANATEETYPEOCBID)) {
                        	 IssueOutwardLGTradeFinancePage.senkeysBankAccount(data.getBankAccountReference())
    		                 .senkeysPaySysId(data.getPaySysID())
                             .pressGeneralDetailsContinueButton()
                             .sendkeysBeneficiaryName(data.getName())
                             .sendkeysBeneficiaryAddress(data.getAddress());
                  if (data.getAddressType().equals(FinacleFields.ADDRESSTYPEBANKIDENTIFIER)) {          	            		
                	 IssueOutwardLGTradeFinancePage.enterBankIdentifier(data.getBankIdentifier());
                  }else if(data.getAddressType().equals(FinacleFields.ADDRESSTYPENAMEANDADDRESS)) {
                	  IssueOutwardLGTradeFinancePage.enterAdvisingName(data.getAdvisingName())
                	                                .enterAdvisingAddress(data.getAdvisingAddress())
                	                                .enterCityField(data.getCity())
                	                                .enterStateField(data.getState())
                	                                .enterCountryField(data.getCountry())
                	                                .enterPostalCodeField(data.getPostalCode());
                	               
                  }
                	 IssueOutwardLGTradeFinancePage.pressOnPartyContinueButton();
                	if(data.getPurposeGuarantee() !=null) {
                		IssueOutwardLGTradeFinancePage.enterPurposeOfGuarantee(data.getPurposeGuarantee());
                	}
                	IssueOutwardLGTradeFinancePage.sendkeysExpiryDate(data.getExpiryDate())
                             .sendkeysclaimDate(data.getClaimDate())                         
                             .selectApplicableRules(data.getRulesdropdown())         
                        	  .selectCounterGuranteeMenu()
                              .enterGuaranteeNumber(data.getGuaranteeNumberId())
                              .enterRateCode(data.getRateCode())
                             .closeCounterGuranteeMenu() 
                	 .selectGuaranteeAdditionalDetails()		                               
                     .enterpurposeOfMessage(data.getMessage());
                                     	 
  	             IssueOutwardLGTradeFinancePage.pressOnGuaranteeDetailsContinueButton()
  	             .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
                         .pressLimitContinueButton()
                         .pressMarginContinueButton()
                         .pressChargesContinueButton()
                         .pressInstructionContinueButton()
                         .pressTracerContinueButton()
                         .pressTextContinueButton()
                         .selectMessageType(data.getMessageMenu())
                         .enterReceivingBank(data.getReceivingBank())
                         .clickOnGenerateButton()
                         .clickOnFirstEditButton()
                         .clickOnAcceptFirstMessageButton()
                         .clickOnUpdateFirstButton()
                         .clickOnSecondEditButton()
                         .clickOnEditNarrativeButton()                       
                         .enterNarrativeTextField(data.getNarrativeText())
                         .clickOnSaveButton()
                         .acceptSecondMessageButton()
                         .clickOnUpdateSecondButton()
                         .pressMessageContinueButton()	                                
                         .pressSubmitButton()
                         .saveAccountId(data.getLinkedTcid());
	             }
	}
}
	

	
