package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public static Connection connection;
	
	private ConnectionFactory(Connection connection) {}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null || connection.isClosed() || !isConnectionValid()) {
			connection = initConnection();
		}
		return connection;
	}

	private static Connection initConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");

			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/bancoCursoEbac",
					"postgres",
					"19091997"
			);
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}

	private static boolean isConnectionValid() {
		try (Statement stmt = connection.createStatement()) {
			stmt.executeQuery("SELECT 1");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
