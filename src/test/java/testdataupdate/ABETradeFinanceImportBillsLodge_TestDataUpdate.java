package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABETradeFinanceImportBillsLodge_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cifId" , "documentryCreditNo" , "operativeAccountId"};
	private static final String[] ControlColumns  = {"billCcy" , "billAmt" };
	
	private static final String csvFilePath = Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV;
	
	private static final String basequery = "SELECT A.CIF_ID ,  "
											+ "(SELECT DC.DC_REF_NUM FROM TBAADM.DCMM DC  "
											+ "WHERE DC.ENTITY_CRE_FLG = 'Y' "
											+ "AND DC.DC_REG_TYPE IN ('LIMLC' , 'FIMLC')   "
											+ "AND DC.SOL_ID = '1408'      "
											+ "AND DC.ACTL_CRNCY_CODE = '{0}'      "
											+ "AND DC.OPEN_VALUE - DC.BILL_LODG_AMT > {1}      "
											+ "AND DC.OPEN_ENDED_DC_FLG = 'N'      "
											+ "AND DC.DEFERRED_FLG = 'N' 	    "
											+ "AND DC.EXPIRY_DATE > CURRENT_DATE 	    "
											+ ") AS LC_NUM ,  A.FORACID  "
											+ "FROM TBAADM.GAM A "
											+ "INNER JOIN CRMUSER.ACCOUNTS C ON C.ORGKEY = A.CIF_ID AND C.TFPARTYFLAG = 'Y' "
											+ "LEFT JOIN TBAADM.SMT S ON A.ACID = S.ACID AND S.ACCT_STATUS !='A' "
											+ "WHERE A.SCHM_TYPE in ( 'CAA' , 'SBA' , 'ODA')  "
											+ "AND A.clr_bal_amt > 7000 + {1}   "
											+ "AND ROWNUM <= 50  "
											+ "ORDER BY DBMS_RANDOM.value  "
											+ "FETCH FIRST 1 ROWS ONLY ";
	
	
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
