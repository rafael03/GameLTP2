package br.com.jogo.controller;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuAplicativo {

//	private static final JMenu menuBar = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void menuSuperior(JMenuBar menuBar) {

		JMenu menu = new JMenu("Inicio");
		JMenu menuRanking = new JMenu("Ranking");
		JMenu menuPerguntas = new JMenu("Perguntas");

		// menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuBar.add(menuRanking);
		menuBar.add(menuPerguntas);

		// Bloco de sub-menus inicio
		JMenuItem Jogar = new JMenuItem("Jogar");
		JMenuItem Sair = new JMenuItem("Sair");
		menu.add(Jogar);
		menu.add(Sair);

		// Bloco de sub-menus Ranking
		JMenuItem subMenuMelhores = new JMenuItem("Melhores Jogadores");
		JMenuItem subMenuPiores = new JMenuItem("Piores Jogadores");
		menuRanking.add(subMenuMelhores);
		menuRanking.add(subMenuPiores);

		// Bloco de sub-menus Perguntas
		JMenuItem subMenuCriarPergunta = new JMenuItem("Cadastrar pergunta");
		JMenuItem subMenuEditarPergunta = new JMenuItem("Editar pergunta");
		menuPerguntas.add(subMenuCriarPergunta);
		menuPerguntas.add(subMenuEditarPergunta);
	}

}
