package br.com.jogo.model;

import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class InitializeJdbc {
	
	
	public static void main(String[] args) {
		InitializeJdbc.createDataBase();
	}
	
	/**
	 * Cria a tabela no banco caso não exista
	 */
	public static void createDataBase() {
		try {
			Connection con = Conexao.getConnection();
			Statement st = (Statement) con.createStatement();

			//monta a query de criacao de tabela
			StringBuffer sqlCreate = new StringBuffer();	
			sqlCreate.append(" create table if not exists pergunta ");
			sqlCreate.append("( id_pergunta int(20) not null auto_increment, ");
			sqlCreate.append("  texto_pergunta varchar(1000) not null,");
			sqlCreate.append("  resposta_certa varchar(500) not null,");
			sqlCreate.append("  resposta_errada1 varchar(500) not null,");
			sqlCreate.append("  resposta_errada2 varchar(500) not null,");
			sqlCreate.append("  resposta_errada3 varchar(500) not null,");
			sqlCreate.append("  primary key (id_pergunta) ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ");

			// executa o comando da variavel sqlCreate
			st.execute(sqlCreate.toString());

			// Fecha a conexão com o Banco
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro (criaBancoPerguntas)" + e);
		}
	}

}
