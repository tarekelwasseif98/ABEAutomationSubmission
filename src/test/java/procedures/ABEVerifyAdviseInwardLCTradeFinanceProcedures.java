package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyAdviseInwardLCTradeFinanceData;
import pageobjects.ABEVerifyAdviseInwardLCTradeFinancePage;

public class ABEVerifyAdviseInwardLCTradeFinanceProcedures {
	public static void verifyAdviseInwardLCs(WebDriver driver, ABEVerifyAdviseInwardLCTradeFinanceData data) throws Exception {
		ABEVerifyAdviseInwardLCTradeFinancePage ABEVerifyAdviseInwardLCTradeFinancePage = new ABEVerifyAdviseInwardLCTradeFinancePage(driver);
		ABEVerifyAdviseInwardLCTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .enterDocCredit(data.getDocumentaryCreditId())
									   .navigateBetweenSideMenus()
									   .messageDetails()
									   .submitRecord();
	}
}