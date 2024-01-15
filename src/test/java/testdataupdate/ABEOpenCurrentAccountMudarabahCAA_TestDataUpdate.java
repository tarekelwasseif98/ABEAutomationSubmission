package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenCurrentAccountMudarabahCAA_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif"};
	private static final String[] ControlColumns  = {"cifType"};
	
	private static final String csvFilePath = Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV;
	
	private static final String basequery = "SELECT C.ORGKEY "
			+ "FROM CRMUSER.ACCOUNTS C "
			+ "LEFT OUTER JOIN TBAADM.GAM A ON A.CIF_ID = C.ORGKEY "
			+ "LEFT OUTER JOIN tbaadm.SMT S ON S.ACID = A.ACID "
			+ "AND {0} "
			+ "WHERE C.KYC_STATUS = 'A' "
			+ "AND EXISTS (select 1 from Crmuser.ENTITYDOCUMENT D where D.ORGKEY = C.ORGKEY AND DOCEXPIRYDATE > Current_Date) "
			+ "AND EXISTS (select 1 from crmuser.AMLKYC K where K.orgkey = C.orgkey AND KYC_RECERTDATE > Current_Date) "
			+ "AND A.CIF_ID IS NULL "
			+ "AND S.ACCT_STATUS IS NULL "
			+ "AND ROWNUM <= 50 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only";

	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
