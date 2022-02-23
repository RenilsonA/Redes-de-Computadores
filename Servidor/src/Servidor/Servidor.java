package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Administrativo.Administrativo;
import ClassesArray.Funcionarios;
import Ponto.Pontos;

public class Servidor {
	static ServerSocket servidor = null;
	static ObjectOutputStream saida;
	static ObjectInputStream entrada;
	
	public void CriarServidor(int porta) throws IOException {
		servidor = new ServerSocket(porta);
	}
	
	public Socket Espera() throws IOException {
		Socket socket = servidor.accept();
		return socket;
	}
	
	public void FecharSocket(Socket socket) throws IOException {
		socket.close();
	}
	
	public void Tratamento(Socket socket) throws IOException {
		try {		
			Lista lista = new Lista();
			saida = new ObjectOutputStream(socket.getOutputStream());
			entrada = new ObjectInputStream(socket.getInputStream());
			
			int selecao = entrada.read();
			if(selecao == 10) {
				saida.write(Lista.getId());
				saida.flush();
			} else if(selecao == 0) {
				int ID = entrada.read();
				ID = lista.posicao(ID);
				Pontos p = new Pontos();
				boolean x = false, y = false;
				if(ID != -1) {
					y = true;
					x = p.ponto(ID);
				}
				saida.writeBoolean(y);
				saida.flush();
				saida.writeBoolean(x);
				saida.flush();
			} else if (selecao == 1) {
				saida.write(Lista.funcionarios.size());
				saida.flush();
				for(Funcionarios x: Lista.funcionarios) {
					saida.writeUTF(x.getIdentificacao());
					saida.flush();
					saida.write(x.getID());
					saida.flush();
					saida.writeUTF(x.getNome());
					saida.flush();
					saida.writeUTF(x.getEndereco());
					saida.flush();
				}
			} else if(selecao == 2) {
				Administrativo adm = new Administrativo();
				int id = entrada.read();
				int x = adm.cadastrar(id, entrada.readUTF(), entrada.readUTF(), entrada.readBoolean(), entrada.readBoolean(), entrada.readBoolean(),
							  entrada.readBoolean(), entrada.readUTF(), entrada.read(), entrada.readUTF(), entrada.readUTF(), entrada.read(),
							  entrada.read(), entrada.readUTF());
				saida.write(x);
				saida.flush();
				lista.Salvar(true);
			} else if(selecao == 3) {
				saida.write(Lista.funcionarios.size());
				saida.flush();
				for(Funcionarios x: Lista.funcionarios) {
					saida.write(x.getID());
					saida.flush();
					saida.writeUTF(x.getNome());
					saida.flush();
				}
			} else if(selecao == 4) {
				int index = entrada.read();
				saida.write(Lista.funcionarios.get(index).getID());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getNome());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getEndereco());
				saida.flush();
				saida.writeBoolean(Lista.funcionarios.get(index).isViaCorreios());
				saida.flush();
				saida.writeBoolean(Lista.funcionarios.get(index).isEmMaos());
				saida.flush();
				saida.writeBoolean(Lista.funcionarios.get(index).isViaDeposito());
				saida.flush();
				saida.writeBoolean(Lista.funcionarios.get(index).isSindicato());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getIdentificacao());
				saida.flush();
				saida.write(Lista.funcionarios.get(index).getNumeroCasa());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getCep());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getBancarios().getBanco());
				saida.flush();
				saida.write(Lista.funcionarios.get(index).getBancarios().getAgencia());
				saida.flush();
				saida.write(Lista.funcionarios.get(index).getBancarios().getOperacao());
				saida.flush();
				saida.writeUTF(Lista.funcionarios.get(index).getBancarios().getConta());
				saida.flush();
			} else if(selecao == 5) {
				Administrativo adm = new Administrativo();
				adm.modificar(entrada.read(), entrada.readUTF(), entrada.readUTF(), entrada.readBoolean(), entrada.readBoolean(),
							  entrada.readBoolean(), entrada.readBoolean(), entrada.readUTF(), entrada.read(), entrada.readUTF(),
							  entrada.readUTF(), entrada.read(), entrada.read(), entrada.readUTF());
				lista.Salvar(true);
			} else if(selecao == 6) {
				int x = lista.posicao(entrada.read());
				saida.write(x);
				saida.flush();
			} else if(selecao == 7) {
				String x = Lista.funcionarios.get(entrada.read()).getNome();
				saida.writeUTF(x);
				saida.flush();
			} else if(selecao == 8) {
				Lista.funcionarios.remove(entrada.read());
			} else if(selecao == 9) {
				int x = lista.posicao(entrada.read());
				if(x != -1) saida.writeBoolean(true);
				else saida.writeBoolean(false);
				saida.flush();
			}
			
			saida.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
