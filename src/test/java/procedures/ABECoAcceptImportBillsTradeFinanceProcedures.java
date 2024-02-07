package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECoAcceptImportBillsTradeFinanceData;
import pageobjects.ABECoAcceptImportBillsTradeFinancePage;

public class ABECoAcceptImportBillsTradeFinanceProcedures {
	
	public static void coAcceptImportBills(WebDriver driver, ABECoAcceptImportBillsTradeFinanceData data) throws Exception {
		ABECoAcceptImportBillsTradeFinancePage CoAcceptImportBillsTradeFinanceByMaker = new ABECoAcceptImportBillsTradeFinancePage(driver);
		
		CoAcceptImportBillsTradeFinanceByMaker.sendKeysSearchBarTextField(data.getMenu())
									   			.switchFormAreaFrame();
		
		if(data.getMixedBillId1() == null && data.getMixedBillId2() == null)
		{
			
			CoAcceptImportBillsTradeFinanceByMaker.sendKeysBillId(data.getBillId());
			
			CoAcceptImportBillsTradeFinanceByMaker.pressGoButton()
												   .sendKeysCoAcceptanceDateTextField(data.getCoacceptanceDate())
												   .pressPartyDetailsTab()
												   .pressTenorDetailsTab()
												   .pressTenorEditButton()
												   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
												   .pressUpdateButton()
												   .pressEventDetailsTab()
												   .pressTransactionDetailsTab()
												   .pressSubmitButton();
		}
		
		else if (data.getMixedBillId1() != null && data.getMixedBillId2() != null)
		{
			
			CoAcceptImportBillsTradeFinanceByMaker.sendKeysBillId(data.getBillId())
													.sendKeysTenorBillId(data.getMixedBillId2());
			
			CoAcceptImportBillsTradeFinanceByMaker.pressGoButton()
												   .sendKeysCoAcceptanceDateTextField(data.getCoacceptanceDate())
												   .pressPartyDetailsTab()
												   .pressTenorDetailsTab()
												   .pressTenorEditButton2()
												   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
												   .pressUpdateButton()
												   .pressEventDetailsTab()
												   .pressTransactionDetailsTab()
												   .pressSubmitButton();
		}
//		else if (data.getMixedBillId1() != null && data.getMixedBillId2() == null)
//		{
//			
//			   createCasaCurrentAccountByMaker.sendKeysBillId(data.getBillId())
//				.sendKeysTenorBillId(data.getMixedBillId1());
//			   createCasaCurrentAccountByMaker.pressGoButton()
//			   .sendKeysCoAcceptanceDateTextField(data.getCoacceptanceDate())
//			   .pressPartyDetailsTab()
//			   .pressTenorDetailsTab()
//			   .pressTenorEditButton2()
//			   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
//			   .pressUpdateButton()
//			   .pressEventDetailsTab()
//			   .pressTransactionDetailsTab()
//			   .pressSubmitButton();
//		}
//		else if (data.getMixedBillId1() == null && data.getMixedBillId2() != null)
//		{
//			createCasaCurrentAccountByMaker.sendKeysBillId(data.getBillId())
//			.sendKeysTenorBillId(data.getMixedBillId2());
//		   createCasaCurrentAccountByMaker.pressGoButton()
//		   .sendKeysCoAcceptanceDateTextField(data.getCoacceptanceDate())
//		   .pressPartyDetailsTab()
//		   .pressTenorDetailsTab()
//		   .pressTenorEditButton2()
//		   .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
//		   .pressUpdateButton()
//		   .pressEventDetailsTab()
//		   .pressTransactionDetailsTab()
//		   .pressSubmitButton();
//		}
		
		}

}
