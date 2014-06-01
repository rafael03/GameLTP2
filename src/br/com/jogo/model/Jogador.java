package br.com.jogo.model;

import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class Jogador {
	
	public static void insereJogador(String nome, String senha) {
		try {
			// Abre conexão com o Banco
			Connection con = Conexao.getConnection();
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
