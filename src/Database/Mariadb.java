package Database;

import java.util.ArrayList;

import SubSystem.Database;

import java.sql.*;

public class Mariadb{

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://128.199.239.13/pttkxdpm";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "gn1C4IrvFiGesuwK";
    
    // gi gi fo
    static Statement stmt = null;
    public static Connection conn = null;
    // connect Db
    public static void connect() throws ClassNotFoundException, SQLException {
    	
       
       //STEP 2: Register JDBC driver
         Class.forName(JDBC_DRIVER);

         //STEP 3: Open a connection
         System.out.println("Connecting to a selected database...");
         conn = DriverManager.getConnection(
        		 DB_URL, USER, PASS);
         System.out.println("Connected database successfully...");
         stmt = conn.createStatement();
    }
	
    public ResultSet query(String sql, ArrayList list) {
    	ResultSet res = null;
		try {
			// prepare for sql query
		    PreparedStatement preStatement = conn.prepareStatement(sql);
		    Object[] arr = list.toArray();
		    // add argument
		    for (int i = 0; i < arr.length; i++) {
		    	System.out.println("Arr:" + arr[i]);
		    	if (arr[i] instanceof Integer) {
		    	   	System.out.println("Int :" + arr[i]);
		    		preStatement.setInt(i+1, (int) arr[i]);
		        }
		        else if (arr[i] instanceof String) {
		        	System.out.println("String :" + arr[i]);
		        	preStatement.setString(i+1, (String) arr[i]);
		        }
	        }
	
			res = preStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return res;
    }
}
