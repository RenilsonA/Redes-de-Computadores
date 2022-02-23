package Inicio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {
	static Socket socket;
	static ObjectOutputStream saida;
	static ObjectInputStream entrada;
	Tempo t = new Tempo();
	
	public void Inicia(int porta) {
		try {
			socket = new Socket("localhost", porta);
			saida = new ObjectOutputStream(socket.getOutputStream());
			entrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Comunicação(int ID) throws IOException {
		Inicia(Inicio_Cliente.porta);
		saida.write(0);
		saida.flush();
		saida.write(ID);
		saida.flush();
		boolean retorno = entrada.readBoolean();
		boolean x = entrada.readBoolean();
		if(retorno) {
			if(x)
				 JOptionPane.showMessageDialog(null, "Seu Turno acabou às: " + t.Horas(), "ID " + ID, 0, null); //saida
			else JOptionPane.showMessageDialog(null, "Seu Turno começou às: " + t.Horas(), "ID " + ID, 0, null); //entrada
		}
		else JOptionPane.showMessageDialog(null, "ID incorreto ou não consta no sistema", "Erro", 0, null);	//ID incorreto
		saida.close();
		entrada.close();
		socket.close();		
	}
	
}
