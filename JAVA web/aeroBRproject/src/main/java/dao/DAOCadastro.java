package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bd.ConexaoMySql;
import modelos.Cliente;

public class DAOCadastro implements CRUD {
	
	private static Connection connection = ConexaoMySql.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setInt(1, cliente.getId());
			preparedstatement.setString(1, cliente.getNome());
			preparedstatement.setString(2, cliente.getSnome());
			preparedstatement.setString(3, cliente.getIdade());
			preparedstatement.setString(4, cliente.getUf());
			preparedstatement.setString(5, cliente.getContat());
			preparedstatement.setString(6, cliente.getSenha());
			
			preparedstatement.executeUpdate();
			
			System.out.println("Os dados foram registrados na base de dados");
			
		} catch (SQLException e) {
			
			System.out.println("Houve um erro no registro dos dados" + e.getMessage());
		}
	};
	
	public static Cliente findByContat (String contat) {
		sql = String.format("SELECT * FROM cliente WHERE contat = ?", contat);
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				
				cliente.setNome(resultSet.getString("nome"));
				cliente.setSnome(resultSet.getString("snome"));
				cliente.setIdade(resultSet.getString("idade"));
				cliente.setContat(resultSet.getString("contat"));
				cliente.setUf(resultSet.getString("uf"));
				cliente.setSenha(resultSet.getString("senha"));
				
				System.out.println("O cliente foi encontrado com sucesso.");
				return cliente;
			}
			
		} catch (SQLException e){
			System.out.println("Erro ao tentar encontrar o cliente" + e.getMessage());
			
		}
		return null;
	};
	
	public static void update (Cliente cliente) {
		
		sql = "UPTADE Cliente SET nome=?, snome=?, idade=?, uf=?, contat=?, senha=? WHERE contat=?";
		
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setString(1, cliente.getNome());
			preparedstatement.setString(2, cliente.getSnome());
			preparedstatement.setString(3, cliente.getIdade());
			preparedstatement.setString(4, cliente.getUf());
			preparedstatement.setString(5, cliente.getContat());
			preparedstatement.setString(6, cliente.getSenha());
			
			preparedstatement.executeUpdate();
			
			System.out.println("Os dados foram registrados na base de dados");
			
		} catch (SQLException e) {
			
			System.out.println("Houve um erro no registro dos dados" + e.getMessage());
		}
		
	};

	public static void delete(String contat) {
		sql = "DELETE FROM cliente WHERE contat = ?";
		
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setString(1, contat);
			preparedstatement.executeUpdate();
			
			System.out.println("Os dados foram deletados da tabela cliente");
			
		} catch (SQLException e) {
			System.out.println("Erro ao tentar deletar os dados" + e.getMessage());
		}
		
	}

}

