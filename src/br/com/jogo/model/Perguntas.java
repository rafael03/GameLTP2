package br.com.jogo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public class Perguntas extends Conexao {
	
	public static void inserePerguntas(String textoPergunta, String respostaCerta, String opcao1, String opcao2, String opcao3) {
		try {
			// Abre conexão com o Banco
			Connection con = getConnection();
			
			//Monta o a query com passagem de parametro dinâmico
			PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into pergunta(texto_pergunta, resposta_certa, resposta_errada1, resposta_errada2, resposta_errada3) VALUES (?,?,?,?,?)");

			// Insere os dados no Banco
			st.setString(1, textoPergunta);
			st.setString(2, respostaCerta);
			st.setString(3, opcao1);
			st.setString(4, opcao2);
			st.setString(5, opcao3);
			
			st.executeUpdate();

			// Fecha a conexão com o Banco
			con.close();
			
			System.out.println("Dados Salvos (inserePerguntas) " + textoPergunta);
			
		} catch (Exception e) {
			// Se der erro, retorna a mensagem com erro
			System.out.println("Erro (inserePerguntas()): " + e);
		}
	}

	public static <E> void mostraPeguntas() {
		String consulta = "select * from pergunta";
		try {
			Connection con = getConnection();
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
		String consulta = "select id_pergunta from pergunta ";
		try {
			ArrayList<Integer> perguntas = new ArrayList<Integer>();
			Connection con = Conexao.getConnection();
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
		String consulta = "select * from pergunta where id_pergunta = "+ integer;
		try {
			Connection con = Conexao.getConnection();
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
