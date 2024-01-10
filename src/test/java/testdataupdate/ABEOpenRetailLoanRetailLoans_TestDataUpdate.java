package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenRetailLoanRetailLoans_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "operativeAccount"};
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABEOPENRETAILLOANRETAILLOANSCSV;
	
	private static final String basequery = "SELECT A.CIF_ID , A.FORACID "
			+ "    FROM TBAADM.GAM A  "
			+ "JOIN tbaadm.SMT S on A.ACID = S.ACID  "
			+ "WHERE A.ACCT_CRNCY_CODE = 'EGP'  "
			+ "    AND S.ACCT_STATUS = 'A'  "
			+ "    AND A.clr_bal_amt > 15000  "
			+ "    AND CURRENT_DATE - A.ACCT_OPN_DATE > 31  "
			+ "    AND EXISTS( SELECT 1 FROM CRMUSER.ACCOUNTS C   "
			+ "                    WHERE C.ORGKEY = A.CIF_ID  "
			+ "                        AND C.KYC_STATUS = 'A'  "
			+ "						   AND C.SEGMENTATION_CLASS = 'RETL' "
			+ "                        AND CURRENT_DATE - C.CUST_DOB between 7665 and 18250)  "
			+ "    AND NOT EXISTS ( SELECT 1 FROM TBAADM.GAM A2 "
			+ "                        WHERE A2.CIF_ID = A.CIF_ID "
			+ "                        AND A2.clr_bal_amt < 0 ) "
			+ "    AND ROWNUM <= 100  "
			+ "    ORDER by DBMS_RANDOM.value  "
			+ "    FETCH NEXT 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
