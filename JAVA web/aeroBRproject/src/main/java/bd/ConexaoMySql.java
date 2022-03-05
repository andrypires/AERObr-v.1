package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

	static String url = "jdbc:mysql://localhost:3306/aerobr"; 
	static String usuario = "root";
	static String senha = "9332sqL*";
	
	public static Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc");
			System.out.println("O driver foi encontrado!");
		} catch (ClassNotFoundException e){
			System.out.println("Driver não foi encontrado" + e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado à baseda dados!");
			return connection;
		} catch (SQLException e){
			System.out.println("Não foi realizada a conexão à base de dados" + e.getMessage());
			return null;
		}
	}
}
