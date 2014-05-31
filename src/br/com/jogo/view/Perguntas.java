package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Perguntas extends JFrame {
	public JButton btCadastrar, btEditar, btDeletar, btBuscar;
	public ImageIcon imgCadastrar, imgBuscar ,imgEditar;

	public Perguntas() {
		btCadastrar = new JButton("Cadastrar Perguntas");
		btEditar =  new JButton("Editar Perguntas");
		btBuscar = new JButton("Pesquisar Por Perguntas");
		
		imgCadastrar = new ImageIcon("img/inserir.png");
		imgEditar = new ImageIcon("img/editar.png");
		imgBuscar = new ImageIcon("img/buscar.png");
		
		btCadastrar.setIcon(imgCadastrar);
		btEditar.setIcon(imgEditar);
		btBuscar.setIcon(imgBuscar);
		
		JPanel panButtons = new JPanel(new GridLayout(3, 1));
		panButtons.add(btCadastrar);
		panButtons.add(btEditar);
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
				CadastrarPerguntas cadastroDePerguntas = new CadastrarPerguntas();
				cadastroDePerguntas.main(null);
				
			}
		});
		
		
		btBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Jogar", "Janela",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
			btEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Editar", "Janela",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Perguntas();
	}

}
