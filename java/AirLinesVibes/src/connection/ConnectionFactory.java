package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/airLinesVibes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "@Gremio1010";
	
	public Connection getConnection() { 

	    try {
			return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}
