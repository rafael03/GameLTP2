package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.com.jogo.controller.Embaralhador;
import br.com.jogo.model.Perguntas;

public class Jogar extends JFrame {

	private String respostaCerta;

	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> perguntasRestantes;
	private JButton btResponder;
	private JLabel lbId, lbTextoPergunta, lbRespostaCorreta, lbOpcao1,
			lbOpcao2, lbOpcao3, lbVidas;
	private ArrayList<JRadioButton> respostas = new ArrayList<JRadioButton>();
	private int qtdVidas;

	public void main(ArrayList<Integer> idPerguntas, int qtdVidas) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Jogar(idPerguntas, qtdVidas);
	}

	public Jogar(ArrayList<Integer> idPerguntas, int qtdVidas) {

		this.qtdVidas = qtdVidas;

		perguntasRestantes = idPerguntas;

		Map<String, String> pergunta = Perguntas.getPergunta(perguntasRestantes
				.get(0));

		lbVidas = new JLabel();
		lbId = new JLabel();
		lbTextoPergunta = new JLabel();
		lbRespostaCorreta = new JLabel();
		lbOpcao1 = new JLabel();
		lbOpcao2 = new JLabel();
		lbOpcao3 = new JLabel();

		lbVidas.setText("Vidas: " + Integer.toString(qtdVidas));
		lbId.setText("ID: " + pergunta.get("id_pergunta"));
		lbTextoPergunta.setText(pergunta.get("textoPergunta"));
		lbRespostaCorreta.setText(pergunta.get("respostaCorreta"));
		lbOpcao1.setText(pergunta.get("opcao1"));
		lbOpcao2.setText(pergunta.get("opcao2"));
		lbOpcao3.setText(pergunta.get("opcao3"));

		respostaCerta = pergunta.get("respostaCorreta");

		JRadioButton resposta1 = new JRadioButton(
				pergunta.get("respostaCorreta"));
		JRadioButton resposta2 = new JRadioButton(pergunta.get("opcao1"));
		JRadioButton resposta3 = new JRadioButton(pergunta.get("opcao2"));
		JRadioButton resposta4 = new JRadioButton(pergunta.get("opcao3"));

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(resposta1);
		bGroup.add(resposta2);
		bGroup.add(resposta3);
		bGroup.add(resposta4);

		respostas.add(resposta1);
		respostas.add(resposta2);
		respostas.add(resposta3);
		respostas.add(resposta4);

		ArrayList<JRadioButton> respostasEmbaralhadas = Embaralhador
				.montaListaRespostasEmbaralhadas(respostas);

		JPanel panelPergunta = new JPanel(new GridLayout(1, 3));
		panelPergunta.add(lbTextoPergunta);
		panelPergunta.add(lbId);
		panelPergunta.add(lbVidas);

		JPanel panelResposta = new JPanel(new GridLayout(4, 1));
		panelResposta.add(respostasEmbaralhadas.get(0));
		panelResposta.add(respostasEmbaralhadas.get(1));
		panelResposta.add(respostasEmbaralhadas.get(2));
		panelResposta.add(respostasEmbaralhadas.get(3));

		btResponder = new JButton("Responder");
		JPanel panelBotoes = new JPanel(new GridLayout(1, 2));
		panelBotoes.add(btResponder);

		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panelPergunta, BorderLayout.NORTH);
		this.getContentPane().add(panelResposta, BorderLayout.CENTER);
		this.getContentPane().add(panelBotoes, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pergunta");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		defineAcoesDosBotoes();

	}

	private void defineAcoesDosBotoes() {

		btResponder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				boolean acheiUmaCerta = false;

				for (JRadioButton option : respostas) {
					if (option.isSelected()
							&& option.getText().equalsIgnoreCase(respostaCerta)) {
						acheiUmaCerta = true;
						System.out.println("Parebéns! Resposta correta!");
						break;
					}
				}
				if (!acheiUmaCerta) {
					System.out
							.println("Seu burro! Resposta errada! Animal!!!!!!");
					qtdVidas--;
				}

				
				//Aqui que esta retirando o indice da pergunta
				perguntasRestantes.remove(0);

				if (perguntasRestantes.size() > 0 && qtdVidas > 0) {
					main(perguntasRestantes, qtdVidas);
				} else {
					new TelaInicial();
				}

			}
		});

	}

}
