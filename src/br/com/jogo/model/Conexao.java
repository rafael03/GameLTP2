package br.com.jogo.model;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	//Configurar o banco
	protected static final String URL = "jdbc:mysql://localhost:3306/gameLTPII";
	private static final String userNameDb = "root";
	private static final String userPasswDb = "123";

	public static void main(String[] args) {
		
		//TODO refatorar código para verificar se as tabelas já foram criadas
		InitializeJdbc.createDataBase();
		
	}
	
	
	public static Connection getConnection () {
		
		try {
			Connection con = (Connection) DriverManager.getConnection(URL, userNameDb, userPasswDb);
			return con;			
		} catch (Exception e) {
			System.out.println("Erro (CriaTabelas)" + e);
		}
		return null;
		
	}

	



}
