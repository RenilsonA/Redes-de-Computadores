package Geral;

import java.awt.event.KeyEvent;

public class Funcoes{	
	public void ApenasNumeros (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '.')) {
			evento.consume();
		}
	}
	
	public void NumerosPCEP (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '-')) {
			evento.consume();
		}
	}
	
	public void NumerosCEspaco (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == KeyEvent.VK_SPACE)) {
			evento.consume();
		}
	}
	
	public void NumerosPData (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '/' || Numero == '-')) {
			evento.consume();
		}
	}
}
