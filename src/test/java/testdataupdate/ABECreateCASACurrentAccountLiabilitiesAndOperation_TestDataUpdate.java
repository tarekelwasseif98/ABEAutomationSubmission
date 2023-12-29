package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateCASACurrentAccountLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {};
	

	private static final String csvFilePath = Paths.ABECREATECASACURRENTACCOUNTLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT C.ORGKEY FROM CRMUSER.ACCOUNTS C "
			+ "WHERE KYC_STATUS = 'A' "
			+ "AND CURRENT_DATE - C.CUST_DOB between 7665 and 21900 "
			+ "AND ROWNUM <= 100 "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
