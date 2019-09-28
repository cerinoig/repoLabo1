package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

//	private static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TP_TALLER_MECANICO;" + "integratedSecurity=true";
	private static String DB_URL = "jdbc:mysql://localhost:3306/TP_TALLER_MECANICO?useSSL=false&user=root&password=root";
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(DB_URL);
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		return conn;
	}
}