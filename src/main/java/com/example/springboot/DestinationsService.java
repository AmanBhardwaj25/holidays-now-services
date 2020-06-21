package com.example.springboot;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




import org.springframework.stereotype.Service;



@Service
public class DestinationsService {
/*	
	Destination dallas = new Destination("1","Dallas","Texas");
	
	
	Destination irving = new Destination("2","Irving","Texas");
	
	Destination newyork = new Destination("3","New York","New York");
	
	
		
	
	
	public ArrayList<Destination> getDestinations(){
		
		ArrayList<Destination> destarray = new ArrayList<Destination>();
		destarray.add(dallas);
		destarray.add(irving);
		destarray.add(newyork);
		
		return destarray;
	}
	
*/
	public ArrayList<Destination> getDestinations(){
		
		ArrayList<Destination> destarray = new ArrayList<Destination>();
	
	Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Aman Bhardwaj/Documents/Full Stack Projects/DB/DBs/holidays.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

     
      
     
      
      ResultSet rs = statement.executeQuery("select * from DESTINATIONS WHERE ID = 100");
      
      Destination newyork = new Destination(rs.getString("ID"),rs.getString("COUNTRY"),rs.getString("CITY"),rs.getString("STATE"));
      
      destarray.add(newyork);
      
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("CITY"));
        System.out.println("id = " + rs.getInt("ID"));
      }
      
      
     
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
	return destarray;
    
    
}
	
}