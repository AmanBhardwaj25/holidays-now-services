package com.example.springboot;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;





@Service
public class DestinationsService {
	
	
	@Value("${dns}")
	String dns;
	
	@Value("${user}")
	String user;
	
	@Value("${password}")
	String pass;
	
	
	
	public ArrayList<Destination> getDestinations() throws IOException{
		
		ArrayList<Destination> destarray = new ArrayList<Destination>();
		
	
		Connection connection = null;
    try
    {
    	
    	
    	
    	
    	
    	System.out.println("Values for creds: " + dns + user + pass);
      // create a database connection
	      connection = DriverManager.getConnection(dns,user,pass);
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

     
      
     
      
      ResultSet rs = statement.executeQuery("SELECT * from DESTINATIONS");
      
      while (  rs.next()) {
      
     Destination dest = new Destination(rs.getString("ID"),rs.getString("COUNTRY"),rs.getString("CITY"),rs.getString("STATE"));
    	  
    	//  Destination dest = new Destination(rs.getString("COUNTRY"),rs.getString("CITY"),rs.getString("STATE"));
      
      destarray.add(dest);
      
     
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
	
	public ArrayList<Destination> getDestinationByID(int i) throws IOException{
		
		

		
		ArrayList<Destination> destarray = new ArrayList<Destination>();
		
		
		
	
		
		Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection(dns,user,pass);
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	     
	      
	     System.out.println("Connection Successful to DB: " + connection.getCatalog());
	      
	      ResultSet rs = statement.executeQuery("select * from DESTINATIONS WHERE ID = " + i);
	      
	      rs.next();
	      
	   Destination dest = new Destination(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
	      
	   //   Destination dest = new Destination(rs.getString("COUNTRY"),rs.getString("CITY"),rs.getString("STATE"));
	      
	      
	      System.out.println("String 1: " + rs.getString(1)+ " String 2: " + rs.getString(2));
	      
	      destarray.add(dest);
	
	      
	     
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