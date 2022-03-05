package dao;

import modelos.Cliente;

public interface CRUD {
	
	public static void create(Cliente cliente) {};
	public static void delete (int cadastroId) {};
	public static Cliente findByPk (int contat) {return null;};
	public static void update (Cliente cliente) {}
}
