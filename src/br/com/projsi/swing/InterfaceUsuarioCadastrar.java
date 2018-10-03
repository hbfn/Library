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
import javax.swing.text.MaskFormatter;

import br.com.projsi.dao.DaoException;
import br.com.projsi.dao.UsuarioDao;
import br.com.projsi.models.Usuario;
import br.com.projsi.utils.Constantes;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;

public class InterfaceUsuarioCadastrar extends JFrame{
	
	
	private JTextField tfNome;
	private JTextField tfNumeroDocumento;
	private JTextField tfDataNasc;
	private JTextField tfBairro;
	private JTextField tfRua;
	private JTextField tfCidade;
	private JTextField tfNumero;
	private JTextField tfCep;
	private JTextField tfContato;
	private JTextField tfContato2;
	private JTextField tfComplemento;
	private JComboBox cbTipoDocumento;
	private JComboBox cbSexo;
	private JComboBox cbNacionalidade;
	private JComboBox cbEstado;
	
	private UsuarioDao usuDao;
	private Usuario usuario;
	
	private JButton btnSalvar;
	private JButton btnCancelar;

	public InterfaceUsuarioCadastrar() {
		
		usuDao = new UsuarioDao();
		
		setBounds(600, 200, 1024, 768);
		setTitle("Library - 2017");
		getContentPane().setLayout(null);
		
		JPanel panelCadastrarUsuario = new JPanel();
		panelCadastrarUsuario.setBackground(Color.WHITE);
		panelCadastrarUsuario.setLayout(null);
		panelCadastrarUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de Usuário", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastrarUsuario.setBounds(44, 24, 923, 679);
		getContentPane().add(panelCadastrarUsuario);
		
		MaskFormatter mascaracpf = null;
		try {
			 mascaracpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MaskFormatter mascaracnpj = null;
		try {
			 mascaracnpj = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MaskFormatter mascaracep = null;
		try {
			 mascaracep = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MaskFormatter mascaradata = null;
		try {
			 mascaradata = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfNome = new JTextField();
		tfNome.setBounds(70, 65, 390, 24);
		panelCadastrarUsuario.add(tfNome);
		tfNome.setColumns(10);
		
		JTextArea txtrNome = new JTextArea();
		txtrNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNome.setText("Nome:");
		txtrNome.setBounds(10, 63, 60, 22);
		panelCadastrarUsuario.add(txtrNome);
		
		JTextArea txtrCpf = new JTextArea();
		txtrCpf.setText("Tipo de Documento:");
		txtrCpf.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrCpf.setBounds(10, 130, 168, 31);
		panelCadastrarUsuario.add(txtrCpf);
		
		JTextArea txtrNmeroDoDocumento = new JTextArea();
		txtrNmeroDoDocumento.setText("N\u00FAmero do Documento:");
		txtrNmeroDoDocumento.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNmeroDoDocumento.setBounds(10, 198, 198, 24);
		panelCadastrarUsuario.add(txtrNmeroDoDocumento);
		
		JTextArea txtrDataDeNascimento = new JTextArea();
		txtrDataDeNascimento.setText("Data de Nascimento:");
		txtrDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrDataDeNascimento.setBounds(477, 63, 174, 20);
		panelCadastrarUsuario.add(txtrDataDeNascimento);
		
		JTextArea txtrSexo = new JTextArea();
		txtrSexo.setText("Sexo:");
		txtrSexo.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrSexo.setBounds(477, 130, 50, 20);
		panelCadastrarUsuario.add(txtrSexo);
		
		JTextArea txtrContato_1 = new JTextArea();
		txtrContato_1.setText("Contato:");
		txtrContato_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrContato_1.setBounds(477, 273, 75, 20);
		panelCadastrarUsuario.add(txtrContato_1);
		
		JTextArea txtrContato = new JTextArea();
		txtrContato.setText("Contato:");
		txtrContato.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrContato.setBounds(475, 198, 77, 31);
		panelCadastrarUsuario.add(txtrContato);
		
		tfNumeroDocumento = new JFormattedTextField(mascaracpf);
		tfNumeroDocumento.setColumns(10);
		tfNumeroDocumento.setBounds(208, 200, 259, 24);
		panelCadastrarUsuario.add(tfNumeroDocumento);
		
	
		tfDataNasc = new JFormattedTextField(mascaradata);
		tfDataNasc.setColumns(10);
		tfDataNasc.setBounds(653, 65, 260, 24);
		panelCadastrarUsuario.add(tfDataNasc);
		
		JTextArea txtrBairro = new JTextArea();
		txtrBairro.setText("Bairro:");
		txtrBairro.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrBairro.setBounds(10, 273, 60, 20);
		panelCadastrarUsuario.add(txtrBairro);
		
		JTextArea txtrRua = new JTextArea();
		txtrRua.setText("Rua:");
		txtrRua.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrRua.setBounds(10, 344, 42, 20);
		panelCadastrarUsuario.add(txtrRua);
		
		JTextArea txtrCidade = new JTextArea();
		txtrCidade.setText("Cidade:");
		txtrCidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrCidade.setBounds(10, 413, 66, 20);
		panelCadastrarUsuario.add(txtrCidade);
		
		JTextArea txtrEstado = new JTextArea();
		txtrEstado.setText("Estado:");
		txtrEstado.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrEstado.setBounds(10, 484, 66, 20);
		panelCadastrarUsuario.add(txtrEstado);
		
		JTextArea txtrNmero = new JTextArea();
		txtrNmero.setText("N\u00FAmero:");
		txtrNmero.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNmero.setBounds(10, 553, 71, 20);
		panelCadastrarUsuario.add(txtrNmero);
		
		JTextArea txtrCep = new JTextArea();
		txtrCep.setText("Cep:");
		txtrCep.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrCep.setBounds(10, 621, 42, 20);
		panelCadastrarUsuario.add(txtrCep);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(70, 275, 397, 24);
		panelCadastrarUsuario.add(tfBairro);
		
		tfRua = new JTextField();
		tfRua.setColumns(10);
		tfRua.setBounds(53, 346, 414, 24);
		panelCadastrarUsuario.add(tfRua);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(77, 415, 390, 24);
		panelCadastrarUsuario.add(tfCidade);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(83, 555, 384, 24);
		panelCadastrarUsuario.add(tfNumero);
		
		tfCep = new JFormattedTextField(mascaracep);
		tfCep.setColumns(10);
		tfCep.setBounds(53, 623, 414, 24);
		panelCadastrarUsuario.add(tfCep);
		
		tfContato = new JTextField();
		tfContato.setColumns(10);
		tfContato.setBounds(555, 198, 358, 24);
		panelCadastrarUsuario.add(tfContato);
		
		tfContato2 = new JTextField();
		tfContato2.setColumns(10);
		tfContato2.setBounds(555, 273, 358, 24);
		panelCadastrarUsuario.add(tfContato2);
		
		JTextArea txtrNacionalidade = new JTextArea();
		txtrNacionalidade.setText("Nacionalidade:");
		txtrNacionalidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrNacionalidade.setBounds(477, 413, 125, 20);
		panelCadastrarUsuario.add(txtrNacionalidade);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (usuario == null) {
					usuario = new Usuario();
				}
				usuario.setNome(tfNome.getText());
				usuario.setNumeroDocumento(tfNumeroDocumento.getText());
				usuario.setTipoDocumento((String) cbTipoDocumento.getSelectedItem());
				usuario.getEndereco().setNacionalidade((String) cbNacionalidade.getSelectedItem());
				usuario.getContato().setContato(tfContato.getText());
				usuario.getContato().setContato2(tfContato2.getText());
				usuario.getEndereco().setCidade(tfCidade.getText());
				usuario.getEndereco().setCep(tfCep.getText());
				usuario.getEndereco().setBairro(tfBairro.getText());
				usuario.getEndereco().setRua(tfRua.getText());
				usuario.getEndereco().setComplemento(tfComplemento.getText());
				usuario.setSexo((String) cbSexo.getSelectedItem());
				usuario.getEndereco().setNumero(tfNumero.getText());
				usuario.getEndereco().setEstado((String) cbEstado.getSelectedItem());
				usuario.setStatus(true);
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
				String dt = tfDataNasc.getText();
				try {
					usuario.setNascimento(format.parse(dt));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					validarUsuario(usuario);
					System.out.println(usuario);
					if(usuario.getId() == null){
						usuDao.cadastrar(usuario);
					} else {
						usuDao.editar(usuario);
					}
					JOptionPane.showMessageDialog(InterfaceUsuarioCadastrar.this, "Usuário Salvo com Sucesso!");
					limparCampos();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setForeground(SystemColor.textHighlight);
		btnSalvar.setActionCommand("Salvar Evento");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(633, 644, 135, 24);
		panelCadastrarUsuario.add(btnSalvar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(778, 644, 135, 24);
		panelCadastrarUsuario.add(btnCancelar);
		
		cbTipoDocumento = new JComboBox();
		cbTipoDocumento.setModel(new DefaultComboBoxModel(Constantes.TP_DOCUMENTO));
		cbTipoDocumento.setBounds(180, 134, 95, 20);
		panelCadastrarUsuario.add(cbTipoDocumento);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(Constantes.TP_SEXO));
		cbSexo.setBounds(537, 134, 95, 20);
		panelCadastrarUsuario.add(cbSexo);
		
		cbNacionalidade = new JComboBox();
		cbNacionalidade.setModel(new DefaultComboBoxModel(Constantes.NACIONALIDADE));
		cbNacionalidade.setBounds(602, 413, 216, 20);
		panelCadastrarUsuario.add(cbNacionalidade);
		
		cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(Constantes.ESTADO));
		cbEstado.setBounds(80, 488, 184, 20);
		panelCadastrarUsuario.add(cbEstado);
		
		JTextArea txtrComplemento = new JTextArea();
		txtrComplemento.setText("Complemento:");
		txtrComplemento.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrComplemento.setBounds(477, 344, 125, 20);
		panelCadastrarUsuario.add(txtrComplemento);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(602, 346, 311, 24);
		panelCadastrarUsuario.add(tfComplemento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfaceUsuarioCadastrar.class.getResource("/br/com/projsi/imagem/logo-library-main.png")));
		lblNewLabel.setBounds(0, 0, 1008, 730);
		getContentPane().add(lblNewLabel);
}

	private void limparCampos() {

		tfNome.setText("");
		tfNumeroDocumento.setText("");
		cbTipoDocumento.setSelectedItem(Constantes.SELECIONE);
		cbNacionalidade.setSelectedItem(Constantes.SELECIONE);
		cbSexo.setSelectedItem(Constantes.SELECIONE);
		cbEstado.setSelectedItem(Constantes.SELECIONE);
		tfContato.setText("");
		tfContato2.setText("");
		tfCidade.setText("");
		tfCep.setText("");
		tfBairro.setText("");
		tfRua.setText("");
		tfNumero.setText("");
		tfComplemento.setText("");
		tfDataNasc.setText("");
	}

	public void validarUsuario(Usuario u) throws Exception {

		tfNome.setBorder(new LineBorder(new Color(0, 100, 0)));
		if (u.getNome().split(" ").length < 2) {
			tfNome.setBorder(new LineBorder(Color.RED));
			throw new Exception("Nome deve conter pelo menos Nome e Sobrenome");
		}
		if (u.getNumeroDocumento().equals("000.000.000-00") || u.getNumeroDocumento().equals("   .   .   -  ")) {
			throw new Exception("Cpf Inválido!");
		}
	}

	public void carregarUsuario(Usuario u) {
		this.usuario = u;
		tfNome.setText(u.getNome());
		tfNumeroDocumento.setText(u.getNumeroDocumento());
		cbTipoDocumento.setSelectedItem(u.getTipoDocumento());
		cbSexo.setSelectedItem(u.getSexo());
		cbNacionalidade.setSelectedItem(u.getEndereco().getNacionalidade());
		tfContato.setText(u.getContato().getContato());
		tfContato2.setText(u.getContato().getContato2());
		tfCidade.setText(u.getEndereco().getCidade());
		tfCep.setText(u.getEndereco().getCep());
		tfBairro.setText(u.getEndereco().getBairro());
		tfRua.setText(u.getEndereco().getRua());
		tfNumero.setText(String.valueOf(u.getEndereco().getNumero()));
		tfComplemento.setText(u.getEndereco().getComplemento());
		tfDataNasc.setText(String.valueOf(u.getNascimento()));
	}
}
