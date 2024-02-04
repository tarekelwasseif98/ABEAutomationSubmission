package procedures;

import org.openqa.selenium.WebDriver;

import utils.FinacleFieldsUtils;
import data.ABEOpenOVDData;
import pageobjects.ABEOpenOVDPage;
import utils.PageFunctionUtils;

public class ABEOpenOVDProcedures {

	public static void overDraftAccountByMaker(WebDriver driver, ABEOpenOVDData data) throws Exception {
		ABEOpenOVDPage OpenOverDraftAccountPage = new ABEOpenOVDPage(driver);
		
		OpenOverDraftAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysCustomerDetailsCIF(data.getCif())
									   .sendKeysCustomerDetailsSchemeCode(data.getSchemeCode())
									   .sendKeysCustomerDetailsCurrency(data.getCurrency())
									   .goButton()
									   .sendKeysCustomerAccountDocumentDate(data.getDocumentDate())
									   .sendKeysCustomerAccountExpiryDate(data.getExpiryDate())									   									   																		  
		                               .pressAddButton()
		                               .sendkeystenorFields(data.getTenor());
		                              FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
											   if(data.getTypes().equals(FinacleFields.TYPESUNSECURED) && data.getCifType().equals(FinacleFields.CIFTYPECORPORATE) || data.getTypes().equals(FinacleFields.TYPESUNSECURED) && data.getCifType().equals(FinacleFields.CIFTYPERETAIL)){												   
												   OpenOverDraftAccountPage.selectDrawingPower(data.getDropdownMenu())
												                            .pressAddidtionalContinueButton();
												   
											   }if(data.getTypes().equals(FinacleFields.TYPESSECURED) && data.getCifType().equals(FinacleFields.CIFTYPECORPORATE)) {
												   OpenOverDraftAccountPage.turnOver();
											   }
											   else if(data.getTypes().equals(FinacleFields.TYPESSECURED) && data.getCifType().equals(FinacleFields.CIFTYPERETAIL)) {
												   OpenOverDraftAccountPage.pressForSecuredRetail();
												   
											   }
					OpenOverDraftAccountPage.pressGeneralContinueButton()   
                                       .pressSignatureContinueButton()
                                       .pressAccountContinueButton()
                                       .pressInterestContinueButton()
                                       .pressSchemeContinueButton()
                                       .pressRevolvingContinueButton()
                                       .pressRelatedContinueButton();
		                                  
                                      
                                    	   if(data.getCollateralType().equals(FinacleFields.COLLATERALTYPESINGLE)) {
                                    	   OpenOverDraftAccountPage.addCollateralDetails(data.getCollateralCode())                                 	                      
                                    	                           .sendkeysCollateralDetailsLoanValue(data.getModifyLoan())
                                    	                           .sendkeysCollateralDetailsApportionedAmount(data.getApportionedAmount())
                                    	                           .sendkeysCollateralDetailsEntityId(data.getEntityId())
									                               .pressCollateralSaveAndPreviewButton()
									                               .pressCollateralContinueButton();
									                             
                                       }  
									                if(data.getCollateralType().equals(FinacleFields.COLLATERALTYPEMULTIPLE)) {      
									       OpenOverDraftAccountPage.sendkeysForCollateralCode(data.getCollateralCode())
									                               .sendkeysForTwoEntitiesIdsLoanValue(data.getModifyLoan())
									                               .sendkeysForTwoEntitiesIdsApportionedAmount(data.getApportionedAmount())
									                               .sendkeysForEntityId1(data.getEntityId1())
									                               .pressCollateralSaveAndPreviewButton1()
									                               .pressCollateralContinueButton();
									                             

						                               }if(data.getCollateralType().equals(FinacleFields.NOTCOLLATERALTYPE)) {				                            	   
						                            	   OpenOverDraftAccountPage.pressCollateralContinueButton();
	                                                      
                           				
                           				}
						                               OpenOverDraftAccountPage.pressDocumentContinueButton()
                                                       .pressTaxContinueButton()
                                                       .pressExceptionContinueButton()
                                                       .pressBankContinueButton()
                                                       .pressFlexiContinueButton()
                                                       .pressPaymentContinueButton()
                                                       .pressChargeContinueButton()
                                                       .pressBaseContinueButton()
                                                       .pressFreeOptionsButton()                                                     
								                       .sendkeysWithdrawalField(data.getWithdrawal())
								                       .pressMissContinueButton()
								                       .pressSubmitButton()
									                   .saveAccountId(data.getLinkedTcid2(), data.getLinkedTcid()); 
									                
									                
									                
	}
                                    	 

}
	


