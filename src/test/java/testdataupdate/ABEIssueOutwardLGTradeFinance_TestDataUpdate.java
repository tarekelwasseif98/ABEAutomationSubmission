package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEIssueOutwardLGTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "bankAccountReference"};
	private static final String[] ControlColumns  = {"currency" , "guaranteeAmount"};
	
	private static final String csvFilePath = Paths.ABEISSUEOUTWARDLGTRADEFINANCECSV;
	
	private static final String basequery = "SELECT  A.CIF_ID , A.FORACID  "
			+ "FROM TBAADM.GAM A "
			+ "    JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "where A.ACCT_CRNCY_CODE = '{0}' "
			+ "    AND S.ACCT_STATUS = 'A' "
			+ "    AND A.SCHM_TYPE in ( 'CAA' , 'SBA') "
			+ "    AND A.clr_bal_amt > {1} "
			+ "    AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C  "
			+ "                WHERE C.ORGKEY = A.CIF_ID "
			+ "                AND C.KYC_STATUS = 'A' "
			+ "                AND C.RECORDSTATUS = 'A' "
			+ "                AND C.TFPARTYFLAG = 'Y') "
			+ "                 "
			+ "    AND NOT EXISTS ( SELECT 1 FROM TBAADM.GAM A2 "
			+ "                    JOIN tbaadm.SMT S2 on A2.ACID = S2.ACID "
			+ "                    WHERE A2.CIF_ID = A.CIF_ID "
			+ "                     AND S2.ACCT_STATUS = 'D') "
			+ "    AND ROWNUM <= 50 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
