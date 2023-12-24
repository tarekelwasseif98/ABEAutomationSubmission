package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateOutwardTransferPaymentData;
import pageobjects.ABECreateOutwardTransferPaymentPage;

public class ABECreateOutwardTransferPaymentProcedures {

	public static void AchOutwardByMaker(WebDriver driver, ABECreateOutwardTransferPaymentData data) throws Exception {
		ABECreateOutwardTransferPaymentPage ABECreateOutwardTransferPaymentPage = new ABECreateOutwardTransferPaymentPage(driver);
		ABECreateOutwardTransferPaymentPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentType(data.getServiceTypeID(),data.getPaysysID())
		                                .pressSubmitButton()
		                                .sendKeysAchOutwardPayment(
		                                		data.getCountryCode_REM(),
		                                		data.getWaiveChargeRemark(),
		                                		data.getChargeWaiveOption(),
		                                		data.getCharge_type(), 
		                                		data.getAccount(),
		                                		data.getCCY(), 
		                                		data.getName_REM() , 
		                                		data.getAddress1_BEN(), 
		                                		data.getAddress2_BEN(),
		                                		data.getPurpose_Code() ,
		                                		data.getAddress1_REM(),
		                                		data.getAddress2_REM(),
		                                		data.getAmount(),
		                                		data.getDate(),
		                                		data.getLine1_RI(), 
		                                		data.getAccount_BEN(),
		                                		data.getName_BEN(),  
		                                		data.getBIC_BEN(), 
		                                		data.getNetwork_BEN(),
		                                		data.getBank_BEN(), 
		                                		data.getBranch_BEN())
		                                .savePOID(data.getPaysysID(), data.getVerifylinkedTcid(), data.getAuthLinkedTcid());
		
	}
	
}