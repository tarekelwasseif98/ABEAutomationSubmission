package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEAddInwardGuaranteeData;
import pageobjects.ABEAddInwardGuaranteePage;
import utils.FinacleFieldsUtils;

public class ABEAddInwardGuaranteeProcedures {


	public static void addInwardGuaranteeByMaker(WebDriver driver, ABEAddInwardGuaranteeData data) throws Exception {
		ABEAddInwardGuaranteePage AddInwardGuaranteePage = new ABEAddInwardGuaranteePage(driver);
		                           AddInwardGuaranteePage.sendKeysSearchBarTextField(data.getMenu())
	                                  .switchFormAreaFrame()
	                                  .sendkeysGuaranteeTypeField(data.getGuaranteeType())
	                                  .sendkeysCurrencyDetails(data.getCurrency())
	                                  .sendKeysCustomerDetailsCIF(data.getCif())
	                                  .goButton()
	                                  .sendkeysGuaranteeAmount(data.getGuaranteeAmount());
	                                  
		                           FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
		                        
		                        	   
		                   if (data.getCurrency().equals(FinacleFields.CCYUSD) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFBID)) {
		         		            	  if(data.getBankAccountReference() != null && data.getPaySysID() != null) {
		                               AddInwardGuaranteePage.senkeysBankAccount(data.getBankAccountReference()) 
		                                	  .senkeysPaySysId(data.getPaySysID());
		         		            	  }
		         		            	  AddInwardGuaranteePage.pressGeneralDetailsContinueButton()
		                                      .sendkeysBeneficiaryName(data.getName())
		                                      .sendkeysBeneficiaryAddress(data.getAddress());
		                             if(data.getAddressType() != null && data.getBankIdentifier() != null) {        
		                                	  AddInwardGuaranteePage.selectAdressType(data.getAddressType())
		                                	  .enterBankIdentifier(data.getBankIdentifier())
		                                	  .pressOnPartyContinueButton(); 
		                             }
		                             AddInwardGuaranteePage.pressOnPartyContinueButton()
		                                      .sendkeysExpiryDate(data.getExpiryDate())
		                                      .sendkeysclaimDate(data.getClaimDate())
		                                      .selectApplicableRules(data.getRulesdropdown())
		                                      .pressOnCounterGuaranteeButton()                                	                            
		                                      .pressOnYesButton()
		                                      .pressOnCloseCounterGuaranteeButton();
		                               if(data.getChargeBorneMenu() != null) {
		                            	   AddInwardGuaranteePage.selectGuaranteeAdditionalDetails()
		                            	   .selectChargeBorne(data.getChargeBorneMenu())
		                            	   .enterpurposeOfMessage(data.getMessage())
		                            	   .pressOnGuaranteeDetailsContinueButtonEUR();	                        	   
		                            	     
		                               }else if(data.getChargeBorneMenu() == null){
		                            	   AddInwardGuaranteePage.pressOnGuaranteeContinueButtonUSD();
		                               } 
		                             AddInwardGuaranteePage
		                                      .pressLimitContinueButton()
		                                      .pressMarginContinueButton()
		                                      .pressChargesContinueButton()
		                                      .pressInstructionContinueButton()
		                                      .pressTextContinueButton();
		         	
		                    //IFBID        	
		                             if(data.getReceivingBank() != null && data.getMessageMenu() != null && data.getNarrativeText() != null) {
		                                	  AddInwardGuaranteePage.selectMessageType(data.getMessageMenu())
		                                      .enterReceivingBank(data.getReceivingBank())
		                                      .clickOnGenerateButton()
		                                      .clickOnFirstMessageEditButton()
		                                      .clickOnAcceptFirstMessageButton()
		                                      .clickOnUpdateFirstMessageButton()
		                                      .clickOnSecondEditButton()
		                                	  .clickOnEditNarrativeButton()
		                                	  .enterNarrativeTextField(data.getNarrativeText())
		                                	  .clickOnSaveButton()
		                                	  .clicOnacceptSecondMessageButton()
		                                	  .clickOnUpdateSecondButton()
		                                      .pressMessageContinueButton();	
		                                  }else if(data.getReceivingBank() == null && data.getMessageMenu() == null && data.getNarrativeText() == null) {
		                                	  AddInwardGuaranteePage.pressMessageContinueButton();
		         		             }
		         	
		           } 
		              //ILADV    //ILBID         
		            if(data.getCurrency().equals(FinacleFields.CCYEGP) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEILADV) 
		            		|| data.getCurrency().equals(FinacleFields.CCYEGP) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEILBID)){               
                      	  AddInwardGuaranteePage.pressGeneralDetailsContinueButton()
                             .sendkeysBeneficiaryName(data.getName())
                             .sendkeysBeneficiaryAddress(data.getAddress());
                    if(data.getAddressType() != null && data.getBankIdentifier() != null) {        
                       	  AddInwardGuaranteePage.selectAdressType(data.getAddressType())
                       	  .enterBankIdentifier(data.getBankIdentifier());
                       	
                    }
                    AddInwardGuaranteePage.pressOnPartyContinueButton()
                             .sendkeysExpiryDate(data.getExpiryDate())
                             .sendkeysclaimDate(data.getClaimDate())
                             .selectApplicableRules(data.getRulesdropdown())
                             .pressOnCounterGuaranteeButton()                                	                            
                             .pressOnYesButton()
                             .pressOnCloseCounterGuaranteeButton();
                      if(data.getChargeBorneMenu().equals(FinacleFields.CHARAGEBORNEBY) && data.getChargeBorneMenu() != null) {
                   	   AddInwardGuaranteePage.selectGuaranteeAdditionalDetails()
                   	   .selectChargeBorne(data.getChargeBorneMenu())
                 	   .pressOnGuaranteeContinueButtonUSD();	                        	   
                   	     
                      }       
                    AddInwardGuaranteePage
                             .pressLimitContinueButton()
                             .pressMarginContinueButton();
                    
                  /*  if(data.getLaterCollectionAmount() != null && data.getLaterCollectionDate() != null) {
                    	AddInwardGuaranteePage.pressEditChargesButton()
                    	                      .enterLaterCollectionAmount(data.getLaterCollectionAmount())  
                    	                      .enterLaterCollectionDate(data.getLaterCollectionDate())                    	                                     	                     
                    	                      .pressUpdateChargesButton();
                    	                     
                    }*/
                    AddInwardGuaranteePage.pressChargesContinueButton()                   
                                          .pressInstructionContinueButton()
                                          .pressTextContinueButton()
                                          .pressMessageContinueButton();	   
		            }
		    
		        
	
		            
		         //IFBID //EUR //LIBER //EGP
		             if(data.getCurrency().equals(FinacleFields.CCYEUR) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFBID) || data.getCurrency().equals(FinacleFields.CCYEGP) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPELIPER)) {
		                        	  if(data.getBankAccountReference() != null && data.getPaySysID() != null) {
		                        	  AddInwardGuaranteePage.senkeysBankAccount(data.getBankAccountReference()) 
		                        	  .senkeysPaySysId(data.getPaySysID());
		                        	  }
		                        	  AddInwardGuaranteePage.pressGeneralDetailsContinueButton()
		                              .sendkeysBeneficiaryName(data.getName())
	                                  .sendkeysBeneficiaryAddress(data.getAddress());
	                         if(data.getAddressType() != null && data.getBankIdentifier() != null) {        
		                        	  AddInwardGuaranteePage.selectAdressType(data.getAddressType())
		                        	  .enterBankIdentifier(data.getBankIdentifier())
		                        	  .pressOnPartyContinueButton(); 
	                         }
	                         AddInwardGuaranteePage.pressOnPartyContinueButton()
	                                  .sendkeysExpiryDate(data.getExpiryDate())
	                                  .sendkeysclaimDate(data.getClaimDate())
	                                  .selectApplicableRules(data.getRulesdropdown())
	                                  .pressOnCounterGuaranteeButton()                                	                            
	                                  .pressOnYesButton()
	                                  .pressOnCloseCounterGuaranteeButton();
	                           if(data.getChargeBorneMenu().equals(FinacleFields.CHARAGEBORNEBY) && data.getChargeBorneMenu() != null) {
	                        	   AddInwardGuaranteePage.selectGuaranteeAdditionalDetails()
	                        	   .selectChargeBorne(data.getChargeBorneMenu())
	                        	   .enterpurposeOfMessage(data.getMessage())
	                        	   .pressOnGuaranteeDetailsContinueButtonEUR();	                        	   
	                        	     
	                           }       
	                         AddInwardGuaranteePage
	                                  .pressLimitContinueButton()
	                                  .pressMarginContinueButton()
	                                  .pressChargesContinueButton()
	                                  .pressInstructionContinueButton()
		                              .pressTextContinueButton();
			
	                //LIBER
	                         if(data.getReceivingBank() == null && data.getMessageMenu() == null && data.getNarrativeText() == null) {       
	                        	AddInwardGuaranteePage.clickOnEditMessageButton()
	                                  .clickOnAcceptMessageButton()
	                                  .clickOnUpdateMessageButton()
                                      .pressMessageContinueButton();	
	                //IFBID        	
		                          }else if(data.getReceivingBank() != null && data.getMessageMenu() != null && data.getNarrativeText() != null) {
		                        	  AddInwardGuaranteePage.selectMessageType(data.getMessageMenu())
		                              .enterReceivingBank(data.getReceivingBank())
		                              .clickOnGenerateButton()
		                              .clickOnFirstMessageEditButton()
		                              .clickOnAcceptFirstMessageButton()
		                              .clickOnUpdateFirstMessageButton()
		                              .clickOnSecondEditButton()
		                        	  .clickOnEditNarrativeButton()
		                        	  .enterNarrativeTextField(data.getNarrativeText())
		                        	  .clickOnSaveButton()
		                        	  .clicOnacceptSecondMessageButton()
		                        	  .clickOnUpdateSecondButton()
                                      .pressMessageContinueButton();	
		                          }
		                        	  }
		             
		             //IFPER
		      if (data.getCurrency().equals(FinacleFields.CCYUSD) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFPER) ||data.getCurrency().equals(FinacleFields.CCYEUR) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFPER)) {
		            	 
		            	  if(data.getBankAccountReference() != null && data.getPaySysID() != null) {
                        	  AddInwardGuaranteePage.senkeysBankAccount(data.getBankAccountReference()) 
                        	  .senkeysPaySysId(data.getPaySysID());
                        	  }
                        	  AddInwardGuaranteePage.pressGeneralDetailsContinueButton()
                              .sendkeysBeneficiaryName(data.getName())
                              .sendkeysBeneficiaryAddress(data.getAddress());
                     if(data.getAddressType() != null && data.getBankIdentifier() != null) {        
                        	  AddInwardGuaranteePage.selectAdressType(data.getAddressType())
                        	  .enterBankIdentifier(data.getBankIdentifier())
                        	  .pressOnPartyContinueButton(); 
                     }
                     AddInwardGuaranteePage.pressOnPartyContinueButton()
                              .sendkeysExpiryDate(data.getExpiryDate())
                              .sendkeysclaimDate(data.getClaimDate())
                              .selectApplicableRules(data.getRulesdropdown())
                              .pressOnCounterGuaranteeButton()                                	                            
                              .pressOnYesButton()
                              .pressOnCloseCounterGuaranteeButton();
                       if(data.getChargeBorneMenu().equals(FinacleFields.CHARAGEBORNEBY) && data.getChargeBorneMenu() != null) {
                    	   AddInwardGuaranteePage.selectGuaranteeAdditionalDetails()
                    	   .selectChargeBorne(data.getChargeBorneMenu())
                    	   .enterpurposeOfMessage(data.getMessage())
                    	   .pressOnGuaranteeDetailsContinueButtonEUR();	                        	   
                    	     
                       }       
                     AddInwardGuaranteePage
                              .pressLimitContinueButton()
                              .pressMarginContinueButton()
                              .pressChargesContinueButton()
                              .pressInstructionContinueButton()
                              .pressTextContinueButton();
	
            //LIBER
                     if(data.getReceivingBank() == null && data.getMessageMenu() == null && data.getNarrativeText() == null) {       
                    	AddInwardGuaranteePage.clickOnEditMessageButton()
                              .clickOnAcceptMessageButton()
                              .clickOnUpdateMessageButton()
                              .pressMessageContinueButton();	
            //IFBID        	
                          }else if(data.getReceivingBank() != null && data.getMessageMenu() != null && data.getNarrativeText() != null) {
                        	  AddInwardGuaranteePage.selectMessageType(data.getMessageMenu())
                              .enterReceivingBank(data.getReceivingBank())
                              .clickOnGenerateButton()
                              .clickOnFirstMessageEditButton()
                              .clickOnAcceptFirstMessageButton()
                              .clickOnUpdateFirstMessageButton()
                              .clickOnSecondEditButton()
                        	  .clickOnEditNarrativeButton()
                        	  .enterNarrativeTextField(data.getNarrativeText())
                        	  .clickOnSaveButton()
                        	  .clicOnacceptSecondMessageButton()
                        	  .clickOnUpdateSecondButton()
                              .pressMessageContinueButton();	
                          }
		         }
		      //IFADV
		      
		      if (data.getCurrency().equals(FinacleFields.CCYUSD) && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFADV)) {	            	 
            	  if(data.getBankAccountReference() != null && data.getPaySysID() != null) {
                	  AddInwardGuaranteePage.senkeysBankAccount(data.getBankAccountReference()) 
                	  .senkeysPaySysId(data.getPaySysID());
                	  }
                	  AddInwardGuaranteePage.pressGeneralDetailsContinueButton()
                      .sendkeysBeneficiaryName(data.getName())
                      .sendkeysBeneficiaryAddress(data.getAddress());
             if(data.getAddressType() != null && data.getBankIdentifier() != null) {        
                	  AddInwardGuaranteePage.selectAdressType(data.getAddressType())
                	  .enterBankIdentifier(data.getBankIdentifier())
                	  .pressOnPartyContinueButton(); 
             }
             AddInwardGuaranteePage.pressOnPartyContinueButton()
                      .sendkeysExpiryDate(data.getExpiryDate())
                      .sendkeysclaimDate(data.getClaimDate())
                      .selectApplicableRules(data.getRulesdropdown())
                      .pressOnCounterGuaranteeButton()                                	                            
                      .pressOnYesButton()
                      .pressOnCloseCounterGuaranteeButton();
               if(data.getChargeBorneMenu().equals(FinacleFields.CHARAGEBORNEBY) && data.getChargeBorneMenu() != null) {
            	   AddInwardGuaranteePage.selectGuaranteeAdditionalDetails()
            	   .selectChargeBorne(data.getChargeBorneMenu())
            	   .enterpurposeOfMessage(data.getMessage())
            	   .pressOnGuaranteeDetailsContinueButtonEUR();	                        	   
            	     
               }       
             AddInwardGuaranteePage
                      .pressLimitContinueButton()
                      .pressMarginContinueButton()
                      .pressChargesContinueButton()
                      .pressInstructionContinueButton()
                      .pressTextContinueButton();

    //LIBER
             if(data.getReceivingBank() == null && data.getMessageMenu() == null && data.getNarrativeText() == null) {       
            	AddInwardGuaranteePage.clickOnEditMessageButton()
                      .clickOnAcceptMessageButton()
                      .clickOnUpdateMessageButton()
                      .pressMessageContinueButton();	
    //IFBID        	
                  }else if(data.getReceivingBank() != null && data.getMessageMenu() != null && data.getNarrativeText() != null) {
                	  AddInwardGuaranteePage.selectMessageType(data.getMessageMenu())
                      .enterReceivingBank(data.getReceivingBank())
                      .clickOnGenerateButton()
                      .clickOnFirstMessageEditButton()
                      .clickOnAcceptFirstMessageButton()
                      .clickOnUpdateFirstMessageButton()
                      .clickOnSecondEditButton()
                	  .clickOnEditNarrativeButton()
                	  .enterNarrativeTextField(data.getNarrativeText())
                	  .clickOnSaveButton()
                	  .clicOnacceptSecondMessageButton()
                	  .clickOnUpdateSecondButton()
                      .pressMessageContinueButton();	
                  }
         }
		      
		      
		      
	
		        AddInwardGuaranteePage.pressSubmitButton()
                                      .saveGuaranteeId(data.getLinkedTcid1(), data.getLinkedTcid2());		   
}
}
