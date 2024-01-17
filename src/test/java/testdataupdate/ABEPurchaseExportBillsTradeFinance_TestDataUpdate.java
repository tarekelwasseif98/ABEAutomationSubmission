package testdataupdate;

import database.Updater;
import utils.Paths;

public class ABEPurchaseExportBillsTradeFinance_TestDataUpdate {

	//columns names in the CSV that need to be updated . must be in the same order of the CSV file  
	
	private static final String[] UpdatedColumns  = {"limitIdPrefix" , "limitIdSuffix" , 
													 "mixedBill1LimitIdPrefix" , "mixedBill1LimitIdSuffix",
													 "mixedBill2LimitIdPrefix" , "mixedBill2LimitIdSuffix",
													 "billPurchaseAccountId" , "mixedBill1PurchaseAccountId" , "mixedBill2PurchaseAccountId",				 	
	};
	
	private static final String[] ControlColumns  = {"ccy" , "billPurchaseAmount" , "valueDate"};
	
	private static final String csvFilePath = Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCECSV;
	
	private static final String basequery = "WITH LimitID (LIMIT_PREFIX , LIMIT_SUFFIX) AS  "
			+ "( SELECT L.LIMIT_PREFIX , L.LIMIT_SUFFIX from TBAADM.LLT L "
			+ "    Where L.ENTITY_CRE_FLG = 'Y' "
			+ "    AND L.CRNCY_CODE  = '{0}' "
			+ "	   AND L.GLOBAL_LIMIT_FLG = 'N' "
			+ "    AND L.LIM_EFF_DATE < TO_DATE( '{2}', 'DD-MM-YYYY') "
			+ "    AND L.LIM_SANCT_DATE < TO_DATE('01-01-2099' , 'DD-MM-YYYY') "
			+ "    AND L.SANCT_LIM - (L.CONTINGENT_LIAB+L.LIAB) > {1} "
			+ "    AND ROWNUM <= 50 "
			+ "    ORDER BY DBMS_RANDOM.value "
			+ "    FETCH FIRST 1 ROWS ONLY  ) "
			+ "SELECT  "
			+ "(select LIMIT_PREFIX FROM LimitID)AS Prefix1 , (SELECT LIMIT_SUFFIX FROM LimitID) AS Suffix1, "
			+ "(select LIMIT_PREFIX FROM LimitID)AS Prefix2 , (SELECT LIMIT_SUFFIX FROM LimitID) AS Suffix2, "
			+ "(select LIMIT_PREFIX FROM LimitID)AS Prefix3 , (SELECT LIMIT_SUFFIX FROM LimitID) AS Suffix3, "
			+ "A.FORACID , A.FORACID , A.FORACID "
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
