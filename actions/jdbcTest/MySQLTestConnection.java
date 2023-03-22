package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MySQLTestConnection {
	public static Connection getMyconnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// lấy ra đối tượng connection kết nối vào database
		Connection conn = MySQLTestConnection.getMyconnection();
		// tạo ra một đối tượng statement
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM wp_users;";
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		while (resultSet.next()) {
			// di chuyển con trỏ xuống bảng ghi kế tiếp.
			int userId = resultSet.getInt(1);
			String userLogin =  resultSet.getString(2);
			String userEmail =  resultSet.getString("user_email");
			System.out.println("----------------------");
			System.out.println("Emp Id:"+userId);
			System.out.println("User login:"+userLogin);
			System.out.println("City:"+userEmail);
		}
		conn.close();
		System.out.println("----------close connection---------");
		
	}
}