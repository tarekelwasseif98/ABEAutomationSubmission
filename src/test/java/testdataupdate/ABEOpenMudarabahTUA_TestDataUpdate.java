package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenMudarabahTUA_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "profitCreditAccountId" , "repaymentAccountId" , "debitAccountId"};
	private static final String[] ControlColumns  = {"initialDepositAmount" };
	
	private static final String csvFilePath = Paths.ABEOPENMUDARABAHTUACSV;
	
	private static final String basequery = "SELECT  CIF_ID ,  "
			+ "        foracid as profitCreditAccountId , "
			+ "        foracid as repaymentAccountId ,  "
			+ "        foracid as debitAccountId  "
			+ "FROM TBAADM.GAM A "
			+ "    JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "where A.ACCT_CRNCY_CODE = 'EGP' "
			+ "    AND S.ACCT_STATUS = 'A' "
			+ "    AND A.SOL_ID = '2588' "
			+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
			+ "    AND A.clr_bal_amt > {0} "
			+ "	   AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C WHERE C.ORGKEY = A.CIF_ID AND C.KYC_STATUS = 'A') "
			+ "    AND EXISTS (select 1 from CRMUSER.ENTITYDOCUMENT D where D.ORGKEY = A.CIF_ID AND DOCEXPIRYDATE > Current_Date) "
			+ "    AND NOT EXISTS ( SELECT 1 FROM TBAADM.GAM A2 "
			+ "                    JOIN tbaadm.SMT S2 on A2.ACID = S2.ACID "
			+ "                    WHERE A2.CIF_ID = A.CIF_ID "
			+ "                     AND S2.ACCT_STATUS = 'D') "
			+ "    AND ROWNUM <= 50 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
