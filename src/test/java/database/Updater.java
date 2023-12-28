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
        	//construct query
        	String query = QueryConstructor.create(csvFilePath , csvRecord , ControlColumns , basequery);
        	
            
        	System.out.println("[db Info] : TC id : "+ csvRecord.get("tcId"));
        	//System.out.println("[debug] : query);
        	
        	// open db connection and run query 
    		dbResults = dbConnection.runQuery(query).getResults();
    		
    		//move ResultSet iterator to point to first record in query results 
    		dbResults.next();
    		
    		/*Loop over results columns  . this loops should be over rows and columns but since we only pull only one record each time we font neet the nested for loops*/
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
                }
            }
            System.out.println("[db Info] : update testdata : done");
        }
        csvParser.close();
        dbConnection.disconnect();
	}
	
	public static void update(String csvFilePath , String[] UpdatedColumns , String[] ControlColumns , int[] ControlAttributes , String basequery) throws Exception
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
        	String query ;
        	
        	System.out.println("[db Info] : TC id : "+ csvRecord.get("tcId"));
        	
        	if(ControlAttributes[0] == 0) 
        	{
        		query = QueryConstructor.create(csvFilePath , csvRecord , ControlColumns , basequery);
        	}
        	else
        	{
        		query = basequery;
        	}
        	
        	StringBuilder sb = new StringBuilder(query);
        	
        	try {
        		sb.insert(ControlAttributes[0] , csvRecord.get( ControlColumns[0]).substring(1) );
        	}
        	catch (StringIndexOutOfBoundsException e)
        	{
        		System.err.println("[db Error] : "+ ControlColumns[0] +" column is empty ");
        		continue;
        	}
			
			query = sb.toString();
			
        	
        	//System.out.println("[debug] :"+ query);
        	
        	
        	// open db connection and run query 
    		dbResults = dbConnection.runQuery(query).getResults();
    		
    		//move ResultSet iterator to point to first record in query results 
    		dbResults.next();
    		
    		/*Loop over results columns  . this loops should be over rows and columns but since we only pull only one record each time we font neet the nested for loops*/
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
                }
            }
            System.out.println("[db Info] : update testdata : done");
        }
        csvParser.close();
        dbConnection.disconnect();
	}
	
}
