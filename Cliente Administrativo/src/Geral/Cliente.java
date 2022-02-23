package Geral;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Cliente {
	Socket socket;
	ObjectOutputStream saida;
	ObjectInputStream entrada;
	public static int ID = -1;
	
	public static void setID(int iD) {
		Cliente.ID = iD;
	}

	public void Inicia(int porta) {
		try {
			socket = new Socket("localhost", porta);
			saida = new ObjectOutputStream(socket.getOutputStream());
			entrada = new ObjectInputStream(socket.getInputStream());
			//JOptionPane.showMessageDialog(null, "Aguarde", "Conectando", 1, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PegaID() {
		try {
			Inicia(Inicio_Cliente.porta);
			saida.write(10);
			saida.flush();
			Cliente.setID(entrada.read());
			saida.close();
			entrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ComunicaçãoListas(JTable table, DefaultTableModel modelo) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(1);
		saida.flush();
		int tamanho = entrada.read();
		for(int a = 0; a < tamanho; a++) {
			String tipo = entrada.readUTF();
			if(tipo == null) tipo = "-------";
			Object linha[] = new Object[] {entrada.read(), entrada.readUTF(), entrada.readUTF(), tipo};
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		saida.close();
		entrada.close();
		socket.close();
	}
	
	public int ComunicaçãoCadastro(int id, String N, String E, boolean X, boolean Y, boolean Z, boolean Sin, String ident, int num,
									String cep, String bank, int ag, int ope, String cont) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(2);
		saida.flush();
		saida.write(id);
		saida.flush();
		saida.writeUTF(N);
		saida.flush();
		saida.writeUTF(E);
		saida.flush();
		saida.writeBoolean(X);
		saida.flush();
		saida.writeBoolean(Y);
		saida.flush();
		saida.writeBoolean(Z);
		saida.flush();
		saida.writeBoolean(Sin);
		saida.flush();
		saida.writeUTF(ident);
		saida.flush();
		saida.write(num);
		saida.flush();
		saida.writeUTF(cep);
		saida.flush();
		saida.writeUTF(bank);
		saida.flush();
		saida.write(ag);
		saida.flush();
		saida.write(ope);
		saida.flush();
		saida.writeUTF(cont);
		saida.flush();
		int x = entrada.read();
		saida.close();
		entrada.close();
		socket.close();
		return x;
	}
	
	public void ComunicaçãoModificacao(JComboBox<String> Nome) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(3);
		saida.flush();
		int tamanho = entrada.read();
		for(int a = 0; a < tamanho; a++) {
			Nome.addItem(entrada.read() + " - " + entrada.readUTF());
		}
		saida.close();
		entrada.close();
		socket.close();
	}

	public void ComunicaçãoModificacao(int x, JTextField textID, JTextField nome, JTextField endereco, JCheckBox chckbxViaCorreio, JCheckBox chckbxEmMos,
									   JCheckBox chckbxViaDeposito, JCheckBox chckbxVinculo, JTextField textFieldNomeSindicato, JTextField numero,
									   JTextField cep, JTextField banco, JTextField agencia, JTextField operacao, JTextField conta) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(4);
		saida.flush();
		saida.write(x);
		saida.flush();
		textID.setText(Integer.toString(entrada.read()));
		nome.setText(entrada.readUTF());
		endereco.setText(entrada.readUTF());
		chckbxViaCorreio.setSelected(entrada.readBoolean());
		chckbxEmMos.setSelected(entrada.readBoolean());
		chckbxViaDeposito.setSelected(entrada.readBoolean());
		chckbxVinculo.setSelected(entrada.readBoolean());
		textFieldNomeSindicato.setText(entrada.readUTF());
		numero.setText(Integer.toString(entrada.read()));
		cep.setText(entrada.readUTF());
		banco.setText(entrada.readUTF());
		agencia.setText(Integer.toString(entrada.read()));
		operacao.setText(Integer.toString(entrada.read()));
		conta.setText(entrada.readUTF());
		saida.close();
		entrada.close();
		socket.close();
	}
	
	public void ComunicaçãoModificacao(int index, String N, String E, boolean X, boolean Y,
		       boolean Z, boolean Sin, String ident, int num, String cep, String bank, int ag, int ope,
		       String cont) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(5);
		saida.flush();
		saida.write(index);
		saida.flush();
		saida.writeUTF(N);
		saida.flush();
		saida.writeUTF(E);
		saida.flush();
		saida.writeBoolean(X);
		saida.flush();
		saida.writeBoolean(Y);
		saida.flush();
		saida.writeBoolean(Z);
		saida.flush();
		saida.writeBoolean(Sin);
		saida.flush();
		saida.writeUTF(ident);
		saida.flush();
		saida.write(num);
		saida.flush();
		saida.writeUTF(cep);
		saida.flush();
		saida.writeUTF(bank);
		saida.flush();
		saida.write(ag);
		saida.flush();
		saida.write(ope);
		saida.flush();
		saida.writeUTF(cont);
		saida.flush();
		saida.close();
		entrada.close();
		socket.close();
	}
	
	public boolean TemID(int ID) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(9);
		saida.flush();
		saida.write(ID);
		saida.flush();
		boolean x = entrada.readBoolean();
		saida.close();
		entrada.close();
		socket.close();
		return x;
	}
	
	public int ComunicaçãoTemID(int ID) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(6);
		saida.flush();
		saida.write(ID);
		saida.flush();
		int x = entrada.read();
		saida.close();
		entrada.close();
		socket.close();
		return x;
	}
	
	public String ComunicaçãoNome(int posicao) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(7);
		saida.flush();
		saida.write(posicao);
		saida.flush();
		String x = entrada.readUTF();
		saida.close();
		entrada.close();
		socket.close();
		return x;
	}
	
	public void ComunicaçãoRemover(int posicao) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(8);
		saida.flush();
		saida.write(posicao);
		saida.flush();
		saida.close();
		entrada.close();
		socket.close();
	}
	
	public void ComunicaçãoRemoverTabela(JTable table, DefaultTableModel modelo) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(3);
		saida.flush();
		int tamanho = entrada.read();
		for(int a = 0; a < tamanho; a++) {
			Object linha[] = new Object[] {entrada.read(), entrada.readUTF()};
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		saida.close();
		entrada.close();
		socket.close();
	}
}
