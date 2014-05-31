package br.com.jogo.model;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class bdPerguntas extends Conexao {

	public static void criaBancoPerguntas() {
		try {
			Connection con = (Connection) DriverManager.getConnection(URL,
					"root", "mysql");
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
					"root", "mysql");
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
			System.out.println("Dados Salvos (inserePerguntas) " + strPergunta);
		} catch (Exception e) {
			// Se der erro, retorna a mensagem com erro
			System.out.println("Erro (inserePerguntas()): " + e);
		}
	}

	public static <E> void mostraPeguntas() {
		String consulta = "SELECT * FROM tabelaPergunta;";
		try {
			Connection con = (Connection) DriverManager.getConnection(URL, "root", "mysql");
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			while (rs.next()){
				System.out.println("ID: "+ rs.getString("id_pergunta") + "  Pergunta: " + rs.getString("texto_pergunta"));
			}
		} catch (SQLClientInfoException e) {
			System.out.println("Erro (mostraPeguntas()): " + e);
		} catch (Exception e) {
			System.out.println("Erro (mostraPeguntas()): " + e);
		}

	}
	
	public static ArrayList<Integer> retornaIndiceDePerguntas() {
		String consulta = "SELECT * FROM tabelaPergunta;";
		try {
			ArrayList<Integer> perguntas = new ArrayList<Integer>();
			Connection con = (Connection) DriverManager.getConnection(URL, "root", "mysql");
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()){
				perguntas.add(Integer.parseInt(rs.getString("id_pergunta")));
			}
			//Se tudo ocorrer bem, ira retornar a lista com o indice das perguntas
			return perguntas;

		} catch (SQLClientInfoException e) {
			System.out.println("Erro (mostraPeguntas()): " + e);
		} catch (Exception e) {
			System.out.println("Erro (mostraPeguntas()): " + e);
		}
		return null;

	}
	
	public static Map<String, String> getPergunta(Integer integer) {
		//Retorna pergunta de acordo com o indice informado
		String consulta = "SELECT * FROM tabelaPergunta where id_pergunta = "+ integer +";";
		try {
			Connection con = (Connection) DriverManager.getConnection(URL, "root", "mysql");
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			while (rs.next()){
				Map<String, String> pergunta = new HashMap<String,String>();
				pergunta.put("id_pergunta", rs.getString("id_pergunta"));
				pergunta.put("textoPergunta", rs.getString("texto_pergunta"));
				pergunta.put("respostaCorreta", rs.getString("resposta_certa"));
				pergunta.put("opcao1", rs.getString("resposta_errada1"));
				pergunta.put("opcao2", rs.getString("resposta_errada2"));
				pergunta.put("opcao3", rs.getString("resposta_errada3"));
				System.out.println("TESTE" + pergunta);
				return pergunta;
			}
		} catch (SQLClientInfoException e) {
			System.out.println("Erro (getPergunta()): " + e);
		} catch (Exception e) {
			System.out.println("Erro (getPergunta()): " + e);
		}
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getPergunta(5);
	}

	

}
