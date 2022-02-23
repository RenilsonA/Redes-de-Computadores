package Servidor;

import java.io.IOException;
import java.net.Socket;

public class Threads extends Thread {
	public void run(Servidor chama) throws IOException{
		while (true) {
			Socket socket = chama.Espera();
			chama.Tratamento(socket);
		}
	}
}
