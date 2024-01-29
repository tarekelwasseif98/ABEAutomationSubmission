package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateCASASavingsAccountLiabilitiesAndOperation_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {"cifType", "cifAge"};
	

	private static final String csvFilePath = Paths.ABECREATECASASAVINGSACCOUNTLIABILITIESANDOPERATIONCSV;
	
	private static final String basequery = "SELECT C.ORGKEY "
											+ "FROM CRMUSER.ACCOUNTS C "
											+ "JOIN CRMUSER.ENTITYDOCUMENT D ON D.ORGKEY = C.ORGKEY AND D.DOCEXPIRYDATE > CURRENT_DATE "
											+ "LEFT JOIN tbaadm.gam A ON A.cif_id = C.ORGKEY "
											+ "LEFT JOIN tbaadm.smt S ON S.ACID = A.ACID AND S.ACCT_STATUS = 'D' "
											+ "WHERE  "
											+ "    C.ENTITY_CRE_FLAG = 'Y' "
											+ "    AND EXISTS (select 1 from CRMUSER.ENTITYDOCUMENT D where D.ORGKEY = A.CIF_ID AND DOCEXPIRYDATE > Current_Date) "
											+ "    AND {0}"
											+ "	   AND {1}"
											+ "    AND S.ACID IS NULL "
											+ "    AND ROWNUM <= 200 "
											+ "ORDER BY DBMS_RANDOM.value "
											+ "FETCH FIRST 1 ROWS ONLY";
	
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
