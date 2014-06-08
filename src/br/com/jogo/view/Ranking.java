package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.jogo.model.Jogador;

public class Ranking extends JFrame {
	
private static final long serialVersionUID = 1L;
	
	public JButton btnVoltar;

	public Ranking() {
		
		List<Map<String,String>> ranking = Jogador.buscarRanking();
		
		JPanel rankingPanel = new JPanel(new GridLayout(ranking.size(), 2));
		
		for (Map<String, String> map : ranking) {
			JLabel columnName = new JLabel("Nome: " + map.get("nome"));
			JLabel columnPonto = new JLabel("Pontos: " + map.get("pontos"));
			rankingPanel.add(columnName);
			rankingPanel.add(columnPonto);
		}

		btnVoltar = new JButton("Voltar");

		JPanel painelButton = new JPanel(new GridLayout(0, 2));
		painelButton.add(btnVoltar);

		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(rankingPanel, BorderLayout.NORTH);
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
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				new TelaInicial();
				dispose();
			}
		});

	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Ranking();
	}

}
