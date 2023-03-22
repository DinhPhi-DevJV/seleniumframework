package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerJTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String dbName = "automationfc";
		String userName = "automationtest";
		String password = "automationfc";
		return getSQLServerConnection(hostName, sqlInstanceName, dbName, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String dbName,
			String userName, String password) {
		Connection conn = null;
		String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName + ";instance=" + sqlInstanceName;
		try {
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
