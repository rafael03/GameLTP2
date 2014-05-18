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

import br.com.jogo.controller.MenuAplicativo;
import br.com.jogo.model.Conexao;

public class index {

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
		chamaMenu();
		Campos();
		
	}
	public static void chamaMenu() {
		MenuAplicativo novoMenu = new MenuAplicativo();
		novoMenu.menuSuperior(menuBar);
	}

	private static void montaJanela() {
		// TODO Auto-generated method stub
		Janela.setSize(540, 540);
		Janela.setVisible(true);
		Janela.setLayout(new GridLayout(3, 2));
		Janela.setJMenuBar(menuBar);
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
