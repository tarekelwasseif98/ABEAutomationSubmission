package procedures;

import org.openqa.selenium.WebDriver;

import data.ABETradeFinanceImportBillsLodgeData;
import pageobjects.ABETradeFinanceImportBillsLodgePage;
import utils.FinacleFieldsUtils;

public class ABETradeFinanceImportBillsLodgeProcedures {

	public static void TradeFinanceImportBillsLodge(WebDriver driver, ABETradeFinanceImportBillsLodgeData data) throws Exception {
		ABETradeFinanceImportBillsLodgePage lodgeImportBills = new ABETradeFinanceImportBillsLodgePage(driver);
		lodgeImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame()
									   .sendKeysBillType(data.getBillType())
									   .sendKeysCif(data.getCifId())
									   .sendKeysBillCcy(data.getBillCcy());
									   
									   
		if(data.getUnderDocumentaryCredit().equals(FinacleFieldsUtils.UNDERDOCUMENTRYCREDITNO))
		{
			lodgeImportBills.PressunderDocumentryCreditNoRadioButton();
		}							   
		else {
			lodgeImportBills.PressunderDocumentryCreditYesRadioButton()
			.sendKeysDocumentCreditNum(data.getDocumentryCreditNo());
			

		}
									   
									   lodgeImportBills
									   .PressGoButton()
									   .sendKeysOperativeAcId(data.getOperativeAccountId())
									   .sendKeysBillAmount(data.getBillAmt())
									   .sendKeysBillCountry(data.getBillCountry())
									   .sendKeysOtherBankRefNum(data.getBankRef())
									   .PressGeneralDetailsContinueButton()
									   .sendKeysName(data.getName())
									   .sendKeysAdress1(data.getAddress1());
									   if(data.getBankIdentfier() != null) {
									   lodgeImportBills   .sendDrawerBankIdentifier(data.getBankIdentfier());
									   }
									   lodgeImportBills .PressPartyDetailsContinueButton();
									   
									   
									   if(data.getType().equals(FinacleFieldsUtils.BILLTENORSIGHT))
									   {
										   lodgeImportBills.PressEditButton()
										   .sendKeysOnboardDate(data.getOnboardDate())
										   .sendKeysBillDate(data.getBillDate())
										   .sendKeysDueDate(data.getDueDate())
										   .PressUpdateButton();
									   }
									   else if(data.getType().equals(FinacleFieldsUtils.BILLTENORUSANCE))
									   {
										   lodgeImportBills.PressEditButton()
										   .sendKeysTenor(data.getMonth(), data.getDay())
										   .sendKeysOnboardDate(data.getOnboardDate())
										   .sendKeysBillDate(data.getBillDate())
										   .sendKeysDueDate(data.getDueDate())

										   .PressUpdateButton();
									   }
									   else if(data.getType().equals(FinacleFieldsUtils.tradeFinanceBillType3))
									   {
										   lodgeImportBills.PressTenorAddButton()
										   .addBill1Tenor(data.getBill1Amount(), data.getBillType(), data.getOnboardDate(), data.getBillDate(),data.getDueDate())
										   .addBill2Tenor(data.getBill2Amount(), data.getBillType(), data.getMonth(), data.getDay(), data.getOnboardDate(), data.getBillDate(), data.getDueDate());
									   }
									   
									 
									   lodgeImportBills.PressTenorDetailsContinueButton()
									   .sendKeysinvoiceAmtTextField(data.getInvoiceAmt());
									   if(data.getUnderDocumentaryCredit().equals(FinacleFieldsUtils.UNDERDOCUMENTRYCREDITYES))
									   {
										   lodgeImportBills.sendKeysDocumentStatus();

									   }
									   
									   if(data.getRateCode() != null) {
										   lodgeImportBills.sendKeysRate(data.getRateCode());
										   }
									   
									   lodgeImportBills.PressSideTabs();
//									   if(data.getBankIdentfier() != null)
//									   {
										   lodgeImportBills.PressMessageDetailsTab();
										 //  .generateMessage(data.getBankIdentfier());
								//	   }
									  
									   lodgeImportBills.PressSubmitButton()
									   .saveAccountId(data.getLinkedTcid(), data.getAcceptLinkedTcid(), data.getVerifyAcceptLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid(),data.getCoAcceptLinkedTcid(),data.getVerifyCoAcceptLinkedTcid());
									   
							
		}
}
