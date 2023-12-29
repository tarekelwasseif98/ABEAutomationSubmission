package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateTdLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "debitAcId"};
	private static final String[] ControlColumns  = {"ccy" , "initialDepositAmmount"};
	private static final int[] insertLocation = {186,216};
	
	private static final String csvFilePath = Paths.ABECREATETDLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT A.CIF_ID , A.FORACID FROM tbaadm.GAM A "
			+ "    JOIN tbaadm.SMT S ON S.ACID = A.ACID "
			+ "    WHERE S.ACCT_STATUS = 'A' "
			+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
			+ "    AND A.ACCT_CRNCY_CODE = '' "
			+ "    AND A.clr_bal_amt > "
			+ "    AND EXISTS  "
			+ "    ( "
			+ "        SELECT 1 "
			+ "        FROM CRMUSER.ACCOUNTS C  "
			+ "        WHERE A.CIF_ID = C.ORGKEY "
			+ "        AND CURRENT_DATE - C.CUST_DOB > 7665 "
			+ "        AND C.KYC_STATUS = 'A' "
			+ "    ) "
			+ "    AND ROWNUM <= 20 "
			+ "    ORDER BY DBMS_RANDOM.value "
			+ "    FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns ,insertLocation ,  basequery );
	}
	
}
