package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bd.ConexaoMySql;
import modelos.Contato;

	public class DAOContato implements CRUD {
	
	private static Connection connection = ConexaoMySql.createConnection();
	private static String sql;
	
	public static void create(Contato contato) {
		sql = "INSERT INTO contato VALUES (null, ?, ?)";
		
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setInt(1, contato.getId());
			preparedstatement.setString(1, contato.getContat());
			preparedstatement.setString(2, contato.getComent());
			
			preparedstatement.executeUpdate();
			
			System.out.println("Os dados foram registrados na base de dados");
			
		} catch (SQLException e) {
			
			System.out.println("Houve um erro no registro dos dados" + e.getMessage());
		}
	};
}