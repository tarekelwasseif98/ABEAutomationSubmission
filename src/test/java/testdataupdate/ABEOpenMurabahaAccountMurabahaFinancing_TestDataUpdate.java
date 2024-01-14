package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenMurabahaAccountMurabahaFinancing_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "debitAccountId" , "operativeAccountId" ,"limitIdPrefix" , "limitIdSuffix"};
	private static final String[] ControlColumns  = {"assetValue" , "accountOpeningDate" , "expiryDate"};
	
	private static final String csvFilePath = Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV;
	
	private static final String basequery = "WITH LimitID (LIMIT_PREFIX , LIMIT_SUFFIX) AS  "
			+ "( select L.LIMIT_PREFIX , L.LIMIT_SUFFIX from TBAADM.LLT L "
			+ "    Where L.ENTITY_CRE_FLG = 'Y' "
			+ "    AND L.CRNCY_CODE  = 'EGP' "
			+ "    AND L.SANCT_LIM - (L.CONTINGENT_LIAB+L.LIAB) > {0} "
			+ "	   AND L.LIM_EFF_DATE   < TO_DATE('{1}', 'DD-MM-YYYY') "
			+ "	   AND L.LIM_SANCT_DATE < TO_DATE('{2}', 'DD-MM-YYYY') "
			+ "    AND ROWNUM <= 50 "
			+ "    ORDER BY DBMS_RANDOM.value "
			+ "    FETCH FIRST 1 ROWS ONLY  ) "
			+ "select A.CIF_ID , A.FORACID , A.FORACID ,(select LIMIT_PREFIX FROM LimitID)AS Prefix , (SELECT LIMIT_SUFFIX FROM LimitID) AS Suffix "
			+ "FROM TBAADM.GAM A   "
			+ "JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "where A.SCHM_TYPE in ('CAA' , 'SBA') "
			+ "    AND A.ACCT_CRNCY_CODE = 'EGP' "
			+ "    AND A.clr_bal_amt > 20000 "
			+ "    AND S.ACCT_STATUS = 'A' "
			+ "    AND A.SOL_ID IN ('2588') "	
			+ "    AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C  "
			+ "                        WHERE C.ORGKEY = A.CIF_ID "
			+ "                            AND C.KYC_STATUS = 'A' "
			+ "                            AND C.RECORDSTATUS = 'A' "
			+ "                            AND C.SEGMENTATION_CLASS = 'CO') "
			+ "							   AND A.SOL_ID IN ('2588') "
			+ "AND ROWNUM <= 50 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
