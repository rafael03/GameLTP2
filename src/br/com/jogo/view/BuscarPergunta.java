package br.com.jogo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	Vector cabecalho = new Vector(); // declara cabecalho como um objeto
	// do tipo vetor
	Vector linhas = new Vector(); // · armazena todas as linhas que vão

	// compor a tabela

	public BuscarPergunta() throws SQLException {
		lbBuscar = new JLabel("Digite o ID da questão: ");
		fieldBuscar = new JTextField();
		btBuscar = new JButton("Buscar por ID");

		JPanel panButtons = new JPanel(new GridLayout(1, 3));
		panButtons.add(lbBuscar);
		panButtons.add(fieldBuscar);
		panButtons.add(btBuscar);

		ResultSet res = Perguntas.buscaTabela();
		ResultSetMetaData rsmd = res.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); ++i)
			cabecalho.addElement(rsmd.getColumnName(i));
		// busca dados das linhas
		do {
			linhas.addElement(proximaLinha(res, rsmd));
		} while (res.next());
		// Mostra a tabela com cabeçalhos e registros
		final JTable tab = new JTable(linhas, cabecalho);
		JScrollPane scroller = new JScrollPane(tab);
		getContentPane().add(scroller, BorderLayout.CENTER);
		validate();
		// st.close();

		tab.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						// do some actions here, for example
						// print first column value from selected row
						System.out.println(tab.getValueAt(tab.getSelectedRow(),
								0).toString());
					}
				});
		// JTable jtable = new JTable(dados, colunas);
		JPanel panTable = new JPanel(new GridLayout(1, 1));
		panTable.add(tab);

		// painel do JFrame
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panButtons, BorderLayout.NORTH);
		this.getContentPane().add(panTable, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Buscar Perguntas");
		this.setSize(600, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// botoesNaTelaPergunta();

	}

	private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
		Vector LinhaAtual = new Vector();

		try {
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				System.out.println(rsmd.getColumnType(i));
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
		}
		return LinhaAtual;

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Tela de perguntas");
		JFrame.setDefaultLookAndFeelDecorated(true);
		new BuscarPergunta();
	}

}
