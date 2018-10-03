package br.com.projsi.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projsi.dao.DaoException;
import br.com.projsi.dao.LivroDao;
import br.com.projsi.dao.UsuarioDao;
import br.com.projsi.models.Livro;
import br.com.projsi.models.Usuario;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class InterfaceLivroListar extends JFrame{
	
	private JTable table;
	private DefaultTableModel modelo;
	
	private LivroDao livDao;
	private InterfaceLivroCadastrar itfLivroCadastrar;
	
	public InterfaceLivroListar() {
		
		itfLivroCadastrar = new InterfaceLivroCadastrar();
		
		livDao = new LivroDao();
		
		setTitle("Library - 2017");
		setBounds(600, 200, 1024, 759);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCadastrarUsuario = new JPanel();
		panelCadastrarUsuario.setBackground(Color.WHITE);
		panelCadastrarUsuario.setLayout(null);
		panelCadastrarUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Livros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastrarUsuario.setBounds(44, 24, 923, 679);
		getContentPane().add(panelCadastrarUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 903, 558);
		panelCadastrarUsuario.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Titulo", "Editora", "Autor", "AnoEdição", "Idioma", "Preço", "Disponivel"}));
		scrollPane.setViewportView(table);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
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
		btnListar.setForeground(SystemColor.textHighlight);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnListar.setBounds(10, 20, 903, 50);
		panelCadastrarUsuario.add(btnListar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(798, 644, 115, 24);
		panelCadastrarUsuario.add(btnCancelar);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo = (DefaultTableModel) table.getModel();

				System.out.println(table.getSelectedRow());

				if (table.getSelectedRow() >= 0) {
					Long id = Long.parseLong( (String) modelo.getValueAt(table.getSelectedRow(), 0));
					Livro livro;
					try {
						livro = livDao.buscar(id);
						livDao.remover(livro);
						System.out.println(livro);
					} catch (DaoException e1) {
						JOptionPane.showMessageDialog(null, "Livro não Encontrado!");
					}
				}
			}
		});
		btnDeletar.setForeground(SystemColor.textHighlight);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeletar.setBounds(673, 644, 115, 24);
		panelCadastrarUsuario.add(btnDeletar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo = (DefaultTableModel) table.getModel();

				System.out.println(table.getSelectedRow());

				if (table.getSelectedRow() >= 0) {
					Long id = Long.parseLong( (String) modelo.getValueAt(table.getSelectedRow(), 0));
					Livro livro;
					try {
						livro = livDao.buscar(id);
						itfLivroCadastrar.setVisible(true);
						itfLivroCadastrar.carregarLivro(livro);
						System.out.println(livro);
					} catch (DaoException e1) {
						JOptionPane.showMessageDialog(null, "Livro não Encontrado!");
					}
				}
			}
		});
		btnEditar.setForeground(SystemColor.textHighlight);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBounds(544, 644, 115, 24);
		panelCadastrarUsuario.add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfaceLivroListar.class.getResource("/br/com/projsi/imagem/logo-library-main.png")));
		lblNewLabel.setBounds(0, 0, 1008, 730);
		getContentPane().add(lblNewLabel);
}
	
	public void carregarLivrosPorFiltro(List<Livro> livros) {

		System.out.println(livros.size());
		limparTabela();
		for (Livro l : livros) {
			addLinha(l);
		}
	}
	
	public void addLinha(Livro livro) {

		modelo = (DefaultTableModel) table.getModel();
		modelo.addRow(livro.getLinhaLivro());
	}

	public void limparTabela() {
		modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
	}
}
