package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsible for connecting to the database
 * SigletonConnection means that we will make just a single connection
 * @author Werner
 */

public class SingletonConnection {
	private static String url = "jdbc:postgresql://localhost:5433/posjava?autoreconnect=true";
	private static String password = "1234";
	private static String user = "postgres";
	private static Connection connection = null;

	static {

		connect();
	}

	public SingletonConnection() {

		connect();
	}
	
	

	private static void connect() {
		
		if(connection == null) {
			try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false); //Transaction commit  will be done when I want
			
			System.out.println("conectado");
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	}
}
	
	
	public static Connection getConnection() {
		
		
		
		return connection;
	}
	
	
	

}

