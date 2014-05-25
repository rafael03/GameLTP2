package br.com.jogo.model;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class bdPerguntas extends Conexao {

	public static void criaBancoPerguntas() {
		try {
			Connection con = (Connection) DriverManager.getConnection(URL,
					"root", "");
			Statement st = (Statement) con.createStatement();

			// Insere os dados no Banco
			String sqlCreate = "CREATE TABLE IF NOT EXISTS tabelaPergunta"
					+ "(id_pergunta int(20) NOT NULL AUTO_INCREMENT,"
					+ " texto_pergunta varchar(1000) NOT NULL,"
					+ " resposta_certa varchar(500) NOT NULL,"
					+ " resposta_errada1 varchar(500) NOT NULL,"
					+ " resposta_errada2 varchar(500) NOT NULL,"
					+ " resposta_errada3 varchar(500) NOT NULL,"
					+ " PRIMARY KEY (id_pergunta))ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;";

			// executa o comando dentro da variavel sqlCreate
			st.execute(sqlCreate);

			// Fecha a conexão com o Banco
			con.close();
		} catch (Exception e) {
			System.out.println("Erro (criaBancoPerguntas)" + e);
		}
	}

	// TODO
	public static void inserePerguntas(String strPergunta,
			String strRespostaCorreta, String strOpcao1, String strOpcao2,
			String strOpcao3) {
		try {
			// Abre conexão com o Banco
			Connection con = (Connection) DriverManager.getConnection(URL,
					"root", "");
			Statement st = (Statement) con.createStatement();
			
			String valPergunta = strPergunta;
			String valRespostaCorreta = strRespostaCorreta;
			String valOpcao1 = strOpcao1;
			String valOpcao2 = strOpcao2;
			String valOpcao3 = strOpcao3;

			// Insere os dados no Banco
			st.executeUpdate("INSERT INTO tabelaPergunta(texto_pergunta, resposta_certa,resposta_errada1,resposta_errada2,resposta_errada3) VALUES ('"
					+ valPergunta
					+ "','"
					+ valRespostaCorreta
					+ "','"
					+ valOpcao1 + "','" + valOpcao2 + "','" + valOpcao3 + "');");

			// Fecha a conexão com o Banco
			con.close();
			System.out.println("Dados Salvos (inserePerguntas) "+ strPergunta);
		} catch (Exception e) {
			// Se der erro, retorna a mensagem com erro
			System.out.println("Erro (inserePerguntas): " + e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
