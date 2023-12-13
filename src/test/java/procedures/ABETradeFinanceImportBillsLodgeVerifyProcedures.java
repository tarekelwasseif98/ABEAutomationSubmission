package procedures;

import org.openqa.selenium.WebDriver;

import data.ABETradeFinanceImportBillsLodgeVerifyData;
import pageobjects.ABETradeFinanceImportBillsLodgeVerifyPage;


public class ABETradeFinanceImportBillsLodgeVerifyProcedures {
	public static void TradeFinanceImportBillsVerifyLodge(WebDriver driver, ABETradeFinanceImportBillsLodgeVerifyData data) throws Exception {
		ABETradeFinanceImportBillsLodgeVerifyPage lodgeImportBills = new ABETradeFinanceImportBillsLodgeVerifyPage(driver);
		lodgeImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame()
									   .sendKeysBillId(data.getBillId())
									   .pressGoButton()
									   .pressSideTab1()
									   .pressSideTab2()
									   .pressTenorDetailsViewButton1()
									   .pressTenorDetailsCloseButton()
									   .pressTenorDetailsViewButton2()
									   .pressTenorDetailsCloseButton()
									   .pressSideTab3()
									   .pressSideTab4()
									   .pressSideTab5()
									   .pressSideTab6()
									   .pressSideTab7()
									   .pressSubmitButton()
									   .saveBillId(data.getAcceptLinkedTcid(),data.getVerifyAcceptLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid(), data.getCoAcceptLinkedTcid(),data.getVerifyCoAcceptLinkedTcid());
	}

}
