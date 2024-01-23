package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateCDLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "debitAcId"};
	private static final String[] ControlColumns  = {"cifType" , "ccy" , "initialDepositAmmount"};
	
	private static final String csvFilePath = Paths.ABECREATECDLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT A.CIF_ID , A.FORACID FROM tbaadm.GAM A "
			+ "    JOIN tbaadm.SMT S ON S.ACID = A.ACID "
			+ "    WHERE S.ACCT_STATUS = 'A' "
			+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
			+ "    AND A.ACCT_CRNCY_CODE = '{1}' "
			+ "    AND A.ACCT_CLS_FLG = 'N' "
			+ "    AND A.clr_bal_amt > {2} "
			+ "    AND EXISTS  "
			+ "    ( "
			+ "        SELECT 1 "
			+ "        FROM CRMUSER.ACCOUNTS C  "
			+ "        WHERE C.ORGKEY = A.CIF_ID "
			+ "        AND C.KYC_STATUS = 'A' "
			+ "		   AND EXISTS (select 1 from Crmuser.ENTITYDOCUMENT D where D.ORGKEY = C.ORGKEY AND DOCEXPIRYDATE > Current_Date) "
			+ "		   AND {0} "
			+ "        AND CURRENT_DATE - C.CUST_DOB between 7665 AND 20075 "
			+ "    ) "
			+ "    AND ROWNUM <= 20 "
			+ "    ORDER BY DBMS_RANDOM.value "
			+ "    FETCH FIRST 1 ROWS ONLY";
	

	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns  ,  basequery );
	}
	
}
