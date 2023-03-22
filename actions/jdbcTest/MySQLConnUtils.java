package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() {
		String hotsName = "localhost";
		String adName = "automationfc";
		String uerName = "root";
		String password = "";
		return getMySQLConnection(hotsName, adName, uerName, password);
		
	}

	private static Connection getMySQLConnection(String hotsName, String dbName, String uerName, String passwork) {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.driver");
			String connectionURL = "jdbc:mysql://" + hotsName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, uerName, passwork);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
