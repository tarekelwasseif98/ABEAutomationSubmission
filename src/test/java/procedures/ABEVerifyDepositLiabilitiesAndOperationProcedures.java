package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyDepositLiabilitiesAndOperationData;
import pageobjects.ABEVerifyDespositLiabilitiesAndOperationPage;

public class ABEVerifyDepositLiabilitiesAndOperationProcedures {
	
	public static void ABEVerifyDepositLiabilitiesAndOperationByChecker(WebDriver driver, ABEVerifyDepositLiabilitiesAndOperationData data) throws Exception {
		ABEVerifyDespositLiabilitiesAndOperationPage ABEVerifyDepositLiabilitiesAndOperationByChecker = new ABEVerifyDespositLiabilitiesAndOperationPage(driver);
		ABEVerifyDepositLiabilitiesAndOperationByChecker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .selectFuntionCodeType()
									  .sendKeysAccountId(data.getAccountId())
									  .pressGoButton()
									  .pressSubmitButton();
		try {
			
        	ABEVerifyDepositLiabilitiesAndOperationByChecker.getSuccessMessageText();

		} catch (Exception e) {

	        try {
	        	ABEVerifyDepositLiabilitiesAndOperationByChecker.handleAlert();
	        } catch (Exception e1) {
	        	ABEVerifyDepositLiabilitiesAndOperationByChecker.submitAssertion();

	        }
		
									 
									
		}
	}
}
