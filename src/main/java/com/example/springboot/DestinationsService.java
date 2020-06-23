package com.example.springboot;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

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
		
		String dns = "jdbc:mysql://holidays.cvwtgrabutha.us-east-2.rds.amazonaws.com:3306/holidays?useSSL=FALSE";
		
	
	Connection connection = null;
    try
    {
      // create a database connection
	      connection = DriverManager.getConnection(dns,"root","ohnothe5oh");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

     
      
     
      
      ResultSet rs = statement.executeQuery("SELECT * from DESTINATIONS WHERE ID = 100");
      
      rs.next();
      
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
	
	public ArrayList<Destination> getDestinationByID(int i) throws FileNotFoundException{
		
		

		
		ArrayList<Destination> destarray = new ArrayList<Destination>();
		
		
		FileReader reader = new FileReader("src/main/resources/cred.properties");  
	      
	    Properties auth =new Properties();  
	    try {
			auth.load(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		
		String dns = auth.getProperty("dns");
		
		String user = auth.getProperty("username");
		
		String pass = auth.getProperty("password");
		
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
	      
	      
	      System.out.println("String 1: " + rs.getString(1)+ " String 2: " + rs.getString(2));
	      
	      destarray.add(dest);
	/*      
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("CITY"));
	        System.out.println("id = " + rs.getInt("ID"));
	      } */
	      
	      
	     
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