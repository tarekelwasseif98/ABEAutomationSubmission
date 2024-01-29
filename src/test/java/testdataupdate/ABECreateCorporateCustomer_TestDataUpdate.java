package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABECreateCorporateCustomer_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"relationCIFID" };
	private static final String[] ControlColumns  = {};
	
	private static final String csvFilePath = Paths.ABECREATECORPORATECUSTOMERCSV;
	
	private static final String basequery = "SELECT C.ORGKEY "
			+ "FROM CRMUSER.ACCOUNTS C "
			+ "WHERE CURRENT_DATE - C.CUST_DOB between 7665 AND 21900 "
			+ "AND EXISTS (select 1 from CRMUSER.ENTITYDOCUMENT D where D.ORGKEY = C.ORGKEY AND DOCEXPIRYDATE > Current_Date) "
			+ "AND C.SEGMENTATION_CLASS = 'RETL' "
			+ "AND C.RECORDSTATUS = 'A' "
			+ "AND C.ENTITY_CRE_FLAG = 'Y' "
			+ "AND ROWNUM <= 150  "
			+ "ORDER by DBMS_RANDOM.value "
			+ "FETCH NEXT 1 rows only ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
