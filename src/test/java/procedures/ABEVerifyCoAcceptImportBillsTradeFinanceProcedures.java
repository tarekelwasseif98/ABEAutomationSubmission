package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCoAcceptImportBillsTradeFinanceData;
import pageobjects.ABEVerifyCoAcceptImportBillsTradeFinancePage;

public class ABEVerifyCoAcceptImportBillsTradeFinanceProcedures {

	
	public static void VerifyCoAcceptImportBills(WebDriver driver, ABEVerifyCoAcceptImportBillsTradeFinanceData data) throws Exception {
		ABEVerifyCoAcceptImportBillsTradeFinancePage VerifyCoAcceptImportBills = new ABEVerifyCoAcceptImportBillsTradeFinancePage(driver);
		VerifyCoAcceptImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame();
	
		
		if(data.getMixedBillId1() == null && data.getMixedBillId2() == null)
		{
			VerifyCoAcceptImportBills.sendKeysBillId(data.getBillId())
			   .pressGoButton()
			   .pressPartyDetailsTab()
			   .pressTenorDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressSubmitButton();
		}
		
		
		else if (data.getMixedBillId1() != null && data.getMixedBillId2() == null){
			VerifyCoAcceptImportBills.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			   .pressGoButton()
			   .pressPartyDetailsTab()
			   .pressTenorDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressSubmitButton();
		}
		
		else if (data.getMixedBillId1() == null && data.getMixedBillId2() != null){
			VerifyCoAcceptImportBills.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			   .pressGoButton()
			   .pressPartyDetailsTab()
			   .pressTenorDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressSubmitButton();
		}
		
		else if (data.getMixedBillId1() != null && data.getMixedBillId2() != null){
			VerifyCoAcceptImportBills.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			   .pressGoButton()
			   .pressPartyDetailsTab()
			   .pressTenorDetailsTab()
			   .pressEventDetailsTab()
			   .pressTransactionDetailsTab()
			   .pressSubmitButton();
		}
		
		
		}
}
