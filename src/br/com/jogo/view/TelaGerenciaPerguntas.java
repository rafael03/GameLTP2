package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaGerenciaPerguntas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JButton btCadastrar, btDeletar, btBuscar;
	public ImageIcon imgCadastrar, imgBuscar ,imgEditar;

	public TelaGerenciaPerguntas() {
		btCadastrar = new JButton("Cadastrar Perguntas");
		btBuscar = new JButton("Pesquisar Por Perguntas");
		
		imgCadastrar = new ImageIcon("img/inserir.png");
		imgBuscar = new ImageIcon("img/buscar.png");
		
		btCadastrar.setIcon(imgCadastrar);
		btBuscar.setIcon(imgBuscar);
		
		JPanel panButtons = new JPanel(new GridLayout(2, 1));
		panButtons.add(btCadastrar);
		panButtons.add(btBuscar);		
		

		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panButtons, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gerencia de Perguntas");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		botoesNaTelaPergunta();
	}

	private void botoesNaTelaPergunta() {
		btCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Chama a tela de cadastro de perguntas
				TelaCadastroPerguntas.main(null);
				
			}
		});
		
		
		btBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "Jogar", "Janela", JOptionPane.INFORMATION_MESSAGE);
				try {
					BuscarPergunta.main(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new TelaGerenciaPerguntas();
	}

}
