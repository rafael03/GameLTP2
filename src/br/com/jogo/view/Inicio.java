package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.jogo.controller.GeradorDePerguntas;
import br.com.jogo.view.Perguntas;

public class Inicio extends JFrame {
	public JButton btJogar, btRanking, btCadastrarPergunta;
	public ImageIcon imgJogar, imgRanking, imgCadastrarPergunta;

	public Inicio() {
		//Cria botões
		btJogar = new JButton("    Jogar");
		btRanking = new JButton("  Ranking");
		btCadastrarPergunta = new JButton("Perguntas");
		
		//Cria icones
		imgJogar = new ImageIcon("img/jogar.png");
		imgRanking  = new ImageIcon("img/ranking.png");
		imgCadastrarPergunta = new ImageIcon("img/cadastrar.png");
		
		//passa os icones para os botoes
		btJogar.setIcon(imgJogar);
		btRanking.setIcon(imgRanking);
		btCadastrarPergunta.setIcon(imgCadastrarPergunta);


		// Define numero de linhas x numero de colunas
		JPanel panButtons = new JPanel(new GridLayout(3, 1));
		panButtons.add(btJogar);
		panButtons.add(btRanking);
		panButtons.add(btCadastrarPergunta);

		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panButtons, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Game Play");
		this.setSize(600, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		chamaClickOnButton();
	}

	private void chamaClickOnButton() {
		// Funcões realizadas ao se clicar em algum botão

		// Efeito ao clicar no botão btJogar
		btJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GeradorDePerguntas perguntas = new GeradorDePerguntas();
				ArrayList<Integer> lista_de_pergntas = perguntas.embaralhaListaDePerguntas();
				
				//Passa lista com indice das perguntas já embaralhadas
				Jogar jogar = new Jogar(lista_de_pergntas, 3);
				jogar.main(lista_de_pergntas, 3);
			}
		});

		// Efeito ao clicar no botão btRanking
		btRanking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ranking", "Janela",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Efeito ao clicar no botão btCadastrarPergunta
		btCadastrarPergunta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//Chama outra tela
				Perguntas perguntas = new Perguntas();
				perguntas.main(null);
				
			}
		});

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Linha responsavel por personalizar a janela
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Inicio();

	}

}
