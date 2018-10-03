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

public class InterfaceLivroMenu extends JFrame{
	
	
	private Interface itf;
	private JButton cadastrarLivro;
	private JButton listarLivro;
	
	private InterfaceLivroCadastrar itfLivroCadastrar;
	private InterfaceLivroListar itfLivroListar;
	
	public InterfaceLivroMenu() {
		
		itfLivroCadastrar = new InterfaceLivroCadastrar();
		itfLivroListar = new InterfaceLivroListar();
		
		getContentPane().setLayout(null);
		setBounds(1000, 600, 235, 120);
		setTitle("Usuário");
		getContentPane().setLayout(null);
		
		cadastrarLivro = new JButton("");
		cadastrarLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				itfLivroCadastrar.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cadastrarLivro.setIcon(
						new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/addlivro.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				cadastrarLivro.setIcon(
						new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/addlivro.png")));
			}
		});
		cadastrarLivro.setIcon(new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/addlivro.png")));
		cadastrarLivro.setBounds(0, 0, 105, 82);
		getContentPane().add(cadastrarLivro);
		
		listarLivro = new JButton("");
		listarLivro.setIcon(new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/listarlivro.png")));
		listarLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				itfLivroListar.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				listarLivro.setIcon(
						new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/listarlivro.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				listarLivro.setIcon(
						new ImageIcon(InterfaceLivroMenu.class.getResource("/br/com/projsi/imagem/listarlivro.png")));
			}
		});
		listarLivro.setBounds(115, 0, 105, 82);
		getContentPane().add(listarLivro);
	}
}