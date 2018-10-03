package br.com.projsi.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projsi.dao.DaoException;
import br.com.projsi.dao.LivroDao;
import br.com.projsi.models.Livro;
import br.com.projsi.models.Usuario;
import br.com.projsi.utils.Constantes;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class InterfaceLivroCadastrar extends JFrame{
	
	
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfPreco;
	private JTextField tfEditora;
	private JComboBox cbAno;
	private JComboBox cbIdioma;
	private Livro livro;
	private LivroDao livDao;

	public InterfaceLivroCadastrar() {
		
		livDao = new LivroDao();
		
		setBounds(600, 200, 1024, 759);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelCadastrarUsuario = new JPanel();
		panelCadastrarUsuario.setBackground(Color.WHITE);
		panelCadastrarUsuario.setLayout(null);
		panelCadastrarUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de Livro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastrarUsuario.setBounds(44, 24, 923, 679);
		getContentPane().add(panelCadastrarUsuario);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(70, 65, 390, 24);
		panelCadastrarUsuario.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNome.setText("T\u00EDtulo:");
		txtrNome.setBounds(10, 63, 60, 22);
		panelCadastrarUsuario.add(txtrNome);
		
		JTextArea txtrNmeroDoDocumento = new JTextArea();
		txtrNmeroDoDocumento.setText("Autor:");
		txtrNmeroDoDocumento.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNmeroDoDocumento.setBounds(477, 132, 60, 24);
		panelCadastrarUsuario.add(txtrNmeroDoDocumento);
		
		JTextArea txtrDataDeNascimento = new JTextArea();
		txtrDataDeNascimento.setText("Pre\u00E7o:");
		txtrDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrDataDeNascimento.setBounds(477, 63, 60, 20);
		panelCadastrarUsuario.add(txtrDataDeNascimento);
		
		JTextArea txtrContato = new JTextArea();
		txtrContato.setText("Idioma:");
		txtrContato.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrContato.setBounds(10, 196, 66, 31);
		panelCadastrarUsuario.add(txtrContato);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(542, 134, 371, 24);
		panelCadastrarUsuario.add(tfAutor);
		
		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(542, 65, 371, 24);
		panelCadastrarUsuario.add(tfPreco);
		
		JTextArea txtrBairro = new JTextArea();
		txtrBairro.setText("Editora:");
		txtrBairro.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrBairro.setBounds(10, 132, 66, 20);
		panelCadastrarUsuario.add(txtrBairro);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					if (livro == null) {
						livro = new Livro();
					}
					
					livro.setTitulo(tfTitulo.getText());
					livro.setAutor(tfAutor.getText());
					livro.setEditora(tfEditora.getText());
					livro.setPreco(Double.parseDouble((tfPreco.getText())));
					livro.setIdioma((String) cbIdioma.getSelectedItem());
					livro.setAnoEdicao((String) cbAno.getSelectedItem());
					livro.setDisponivel(true);
					
					try {
						validarLivro(livro);
						System.out.println(livro);
						if(livro.getId() == null){
							livDao.cadastrar(livro);
						}else {
							livDao.editar(livro);
						}
						JOptionPane.showMessageDialog(InterfaceLivroCadastrar.this, "Livro Cadastrado com Sucesso!");
						limparCamposLivro();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		btnSalvar.setForeground(SystemColor.textHighlight);
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(633, 637, 135, 24);
		panelCadastrarUsuario.add(btnSalvar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(778, 637, 135, 24);
		panelCadastrarUsuario.add(btnCancelar);
		
		tfEditora = new JTextField();
		tfEditora.setColumns(10);
		tfEditora.setBounds(83, 134, 377, 24);
		panelCadastrarUsuario.add(tfEditora);
		
		cbIdioma = new JComboBox();
		cbIdioma.setModel(new DefaultComboBoxModel(Constantes.NACIONALIDADE));
		cbIdioma.setBounds(83, 200, 179, 20);
		panelCadastrarUsuario.add(cbIdioma);
		
		JTextArea txtrAnoDaEdio = new JTextArea();
		txtrAnoDaEdio.setText("Ano:");
		txtrAnoDaEdio.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrAnoDaEdio.setBounds(477, 196, 42, 31);
		panelCadastrarUsuario.add(txtrAnoDaEdio);
		
		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(Constantes.ANOS));
		cbAno.setBounds(529, 200, 81, 20);
		panelCadastrarUsuario.add(cbAno);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfaceLivroCadastrar.class.getResource("/br/com/projsi/imagem/logo-library-main.png")));
		lblNewLabel.setBounds(0, 0, 1008, 730);
		getContentPane().add(lblNewLabel);
}
	private void limparCamposLivro() {

		tfTitulo.setText("");
		tfEditora.setText("");
		tfAutor.setText("");
		tfPreco.setText("");
		cbAno.setSelectedItem(Constantes.SELECIONE);
		cbIdioma.setSelectedItem(Constantes.SELECIONE);
	}

	public void validarLivro(Livro l) throws Exception {

		tfTitulo.setBorder(new LineBorder(new Color(0, 100, 0)));
		if (l.getTitulo().split(" ").length < 1) {
			tfTitulo.setBorder(new LineBorder(Color.RED));
			throw new Exception("Titulo deve ser Informado!");
		}
	}

	public void carregarLivro(Livro l) {
		this.livro = l;
		tfTitulo.setText(l.getTitulo());
		tfEditora.setText(l.getEditora());
		tfPreco.setText(String.valueOf(l.getPreco()));
		tfAutor.setText(l.getAutor());
		cbAno.setSelectedItem(l.getAnoEdicao());
		cbIdioma.setSelectedItem(l.getIdioma());
	}
}
