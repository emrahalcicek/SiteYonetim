
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {


  public static Connection getConnection() throws SQLException{
		Connection connection = null;
		String connectionURL = "jdbc:oracle:thin:localhost:port:dbName";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "dbusername", "password");
                        
                        System.out.println("Ok!");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return connection;
	}
}
