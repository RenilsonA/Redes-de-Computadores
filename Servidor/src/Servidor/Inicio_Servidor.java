package Servidor;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class Inicio_Servidor {
	public JFrame admin;
	static boolean ler = true;
	public static String endereco = "";			//Aqui colocar o endereço do bloco de notas, se quiser ir para outra pasta
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(ler == true) {
						try {
							Lista lista = new Lista();
							lista.Ler(endereco);
						} catch (IOException e) {
							e.printStackTrace();
						}
						ler = false;
					}	
					Servidor chama = new Servidor();
					chama.CriarServidor(5556);
					Threads thread = new Threads();
					thread.run(chama);
				} catch (Exception e) {
					System.out.print("Erro no servidor: " + e.getMessage());
				}
			}
		});
	}
}
