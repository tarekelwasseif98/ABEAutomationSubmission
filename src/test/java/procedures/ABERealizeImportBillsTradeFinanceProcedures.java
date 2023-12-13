package procedures;

import org.openqa.selenium.WebDriver;

import data.ABERealizeImportBillsTradeFinanceData;
import pageobjects.ABERealizeImportBillsTradeFinancePage;

public class ABERealizeImportBillsTradeFinanceProcedures {

	
	public static void realizeImportBillsTradeFinance(WebDriver driver, ABERealizeImportBillsTradeFinanceData data) throws Exception {
		ABERealizeImportBillsTradeFinancePage realizeImportBills = new ABERealizeImportBillsTradeFinancePage(driver);
		realizeImportBills.sendKeysSearchBarTextField(data.getMenu())
		.switchFormAreaFrame();
		
	
		if(data.getMixedBillId1() == null && data.getMixedBillId2() == null)
		{
			realizeImportBills .sendKeysBillId(data.getBillId())
			 .sendKeysSolId(data.getSolId())
			 .pressGoButton()
		//	 .sendKeysBillRealizationAmount(data.getBillRealizationAmount())
			 .sendKeysBillRealizationAcount(data.getRealizationAccountId())
			 .pressEventDetailsTab()
			 .pressTransactionDetailsTab()
			 .pressSubmitButton();
	    }
	
	
	
	else if (data.getMixedBillId1() == null && data.getMixedBillId2() != null){
		
		realizeImportBills .sendKeysBillId(data.getBillId())
		.sendKeysTenorBillId(data.getMixedBillId2())
		 .sendKeysSolId(data.getSolId())
		 .pressGoButton()
		// .sendKeysBillRealizationAmount(data.getBillRealizationAmount())
		 .sendKeysBillRealizationAcount(data.getRealizationAccountId())
		 .pressEventDetailsTab()
		 .pressTransactionDetailsTab()
		 .pressSubmitButton();
	}
	
	else if (data.getMixedBillId1() != null && data.getMixedBillId2() != null){
		
		realizeImportBills .sendKeysBillId(data.getBillId())
		.sendKeysTenorBillId(data.getMixedBillId2())
		 .sendKeysSolId(data.getSolId())
		 .pressGoButton()
		// .sendKeysBillRealizationAmount(data.getBillRealizationAmount())
		 .sendKeysBillRealizationAcount(data.getRealizationAccountId())
		 .pressEventDetailsTab()
		 .pressTransactionDetailsTab()
		 .pressSubmitButton()
		 .pressRepeatTaskButton()
		 .sendKeysBillId(data.getBillId())
		 .sendKeysTenorBillId(data.getMixedBillId1())
		 .sendKeysSolId(data.getSolId())
		  .pressGoButton()
		//.sendKeysBillRealizationAmount(data.getBillRealizationAmount())
			 .sendKeysBillRealizationAcount(data.getRealizationAccountId())
		.pressEventDetailsTab()
			 .pressTransactionDetailsTab()
			 .pressSubmitButton();
	}
		
		
}}
