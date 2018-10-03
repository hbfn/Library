package br.com.projsi.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceUsuarioMenu extends JFrame{
	
	
	private Interface itf;
	private JButton cadastrarUsuario;
	private JButton listarUsuario;
	
	private InterfaceUsuarioCadastrar itfUsuarioCadastrar;
	private InterfaceUsuarioListar itfUsuarioListar;
	
	public InterfaceUsuarioMenu() {
		
		itfUsuarioCadastrar = new InterfaceUsuarioCadastrar();
		itfUsuarioListar = new InterfaceUsuarioListar();
		
		getContentPane().setLayout(null);
		setBounds(1000, 600, 235, 120);
		setTitle("Usuário");
		getContentPane().setLayout(null);
		
		cadastrarUsuario = new JButton("");
		cadastrarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				itfUsuarioCadastrar.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cadastrarUsuario.setIcon(
						new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/addusuario.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				cadastrarUsuario.setIcon(
						new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/addusuario.png")));
			}
		});
		cadastrarUsuario.setIcon(new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/addusuario.png")));
		cadastrarUsuario.setBounds(0, 0, 105, 82);
		getContentPane().add(cadastrarUsuario);
		
		listarUsuario = new JButton("");
		listarUsuario.setIcon(new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/listarusuario.png")));
		listarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				itfUsuarioListar.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				listarUsuario.setIcon(
						new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/listarusuario.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				listarUsuario.setIcon(
						new ImageIcon(InterfaceUsuarioMenu.class.getResource("/br/com/projsi/imagem/listarusuario.png")));
			}
		});
		listarUsuario.setBounds(115, 0, 105, 82);
		getContentPane().add(listarUsuario);
	}
}