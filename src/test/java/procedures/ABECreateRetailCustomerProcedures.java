package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateRetailCustomerData;
import pageobjects.ABECreateRetailCustomerPage;
import utils.FinacleFieldsUtils;

public class ABECreateRetailCustomerProcedures {

	public static void CreateRetailCustomer(WebDriver driver, ABECreateRetailCustomerData data) throws Exception {
		ABECreateRetailCustomerPage ABECreateRetailCustomerPage = new ABECreateRetailCustomerPage(driver);
		ABECreateRetailCustomerPage.sendKeysSearchBarTextField(data.getMenu())
				.openRetailCustomerFristPage(data.getDocType(), data.getDocNumber());
		if (data.getDocType().equalsIgnoreCase(FinacleFieldsUtils.PASSPORTID)) {
			ABECreateRetailCustomerPage.fillBasicDetailsPASSPORT(data.getDOB())
					.enterARCustomerName(data.getFirstARname(), data.getMidARname(), data.getLastARname())
					.enterENCustomerName(data.getFirstENname(), data.getMidENname(), data.getLastENname())
					.enterNationalityOfCustomer(data.getNationalityCustomer())
					.editIDsummary(data.getCountryOfIssueSummary(), data.getIssueDateIDSummary(),
							data.getExpiryDateIDSummary())
					.addAddressCustomerPASS(data.getAddressLine1(), data.getCityAddress(), data.getGovernorate(),
							data.getCountry())
					.addPhoneAndEmailSummary(data.getPhoneNumber()).continueBasicDetailsButton()
					.fillPersonalDetails(data.getMotherMaidenName(), data.getMotherFirstname());

			if (data.getEmployed1().equalsIgnoreCase("N")) {
				ABECreateRetailCustomerPage.fillEmploymentDetails();
			} else if (data.getEmployed1().equalsIgnoreCase("Y")) {
				ABECreateRetailCustomerPage.selectBankEmployeeRadioButton(data.getBankEmployeeID());
			}

			if (data.getResidencyStatus().equalsIgnoreCase("Non-resident:Foreign National")) {
				ABECreateRetailCustomerPage.fillResidentialDetails(data.getResidencyStatus(), data.getResindencExpiry(),
						data.getResidenceCountry()).continueOtherDetailsButton();
			}
			ABECreateRetailCustomerPage.addSegmentTypeRetailCustomer(data.getSegment(), data.getSubSegment())
					.saveAndEnrich().saveCIF(data.getLinkedTcid());

			// ENRICH
			ABECreateRetailCustomerPage.proceedtoEnrich().generalDetailsOptionPassport(data.getCountry()).bankStatmentDetails()
					.EmailDetails(data.getEmail()).continueBasicDetails()
					.occupationDetailsUnemployed(data.getDataIncome())
					.abeSpecficData(data.getPayrollFlag(), data.getPayRollCustomerCompanyID()).riskDetailsCountryDealing(data.getCategoryCodecountryDealing());
			
			if(data.getPep().equalsIgnoreCase("Y")) {
				ABECreateRetailCustomerPage.pepselection();
			}else if(data.getPep().equalsIgnoreCase("N")) {
				ABECreateRetailCustomerPage.pepunSelectedPASS().highRiskPassportCustomer();
			}
			
			ABECreateRetailCustomerPage.fatcaSelection().saveAndValidateGeneralDetails();
			ABECreateRetailCustomerPage.viewSummary().openBankDefinedDetails().openfinancialDetail().submitEnrichment();

		}else 
			
			if(data.getDocType().equalsIgnoreCase(FinacleFieldsUtils.NATIONALID)) {
			ABECreateRetailCustomerPage.iScoreCheck()
			.enterARNationalCustomerName(data.getMidARname())
			.enterENCustomerName(data.getFirstENname(), data.getMidENname(), data.getLastENname())
			.addAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorate(),
					data.getCountry()).addWorkAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorate(),
					data.getCountry())
			.addPhoneAndEmailSummary(data.getPhoneNumber()).continueBasicDetailsButton()
			.fillPersonalDetails(data.getMotherMaidenName(), data.getMotherFirstname());
	if (data.getEmployed1().equalsIgnoreCase("N")) {
		ABECreateRetailCustomerPage.fillEmploymentDetails().continueOtherDetailsButton();
	} else if (data.getEmployed1().equalsIgnoreCase("Y")) {
		ABECreateRetailCustomerPage.selectBankEmployeeRadioButton(data.getBankEmployeeID()).continueOtherDetailsButton().continueOtherDetailsButton();
	}
	ABECreateRetailCustomerPage.addSegmentTypeRetailCustomer(data.getSegment(), data.getSubSegment())
			.saveAndEnrich().saveCIF(data.getLinkedTcid());

	// ENRICH
	ABECreateRetailCustomerPage.proceedtoEnrich().generalDetailsOptionNATID().bankStatmentDetails()
			.EmailDetails(data.getEmail()).continueBasicDetails();
			if (data.getEmployed1().equalsIgnoreCase("Y")) {
				ABECreateRetailCustomerPage.occupationDetailsABEStaff();
			}else if (data.getEmployed1().equalsIgnoreCase("N")) {
				ABECreateRetailCustomerPage.occupationDetailsUnemployed(data.getDataIncome());
			}
			ABECreateRetailCustomerPage.abeSpecficData(data.getPayrollFlag(), data.getPayRollCustomerCompanyID()).riskDetailsCountryDealing(data.getCategoryCodecountryDealing());
	if(data.getPep().equalsIgnoreCase("Y")) {
		ABECreateRetailCustomerPage.pepselection();
	}else if(data.getPep().equalsIgnoreCase("N")) {
		ABECreateRetailCustomerPage.pepunSelected();
	}
	
	ABECreateRetailCustomerPage.fatcaSelection().saveAndValidateGeneralDetails();
	ABECreateRetailCustomerPage.viewSummary().openBankDefinedDetails().openfinancialDetail().submitEnrichment();
		}

	}

}