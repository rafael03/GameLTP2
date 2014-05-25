package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastrarPerguntas extends JFrame {
	public JButton btSalvar, btLimpar;
	public JTextField fieldPergunta, fieldRespostaCorreta, fieldOpcao1, fieldOpcao2, fieldOpcao3;
	public JLabel lbPergunta, lbRespostaCorreta, lbOpcao1, lbOpcao2, lbOpcao3;

	public CadastrarPerguntas() {
		
		lbPergunta = new JLabel("Digite a pergunta: ");
		lbRespostaCorreta = new JLabel("Digite a Resposta Correta"); 
		lbOpcao1 = new JLabel("Opção de Resposta falsa 01"); 
		lbOpcao2 = new JLabel("Opção de Resposta falsa 02"); 
		lbOpcao3  = new JLabel("Opção de Resposta falsa 03");
		
		
		fieldPergunta = new JTextField();
		fieldRespostaCorreta = new JTextField();
		fieldOpcao1 = new JTextField();
		fieldOpcao2 = new JTextField();
		fieldOpcao3 = new JTextField();
		
		JPanel questaoGrid = new JPanel(new GridLayout(5,2));
		
		questaoGrid.add(lbPergunta);
		questaoGrid.add(fieldPergunta);
		
		questaoGrid.add(lbRespostaCorreta);
		questaoGrid.add(fieldRespostaCorreta);
		
		questaoGrid.add(lbOpcao1);
		questaoGrid.add(fieldOpcao1);

		questaoGrid.add(lbOpcao2);
		questaoGrid.add(fieldOpcao2);

		questaoGrid.add(lbOpcao3);
		questaoGrid.add(fieldOpcao3);

		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		
		JPanel painelButton = new JPanel(new GridLayout(0, 2));
		painelButton.add(btSalvar);
		painelButton.add(btLimpar);
		
		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(questaoGrid, BorderLayout.NORTH);
		this.getContentPane().add(painelButton, BorderLayout.SOUTH);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Cadastro de Perguntas");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new CadastrarPerguntas();
	}

}
