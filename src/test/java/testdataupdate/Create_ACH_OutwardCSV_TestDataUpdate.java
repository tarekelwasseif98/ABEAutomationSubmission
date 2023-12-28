package testdataupdate;

import database.Updater;
import utils.Paths;

public class Create_ACH_OutwardCSV_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"Account"};
	private static final String[] ControlColumns  = {"CCY" , "Amount"};
	
	private static final String csvFilePath = Paths.Create_ACH_Outward;
	
	private static final String basequery = "SELECT FORACID FROM tbaadm.SMT " +
            "INNER JOIN TBAADM.GAM ON SMT.ACID = GAM.ACID " +
            "WHERE ROWNUM <= 1 " +
            "AND ACCT_STATUS = 'A' " +
            "AND SCHM_TYPE IN ( 'CAA' , 'SBA') ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
