package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bank.bankimplementation.Addressimpl;

public class JDBCTest {
	private static String driver = "com.mysql.cj.jdbc.Driver";

	private static String url = "jdbc:mysql://localhost:3306/bank_db_address";

	private static String userName = "root";

	private static String password = "2003";//hello world

	public void loadDriver() throws ClassNotFoundException {

		Class.forName(driver);

		System.out.println("Driver loaded...");//hello world

	}

	public static Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName(driver);

			conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Connection success..");

			Statement st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery("select * from customer");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +

						rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " +

						rs.getString(6) + " " + rs.getString(7) + " " + rs.getInt(8));
			}

		} catch (Exception e) {

			e.printStackTrace();

			// TODO: handle exception

		}

		return conn;

	}

	public static void main(String[] args) throws ClassNotFoundException {

		JDBCTest JDBCTest = new JDBCTest();
		JDBCTest.loadDriver();
		JDBCTest.getConnection();

	}

}
