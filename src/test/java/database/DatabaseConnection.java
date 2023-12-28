package database;

import utils.CSVUtils;
import utils.Properties;

import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {
	private String url = Properties.DBPATH;
    //private String schema = Properties.DBSCHEMA;
    private String username = Properties.DBUSER;
    private String password = Properties.DBPASSWORD;
    
    private String[] CSVColumnsToBeUpdated;
    private String CsvToBeUpdatedPath;
    private String Query = null;
    
    private Connection connection;
    private PreparedStatement Statement;
    private ResultSet Results;

    public DatabaseConnection(String CsvToBeUpdatedPath,String [] CSVColumnsToBeUpdated,String Query)
    {
    	this.CsvToBeUpdatedPath = CsvToBeUpdatedPath;
    	this.CSVColumnsToBeUpdated = CSVColumnsToBeUpdated;
    	this.Query = Query;
    	
    }
    public DatabaseConnection(String CsvToBeUpdatedPath,String [] CSVColumnsToBeUpdated)
    {
    	this.CsvToBeUpdatedPath = CsvToBeUpdatedPath;
    	this.CSVColumnsToBeUpdated = CSVColumnsToBeUpdated;
    }
    
    public DatabaseConnection connect() throws SQLException {
    	connection = DriverManager.getConnection(url,username, password);
    	System.out.println("[db Info] : conncetion stablished to "+url);
    	return this;
    }
    
    public void disconnect() throws SQLException {
       connection.close();
       System.out.println("[db Info] : conncetion closed "+url);
    }
    
    public DatabaseConnection runQuery() throws Exception {
    	
    	if(Query != null )
    	{
	    	System.out.println("[db Info] : Running query");
	    	Statement = connection.prepareStatement(Query);
	    	Results = Statement.executeQuery();
	        return this;
    	}
    	else
    	{
    		throw new Exception("Qeury is empty");
    		
    	}
     }
    
	 public DatabaseConnection runQuery(String Query) throws SQLException {
	    	
		 this.Query = Query;
    	System.out.println("[db Info] : Running query");
    	Statement = connection.prepareStatement(Query);
    	Results = Statement.executeQuery();
        return this;
     }

	public ResultSet getResults() {
		return Results;
	}
	
	public void SaveToCSV() throws Exception {
		ResultSetMetaData ResultSetMetaData = Results.getMetaData();
		int columnCount = ResultSetMetaData.getColumnCount();
		
        List<String> columnNames = new ArrayList<>();
        
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(ResultSetMetaData.getColumnName(i));
        }
        
        FileWriter fileWriter = new FileWriter(CsvToBeUpdatedPath);
        boolean firstRow = true;
        
        while (Results.next()) 
        {
        	//the flag Will be true only during the first iteration to set the columns names 
            if (firstRow) 
            {
            	for(String columnName : columnNames) 
	            {
	                fileWriter.append(columnName);
	                fileWriter.append(" ,");
	            }
	            fileWriter.append("\n");
	            firstRow = false;
            }
            else
            {
	            for (int i = 1; i <= columnCount; i++) 
	            {
	                fileWriter.append(Results.getString(i));
	                
	                //This condition to stop the code from adding (,) at the end of the row 
	                if (i < columnCount) 
	                {
	                    fileWriter.append(" ,");
	                }
	            } //end for loop
	            
	            fileWriter.append("\n");
	            
            } //end of else 
            
        } //end of while loop
        
        fileWriter.flush();
        fileWriter.close();      
	} //end of method
	
	public DatabaseConnection UpdateCSV() throws Exception {
		int columnCount = Results.getMetaData().getColumnCount();
		int rowscount = 0;
    	for(String column : CSVColumnsToBeUpdated)CSVUtils.clearColumnByName(CsvToBeUpdatedPath , column);
        while (Results.next()) 
        {
	        for (int i = 1; i <= columnCount; i++) 
	        {
	            CSVUtils.insertValueInCsvCell(CsvToBeUpdatedPath , 
	            								Results.getRow() , 
	            								CSVUtils.getColumnByColumnName(CsvToBeUpdatedPath,CSVColumnsToBeUpdated[i-1]) , 
	            								Results.getString(i)
	            								);
	            
	        } //end for loop
	        rowscount++;
        } //end of while loop
        System.out.println("[db Info] : "+rowscount+" added to csv file : "+CsvToBeUpdatedPath);

		return this;
	} //end of method
} // end of class