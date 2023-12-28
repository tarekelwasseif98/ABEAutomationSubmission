package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenCurrentAccountMudarabahCAA_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV;
	
	private static final String basequery = "SELECT CRML1.ORGKEY FROM CRMUSER.ACCOUNTS CRML1 "
			+ "join  TBAADM.GAM GAML1 on CRML1.ORGKEY = GAML1.CIF_ID "
			+ "join tbaadm.SMT SMTL1 on GAML1.ACID = SMTL1.ACID "
			+ "WHERE NOT EXISTS( "
			+ "select 1 from TBAADM.GAM GAML2 "
			+ "where GAML2.CIF_ID = CRML1.ORGKEY "
			+ "and SMTL1.ACCT_STATUS = 'D') "
			+ "AND CRML1.KYC_STATUS = 'A' "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
