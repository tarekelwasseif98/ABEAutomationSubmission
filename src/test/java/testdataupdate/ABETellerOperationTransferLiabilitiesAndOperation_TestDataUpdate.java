package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABETellerOperationTransferLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"accountIdCr" , "accountIdDr"};
	private static final String[] ControlColumns  = {"ccyCr" ,"ccyDr" , "transactionAmount"};
	private static final int[] insertLocation = {122 , 369 , 426};
	private static final String csvFilePath = Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV;

	private static final String basequery = "SELECT  "
			+ "    ( SELECT FORACID FROM TBAADM.GAM G  "
			+ "      JOIN tbaadm.SMT B on G.ACID = B.ACID "
			+ "      where ACCT_CRNCY_CODE = '' "
			+ "      AND ACCT_STATUS = 'A' "
			+ "      AND ROWNUM <= 100 "
			+ "      ORDER BY DBMS_RANDOM.value "
			+ "      FETCH FIRST 1 ROWS ONLY "
			+ "    ) AS CR , "
			+ "    ( SELECT FORACID FROM TBAADM.GAM G "
			+ "      JOIN tbaadm.SMT B on G.ACID = B.ACID "
			+ "      where ACCT_CRNCY_CODE = '' "
			+ "      AND ACCT_STATUS = 'A' "
			+ "      AND clr_bal_amt > "
			+ "      AND ROWNUM <= 100 "
			+ "      ORDER BY DBMS_RANDOM.value "
			+ "      FETCH FIRST 1 ROWS ONLY "
			+ "    ) AS DR "
			+ "    FROM TBAADM.GAM G "
			+ "    FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns ,insertLocation, basequery );
	}
	
}
