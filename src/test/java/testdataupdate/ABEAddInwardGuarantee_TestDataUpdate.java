package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEAddInwardGuarantee_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "bankAccountReference"};
	private static final String[] ControlColumns  = {"guaranteeAmount" , "currency"};
	
	private static final String csvFilePath = Paths.ABEADDINWARDGUARANTEECSV;
	
	private static final String basequery = "SELECT  A.CIF_ID , A.FORACID  "
			+ "FROM TBAADM.GAM A "
			+ "    JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "where A.ACCT_CRNCY_CODE = '{1}' "
			+ "    AND S.ACCT_STATUS = 'A' "
			+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
			+ "    AND A.clr_bal_amt > {0} "
			+ "    AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C  "
			+ "                WHERE C.ORGKEY = A.CIF_ID "
			+ "                AND C.KYC_STATUS = 'A' "
			+ "                AND C.RECORDSTATUS = 'A' "
			+ "                AND C.TFPARTYFLAG = 'Y') "
			+ "    AND ROWNUM <= 150  "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
