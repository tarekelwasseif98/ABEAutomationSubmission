package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEAcceptImportBillTradeFinanceData;
import pageobjects.ABEAcceptImportBillTradeFinancePage;


public class ABEAcceptImportBillTradeFinanceProcedures {
	
	public static void ABEAcceptImportBillTradeFinanceByMaker(WebDriver driver, ABEAcceptImportBillTradeFinanceData data) throws Exception {
		ABEAcceptImportBillTradeFinancePage acceptImportBills = new ABEAcceptImportBillTradeFinancePage(driver);
		acceptImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame();

		if(data.getMixedBillId1() == null && data.getMixedBillId2() == null)
		{
			acceptImportBills.sendKeysBillId(data.getBillId());
			 acceptImportBills.pressGoButton()
			   .pressTenorEditButton()
			   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
			   .pressUpdateButton()
			   .pressBillDetailsTab()
			   .pressChargeDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressGeneralDetailsTab()
			   .pressPartyDetailsTab()
			   .pressMessageDetailsTab()
			   .pressSubmitButton();

		}
		
		else if (data.getMixedBillId1() != null && data.getMixedBillId2() != null){
			acceptImportBills.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2());
			 acceptImportBills.pressGoButton()
			   .pressTenorEditButton()
			   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
			   .pressUpdateButton()
			   .pressTenorEditButton2()
			   .sendKeysAcceptanceDateTextField2(data.getAcceptanceDate())
			   .pressUpdateButton()
			   .pressBillDetailsTab()
			   .pressChargeDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressGeneralDetailsTab()
			   .pressPartyDetailsTab()
			   .pressMessageDetailsTab()
			   .pressSubmitButton();
		
		}
//		else if (data.getMixedBillId1() != null && data.getMixedBillId2() == null){
//			acceptImportBills.sendKeysBillId(data.getBillId())
//			.sendKeysTenorBillId(data.getMixedBillId1());
//			 acceptImportBills.pressGoButton()
//			   .pressTenorEditButton()
//			   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
//			   .pressUpdateButton()
//			   .pressTenorEditButton2()
//			   .sendKeysAcceptanceDateTextField2(data.getAcceptanceDate())
//			   .pressUpdateButton()
//			   .pressBillDetailsTab()
//			   .pressChargeDetailsTab()
//			   .pressEventDetailsTab()
//			   .pressTransactionDetailsTab()
//			   .pressGeneralDetailsTab()
//			   .pressPartyDetailsTab()
//			   .pressSubmitButton();
//
//		}
//		else if (data.getMixedBillId1() == null && data.getMixedBillId2() != null){
//			acceptImportBills.sendKeysBillId(data.getBillId())
//			.sendKeysTenorBillId(data.getMixedBillId2());
//			 acceptImportBills.pressGoButton()
//			   .pressTenorEditButton()
//			   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
//			   .pressUpdateButton()
//			   .pressTenorEditButton2()
//			   .sendKeysAcceptanceDateTextField2(data.getAcceptanceDate())
//			   .pressUpdateButton()
//			   .pressBillDetailsTab()
//			   .pressChargeDetailsTab()
//			   .pressEventDetailsTab()
//			   .pressTransactionDetailsTab()
//			   .pressGeneralDetailsTab()
//			   .pressPartyDetailsTab()
//			   .pressSubmitButton();
//		
//				}
		
									   
									  
									   
									
		}

}
