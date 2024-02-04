package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyInwardGuaranteeData;
import pageobjects.ABEVerifyInwardGuaranteePage;
import utils.FinacleFieldsUtils;

public class ABEVerifyInwardGuaranteeProcesdures {

	
	

	public static void verifyInwardGuaranteeByChecker(WebDriver driver, ABEVerifyInwardGuaranteeData data) throws Exception {
		ABEVerifyInwardGuaranteePage verifyInwardGuaranteePage = new ABEVerifyInwardGuaranteePage(driver);
		
		verifyInwardGuaranteePage.sendKeysSearchBarTextField(data.getMenu())
                                  .switchFormAreaFrame()
                                  .sendKeysGuaranteeIdTextField(data.getGuaranteeNumberReferenceId())
                                  .pressGoButton()
                                  .pressGeneralDetailsContinueButton()
                                  .pressPartyContinueButton()
                                  .pressGuaranteeContinueButton()
                                  .pressLimitContinueButton()
                                  .pressMarginContinueButton()
                                  .pressChargesContinueButton()
                                  .pressInstructionContinueButton()                          
                                  .pressTextContinueButton();
	    FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
	
	    //LIBER //IFBID
       	  if(data.getPaymentStatus() != null && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPELIPER)) {
       		verifyInwardGuaranteePage.pressViewFirstMessageButtonLiber()
       		                         .selectPaymentStatusFirstMessage(data.getPaymentStatus())
       		                         .pressAcceptFirstMessageButton()
       		                         .pressCloseFirstMessageButton()
       		                         .pressMessageContinueButton()   
                                     .pressSubmitButton();
       	  }if(data.getPaymentStatus() != null && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFBID) || data.getPaymentStatus() != null && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFPER)) {
       	    verifyInwardGuaranteePage.pressViewFirstMessageButton()
                                     .selectPaymentStatusFirstMessage(data.getPaymentStatus())
                                     .pressAcceptFirstMessageButton()
                                     .pressCloseFirstMessageButton()
       	                             .pressViewSecondMessageButton()
       		                         .selectPaymentStatusSecondMessage(data.getPaymentStatus())
       		                         .pressAcceptSecondMessageButton()
       		                         .pressCloseSecondMessageButton()
       		                         .pressMessageContinueButton()
                                     .pressSubmitButton();
       	  }if (data.getPaymentStatus() != null && data.getGuaranteeType().equals(FinacleFields.GUARANTEETYPEIFADV)) {
       		 verifyInwardGuaranteePage.pressViewFirstMessageButton()
             .selectPaymentStatusFirstMessage(data.getPaymentStatus())
             .pressAcceptFirstMessageButton()
             .pressCloseFirstMessageButton()
                .pressViewSecondMessageButton()
                .selectPaymentStatusSecondMessage(data.getPaymentStatus())
                .pressAcceptSecondMessageButton()
                .pressCloseSecondMessageButton()
                .pressMessageContinueButton()
                .pressSubmitButton();
       		  
       	  }
        	else if(data.getPaymentStatus() == null) {       
	     verifyInwardGuaranteePage.pressMessageContinueButton()
                                  .pressSubmitButton();
   	}
	
	}	
	
}
