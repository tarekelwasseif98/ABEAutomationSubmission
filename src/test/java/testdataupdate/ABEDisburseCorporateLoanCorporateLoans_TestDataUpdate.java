package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEDisburseCorporateLoanCorporateLoans_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"disbursmentAccount"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEDISBURSECORPORATELOANCORPORATELOANSCSV;
	
	private static final String basequery = "SELECT FORACID FROM tbaadm.SMT " +
            "INNER JOIN TBAADM.GAM ON SMT.ACID = GAM.ACID " +
            "WHERE ROWNUM <= 1 " +
            "AND clr_bal_amt between 0 and 1000 " +
            "AND ACCT_STATUS = 'A' " +
            "AND ACCT_CRNCY_CODE = 'EGP' "+
            "AND SCHM_TYPE IN ( 'CAA' , 'SBA') ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
