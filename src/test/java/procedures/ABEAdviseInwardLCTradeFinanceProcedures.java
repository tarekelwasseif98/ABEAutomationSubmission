package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEAdviseInwardLCTradeFinanceData;
import pageobjects.ABEAdviseInwardLCTradeFinancePage;

public class ABEAdviseInwardLCTradeFinanceProcedures {

	public static void AdviseInwardLCByMaker(WebDriver driver, ABEAdviseInwardLCTradeFinanceData data) throws Exception {
		ABEAdviseInwardLCTradeFinancePage ABEAdviseInwardLCTradeFinancePage = new ABEAdviseInwardLCTradeFinancePage(driver);
		ABEAdviseInwardLCTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
	     .switchFormAreaFrame().sendkeysdocumentaryCreditTypeField(data.getDocumentaryCreditType(),data.getCcySearch(),data.getCifBen())
	     .sendkeysdocumentaryCreditAmount(data.getDocumentaryCreditAmount(),data.getIssueDate(),data.getOtherDetailsbankRefNo(),data.getPaySysID());
		ABEAdviseInwardLCTradeFinancePage.senkeysRelatedPartyDetails(data.getCifApplicant(),data.getBankIdentifierAdvising(),data.getBankIdentifierIssuingBank());
		ABEAdviseInwardLCTradeFinancePage.senkeysCheckTransferable();
		if(data.getTenorType().equalsIgnoreCase("Sight")) {
			ABEAdviseInwardLCTradeFinancePage.selectTenor(data.getTenorType());
		}else if(data.getTenorType().equalsIgnoreCase("Usance")) {
			ABEAdviseInwardLCTradeFinancePage.selectTenor(data.getTenorType()).enterPeriod();
		}else if(data.getTenorType().equalsIgnoreCase("Mixed Payment")) {
			ABEAdviseInwardLCTradeFinancePage.selectTenor(data.getTenorType()).enterMixedPaymentTenor();
		}
		ABEAdviseInwardLCTradeFinancePage.expiryDateDetails(data.getExpiryDate(), data.getCounrtyOfExpiry()).selectTypeOfConfirmation().fetchCharges().enterMessageDetails(data.getRecBankIdentifier())
		.editRelatedRef(data.getValueRelatedRef()).editNarrativeMessage(data.getTextMessageEditor()).clickAcceptAndUpdate().pressSubmitButton().saveDocumentaryCreditNo(data.getLinkedTcId());
	}
}
