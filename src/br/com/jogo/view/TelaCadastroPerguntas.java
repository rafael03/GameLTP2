package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jogo.model.Perguntas;

public class TelaCadastroPerguntas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JButton btSalvar, btLimpar;
	public JTextField fieldPergunta, fieldRespostaCorreta, fieldOpcao1,	fieldOpcao2, fieldOpcao3;
	public JLabel lbPergunta, lbRespostaCorreta, lbOpcao1, lbOpcao2, lbOpcao3;

	public TelaCadastroPerguntas() {

		lbPergunta = new JLabel("Digite a pergunta: ");
		lbRespostaCorreta = new JLabel("Digite a Resposta Correta");
		lbOpcao1 = new JLabel("Opção de Resposta falsa 01");
		lbOpcao2 = new JLabel("Opção de Resposta falsa 02");
		lbOpcao3 = new JLabel("Opção de Resposta falsa 03");

		fieldPergunta = new JTextField();
		fieldRespostaCorreta = new JTextField();
		fieldOpcao1 = new JTextField();
		fieldOpcao2 = new JTextField();
		fieldOpcao3 = new JTextField();

		JPanel questaoGrid = new JPanel(new GridLayout(5, 2));

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

		botoesTelaCadastrarPerguntas();
	}

	private void botoesTelaCadastrarPerguntas() {
		
		// Efeitos ao clicar nos botões da tela de cadastro de perguntas
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				// Chama a tela de cadastro de perguntas
				String strPergunta = fieldPergunta.getText();
				String strRespostaCorreta = fieldRespostaCorreta.getText();
				String strOpcao1 = fieldOpcao1.getText();
				String strOpcao2 = fieldOpcao2.getText();
				String strOpcao3 = fieldOpcao3.getText();

				if (!(strPergunta.equals("")) || !(strRespostaCorreta.equals(""))) {
					Perguntas.inserePerguntas(strPergunta, strRespostaCorreta, strOpcao1, strOpcao2, strOpcao3);
					JOptionPane.showMessageDialog(null, "Pergunta salva com sucesso!!!", null, JOptionPane.INFORMATION_MESSAGE);
					limpaCampoCadastroPerguntas();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!!!", null, JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Chama a tela de cadastro de perguntas
				limpaCampoCadastroPerguntas();

			}

		});

	}

	private void limpaCampoCadastroPerguntas() {
		// TODO Auto-generated method stub
		fieldPergunta.setText("");
		fieldRespostaCorreta.setText("");
		fieldOpcao1.setText("");
		fieldOpcao2.setText("");
		fieldOpcao3.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new TelaCadastroPerguntas();
	}

}
