package Administrativo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Geral.Cliente;
import Geral.Funcoes;

import javax.swing.JTextField;

public class Remover {
	public JFrame Remocao;
	private JTable table;
	Listar inicio = new Listar();
	private JTextField RemocaodeID;
	
	public Remover() {
		Initialize();
	}

	public void Initialize() {
		Remocao = new JFrame();
		Remocao.setBounds(0, 0, 1280, 800);
		Remocao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Remocao.getContentPane().setLayout(null);
		
		tabela();
			
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRemover.setBounds(432, 689, 193, 61);
		Remocao.getContentPane().add(btnRemover);
		
		JLabel lblListaDeFuncionrios = new JLabel("Remover funcion\u00E1rios");
		lblListaDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionrios.setFont(new Font("Arial", Font.BOLD, 40));
		lblListaDeFuncionrios.setBounds(223, 8, 818, 47);
		Remocao.getContentPane().add(lblListaDeFuncionrios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Remocao.dispose();
					inicio.lista.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCancelar.setBounds(635, 689, 193, 61);
		Remocao.getContentPane().add(btnCancelar);
		
		RemocaodeID = new JTextField();
		RemocaodeID.setFont(new Font("Arial", Font.PLAIN, 15));
		RemocaodeID.setBounds(185, 658, 901, 20);
		Remocao.getContentPane().add(RemocaodeID);
		RemocaodeID.setColumns(10);
		RemocaodeID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("ID's a remover");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 658, 98, 20);
		Remocao.getContentPane().add(lblNewLabel);
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!RemocaodeID.getText().isEmpty()) {
					String f = RemocaodeID.getText() + ' ';
					for(int a = 0; a < f.length(); a++) {
						String x = "";
						while(Character.isDigit(f.charAt(a))) {
							x = x + f.charAt(a);
							a++;
						}
						Cliente c = new Cliente();
						int posicao;
						try {
							if(c.TemID(Integer.parseInt(x))) {
								posicao = c.ComunicaçãoTemID(Integer.parseInt(x));
								if(JOptionPane.showConfirmDialog(Remocao, "Realmente deseja remover o funcionário?\nID: " + x + "\nNome: " + 
										c.ComunicaçãoNome(posicao), "Remover", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

									c.ComunicaçãoRemover(posicao);
								}	
							} else JOptionPane.showMessageDialog(null, "Digite um ID válido", "Erro", 1, null);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					if (!(JOptionPane.showConfirmDialog(Remocao, "Deseja Remover outros funcionários?", 
					   		"Remover novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
						Remocao.dispose();
						inicio.lista.setVisible(true);
					}
					tabela();
				}
			}
		});
		
		JButton btnNewButton = new JButton("Atualizar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(1048, 57, 176, 46);
		Remocao.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remocao.dispose();
				table.remove(table);
				tabela();
				Remocao.setVisible(true);
			}
		});
	}

	private void tabela() {
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes"}, 0);
		Object linha0[] = new Object[] {"ID", "Nome"};
		modelo.addRow(linha0);
		table.setModel(modelo);		
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
		table.getColumnModel().getColumn(1).setPreferredWidth(1000);
		Cliente c = new Cliente();
		try {
			c.ComunicaçãoRemoverTabela(table, modelo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Remocao.getContentPane().add(table);
	}
}