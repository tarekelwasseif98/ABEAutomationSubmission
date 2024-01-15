package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenOverDraftAccount_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "entityId", "entityId1"};
	private static final String[] ControlColumns  = { "currency" , "cifType" , "withdrawal" };
	
	private static final String csvFilePath = Paths.ABEOPENOVERDRAFTACCOUNTCSV;
	
	private static final String basequery = "SELECT  A.CIF_ID , A.FORACID AS col1 , LEAD(A.FORACID) OVER (ORDER BY DBMS_RANDOM.value) AS Col2   "
			+ "FROM TBAADM.GAM A   "
			+ "where A.SCHM_TYPE  = 'TUA'   "
			+ "    AND A.ACCT_CRNCY_CODE = '{0}'   "
			+ "    AND A.clr_bal_amt - A.LIEN_AMT > {2}   "
			+ "    AND NOT EXISTS ( SELECT 1 FROM TBAADM.GAM A2   "
			+ "                        WHERE A2.CIF_ID = A.CIF_ID   "
			+ "                            AND A2.SCHM_TYPE in ( 'TUA' , 'ODA')   "
			+ "                            AND A2.ENTITY_CRE_FLG = 'N')      "
			+ "    AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C    "
			+ "                        WHERE C.ORGKEY = A.CIF_ID   "
			+ "                            AND C.KYC_STATUS = 'A'   "
			+ "                            AND C.RECORDSTATUS = 'A'   "
			+ "                            AND C.SEGMENTATION_CLASS = '{1}')   "
			+ "AND ROWNUM <= 50   "
			+ "ORDER BY DBMS_RANDOM.value   "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
