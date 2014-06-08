package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jogo.model.Jogador;

public class TelaSalvarPontos extends JFrame {
	
private static final long serialVersionUID = 1L;
	
	public JButton btSalvar, btLimpar;
	public JTextField fieldNome;
	public JLabel lbNome;
	private int pontos;

	public TelaSalvarPontos(int pts) {

		pontos = pts;
		
		lbNome = new JLabel("Digite o seu Nome: ");

		fieldNome = new JTextField();

		JPanel questaoGrid = new JPanel(new GridLayout(1, 2));

		questaoGrid.add(lbNome);
		questaoGrid.add(fieldNome);

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
		this.setTitle("Ranking");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		botoesTelaRanking();
	}

	private void botoesTelaRanking() {
		
		btSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String nome = fieldNome.getText();	
				if(Jogador.inserePontosDoJogador(nome, pontos)){
					new Ranking();					
				}
			}
		});

		btLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpaCampoCadastroPerguntas();

			}
		});

	}

	private void limpaCampoCadastroPerguntas() {
		fieldNome.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new TelaSalvarPontos(20);
	}

}
