package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEOpenCorporateLoanCorporateLoans_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"cif" , "operativeAccountId" , "limitIdPrefix" , "limitIdSuffix"};
	private static final String[] ControlColumns  = {"loanAmount" , "accountOpeningDate" , "expiryDate"};
	
	private static final String csvFilePath = Paths.ABEOPENCORPORATELOANCORPORATELOANSCSV;
	
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
			+ "select A.CIF_ID , A.FORACID ,(select LIMIT_PREFIX FROM LimitID)AS Prefix , (SELECT LIMIT_SUFFIX FROM LimitID) AS Suffix "
			+ "FROM TBAADM.GAM A   "
			+ "JOIN tbaadm.SMT S on A.ACID = S.ACID "
			+ "where A.SCHM_TYPE in ('CAA' , 'SBA') "
			+ "    AND A.ACCT_CRNCY_CODE = 'EGP' "
			+ "    AND A.clr_bal_amt > 20000 "
			+ "    AND S.ACCT_STATUS = 'A' "
			+ "    AND EXISTS ( SELECT 1 FROM CRMUSER.ACCOUNTS C WHERE C.ORGKEY = A.CIF_ID AND C.KYC_STATUS = 'A' AND C.SEGMENTATION_CLASS = 'CO') "
			+ "    AND EXISTS (select 1 from Crmuser.ENTITYDOCUMENT D where D.ORGKEY = A.CIF_ID AND DOCEXPIRYDATE > Current_Date) "
			+ "    AND EXISTS (select 1 from crmuser.AMLKYC K where K.orgkey = A.CIF_ID AND KYC_RECERTDATE > Current_Date) "
			+ "    AND ROWNUM <= 50 "
			+ "ORDER BY DBMS_RANDOM.value "
			+ "FETCH FIRST 1 ROWS ONLY";
	
	public static void Update() throws Exception {
		Updater.update( csvFilePath , UpdatedColumns , ControlColumns , basequery );
	}
	
}
