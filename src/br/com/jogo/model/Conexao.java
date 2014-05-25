package br.com.jogo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import br.com.jogo.model.bdPerguntas;

public class Conexao {

	//Configurar o banco
	protected static final String URL = "jdbc:mysql://localhost:3306/GameLTP2";

	public static void main(String[] args) {

		CriaTabelas();
		bdPerguntas Perguntas = new bdPerguntas();
		Perguntas.criaBancoPerguntas();

	}

	public static void CriaTabelas() {
		try {
			Connection con = (Connection) DriverManager.getConnection(URL,
					"root", "");
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

	public static void insereJogador(String nome, String senha) {
		try {
			// Abre conexão com o Banco
			Connection con = (Connection) DriverManager.getConnection(URL,
					"root", "");
			Statement st = (Statement) con.createStatement();

			// Recebe os valores do metodo
			String nomeUser = nome;
			String senhaUser = senha;

			// Insere os dados no Banco
			st.executeUpdate("INSERT INTO jogador(nome, senha) VALUES ('"
					+ nomeUser + "','" + senhaUser + "');");

			// Fecha a conexão com o Banco
			con.close();

		} catch (Exception e) {
			// Se der erro, retorna a mensagem com erro
			System.out.println("Erro (insereJogador): " + e);
		}
	}

}
