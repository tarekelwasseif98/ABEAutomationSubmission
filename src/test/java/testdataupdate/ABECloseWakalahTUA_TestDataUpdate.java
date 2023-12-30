package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECloseWakalahTUA_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"repaymentAccountId"};
	private static final String[] ControlColumns  = {"accountId"};

	private static final String csvFilePath = Paths.ABECLOSEWAKALAHTUACSV;
	
	private static final String basequery = "SELECT GAML1.FORACID FROM TBAADM.GAM GAML1 "
	+ "join tbaadm.SMT SMTL1 on GAML1.ACID = SMTL1.ACID "
	+ "WHERE exists( "
	+ "select 1 from TBAADM.GAM GAML2 "
	+ "where GAML2.foracid = '{0}' "
	+ "and GAML1.clr_bal_amt > (GAML2.clr_bal_amt*-1)) "
	+ "AND GAML1.ACCT_CRNCY_CODE = 'EGP' "
	+ "AND GAML1.SCHM_TYPE in ('SBA' , 'CAA') "
	+ "AND SMTL1.ACCT_STATUS = 'A' "
	+ "ORDER by DBMS_RANDOM.value "
	+ "FETCH NEXT 1 rows only";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
