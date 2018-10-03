package br.com.projsi.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projsi.dao.DaoException;
import br.com.projsi.dao.EmprestimoDao;
import br.com.projsi.dao.LivroDao;
import br.com.projsi.dao.UsuarioDao;
import br.com.projsi.models.Emprestimo;
import br.com.projsi.models.Livro;
import br.com.projsi.models.Usuario;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class InterfaceDevolucao extends JFrame{
	
	private JTable table1;
	private JTable table2;
	private JTable table3;
	
	private DefaultTableModel modelo;
	
	private LivroDao livDao;
	private UsuarioDao usuDao;
	private EmprestimoDao empDao;
	
	private Livro livro;
	private Emprestimo emprestimo;
	
	public InterfaceDevolucao() {
		
		usuDao = new UsuarioDao();
		livDao = new LivroDao();
		empDao = new EmprestimoDao();
		
		setTitle("Library - 2017");
		setBounds(600, 200, 1024, 759);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelDevolucao = new JPanel();
		panelDevolucao.setBackground(Color.WHITE);
		panelDevolucao.setLayout(null);
		panelDevolucao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Usuários", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDevolucao.setBounds(44, 24, 923, 679);
		getContentPane().add(panelDevolucao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 903, 182);
		panelDevolucao.add(scrollPane);

		table1 = new JTable();
		table1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Sexo", "DtNasc", "Nacionalidade", "TipoDocumento", "NumeroDocumento", "Contato", "Contato2", "Cidade", "Bairro", "Rua", "Cep", "Numero", "Complemento", "Estado", "Status"}));
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 285, 903, 182);
		panelDevolucao.add(scrollPane2);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Titulo", "Editora", "Autor", "AnoEdição", "Idioma", "Preço", "Disponivel"}));
		scrollPane2.setViewportView(table2);
		
		JButton btnListar = new JButton("LISTAR USU\u00C1RIOS");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Usuario> usuarios;
				try {
					usuarios = usuDao.listar();
					carregarUsuariosPorFiltro(usuarios);
				} catch (DaoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnListar.setForeground(SystemColor.textHighlight);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListar.setBounds(10, 20, 903, 24);
		panelDevolucao.add(btnListar);
		
		JButton btnEditar = new JButton("CANCELAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnEditar.setForeground(SystemColor.textHighlight);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBounds(798, 644, 115, 24);
		panelDevolucao.add(btnEditar);
		
		JButton btnSavar = new JButton("DEVOLVER");
		btnSavar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				livro = new Livro();
				emprestimo = new Emprestimo();
				
				modelo = (DefaultTableModel) table2.getModel();

				System.out.println(table2.getSelectedRow());

				if (table2.getSelectedRow() >= 0) {
					Long id2 = Long.parseLong( (String) modelo.getValueAt(table2.getSelectedRow(), 0));
			
				modelo = (DefaultTableModel) table3.getModel();

				System.out.println(table3.getSelectedRow());

				if (table3.getSelectedRow() >= 0) {
					Long id3 = Long.parseLong( (String) modelo.getValueAt(table3.getSelectedRow(), 0));

					try {
					emprestimo = empDao.buscar(id3);
					empDao.remover(emprestimo);
					livro = livDao.buscar(id2);
					livro.setDisponivel(true);
				} catch (DaoException e1) {
					JOptionPane.showMessageDialog(null, "Algo está errado!");
				}
			}
			}
			}
		});
		btnSavar.setForeground(SystemColor.textHighlight);
		btnSavar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSavar.setBounds(673, 644, 115, 24);
		panelDevolucao.add(btnSavar);
		
		JButton btnListar_1 = new JButton("LISTAR LIVROS");
		btnListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Livro> livros;
				try {
					livros = livDao.listar();
					carregarLivrosPorFiltro(livros);
				} catch (DaoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnListar_1.setForeground(SystemColor.textHighlight);
		btnListar_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListar_1.setBounds(10, 250, 903, 24);
		panelDevolucao.add(btnListar_1);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(10, 508, 903, 125);
		panelDevolucao.add(scrollPane3);
		
		table3 = new JTable();
		table3.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Data", "Data da Entrega","Id Usuario", "Id Livro"}));
		scrollPane3.setViewportView(table3);
		
		JButton btnListarEmprestimo = new JButton("LISTAR EMPR\u00C9STIMOS");
		btnListarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Emprestimo> emprestimos;
				try {
					emprestimos = empDao.listar();
					carregarEmprestimosPorFiltro(emprestimos);
				} catch (DaoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnListarEmprestimo.setForeground(SystemColor.textHighlight);
		btnListarEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarEmprestimo.setBounds(10, 478, 903, 24);
		panelDevolucao.add(btnListarEmprestimo);
		
		JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel.setIcon(new ImageIcon(InterfaceUsuarioListar.class.getResource("/br/com/projsi/imagem/logo-library-main.png")));
		lblNewLabel.setBounds(0, 0, 1008, 730);
		getContentPane().add(lblNewLabel);
}
	
	public void carregarUsuariosPorFiltro(List<Usuario> usuarios) {

		System.out.println(usuarios.size());
		limparTabelaUsuario();
		for (Usuario u : usuarios) {
			addLinha(u);
		}
	}
	
	public void addLinha(Usuario usuario) {

		modelo = (DefaultTableModel) table1.getModel();
		modelo.addRow(usuario.getLinhaUsuario());
	}
	
	public void carregarLivrosPorFiltro(List<Livro> livros) {

		System.out.println(livros.size());
		limparTabelaLivro();
		for (Livro l : livros) {
			addLinha(l);
		}
	}
	
	public void carregarEmprestimosPorFiltro(List<Emprestimo> emprestimos) {

		System.out.println(emprestimos.size());
		limparTabelaEmprestimo();
		for (Emprestimo emp : emprestimos) {
			addLinha(emp);
		}
	}
	
	public void addLinha(Emprestimo emprestimo) {

		modelo = (DefaultTableModel) table3.getModel();
		modelo.addRow(emprestimo.getLinhaEmprestimo());
	}
	
	public void addLinha(Livro livro) {

		modelo = (DefaultTableModel) table2.getModel();
		modelo.addRow(livro.getLinhaLivro());
	}
	
	public void limparTabelaUsuario() {
		modelo = (DefaultTableModel) table1.getModel();
		modelo.setNumRows(0);
	}
	
	public void limparTabelaEmprestimo() {
		modelo = (DefaultTableModel) table3.getModel();
		modelo.setNumRows(0);
	}
	
	public void limparTabelaLivro() {
		modelo = (DefaultTableModel) table2.getModel();
		modelo.setNumRows(0);
	}
}
