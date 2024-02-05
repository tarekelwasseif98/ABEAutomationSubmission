package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateESWIFTOutward_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"Account"};
	private static final String[] ControlColumns  = {"CCY" , "Amount"};
	
	private static final String csvFilePath = Paths.ABECREATEESWIFTOUTWARDCSV;
	
	private static final String basequery = "SELECT A.FORACID from TBAADM.GAM A  "
			+ "JOIN tbaadm.SMT S on S.ACID = A.ACID  "
			+ "WHERE S.ACCT_STATUS = 'A' "
			+ "AND A.ENTITY_CRE_FLG = 'Y' "
			+ "AND A.ACCT_CLS_FLG = 'N' "
			+ "AND A.FREZ_CODE NOT IN ('D','T') "
			+ "AND SCHM_TYPE IN ( 'CAA' , 'SBA') "
			+ "AND A.clr_bal_amt > 2000+{1} "
			+ "AND A.ACCT_CRNCY_CODE = '{0}' "
			+ "AND ROWNUM <=150 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
