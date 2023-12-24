package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateCorporateCustomerData;
import pageobjects.ABECreateCorporateCustomerPage;

public class ABECreateCorporateCustomerProcedures {

	public static void CreateCorporateCustomer(WebDriver driver, ABECreateCorporateCustomerData data) throws Exception {
		
		//Create
		ABECreateCorporateCustomerPage ABECreateCorporateCustomerPage = new ABECreateCorporateCustomerPage(driver);
		ABECreateCorporateCustomerPage.sendKeysSearchBarTextField(data.getMenu());
		ABECreateCorporateCustomerPage.openCorporateCustomerFristPage(data.getDocNumber(),data.getCorporateCusType());
		
		if(data.getCorporateCusType().equalsIgnoreCase("Customer"))
				{	ABECreateCorporateCustomerPage.enterARCustomerName()
				.enterENCustomerName(data.getLegalcompanyNameEN(), data.getCommericalNameEN(), data.getTradeNameEN())
				.enterEntityType(data.getEntityType(), data.getSubEntitType(), data.getEstablishmentDate(),
						data.getCountryOfIncoporation()).editIDsummary(data.getIssueDateIDSummary())
				.addWorkAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorateAddress(), data.getCountryAddress())
				.addMailingAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorateAddress(), data.getCountryAddress())
				.addPhoneAndEmailSummary(data.getPhoneNumber()).naigavteOtherDetails().selectIndustryType(data.getIndustryType())
			    .corporateRepDetails(data.getBankRelationType(), data.getRelationCIFID()).saveAndEnrich().saveCIF(data.getLinkedTcid());
				//ENRICH
				ABECreateCorporateCustomerPage.proceedtoEnrich().generalDetailsOption(data.getBusStartDate(), data.getCountryEstablishment())
				.bankStatmentDetails().residentialDetails(data.getResidencyCountry()).abeSpecific().countryDealingRiskDetails()
				.calculateRisk();
				ABECreateCorporateCustomerPage.highRiskDetailsCustomer();
				ABECreateCorporateCustomerPage.fatcaDetails().saveAndValidateGeneralDetails().openRelationShipDetails()
				.submitEnrich();
		}else 
			
			if(data.getCorporateCusType().equalsIgnoreCase("Prospect")){
			ABECreateCorporateCustomerPage.prospectCustomer().enterEntityType(data.getEntityType(), data.getSubEntitType(), data.getEstablishmentDate(),
						data.getCountryOfIncoporation()).editProspectIDsummary(data.getIssueDateIDSummary(),data.getCountryAddress())
			.addWorkAddressCustomer(data.getAddressLine1(), data.getCityAddress(), data.getGovernorateAddress(), data.getCountryAddress())
			.addPhoneAndEmailSummary(data.getPhoneNumber()).naigavteOtherDetails().enterCountryOfIncorporationProscpect().selectIndustryType(data.getIndustryType())
		    .corporateRepDetails(data.getBankRelationType(), data.getRelationCIFID()).saveAndEnrich().saveCIF(data.getLinkedTcid());
			//ENRICH
			ABECreateCorporateCustomerPage.proceedtoEnrich().generalDetailsProspectOption().countryDealingRiskDetails()
			.calculateRiskProspect().fatcaDetails().saveAndValidateGeneralDetails().openRelationShipDetailsProspect()
			.submitEnrich();
		}

	}

}