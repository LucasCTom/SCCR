package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	public static Connection establishConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String bancoURL = "jdbc:mysql://localhost:3306/sccrdb";
			connection = (Connection) DriverManager.getConnection(bancoURL, "root", "");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return connection;
	}
	
}
