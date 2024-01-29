package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABELodgeExportBillsTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cifId" , "documentaryCreditNo" , "operativeAccountId"};
	private static final String[] ControlColumns  = {"billCcy" , "billAmount" };
	
	private static final String csvFilePath = Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV;
	
	private static final String basequery = "WITH LCRecord(DC_REF_NUM) "
										+ "AS  (SELECT DC_REF_NUM from TBAADM.DCMM LC  "
										+ "    where LC.ENTITY_CRE_FLG = 'Y'  "
										+ "    AND LC.SOL_ID = '1401' "
										+ "    AND LC.ACTL_CRNCY_CODE = '{0}' "
										+ "    AND LC.OPEN_VALUE - LC.BILL_LODG_AMT > {1} "
										+ "    AND LC.OPEN_ENDED_DC_FLG = 'N' "
										+ "    AND LC.DEFERRED_FLG = 'N' "
										+ "	   AND LC.EXPIRY_DATE > CURRENT_DATE "
										+ "	   AND lc.UPFT_REINST_LIAB_REVL_DC != 'N' AND lc.reinst_usance_tenor != 'R'"
										+ "    AND LC.DC_REG_TYPE IN ('LEXLC' , 'FEXLC') "
										+ "    AND ROWNUM <= 100 "
										+ "    ORDER BY DBMS_RANDOM.value "
										+ "    FETCH FIRST 1 ROWS ONLY ) "
										+ "SELECT A.CIF_ID ,(SELECT DC_REF_NUM FROM LCRecord) AS LC , A.FORACID  "
										+ "FROM TBAADM.GAM A "
										+ "WHERE A.ACCT_CRNCY_CODE = '{0}' "
										+ "AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
										+ "AND A.clr_bal_amt > 7000  "
										+ "AND EXISTS(SELECT 1 FROM TBAADM.SMT S WHERE S.ACID=A.ACID AND S.ACCT_STATUS = 'A') "
										+ "AND EXISTS(SELECT 1 FROM CRMUSER.ACCOUNTS C where C.ORGKEY = A.CIF_ID AND C.TFPARTYFLAG ='Y') "
										+ "AND ROWNUM <= 50 "
										+ "ORDER BY DBMS_RANDOM.value "
										+ "FETCH FIRST 1 ROWS ONLY ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
