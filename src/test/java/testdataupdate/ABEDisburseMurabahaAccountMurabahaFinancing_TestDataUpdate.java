package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEDisburseMurabahaAccountMurabahaFinancing_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"creditAccountId"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGCSV;
	
	private static final String basequery = "SELECT FORACID FROM tbaadm.SMT " +
            "INNER JOIN TBAADM.GAM ON SMT.ACID = GAM.ACID " +
            "AND ACCT_STATUS = 'A' " +
            "AND ACCT_CRNCY_CODE = 'EGP' "+
            "AND SCHM_TYPE IN ( 'CAA' , 'SBA') "+
            "ORDER by DBMS_RANDOM.value "+
            "FETCH NEXT 1 rows only";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
