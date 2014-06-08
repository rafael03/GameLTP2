package br.com.jogo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;
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
	
	public static boolean inserePontosDoJogador(String nome, int pontos) {
		try {
			// Abre conexão com o Banco
			Connection con = Conexao.getConnection();
			PreparedStatement st = (PreparedStatement) con.prepareStatement(" INSERT INTO ranking(NOME, PONTOS) VALUES (?,?) ");

			st.setString(1, nome);
			st.setInt(2, pontos);
			
			// Insere os dados no Banco
			st.executeUpdate();
			
			//fecha o preparedstatment
			st.close();

			// Fecha a conexão com o Banco
			con.close();
			
			return true;

		} catch (Exception e) {
			// Se der erro, retorna a mensagem com erro
			System.out.println("Erro (insereJogador): " + e);
			return false;
		}
	}
	
	
	public static List<Map<String, String>> buscarRanking() {
		String consulta = "SELECT id_ranking, nome, pontos FROM ranking order by pontos desc";
		try {
			List<Map<String, String>> ranking = new ArrayList<Map<String, String>>();
			Connection con = Conexao.getConnection();
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Map<String, String> valoresQuery = new HashMap<String, String>();
				valoresQuery.put("id_ranking", rs.getString("id_ranking"));
				valoresQuery.put("nome", rs.getString("nome"));
				valoresQuery.put("pontos", rs.getString("pontos"));
				ranking.add(valoresQuery);
			}
			return ranking;
		} catch (SQLClientInfoException e) {
			System.out.println("Erro (getPergunta()): " + e);
		} catch (Exception e) {
			System.out.println("Erro (getPergunta()): " + e);
		}
		return null;

	}

}
