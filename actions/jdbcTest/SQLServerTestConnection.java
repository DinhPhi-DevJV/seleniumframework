package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerTestConnection {
	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerJTDSConnUtils.getSQLServerConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM branch;";
		String sql2="INSERT INTO branch(ADDRESS,CITY,NAME) VALUES ('loc thuy','Hue','Phi')";
		// ham dung de insert hoac delete
		int numberOfColumData =  stmt.executeUpdate(sql2);
		System.out.println(numberOfColumData);
		// thực thi câu lệnh sql trả về đối tượng resultset,
		ResultSet resultSet = stmt.executeQuery(sql);
		
		//duyệt trên kết quả trả về
		
		while (resultSet.next()) {
			// di chuyển con trỏ xuống bảng ghi kế tiếp.
			int empId = resultSet.getInt(1);
			String adress =  resultSet.getString(2);
			String city =  resultSet.getString("CITY");
			System.out.println("----------------------");
			System.out.println("Emp Id:"+empId);
			System.out.println("Address :"+adress);
			System.out.println("City:"+city);
		}
		conn.close();
		System.out.println("----------close connection---------");
		
	}
}
