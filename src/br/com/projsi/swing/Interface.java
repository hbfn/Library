package br.com.projsi.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;

public class Interface extends JFrame{
	
	JPanel painelPrincipal;
	
	InterfaceEmprestimo itfEmprestimo;
	InterfaceDevolucao itfDevolucao;
	
	InterfaceUsuarioCadastrar itfUsuarioCadastrar;
	InterfaceUsuarioListar itfUsuarioListar;
	InterfaceUsuarioMenu itfUsuarioMenu;
	
	InterfaceLivroCadastrar itfLivroCadastrar;
	InterfaceLivroListar itfLivroListar;
	InterfaceLivroMenu itfLivroMenu;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface() {
		
	setBounds(600, 200, 1024, 759);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	itfEmprestimo = new InterfaceEmprestimo();
	itfDevolucao = new InterfaceDevolucao();
		
	itfUsuarioCadastrar = new InterfaceUsuarioCadastrar();
	itfUsuarioListar = new InterfaceUsuarioListar();
	itfUsuarioMenu = new InterfaceUsuarioMenu();
	
	itfLivroCadastrar = new InterfaceLivroCadastrar();
	itfLivroListar = new InterfaceLivroListar();
	itfLivroMenu = new InterfaceLivroMenu();

	painelPrincipal = new JPanel();
	painelPrincipal.setBounds(0, 0, 1024, 768);
	getContentPane().add(painelPrincipal);
	setTitle("Library - 2017");
	painelPrincipal.setLayout(null);
	
	JButton btnUsuario = new JButton("Usu\u00E1rio");
	btnUsuario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			itfUsuarioMenu.setVisible(true);
		}
	});
	btnUsuario.setFont(new Font("Arial", Font.BOLD, 14));
	btnUsuario.setBounds(816, 183, 186, 67);
	painelPrincipal.add(btnUsuario);
	
	JButton btnEmprstimo = new JButton("Empr\u00E9stimo");
	btnEmprstimo.setFont(new Font("Arial", Font.BOLD, 14));
	btnEmprstimo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			itfEmprestimo.setVisible(true);
		}
	});
	btnEmprstimo.setBounds(816, 384, 186, 67);
	painelPrincipal.add(btnEmprstimo);
	
	JButton btnLivro = new JButton("Livro");
	btnLivro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			itfLivroMenu.setVisible(true);
		}
	});
	btnLivro.setFont(new Font("Arial", Font.BOLD, 14));
	btnLivro.setBounds(816, 285, 186, 67);
	painelPrincipal.add(btnLivro);
	
	JButton btnDevoluo = new JButton("Devolu\u00E7\u00E3o");
	btnDevoluo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			itfDevolucao.setVisible(true);
		}
	});
	btnDevoluo.setFont(new Font("Arial", Font.BOLD, 14));
	btnDevoluo.setBounds(816, 479, 186, 67);
	painelPrincipal.add(btnDevoluo);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon(Interface.class.getResource("/br/com/projsi/imagem/logo-library.png")));
	lblNewLabel_1.setBounds(18, 182, 772, 370);
	painelPrincipal.add(lblNewLabel_1);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/br/com/projsi/imagem/logo-biblioteca3.png")));
	lblNewLabel.setBounds(0, 0, 1018, 731);
	painelPrincipal.add(lblNewLabel);
}
}