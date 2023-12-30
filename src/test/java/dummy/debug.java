package dummy;


import org.apache.commons.lang3.time.StopWatch;
import testdataupdate.*;


public class debug {
    public static void main(String[] args) throws Exception {
    	StopWatch stopwatch = new StopWatch();
    	stopwatch.start();
    	//----------------BATCH 1 ----------------------------
    	//ABEDisburseCorporateLoanCorporateLoans_TestDataUpdate.Update();
    	//ABEOpenCurrentAccountMudarabahCAA_TestDataUpdate.Update();
    	//ABEDisburseMurabahaAccountMurabahaFinancing_TestDataUpdate.Update();
    	//ABECloseMudarabahTUA_TestDataUpdate.Update();   								
    	//ABECloseWakalahTUA_TestDataUpdate.Update();									
    	
    	//----------------BATCH 2 ----------------------------
    	//ABEOpenRetailLoanRetailLoans_TestDataUpdate.Update();
    	//ABETellerOperationTransferLiabilitiesAndOperation_TestDataUpdate.Update();			
    	//ABECreateTdLiabilitiesAndOperation_TestDataUpdate.Update();						
    	//ABECreateCASACurrentAccountLiabilitiesAndOperation_TestDataUpdate.Update();
    	//ABECreateCASASavingsAccountLiabilitiesAndOperation_TestDataUpdate.Update();
    	
    	//----------------BATCH 3 ----------------------------
    	//Create_ACH_OutwardCSV_TestDataUpdate.Update();
    	//ABECreateACHUSOutward_TestDataUpdate.Update();
    	//ABECreateACHEROutward_TestDataUpdate.Update();
    	//ABECreateESWIFTOutward_TestDataUpdate.Update();
    	//ABECreateSWIFTOutward_TestDataUpdate.Update();
    	//ABECreateSTO_TestDataUpdate.Update();
    	
    	
    	//----------------BATCH 4 ----------------------------
    
    	
    	
    	stopwatch.stop();
    	System.out.println(stopwatch.getTime());
    	/*
    	String s = "";
    	System.out.println(s);
    	*/
    	
    	} //end of main
}// end of class 
