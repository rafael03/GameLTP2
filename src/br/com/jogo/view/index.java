package br.com.jogo.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import br.com.jogo.model.Conexao;

public class index {

	private static final Component MenuBar = null;
	private static final JFrame Janela = new JFrame(
			"Game Play - Cadastro do Jogador");
	private static final JMenuBar menuBar = new JMenuBar();

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriaView();
	}

	public static void CriaView() {
		montaJanela();
		menuSuperior();
		Campos();
	}

	private static void montaJanela() {
		// TODO Auto-generated method stub
		Janela.setSize(540, 540);
		Janela.setVisible(true);
		Janela.setLayout(new GridLayout(3, 2));
		Janela.setJMenuBar(menuBar);
	}

	public static void menuSuperior() {

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

	public static void Campos() {
		// Criando os label de texto
		JLabel textUser = new JLabel("Jogador: ");
		JLabel textSenha = new JLabel("Senha: ");

		// Criando os Campos
		final JTextField fieldUser = new JTextField();
		final JTextField fieldSenha = new JTextField();

		// Criando os Botões
		JButton buttonEntrar = new JButton("Salvar");
		JButton buttonSair = new JButton("Sair");
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String nomeDoJogador = fieldUser.getText();
				String senhaDoJogador = fieldSenha.getText();
				
				System.out.println("Campos" + nomeDoJogador + senhaDoJogador);
				Conexao conexao = new Conexao();
				conexao.insereJogador(nomeDoJogador, senhaDoJogador);
				
			}
		});

		Janela.add(textUser);
		Janela.add(fieldUser);
		Janela.add(textSenha);
		Janela.add(fieldSenha);
		Janela.add(buttonEntrar);
		Janela.add(buttonSair);

	}

}
