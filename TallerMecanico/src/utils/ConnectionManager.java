package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String DB_URL = "jdbc:mysql://localhost:3306/TP_TALLER_MECANICO?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB_URL);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return conn;
	}
}