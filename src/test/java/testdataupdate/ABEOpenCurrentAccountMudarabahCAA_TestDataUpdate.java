package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenCurrentAccountMudarabahCAA_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV;
	
	private static final String basequery = "SELECT C.ORGKEY FROM CRMUSER.ACCOUNTS C  "
			+ "WHERE C.KYC_STATUS = 'A'  "
			+ "AND NOT EXISTS(  "
			+ "        select 1 from TBAADM.GAM A  "
			+ "        join tbaadm.SMT S on S.ACID = A.ACID  "
			+ "        where A.CIF_ID = C.ORGKEY  "
			+ "        and S.ACCT_STATUS = 'D')  "
			+ " AND ROWNUM <= 50  "
			+ " ORDER by DBMS_RANDOM.value  "
			+ " FETCH NEXT 1 rows only ";
	
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
