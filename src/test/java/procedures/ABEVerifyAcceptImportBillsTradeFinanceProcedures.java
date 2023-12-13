package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyAcceptImportBillsTradeFinanceData;
import pageobjects.ABEVerifyAcceptImportBillsTradeFinancePage;


public class ABEVerifyAcceptImportBillsTradeFinanceProcedures {

	public static void ABEVerifyAcceptImportBillsTradeFinance(WebDriver driver, ABEVerifyAcceptImportBillsTradeFinanceData data) throws Exception {
		
		ABEVerifyAcceptImportBillsTradeFinancePage verifyAcceptExportBillsTradeFinancePage = new ABEVerifyAcceptImportBillsTradeFinancePage(driver);

		verifyAcceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
		.switchFormAreaFrame();
		
		if(data.getMixedBillId1() == null && data.getMixedBillId2() ==null)
		{
		verifyAcceptExportBillsTradeFinancePage.sendKeysBillId(data.getBillId())
		.pressGoButton()
		.pressSideTabs()
		.pressSubmitButton();
		}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() ==null)
		{
			verifyAcceptExportBillsTradeFinancePage.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId1())
			.pressGoButton()
			.pressSideTabs()
			.pressSubmitButton();
		}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() !=null)
		{
			verifyAcceptExportBillsTradeFinancePage.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId2())
			.pressGoButton()
			.pressSideTabs()
			.pressSubmitButton();
			
		}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() !=null)
		{
			verifyAcceptExportBillsTradeFinancePage.sendKeysBillId(data.getBillId())
			.sendKeysTenorBillId(data.getMixedBillId1())
			.pressGoButton()
			.pressSideTabs()
			.pressSubmitButton();
		}

	}
}
