package DatabaseActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;

public class ImdbDatabaseConnection {

	private Connection con;
	private static Statement statement;
	private static ResultSet rs;
	
	
	 public void setup()
	 {
		String databaseURL ="jdbc:mysql://localhost:3306/imdb_movies";
	    String user="akshit";
	    String password="libraaksa";
	    con=null;
	
	    try
	    {
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("Connecting to database");
	    	//con=DriverManager.getConnection(databaseURL, user, password);
	    	con=DriverManager.getConnection(databaseURL, user, password);
	    	if(con!=null)
	    	{
	    		  
	    		System.out.println("Connected to the database");
	    	}
	    	
	  	    }catch (SQLException ex){
	    	
	    	ex.printStackTrace();
	    }
	     catch(ClassNotFoundException ex){
	    	ex.printStackTrace();	
	    }	    
	 }
			 
	 public void InsertMovieName(String currentmovietext)
	{
		// String m = currentmovietext.substring(0, currentmovietext.indexOf("(")-1);
		try
		{
		
			//PreparedStatement- used for inserting and updating data into database instead of result set
       PreparedStatement stmt=(PreparedStatement) con.prepareStatement("Insert into app_moviename (movie) values('"+currentmovietext+"')"); 
       int i=stmt.executeUpdate();  
       System.out.println(i+" records inserted");
       		
       }
		catch(SQLException ex)
		{
		ex.printStackTrace();
		}
	}
	
/*	
	public void getmoviedetailsfromdatabase() throws SQLException
	{
		try
		{
		String query="Select * from app_moviename";
		statement=con.createStatement();
		rs=statement.executeQuery(query);
          
		 while(rs.next())
		 {
			 
			 
			 String empname=rs.getString("Name");
			 int empid=rs.getInt("id");
			 System.out.println(empname+"\t"+empid);
			 
			 
		 }
		
	}catch(SQLException ex)
		{
		
		ex.printStackTrace();
		}
*/
	
	public void closedatabase()
	{
		
		if (con != null) 
		{
            try {
                System.out.println("Closing Database Connection...");
                con.close();
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
	}
	}
}

	
