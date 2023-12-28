package database;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class QueryConstructor {

	public static String create(String csvFilePath , CSVRecord csvRecord ,String[] ControlColumns , String basequery) throws Exception
	{
		//query construction for each TC
		String CCY = null;
    	String Amount = null;
    	
    	BufferedReader fileReader = new BufferedReader(new FileReader(csvFilePath));
	    CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());
	    
	    String query = basequery;
	    
    	for( int i = 0 ; i < ControlColumns.length ; i++ )
    	{
    		switch(ControlColumns[i])
    		{
        		case "CCY" :
        		{
        			CCY = csvRecord.get( ControlColumns[0]);
        			query = query.concat("AND ACCT_CRNCY_CODE = '"+ CCY +"' ");
        			
        		}break;
        		case "Amount" :
        		{
        			Amount = csvRecord.get( ControlColumns[i] ).substring(1);
		            query = query.concat("AND clr_bal_amt > "+ Amount);
        		}break;
        		default:throw new Exception("[db Info] : Invalid Column Name ");	
    		}
    	}
	    csvParser.close();
		return query;
	}
}
