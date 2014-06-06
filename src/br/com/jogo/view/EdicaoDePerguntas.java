package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EdicaoDePerguntas extends JFrame{

	public JButton btSalvar, btVoltarTelaPrincipal;
	private JLabel lbId, lbTextoPergunta, lbRespostaCorreta, lbOpcao1,
	lbOpcao2, lbOpcao3, lbVidas;
	public JTextField fieldPergunta, fieldRespostaCorreta, fieldOpcao1,	fieldOpcao2, fieldOpcao3;

	public EdicaoDePerguntas(String id_, String pergunta_, String respostaCerta_, String opcao1_, String opcao2_, String opcao3_) {
		btSalvar = new JButton("Salvar Alterações");
		btVoltarTelaPrincipal = new JButton("Voltar para Tela Principal");
		
//		imgCadastrar = new ImageIcon("img/inserir.png");
//		imgBuscar = new ImageIcon("img/buscar.png");
//		btCadastrar.setIcon(imgCadastrar);
//		btBuscar.setIcon(imgBuscar);
		
		JPanel panButtons = new JPanel(new GridLayout(1, 2));
		panButtons.add(btSalvar);
		panButtons.add(btVoltarTelaPrincipal);		

		
		//Monta os campos para serem editados
		lbId = new JLabel("ID da Questão:");
		lbTextoPergunta = new JLabel("Pergunta:");
		lbRespostaCorreta = new JLabel("Resposta Certa:");
		lbOpcao1 = new JLabel("Opção 01:");
		lbOpcao2 = new JLabel("Opção 02:");
		lbOpcao3 = new JLabel("Opção 03:");
		
		fieldPergunta = new JTextField();
		fieldRespostaCorreta = new JTextField();
		fieldOpcao1 = new JTextField();
		fieldOpcao2 = new JTextField();
		fieldOpcao3 = new JTextField();
		
		fieldPergunta.setText(pergunta_);
		fieldRespostaCorreta.setText(respostaCerta_);
		fieldOpcao1.setText(opcao1_);
		fieldOpcao2.setText(opcao2_);
		fieldOpcao3.setText(opcao3_);
		
		
		
		JPanel panPerguntas = new JPanel(new GridLayout(5,2));
		panPerguntas.add(lbTextoPergunta);
		panPerguntas.add(fieldPergunta);
		
//		panPerguntas.add(lbTextoPergunta);
//		panPerguntas.add(fieldRespostaCorreta);
		
		panPerguntas.add(lbRespostaCorreta);
		panPerguntas.add(fieldRespostaCorreta);
		
		panPerguntas.add(lbOpcao1);
		panPerguntas.add(fieldOpcao1);
		
		panPerguntas.add(lbOpcao2);
		panPerguntas.add(fieldOpcao2);
		
		panPerguntas.add(lbOpcao3);
		panPerguntas.add(fieldOpcao3);
		
		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panPerguntas,BorderLayout.CENTER);
		this.getContentPane().add(panButtons, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gerencia de Perguntas");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
//		botoesNaTelaPergunta();
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		new EdicaoDePerguntas();
//	}
	public static void main(String id_, String pergunta_, String respostaCerta_, String opcao1_, String opcao2_, String opcao3_) {
		// TODO Auto-generated method stub
		System.out.println(id_ + pergunta_);
		JFrame.setDefaultLookAndFeelDecorated(true);
		new EdicaoDePerguntas(id_, pergunta_, respostaCerta_, opcao1_, opcao2_, opcao3_);
		
	}

}
