package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABELodgeExportBillsTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cifId" , "documentaryCreditNo" , "operativeAccountId"};
	private static final String[] ControlColumns  = {"billCcy" , "billAmount" };
	
	private static final String csvFilePath = Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV;
	
	private static final String basequery = "WITH LCRecord(DC_REF_NUM) "
										+ "AS  (select DC_REF_NUM from TBAADM.DCMM LC  "
										+ "    where LC.ENTITY_CRE_FLG = 'Y'  "
										+ "    AND LC.SOL_ID = '1401' "
										+ "    AND LC.ACTL_CRNCY_CODE = '{0}' "
										+ "    AND LC.CURRENT_VALUE >= {1} "
										+ "    AND LC.DC_REG_TYPE IN ('LEXLC' , 'FEXLC') "
										+ "    AND ROWNUM <= 100 "
										+ "    ORDER BY DBMS_RANDOM.value "
										+ "    FETCH FIRST 1 ROWS ONLY ) "
										+ "select A.CIF_ID ,(select DC_REF_NUM from LCRecord) AS LC ,A.FORACID  "
										+ "from tbaadm.gam A "
										+ "where A.ACCT_CRNCY_CODE = '{0}' "
										+ "AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
										+ "AND A.clr_bal_amt > 5000  "
										+ "AND EXISTS(SELECT 1 FROM TBAADM.SMT S WHERE S.ACID=A.ACID AND S.ACCT_STATUS = 'A') "
										+ "AND EXISTS(SELECT 1 FROM CRMUSER.ACCOUNTS C where C.ORGKEY = A.CIF_ID AND C.TFPARTYFLAG ='Y') "
										+ "AND ROWNUM <= 50 "
										+ "ORDER BY DBMS_RANDOM.value "
										+ "FETCH FIRST 1 ROWS ONLY ";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
