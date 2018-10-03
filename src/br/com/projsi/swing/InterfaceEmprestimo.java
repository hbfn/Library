package br.com.projsi.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

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
import java.util.List;
import java.awt.event.ActionEvent;

public class InterfaceEmprestimo extends JFrame {
	
	private JTable table1;
	private JTable table2;
	private DefaultTableModel modelo;
	
	private Usuario usuario;
	private Livro livro;
	private Emprestimo emprestimo;
	
	private LivroDao livDao;
	private UsuarioDao usuDao;
	private EmprestimoDao empDao;
	
	private JTextField tfData;
	private JTextField tfDataEntrega;
	
	
	public InterfaceEmprestimo() {
		
		empDao = new EmprestimoDao();
		usuDao = new UsuarioDao();
		livDao = new LivroDao();
		
		setTitle("Library - 2017");
		setBounds(600, 200, 1024, 759);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelEmprestimo = new JPanel();
		panelEmprestimo.setBackground(Color.WHITE);
		panelEmprestimo.setLayout(null);
		panelEmprestimo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Usuários", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEmprestimo.setBounds(44, 24, 923, 679);
		getContentPane().add(panelEmprestimo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 903, 170);
		panelEmprestimo.add(scrollPane);
		
		MaskFormatter mascaradata = null;
		try {
			 mascaradata = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		table1 = new JTable();
		table1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {  "Id", "Nome", "Sexo", "DtNasc", "Nacionalidade", "TipoDocumento", "NumeroDocumento", "Contato", "Contato2", "Cidade", "Bairro", "Rua", "Cep", "Numero", "Complemento", "Estado", "Status"}));
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 344, 903, 148);
		panelEmprestimo.add(scrollPane2);
		
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
		btnListar.setBounds(10, 93, 442, 24);
		panelEmprestimo.add(btnListar);
		
		JButton btnEditar = new JButton("CANCELAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnEditar.setForeground(SystemColor.textHighlight);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBounds(798, 644, 115, 24);
		panelEmprestimo.add(btnEditar);
		
		JButton btnSavar = new JButton("SALVAR");
		btnSavar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuario = new Usuario();
				livro = new Livro();
				emprestimo = new Emprestimo();
				
				modelo = (DefaultTableModel) table1.getModel();

				System.out.println(table1.getSelectedRow());

				if (table1.getSelectedRow() >= 0) {
					Long id1 = Long.parseLong( (String) modelo.getValueAt(table1.getSelectedRow(), 0));
			
				modelo = (DefaultTableModel) table2.getModel();

				System.out.println(table2.getSelectedRow());

				if (table2.getSelectedRow() >= 0) {
					Long id2 = Long.parseLong( (String) modelo.getValueAt(table1.getSelectedRow(), 0));
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
					String dt = tfData.getText();
					String dt2 = tfDataEntrega.getText();
					
					try {
						emprestimo.setData(format.parse(dt));
						emprestimo.setDataEntrega(format.parse(dt2));
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao inserir data!");
					}
				
					try {
					usuario = usuDao.buscar(id1);
					emprestimo.setUsuario(usuario);
					livro = livDao.buscar(id2);
					livro.setDisponivel(false);
					emprestimo.setLivro(livro);
					empDao.cadastrarEmprestimo(emprestimo);
					System.out.println(emprestimo);
				} catch (DaoException e1) {
					JOptionPane.showMessageDialog(null, "Usuário não Encontrado!");
				}
			}
			}
		}
		});
		btnSavar.setForeground(SystemColor.textHighlight);
		btnSavar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSavar.setBounds(673, 644, 115, 24);
		panelEmprestimo.add(btnSavar);
		
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
		btnListar_1.setBounds(10, 309, 442, 24);
		panelEmprestimo.add(btnListar_1);
		
		JButton btnAdicionarUsurio = new JButton("ADICIONAR USU\u00C1RIO");
		btnAdicionarUsurio.setForeground(SystemColor.textHighlight);
		btnAdicionarUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarUsurio.setBounds(462, 93, 451, 24);
		panelEmprestimo.add(btnAdicionarUsurio);
		
		JButton btnAdicionarLivro_1 = new JButton("ADICIONAR LIVRO");
		btnAdicionarLivro_1.setForeground(SystemColor.textHighlight);
		btnAdicionarLivro_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionarLivro_1.setBounds(462, 309, 451, 24);
		panelEmprestimo.add(btnAdicionarLivro_1);
		
		tfData = new JFormattedTextField(mascaradata);
		tfData.setBounds(65, 38, 387, 20);
		panelEmprestimo.add(tfData);
		tfData.setColumns(10);
		
		tfDataEntrega = new JFormattedTextField(mascaradata);
		tfDataEntrega.setBounds(609, 38, 304, 20);
		panelEmprestimo.add(tfDataEntrega);
		tfDataEntrega.setColumns(10);
		
		JTextArea txtrData = new JTextArea();
		txtrData.setText("Data:");
		txtrData.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrData.setBounds(10, 34, 60, 22);
		panelEmprestimo.add(txtrData);
		
		JTextArea txtrDataDaEntrega = new JTextArea();
		txtrDataDaEntrega.setText("Data da Entrega:");
		txtrDataDaEntrega.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrDataDaEntrega.setBounds(462, 36, 148, 22);
		panelEmprestimo.add(txtrDataDaEntrega);
		
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
	
	public void addLinha(Livro livro) {

		modelo = (DefaultTableModel) table2.getModel();
		modelo.addRow(livro.getLinhaLivro());
	}
	
	public void limparTabelaUsuario() {
		modelo = (DefaultTableModel) table1.getModel();
		modelo.setNumRows(0);
	}
	
	public void limparTabelaLivro() {
		modelo = (DefaultTableModel) table2.getModel();
		modelo.setNumRows(0);
	}
}
