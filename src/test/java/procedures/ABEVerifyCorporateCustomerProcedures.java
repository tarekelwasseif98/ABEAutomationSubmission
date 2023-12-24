package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCorporateCustomerData;

import pageobjects.ABEVerifyCorporateCustomerPage;

public class ABEVerifyCorporateCustomerProcedures {

	public static void verifyCIFBychecker(WebDriver driver, ABEVerifyCorporateCustomerData data) throws Exception {
		ABEVerifyCorporateCustomerPage ABEVerifyCorporateCustomerPage = new ABEVerifyCorporateCustomerPage(driver);
		ABEVerifyCorporateCustomerPage.sendKeysSearchBarTextField(data.getMenu()).switchFormAreaFrame().enterDataAtRCCAT(data.getCif(),data.getCustomerType())
		.approveCIF().openCorporateCustomerFirstPage().approvalForm();
		  
	}
}
