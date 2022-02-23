package Administrativo;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import Geral.Cliente;
import Geral.Funcoes;

public class Modificar {
	Listar inicio = new Listar();
	Funcoes fuctions = new Funcoes();
	
	public JFrame Modificacao;
	private JTextField nome;
	private JTextField endereco;
	private JTextField textFieldNomeSindicato;
	private JTextField textFieldID;
	private JTextField numero;
	private JTextField cep;
	private JTextField banco;
	private JTextField agencia;
	private JTextField operacao;
	private JTextField conta;
	
	public Modificar() {
		initialize();
	}
	public void initialize(){	
		Modificacao = new JFrame();
		Modificacao.setBounds(0, 0, 1280, 850);
		Modificacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modificacao.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Modificacao, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Modificacao.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCancelar.setBounds(640, 748, 232, 52);
		Modificacao.getContentPane().add(btnCancelar);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnModificar.setBounds(398, 748, 232, 52);
		Modificacao.getContentPane().add(btnModificar);
		
		JLabel lblNewLabel_1 = new JLabel("Modificação de Funcion\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(387, 12, 401, 65);
		Modificacao.getContentPane().add(lblNewLabel_1);
				
		nome = new JTextField();
		nome.setEditable(false);
		nome.setEnabled(false);
		nome.setFont(new Font("Arial", Font.PLAIN, 25));
		nome.setBounds(51, 190, 948, 45);
		Modificacao.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome*");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(51, 144, 193, 35);
		Modificacao.getContentPane().add(lblNewLabel);
		
		endereco = new JTextField();
		endereco.setEditable(false);
		endereco.setEnabled(false);
		endereco.setFont(new Font("Arial", Font.PLAIN, 25));
		endereco.setColumns(10);
		endereco.setBounds(51, 292, 575, 45);
		Modificacao.getContentPane().add(endereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o*");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblEndereo.setBounds(51, 246, 193, 35);
		Modificacao.getContentPane().add(lblEndereo);
				
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setEnabled(false);
		textFieldID.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldID.setColumns(10);
		textFieldID.setBounds(1040, 190, 173, 45);
		Modificacao.getContentPane().add(textFieldID);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial", Font.PLAIN, 35));
		lblID.setBounds(1040, 144, 53, 35);
		Modificacao.getContentPane().add(lblID);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFuncionrio.setBounds(51, 89, 193, 35);
		Modificacao.getContentPane().add(lblFuncionrio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(51, 582, 1162, 161);
		Modificacao.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		final JCheckBox chckbxVinculo = new JCheckBox("Vinculo com algum sindicato*");
		chckbxVinculo.setBounds(6, 7, 415, 45);
		panel_2.add(chckbxVinculo);
		chckbxVinculo.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel lblIdentificaoNoSindicato = new JLabel("Identifica\u00E7\u00E3o no sindicato");
		lblIdentificaoNoSindicato.setBounds(6, 66, 388, 35);
		panel_2.add(lblIdentificaoNoSindicato);
		lblIdentificaoNoSindicato.setFont(new Font("Arial", Font.PLAIN, 35));
		
		textFieldNomeSindicato = new JTextField();
		textFieldNomeSindicato.setBounds(6, 112, 1150, 45);
		panel_2.add(textFieldNomeSindicato);
		textFieldNomeSindicato.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldNomeSindicato.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(259, 348, 299, 226);
		Modificacao.getContentPane().add(panel_1_1);
		
		JLabel lblFormaDeReceber = new JLabel("Forma de receber*");
		lblFormaDeReceber.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFormaDeReceber.setBounds(10, 11, 301, 35);
		panel_1_1.add(lblFormaDeReceber);
		
		final JCheckBox chckbxViaCorreio = new JCheckBox("Via Correio");
		chckbxViaCorreio.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaCorreio.setBounds(61, 72, 160, 39);
		panel_1_1.add(chckbxViaCorreio);
		
		final JCheckBox chckbxEmMos = new JCheckBox("Em m\u00E3os");
		chckbxEmMos.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxEmMos.setBounds(61, 114, 188, 39);
		panel_1_1.add(chckbxEmMos);
		
		final JCheckBox chckbxViaDeposito = new JCheckBox("Via Dep\u00F3sito");
		chckbxViaDeposito.setToolTipText("Comissionado");
		chckbxViaDeposito.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaDeposito.setBounds(61, 156, 188, 39);
		panel_1_1.add(chckbxViaDeposito);
		
		numero = new JTextField();
		numero.setEditable(false);
		numero.setEnabled(false);
		numero.setFont(new Font("Arial", Font.PLAIN, 25));
		numero.setColumns(10);
		numero.setBounds(640, 292, 117, 45);
		Modificacao.getContentPane().add(numero);
		
		numero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		JLabel lblNDaCasa = new JLabel("N\u00BA da casa");
		lblNDaCasa.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNDaCasa.setBounds(640, 246, 117, 35);
		Modificacao.getContentPane().add(lblNDaCasa);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 35));
		lblCep.setBounds(850, 246, 78, 35);
		Modificacao.getContentPane().add(lblCep);
		
		cep = new JTextField();
		cep.setEditable(false);
		cep.setEnabled(false);
		cep.setFont(new Font("Arial", Font.PLAIN, 25));
		cep.setColumns(10);
		cep.setBounds(767, 292, 231, 45);
		Modificacao.getContentPane().add(cep);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(568, 348, 525, 226);
		Modificacao.getContentPane().add(panel_1_1_1);
		
		JLabel lblDadosBancrios = new JLabel("Dados banc\u00E1rios");
		lblDadosBancrios.setFont(new Font("Arial", Font.PLAIN, 35));
		lblDadosBancrios.setBounds(103, 11, 301, 35);
		panel_1_1_1.add(lblDadosBancrios);
		
		banco = new JTextField();
		banco.setFont(new Font("Arial", Font.PLAIN, 25));
		banco.setEnabled(false);
		banco.setEditable(false);
		banco.setColumns(10);
		banco.setBounds(113, 57, 311, 45);
		panel_1_1_1.add(banco);
		
		agencia = new JTextField();
		agencia.setFont(new Font("Arial", Font.PLAIN, 25));
		agencia.setEnabled(false);
		agencia.setEditable(false);
		agencia.setColumns(10);
		agencia.setBounds(88, 116, 101, 45);
		panel_1_1_1.add(agencia);
		
		operacao = new JTextField();
		operacao.setFont(new Font("Arial", Font.PLAIN, 25));
		operacao.setEnabled(false);
		operacao.setEditable(false);
		operacao.setColumns(10);
		operacao.setBounds(199, 116, 60, 45);
		panel_1_1_1.add(operacao);
		
		conta = new JTextField();
		conta.setFont(new Font("Arial", Font.PLAIN, 25));
		conta.setEnabled(false);
		conta.setEditable(false);
		conta.setColumns(10);
		conta.setBounds(269, 116, 174, 45);
		panel_1_1_1.add(conta);
		
		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBanco.setBounds(10, 62, 101, 35);
		panel_1_1_1.add(lblBanco);
		
		JLabel lblAgncia = new JLabel("Ag\u00EAncia");
		lblAgncia.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAgncia.setBounds(88, 172, 101, 35);
		panel_1_1_1.add(lblAgncia);
		
		JLabel lblOp = new JLabel("Op.");
		lblOp.setFont(new Font("Arial", Font.PLAIN, 25));
		lblOp.setBounds(209, 172, 48, 35);
		panel_1_1_1.add(lblOp);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setFont(new Font("Arial", Font.PLAIN, 25));
		lblConta.setBounds(323, 172, 101, 35);
		panel_1_1_1.add(lblConta);
		
		chckbxViaCorreio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxEmMos.setSelected(false);
				chckbxViaDeposito.setSelected(false);
			}
		});
		
		chckbxEmMos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxViaCorreio.setSelected(false);
				chckbxViaDeposito.setSelected(false);
			}
		});
		
		chckbxViaDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxViaCorreio.setSelected(false);
				chckbxEmMos.setSelected(false);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Modificacao, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Modificacao.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
		
		cep.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.NumerosPCEP(e);
			}
		});
		
		final JComboBox<String> Nome = new JComboBox<String>();
		Nome.setFont(new Font("Arial", Font.PLAIN, 25));
		Nome.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		Nome.setBounds(258, 88, 955, 45);
		Modificacao.getContentPane().add(Nome);
		final Cliente c = new Cliente();
		try {
			c.ComunicaçãoModificacao(Nome);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Nome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Nome.getSelectedIndex() > 0) {
					nome.setEditable(true);
					nome.setEnabled(true);
					endereco.setEditable(true);
					endereco.setEnabled(true);
					chckbxViaCorreio.setEnabled(true);
					chckbxEmMos.setEnabled(true);
					chckbxViaDeposito.setEnabled(true);
					chckbxVinculo.setEnabled(true);
					textFieldNomeSindicato.setEditable(true);
					textFieldNomeSindicato.setEnabled(true);
					btnModificar.setEnabled(true);
					numero.setEditable(true);
					numero.setEnabled(true);
					cep.setEditable(true);
					cep.setEnabled(true);
					banco.setEditable(true);
					banco.setEnabled(true);
					agencia.setEditable(true);
					agencia.setEnabled(true);
					operacao.setEditable(true);
					operacao.setEnabled(true);
					conta.setEditable(true);
					conta.setEnabled(true);
					
					try {
						c.ComunicaçãoModificacao(Nome.getSelectedIndex() - 1, textFieldID, nome, endereco, chckbxViaCorreio, chckbxEmMos,
												 chckbxViaDeposito, chckbxVinculo, textFieldNomeSindicato, numero, cep, banco, agencia, operacao, conta);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					nome.setEditable(false);
					nome.setEnabled(false);
					endereco.setEditable(false);
					endereco.setEnabled(false);
					chckbxViaCorreio.setEnabled(false);
					chckbxEmMos.setEnabled(false);
					chckbxViaDeposito.setEnabled(false);
					chckbxVinculo.setEnabled(false);
					textFieldNomeSindicato.setEditable(false);
					textFieldNomeSindicato.setEnabled(false);
					btnModificar.setEnabled(false);
					numero.setEditable(false);
					numero.setEnabled(false);
					cep.setEditable(false);
					cep.setEnabled(false);
					banco.setEditable(false);
					banco.setEnabled(false);
					agencia.setEditable(false);
					agencia.setEnabled(false);
					operacao.setEditable(false);
					operacao.setEnabled(false);
					conta.setEditable(false);
					conta.setEnabled(false);
					nome.setText("");
					textFieldID.setText("");
					endereco.setText("");
					textFieldNomeSindicato.setText("");
					numero.setText("");
					cep.setText("");
					banco.setText("");
					agencia.setText("");
					operacao.setText("");
					conta.setText("");
				}
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!nome.getText().isEmpty() &&(chckbxViaCorreio.isSelected() || chckbxEmMos.isSelected() || chckbxViaDeposito.isSelected()) &&
				    !numero.getText().isEmpty() && !cep.getText().isEmpty() && !endereco.getText().isEmpty()) {		
					
					String texto = "Os dados abaixo estão corretos?\nNome: " + nome.getText() + "\nEndereço: " + endereco.getText();
					if(chckbxVinculo.isSelected()) texto = texto + "\nSindicato: Sim" +  "\nIdentificação? " + textFieldNomeSindicato.getText();
					else texto = texto + "\nSindicato: Não";
				
					if (JOptionPane.showConfirmDialog(Modificacao, texto, 
							"Modificação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {	
						
						try {
							c.ComunicaçãoModificacao(Nome.getSelectedIndex() - 1, nome.getText(), endereco.getText(), chckbxViaCorreio.isSelected(),
													 chckbxEmMos.isSelected(), chckbxViaDeposito.isSelected(), chckbxVinculo.isSelected(),
													 textFieldNomeSindicato.getText(), Integer.parseInt(numero.getText()), cep.getText(),
													 banco.getText(), Integer.parseInt(agencia.getText()), Integer.parseInt(operacao.getText()),
													 conta.getText());				
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						Nome.setSelectedIndex(0);
						nome.setText("");
						textFieldID.setText("");
						endereco.setText("");
						chckbxViaCorreio.setSelected(false);
						chckbxEmMos.setSelected(false);
						chckbxViaDeposito.setSelected(false);
						chckbxVinculo.setSelected(false);
						textFieldNomeSindicato.setText("");
						numero.setText("");
						cep.setText("");
						banco.setText("");
						agencia.setText("");
						operacao.setText("");
						conta.setText("");
						
						if (!(JOptionPane.showConfirmDialog(Modificacao, "Deseja modificar outro funcionário?", 
						    	"Modificar novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
							Modificacao.dispose();
							inicio.lista.setVisible(true);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(btnModificar, "Preencha todos os campos com *", "Erro", 0, null);
				}	
			}
		});
	}
}