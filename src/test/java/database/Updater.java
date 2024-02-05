package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import utils.CSVUtils;
import utils.Properties;

public class Updater {
	

	private static final String ANSI_RESET = "\u001B[0m";
	@SuppressWarnings("unused")
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final int 	BufferSize = 1024*10;	
	

	
	public static void update(String csvFilePath , String[] UpdatedColumns , String[] ControlColumns , String basequery) throws Exception
	{
		String Result = null;
    	ResultSet dbResults = null;
    	
		DatabaseConnection dbConnection = new DatabaseConnection(csvFilePath , UpdatedColumns).connect();
	
		BufferedReader fileReader = new BufferedReader(new FileReader(csvFilePath),BufferSize);
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
	        		break;
        		}

            	if( CsvColumnValue.startsWith("'") || CsvColumnValue.startsWith("\""))
    			{
            		CsvColumnValue  = FixKeyWords(ControlColumns[i] , CsvColumnValue.substring(1));
            		
            		query = query.replace("{"+i+"}", CsvColumnValue);
      			}
        		else 
        		{
        			CsvColumnValue  = FixKeyWords(ControlColumns[i] , CsvColumnValue);
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
			
			boolean flag = true;
			//Loop over results columns. these loops should be over rows and columns but since we only pull only one record each time we don't need the nested loops
	        for(int i = 0 ; i < UpdatedColumns.length ; i++)
	        {
	            int colIndexInCSV = CSVUtils.getColumnByColumnName(csvFilePath, UpdatedColumns[i]);
	            int rowIndexInCSV = (int) csvRecord.getRecordNumber();
	
	            try {
	                Result = dbResults.getString(i+1);
	                if(Result == null ) { throw new Exception();}
	                
	                
	                if(flag == true) {System.out.print("[debug] :");flag=false;}
	                System.out.print(" , "+ Result);
	                
	                
	                CSVUtils.insertValueInCsvCell(csvFilePath, rowIndexInCSV , colIndexInCSV , Result);
	            }
	            catch (Exception e) {
	            	System.out.println(ANSI_RED + "[db ERROR] : NO available record the meet the criteria on the database"   + ANSI_RESET);
	            	System.out.println(ANSI_RED + e  + ANSI_RESET);
	            	
	            	break;
	            }
	        }
	            System.out.println("[db Info] : update testdata : done");
        }
        
        csvParser.close();
        fileReader.close();
        dbConnection.disconnect();
	}
	
	
	private static String FixKeyWords(String ColumnName , String str)
	{
		switch(ColumnName.toLowerCase())
		{
		case "ciftype":
			{
				switch(str.toLowerCase())
				{
					case "retail"			:str=" C.SEGMENTATION_CLASS IN ('RETL') AND UNIQUEID  is not null AND (C.STAFFFLAG is null or C.STAFFFLAG != 'Y') ";break;
					case "staff"		    :str=" C.STAFFFLAG = 'Y' AND C.STAFFEMPLOYEEID NOT IN ('1589') ";break;
					case "corporate"		:str=" C.SEGMENTATION_CLASS IN ('CO')  AND UNIQUEID  is null  AND (C.STAFFFLAG is null or C.STAFFFLAG != 'Y') ";break;
					default:{}
				}
			}break;
		case "cifage":
			{
				switch(str.toLowerCase())
				{
					case "minor"		:str=" C.CUSTOMERMINOR = 'Y' ";break;
					case "adult"		:str="CURRENT_DATE - C.CUST_DOB between "+Properties.MinorMaximumAge+" and "+Properties.AdultMaximumAge+" ";break;
					default:{}
				}
			}break;
		case "schemecode":
			{
				switch(str)
				{
					case "1167"			:str=" '"+ Properties.CorpAccountNumberForSchemeAMAN114 +"' AS ";break;
					default:{str="";}
				}
			}break;
			default:{}
			
		}
		return str;
	}
}

