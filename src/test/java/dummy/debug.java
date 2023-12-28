package dummy;

import org.apache.commons.lang3.time.StopWatch;
import testdataupdate.*;


public class debug {
    public static void main(String[] args) throws Exception {
    	
    	StopWatch stopwatch = new StopWatch();
    	stopwatch.start();
    	//ABEOpenCurrentAccountMudarabahCAA_TestDataUpdate.Update();
    	ABEOpenRetailLoanRetailLoans_TestDataUpdate.Update();
    	stopwatch.stop();
    	
    	System.out.println(stopwatch.getTime());
    	} //end of main
}// end of class 
