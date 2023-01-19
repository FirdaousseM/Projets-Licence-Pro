package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

	private static Connection connection = null;
	
	private static String DB_ADDRESS = "localhost:3306/bookommerce_db";  
	private static String DB_LOGIN = "admin";
	private static String DB_PASSWORD = "Administration.0";
	
	public static Connection initConnection() throws ClassNotFoundException, SQLException{

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + DB_ADDRESS, DB_LOGIN, DB_PASSWORD);

		return connection;
	}
}