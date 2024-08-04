package main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public static Connection connection;
	
	private ConnectionFactory(Connection connection) {}

	// Se a conexão não for válida, ele cria uma nova conexão.
	// Isso garante que sempre que uma conexão for solicitada, ela estará pronta para uso.
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
					"main.jdbc:postgresql://localhost:5432/bancoCursoEbac",
					"postgres",
					"19091997"
			);
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}

	//Esse método verificar se a conexão atual é válida antes de usá-la
	private static boolean isConnectionValid() {
		try (Statement stmt = connection.createStatement()) { // Statement é um objeto usado para enviar instruções SQL para o BD
			stmt.executeQuery("SELECT 1");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
