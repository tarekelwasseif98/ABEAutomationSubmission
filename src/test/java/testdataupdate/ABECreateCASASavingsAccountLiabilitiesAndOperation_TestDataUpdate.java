package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateCASASavingsAccountLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {"cifType", "cifAge"};
	

	private static final String csvFilePath = Paths.ABECREATECASASAVINGSACCOUNTLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT C.ORGKEY FROM CRMUSER.ACCOUNTS C "
			+ "WHERE C.KYC_STATUS = 'A' "
			+ "AND {0} "
			+ "AND C.RECORDSTATUS = 'A' "
			+ "AND {1} "
			+ "AND C.ENTITY_CRE_FLAG = 'Y' "
			+ "AND ROWNUM <= 100 "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only ";
	
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
