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
			
			Statement st1 = (Statement) con.createStatement();
			StringBuffer sqlCreate1 = new StringBuffer();	
			sqlCreate1.append(" create table if not exists pergunta ");
			sqlCreate1.append("( id_pergunta int(20) not null auto_increment, ");
			sqlCreate1.append("  texto_pergunta varchar(1000) not null,");
			sqlCreate1.append("  resposta_certa varchar(500) not null,");
			sqlCreate1.append("  resposta_errada1 varchar(500) not null,");
			sqlCreate1.append("  resposta_errada2 varchar(500) not null,");
			sqlCreate1.append("  resposta_errada3 varchar(500) not null,");
			sqlCreate1.append("  primary key (id_pergunta) ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ");

			// executa o comando da variavel sqlCreate
			st1.execute(sqlCreate1.toString());

			
			Statement st2 = (Statement) con.createStatement();
			StringBuffer sqlCreate2 = new StringBuffer();	
			sqlCreate2.append(" create table if not exists ranking ");
			sqlCreate2.append("( id_ranking int(20) not null auto_increment, ");
			sqlCreate2.append("  nome varchar(100) not null,");
			sqlCreate2.append("  pontos int not null,");
			sqlCreate2.append("  primary key (id_ranking) ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ");
			
			// executa o comando da variavel sqlCreate
			st2.execute(sqlCreate2.toString());
			
			
			// Fecha a conexão com o Banco
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro (criaBancoPerguntas)" + e);
		}
	}

}
