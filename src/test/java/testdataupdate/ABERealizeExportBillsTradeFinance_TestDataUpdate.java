package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABERealizeExportBillsTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"realizationAccountId" , "mixedBill1RealizationAccountId" , "mixedBill2RealizationAccountId"};
	
	private static final String[] ControlColumns  = {"ccy" };
	
	private static final String csvFilePath = Paths.ABEREALIZEEXPORTBILLSTRADEFINANCECSV;
	
	private static final String basequery = "SELECT A.FORACID , A.FORACID , A.FORACID  "
											+ "From tbaadm.gam A "
											+ "where A.SCHM_CODE = 'NSTRO' "
											+ "AND A.ENTITY_CRE_FLG = 'Y' "
											+ "AND A.ACCT_CRNCY_CODE = '{0}' "
											+ "AND A.DEL_FLG = 'N' "
											+ "AND A.CLR_BAL_AMT < 0 "
											+ "AND EXISTS (select 1 from tbaadm.namt N where A.BACID = N.MIRROR_ACCT_BACID) "
											+ "AND ROWNUM <= 55  "
											+ "ORDER BY DBMS_RANDOM.value  "
											+ "FETCH FIRST 1 ROWS ONLY ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
