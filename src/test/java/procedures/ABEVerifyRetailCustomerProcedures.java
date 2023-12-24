package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyRetailCustomerData;
import pageobjects.ABEVerifyRetailCustomerPage;

public class ABEVerifyRetailCustomerProcedures {
	
	public static void verifyCIFBychecker(WebDriver driver, ABEVerifyRetailCustomerData data) throws Exception {
		ABEVerifyRetailCustomerPage ABEVerifyRetailCustomerPage = new ABEVerifyRetailCustomerPage(driver);
		ABEVerifyRetailCustomerPage.sendKeysSearchBarTextField(data.getMenu()).switchFormAreaFrame().enterDataAtRCCAT(data.getCIF())
		.approveCIF().openRetailCustomerFirstPage().approvalForm();
		  
	}
}
