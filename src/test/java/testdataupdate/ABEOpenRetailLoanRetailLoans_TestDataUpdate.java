package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenRetailLoanRetailLoans_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "operativeAccount"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEOPENRETAILLOANRETAILLOANSCSV;
	
	private static final String basequery = "SELECT GAML1.CIF_ID , GAML1.FORACID FROM TBAADM.GAM GAML1 "
			+ "JOIN CRMUSER.ACCOUNTS CRML1 ON CRML1.ORGKEY = GAML1.CIF_ID "
			+ "join tbaadm.SMT SMTL1 on GAML1.ACID = SMTL1.ACID "
			+ "WHERE GAML1.ACCT_CRNCY_CODE = 'EGP' "
			+ "AND SMTL1.ACCT_STATUS = 'A' "
			+ "AND GAML1.clr_bal_amt > 15000 "
			+ "AND CURRENT_DATE - GAML1.ACCT_OPN_DATE > 31 "
			+ "AND EXISTS( SELECT 1 FROM CRMUSER.ACCOUNTS CRML2  "
			+ "WHERE CRML2.ORGKEY = GAML1.CIF_ID "
			+ "AND CRML2.KYC_STATUS = 'A' "
			+ "AND CURRENT_DATE - CRML2.CUST_DOB > 7665) "
			+ "AND ROWNUM <= 100 "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
