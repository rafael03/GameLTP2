package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import br.com.jogo.controller.GeradorDePerguntas;

import br.com.jogo.controller.GeradorDePerguntas;
import br.com.jogo.model.bdPerguntas;

public class Jogar extends JFrame{
	ArrayList<Integer> perguntas_;
	int intVidas =3;
	public JButton btResponder;
	public JLabel lbId, lbTextoPergunta, lbRespostaCorreta, lbOpcao1, lbOpcao2, lbOpcao3, lbVidas;
	JRadioButton rdResposta1, rdResposta2, rdResposta3, rdResposta4;
	public void main(ArrayList<Integer> lista_de_pergntas, int intVidas2) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Jogar(lista_de_pergntas, intVidas2);
		System.out.println(lista_de_pergntas);
	}
	
	public Jogar(ArrayList<Integer> lista_de_pergntas, int intVidas2) {
		perguntas_ = lista_de_pergntas;
		bdPerguntas recebe_pergunta = new bdPerguntas();
		Map<String, String> pergunta = recebe_pergunta.getPergunta(perguntas_.get(0));
		
		lbVidas = new JLabel();
		lbId = new JLabel();
		lbTextoPergunta = new JLabel();
		lbRespostaCorreta = new JLabel();
		lbOpcao1 = new JLabel();
		lbOpcao2 = new JLabel();
		lbOpcao3 = new JLabel();
		
		
		lbVidas.setText("Vidas: " + Integer.toString(intVidas2));
		lbId.setText("ID: " + pergunta.get("id_pergunta"));
		lbTextoPergunta.setText(pergunta.get("textoPergunta"));
		lbRespostaCorreta.setText(pergunta.get("respostaCorreta"));
		lbOpcao1.setText(pergunta.get("opcao1"));
		lbOpcao2.setText(pergunta.get("opcao2"));
		lbOpcao3.setText(pergunta.get("opcao3"));
		
		JRadioButton rdResposta1 = new JRadioButton(pergunta.get("respostaCorreta"));
		JRadioButton rdResposta2 = new JRadioButton(pergunta.get("opcao1"));
		JRadioButton rdResposta3 = new JRadioButton(pergunta.get("opcao2"));
		JRadioButton rdResposta4 = new JRadioButton(pergunta.get("opcao3"));
		
		JPanel panelPerguntas = new JPanel(new GridLayout(1, 3));
		panelPerguntas.add(lbTextoPergunta);
		panelPerguntas.add(lbId);
		panelPerguntas.add(lbVidas);
		
		JPanel panelResposta = new JPanel(new GridLayout(4,1));
		panelResposta.add(rdResposta1);
		panelResposta.add(rdResposta2);
		panelResposta.add(rdResposta3);
		panelResposta.add(rdResposta4);
		
		btResponder = new JButton("Responder");
		JPanel panelBotoes = new JPanel(new GridLayout(1, 2));
		panelBotoes.add(btResponder);
		
		
		// painel do JFrame
				this.setLayout(new BorderLayout());
				this.getContentPane().add(panelPerguntas, BorderLayout.NORTH);
				this.getContentPane().add(panelResposta, BorderLayout.CENTER);
				this.getContentPane().add(panelBotoes, BorderLayout.SOUTH);

				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setTitle("Cadastro de Perguntas");
				this.setSize(600, 300);
				this.setResizable(true);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
				
				chamaClickOnButtonJogar(lista_de_pergntas);
				
	}

	private void chamaClickOnButtonJogar(final ArrayList<Integer> perguntas_) {
		btResponder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				perguntas_.remove(0);
				intVidas -=1;
				main(perguntas_, intVidas);
				
			}
		});
		
	}

}
