package pageObjets.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import jdbcTest.MySQLConnUtils;
import pageUIs.wordpress.AdminUserPageUI;

public class AdminUserPO extends BasePage {
	WebDriver driver;

	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUserNumberAtUI() {
		waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String userNumber = getTextElement(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		System.out.println(userNumber);
		return Integer.parseInt(userNumber.split(" ")[0]);
		
	}

	public int getUserNumberAtDB() {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement stm;
		List<Integer> totalUser = new ArrayList<Integer>();
		
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM wp_users" ;
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int number = rs.getInt(1);
				totalUser.add(number);
				System.out.println("numberUser:" + number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("size"+ totalUser.size());
		return totalUser.size();
	}

}
