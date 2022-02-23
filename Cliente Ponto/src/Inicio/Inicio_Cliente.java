package Inicio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Pontos.Pontos;

public class Inicio_Cliente {
	public JFrame admin;
	public static int porta = 5556;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_Cliente window = new Inicio_Cliente();
					window.admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Inicio_Cliente() {
		initialize();
	}
	public void initialize(){
		admin = new JFrame();
		admin.setBounds(0, 0, 854, 290);
		admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Pontos dos Funcion\u00E1rios");
		lblNewLabel.setBounds(0, 11, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		admin.getContentPane().add(lblNewLabel);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(admin, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					admin.dispose();
				}
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFechar.setBounds(346, 186, 143, 57);
		admin.getContentPane().add(btnFechar);
		
		JButton btnPontos = new JButton("Pontos");
		btnPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pontos p = new Pontos();
				admin.dispose();
				p.pontos.setVisible(true);
			}
		});
		btnPontos.setFont(new Font("Arial", Font.PLAIN, 25));
		btnPontos.setBounds(285, 107, 266, 68);
		admin.getContentPane().add(btnPontos);
	}
}
