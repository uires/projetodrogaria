package br.com.drogariareescrita.controleestoque.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String USER = "root";
	private static final String PASS = "220132";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useTimezone=true&serverTimezone=UTC";

	public static Connection getConnectionFactoryBank() throws SQLException {
		Connection conexao = null;
		try {
			/*
			 * @desc: tratamentopara tratar error do JDBC
			 */
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conexao = DriverManager.getConnection(URL, USER, PASS);
		return conexao;
	}
}
