package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import utils.CSVUtils;

public class Updater {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";

	
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
        			System.out.println(ANSI_RED + "[db Error] : value in "+ ControlColumns[i] +" column is missing or invalid "  + ANSI_RESET);
	        		ErrorFlag = true;
	        		continue;
        		}

            	if( CsvColumnValue.startsWith("'") || CsvColumnValue.startsWith("\""))
    			{
            		CsvColumnValue  = FixKeyWords(CsvColumnValue.substring(1));
            		
            		query = query.replace("{"+i+"}", CsvColumnValue);
      			}
        		else 
        		{
        			CsvColumnValue  = FixKeyWords(CsvColumnValue);
        			query = query.replace("{"+i+"}", CsvColumnValue );
        		}
            }
            
            if(ErrorFlag)
            {
            	ErrorFlag=false;
            	continue;
            }
            
        	System.out.println("[debug] :"+ query);
            	
	    	// open db connection and run query 
			try{dbResults = dbConnection.runQuery(query).getResults();}
			catch(Exception e)
			{
				System.out.println(ANSI_RED + "[db Error] : Invalid Query" + ANSI_RESET);
				System.out.println(ANSI_RED + e  + ANSI_RESET);

				continue;
			}
			
			//move ResultSet iterator to point to first record in query results 
			dbResults.next();
			
			//Loop over results columns. these loops should be over rows and columns but since we only pull only one record each time we don't need the nested loops
	        for(int i = 0 ; i < UpdatedColumns.length ; i++)
	        {
	            int colIndexInCSV = CSVUtils.getColumnByColumnName(csvFilePath, UpdatedColumns[i]);
	            int rowIndexInCSV = (int) csvRecord.getRecordNumber();
	
	            try {
	                Result = dbResults.getString(i+1);
	                CSVUtils.insertValueInCsvCell(csvFilePath, rowIndexInCSV , colIndexInCSV , Result);
	            }
	            catch (Exception e) {
	            	System.out.println(ANSI_RED + "[db ERROR] : NO available record the meet the criteria on the database"   + ANSI_RESET);
	            	System.out.println(ANSI_RED + e  + ANSI_RESET);
	            	
	            	continue;
	            }
	        }
	            System.out.println("[db Info] : update testdata : done");
        }
        csvParser.close();
        dbConnection.disconnect();
	}
	
	
	private static String FixKeyWords(String str)
	{
		switch(str.toLowerCase())
		{
			case "retail"			:str=" C.SEGMENTATION_CLASS = 'RETL' AND (C.STAFFFLAG is null or C.STAFFFLAG != 'Y') ";break;
			case "corporate"		:str=" C.SEGMENTATION_CLASS = 'CO' AND (C.STAFFFLAG is null or C.STAFFFLAG != 'Y') ";break;
			case "staff"		:str=" C.STAFFFLAG = 'Y' AND C.STAFFEMPLOYEEID NOT IN ('1589') ";break;
			case "minor"		:str=" C.CUSTOMERMINOR = 'Y' ";break;
			case "adult"		:str="CURRENT_DATE - C.CUST_DOB between 7665 and 21170 ";break;
			default:{}
		}
		
		return str;
	}
}

