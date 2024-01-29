package testdataupdate;

import database.Updater;
import utils.Paths;
import utils.Properties;

public class ABECreateCDLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "debitAcId"};
	private static final String[] ControlColumns  = {"cifType" ,"schemeCode", "ccy" , "initialDepositAmmount"};
	
	private static final String csvFilePath = Paths.ABECREATECDLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT A.CIF_ID , {1} FORACID  FROM tbaadm.GAM A "
										+ "    JOIN tbaadm.SMT S ON S.ACID = A.ACID "
										+ "	   LEFT JOIN tbaadm.SMT L_S ON L_S.ACID = A.ACID AND L_S.ACCT_STATUS = 'D' "
										+ "    WHERE S.ACCT_STATUS = 'A' "
										+ "	   AND L_S.ACID is null"
										+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA' , 'ODA') "
										+ "    AND A.ACCT_CRNCY_CODE = '{2}' "
										+ "    AND A.ACCT_CLS_FLG = 'N' "
										+ "    AND A.clr_bal_amt > {3} "
										+ "	   AND (select count(B.FORACID) from tbaadm.gam B where B.cif_id=A.cif_id and B.schm_code IN ('1167', '1168')) <= 0 "
									//	+ "	   AND NOT EXISTS (SELECT 1 FROM TBAADM.GAM B WHERE B.CIF_ID=A.CIF_ID AND SCHM_CODE = '1168') "
										+ "	   AND EXISTS (select 1 from CRMUSER.ENTITYDOCUMENT D where D.ORGKEY = A.CIF_ID AND DOCEXPIRYDATE > Current_Date) "
										+ "    AND EXISTS  "
										+ "    ( "
										+ "        SELECT 1 "
										+ "        FROM CRMUSER.ACCOUNTS C  " 
										+ "        WHERE C.ORGKEY = A.CIF_ID "
										+ "        AND C.KYC_STATUS = 'A' "
										+ "		   AND {0} "
										+ "        AND CURRENT_DATE - C.CUST_DOB between "+ Properties.MinorMaximumAge+" AND "+Properties.AdultMaximumAge+" "
										+ "    ) "
										+ "    AND ROWNUM <= 20 "
										+ "    ORDER BY DBMS_RANDOM.value "
										+ "    FETCH FIRST 1 ROWS ONLY";
	

	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns  ,  basequery );
	}
	
}
