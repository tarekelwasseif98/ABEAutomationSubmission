package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import utils.CSVUtils;

public class Updater {

	
	public static void update(String csvFilePath , String[] UpdatedColumns , String[] ControlColumns , String basequery) throws Exception
	{
		String Result = null;
    	ResultSet dbResults = null;
    	
		DatabaseConnection dbConnection = new DatabaseConnection(csvFilePath , UpdatedColumns).connect();
	
		BufferedReader fileReader = new BufferedReader(new FileReader(csvFilePath));
	    CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());
    	
    	//clear all data from the columns that will be updated 
	    for(String Column : UpdatedColumns)CSVUtils.clearColumnByName(csvFilePath , Column);
    	
    	//loop over each test case in CSV file 
        for (CSVRecord csvRecord : csvParser) 
        {
        	System.out.println("[db Info] : TC id : "+ csvRecord.get("tcId"));   
        	String query = basequery;
        	
        	boolean ErrorFlag = false;
        
            for(int i = 0 ; i < ControlColumns.length ; i++)
            {
            	String CsvColumnValue = null;
            	try{CsvColumnValue = csvRecord.get( ControlColumns[i]);}
            	catch (Exception IllegalArgumentException) {}
            	
        		if( CsvColumnValue == null || CsvColumnValue == "" || CsvColumnValue == "\'" )
        		{
	        		System.err.println("[db Error] : value in "+ ControlColumns[i] +" column is missing or invalid ");
	        		ErrorFlag = true;
	        		continue;
        		}
            
            	if( CsvColumnValue.startsWith("'") || CsvColumnValue.startsWith("\""))
    			{
            		query = query.replace("{"+i+"}", CsvColumnValue.substring(1) );
      			}
        		else 
        		{
        			query = query.replace("{"+i+"}", CsvColumnValue );
        		}
            }
            
            if(ErrorFlag)
            {
            	ErrorFlag=false;
            	continue;
            }
            
        	//System.out.println("[debug] :"+ query);
            	
	    	// open db connection and run query 
			try{dbResults = dbConnection.runQuery(query).getResults();}
			catch(Exception e)
			{
				System.err.println("[db Error] : Invalid Query");
				System.err.println(e);
				continue;
			}
			
			//move ResultSet iterator to point to first record in query results 
			dbResults.next();
			
			//Loop over results columns  . this loops should be over rows and columns but since we only pull only one record each time we font neet the nested for loops
	        for(int i = 0 ; i < UpdatedColumns.length ; i++)
	        {
	            int colIndexInCSV = CSVUtils.getColumnByColumnName(csvFilePath, UpdatedColumns[i]);
	            int rowIndexInCSV = (int) csvRecord.getRecordNumber();
	
	            try {
	                Result = dbResults.getString(i+1);
	                CSVUtils.insertValueInCsvCell(csvFilePath, rowIndexInCSV , colIndexInCSV , Result);
	            }
	            catch (Exception e) {
	            	System.err.println("[db ERROR] : NO available record the meet the criteria on the database");
	            	System.err.println(e);
	            	continue;
	            }
	        }
	            System.out.println("[db Info] : update testdata : done");
        }
        csvParser.close();
        dbConnection.disconnect();
	}
}

