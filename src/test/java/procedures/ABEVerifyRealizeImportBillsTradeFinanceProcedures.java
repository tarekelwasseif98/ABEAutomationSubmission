package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyRealizeImportBillsTradeFinanceData;
import pageobjects.ABEVerifyRealizeImportBillsTradeFinancePage;

public class ABEVerifyRealizeImportBillsTradeFinanceProcedures {
	
	public static void VerifyRealizeImportBillsTradeFinance(WebDriver driver, ABEVerifyRealizeImportBillsTradeFinanceData data) throws Exception {
		ABEVerifyRealizeImportBillsTradeFinancePage VerifyRealizeImportBillsTradeFinance = new ABEVerifyRealizeImportBillsTradeFinancePage(driver);
		VerifyRealizeImportBillsTradeFinance.sendKeysSearchBarTextField(data.getMenu())
		.switchFormAreaFrame();
		
	
		
		
		if(data.getMixedBillId1() == null && data.getMixedBillId2() == null)
		{
			VerifyRealizeImportBillsTradeFinance .sendKeysBillId(data.getBillId())
			 .pressGoButton()
			 .pressEventDetailsTab()
			 .pressTransactionDetailsTab()
			 .pressSubmitButton();
		}
		
	
		
		else if (data.getMixedBillId1() == null && data.getMixedBillId2() != null){
			VerifyRealizeImportBillsTradeFinance .sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			 .pressGoButton()
			 .pressEventDetailsTab()
			 .pressTransactionDetailsTab()
			 .pressSubmitButton();
		}
		
		else if (data.getMixedBillId1() != null && data.getMixedBillId2() != null){
			VerifyRealizeImportBillsTradeFinance .sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			 .pressGoButton()
			 .pressEventDetailsTab()
			 .pressTransactionDetailsTab()
			 .pressSubmitButton()
			 .pressRepeatTaskButton()
			 .sendKeysBillId(data.getBillId())
				.sendKeysTenorBillId(data.getMixedBillId2())
				 .pressGoButton()
				 .pressEventDetailsTab()
				 .pressTransactionDetailsTab()
				 .pressSubmitButton();
			 
		}
		
	
	}

}
