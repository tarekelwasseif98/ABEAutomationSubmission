package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEAdviseInwardLCTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cifBen" , "cifApplicant"};
	private static final String[] ControlColumns  = {"ccySearch" , "documentaryCreditAmount"};
	
	private static final String csvFilePath = Paths.ABEADVISEINWARDLCCSV;
	
	private static final String basequery = "SELECT  "
			+ "    ( SELECT CIF_ID FROM TBAADM.GAM A  "
			+ "      JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "      where A.ACCT_CRNCY_CODE = '{0}' "
			+ "      AND S.ACCT_STATUS = 'A' "
			+ "      AND A.clr_bal_amt > {1} "
			+ "      AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C  "
			+ "                    WHERE C.ORGKEY = A.CIF_ID "
			+ "                    AND C.SEGMENTATION_CLASS = 'CO') "
			+ "      AND ROWNUM <= 50 "
			+ "      ORDER BY DBMS_RANDOM.value "
			+ "      FETCH FIRST 1 ROWS ONLY "
			+ "    ) AS cifApplicant , "
			+ "    ( SELECT CIF_ID FROM TBAADM.GAM A "
			+ "      JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "      where A.ACCT_CRNCY_CODE = '{0}' "
			+ "      AND S.ACCT_STATUS = 'A' "
			+ "      AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C  "
			+ "                    WHERE C.ORGKEY = A.CIF_ID "
			+ "                    AND C.SEGMENTATION_CLASS = 'CO') "
			+ "      AND ROWNUM <= 50 "
			+ "      ORDER BY DBMS_RANDOM.value "
			+ "      FETCH FIRST 1 ROWS ONLY "
			+ "    ) AS cifBen "
			+ "    FROM TBAADM.GAM A "
			+ "    FETCH FIRST 1 ROWS ONLY ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
