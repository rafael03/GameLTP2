package br.com.jogo.model;


import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class Conexao {

	//Configurar o banco
	protected static final String URL = "jdbc:mysql://localhost:3306/gameLTPII";
	private static final String userNameDb = "root";
	private static final String userPasswDb = "123";

	public static void main(String[] args) {

		criaTabelas();
		//bdPerguntas Perguntas = new bdPerguntas();
		Perguntas.criaBancoPerguntas();
		
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

	public static void criaTabelas() {
		try {
			Connection con = getConnection();
			Statement st = (Statement) con.createStatement();

			// Insere os dados no Banco
			String sqlCreate = "CREATE TABLE IF NOT EXISTS teste"
					+ "(id int(20) NOT NULL AUTO_INCREMENT,"
					+ " nome varchar(100) NOT NULL,"
					+ " senha varchar(100) NOT NULL," + " PRIMARY KEY (id));";

			st.execute(sqlCreate);
			// Fecha a conexão com o Banco
			con.close();
		} catch (Exception e) {
			System.out.println("Erro (CriaTabelas)" + e);
		}
	}



}
