package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.jogo.model.Perguntas;

public class BuscarPergunta extends JFrame {

	/**
	 * @param args
	 */
	private static final long serialVersionUID = 1L;
	public JButton btEditar, btDeletar, btBuscar;
	public JTextField fieldBuscar;
	public JLabel lbBuscar;
	public JTable tab;
	boolean pesquisarPorId;
	Vector cabecalho = new Vector();
	Vector linhas = new Vector();


	public BuscarPergunta() throws SQLException {
		lbBuscar = new JLabel("Digite o ID da questão: ");
		fieldBuscar = new JTextField();
		btBuscar = new JButton("Buscar por ID");

		JPanel panButtons = new JPanel(new GridLayout(1, 3));
		panButtons.add(lbBuscar);
		panButtons.add(fieldBuscar);
		panButtons.add(btBuscar);

		montaTabelaDeAcordoComABusca(pesquisarPorId);
		btBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pesquisarPorId = true;
				try {
					montaTabelaDeAcordoComABusca(pesquisarPorId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
			}
		});


		tab = new JTable(linhas, cabecalho);
		// Adiciona a Tabela no layout
		JPanel panTable = new JPanel(new GridLayout(1, 1));
		panTable.add(tab);
		// Chama Metodo responsavel pelo efeito ao clicar em uma <TR> (Linha)

		// Configurações do Layout
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panButtons, BorderLayout.NORTH);
		this.getContentPane().add(panTable, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Buscar Perguntas");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		efeitoAoClicarNaLinha();
	}

	//Monta tabela de acordo com a busca
	private void montaTabelaDeAcordoComABusca(boolean pesquisarPorId) throws SQLException {
		if (pesquisarPorId) {
			ResultSet valoresDoBanco = null;
			String strIdParaBusca = fieldBuscar.getText();
			valoresDoBanco = Perguntas.buscaPorId(strIdParaBusca);
			montaTabela(valoresDoBanco);
		} else {
			ResultSet valoresDoBanco = Perguntas.buscaTabela();
			montaTabela(valoresDoBanco);
		}
	}
	// Monta a Tabela
	private void montaTabela(ResultSet valoresDoBanco) throws SQLException {
		cabecalho.clear();
		linhas.clear();
		ResultSetMetaData tabelaDoBanco = valoresDoBanco.getMetaData();

		for (int i = 1; i <= tabelaDoBanco.getColumnCount(); ++i)
			cabecalho.addElement(tabelaDoBanco.getColumnName(i));
		
		do {
			linhas.addElement(proximaLinha(valoresDoBanco, tabelaDoBanco));
		} while (valoresDoBanco.next());
		// Mostra a tabela com cabeçalhos e registros

		JScrollPane scroller = new JScrollPane(tab);
		getContentPane().add(scroller, BorderLayout.CENTER);
		validate();

	}

	// Metodo responsavel pelo clique na linha da tabela
	private void efeitoAoClicarNaLinha() {
		// TODO Auto-generated method stub
		tab.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						String id_ = tab.getValueAt(tab.getSelectedRow(), 0)
								.toString();
						String pergunta_ = tab.getValueAt(tab.getSelectedRow(),
								1).toString();
						String respostaCerta_ = tab.getValueAt(
								tab.getSelectedRow(), 2).toString();
						String opcao1_ = tab
								.getValueAt(tab.getSelectedRow(), 3).toString();
						String opcao2_ = tab
								.getValueAt(tab.getSelectedRow(), 4).toString();
						String opcao3_ = tab
								.getValueAt(tab.getSelectedRow(), 5).toString();

						updateOrDeletePergunta(id_, pergunta_, respostaCerta_,
								opcao1_, opcao2_, opcao3_);
						System.out
								.println("Linha Selecionada (efeitoAoClicarNaLinha)>>"
										+ tab.getValueAt(tab.getSelectedRow(),
												0).toString());
					}
				});
	}

	private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
		// Metodo que cria as <TR> da tabela inserindo os seus devidos valores
		Vector LinhaAtual = new Vector();

		try {
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				switch (rsmd.getColumnType(i)) {
				case Types.INTEGER:
					LinhaAtual.addElement(rs.getInt(i));
					break;
				case Types.VARCHAR:
					LinhaAtual.addElement(rs.getString(i));
					break;
				case Types.TIMESTAMP:
					LinhaAtual.addElement(rs.getDate(i));
					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("Erro (proximaLinha): " + e);
		}
		return LinhaAtual;

	}

	private void updateOrDeletePergunta(String id_, String pergunta_,
			String respostaCerta_, String opcao1_, String opcao2_,
			String opcao3_) {
		// TODO Auto-generated method stub
		Object[] options = { "Editar", "Deletar" };
		int n = JOptionPane.showOptionDialog(null, "Escolha a opção desejada:",
				"Gerenciador de Perguntas", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.DEFAULT_OPTION, null, options, options[1]);
		JFrame metric = new JFrame("Editar");
		JFrame imperial = new JFrame("Deletar");
		if (n == 0) {
			// metric.setVisible(true);
			EdicaoDePerguntas.main(id_, pergunta_, respostaCerta_, opcao1_,
					opcao2_, opcao3_);
		} else if (n == 1) {
			Perguntas.deletarPergunta(id_);
			try {
				main(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("no option choosen");
		}
	}

	public static void main(String[] args) throws SQLException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new BuscarPergunta();
	}

}
