package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEIssueOutwardLCsTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEISSUEOUTWARDLCSsTRADEFINANCECSV;
	
	private static final String basequery = "SELECT C.ORGKEY FROM CRMUSER.ACCOUNTS C  "
			+ "    WHERE C.TFPARTYFLAG = 'Y' "
			+ "        AND C.KYC_STATUS = 'A' "
			+ "        AND C.RECORDSTATUS = 'A' "
			+ "        AND ROWNUM <= 150  "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
