package Ponto;

import java.io.IOException;

import ClassesArray.Ponto;
import Servidor.Lista;

public class Pontos {

	public boolean ponto(int ID) {
		Lista lista = new Lista();
		boolean x = false;
		if(ID != -1) {
			if(Lista.funcionarios.get(ID).getPontos().size() > 0 &&
			   Lista.funcionarios.get(ID).getPontos().get(Lista.funcionarios.get(ID).getPontos().size() - 1).isEmTurno()) {
				Lista.funcionarios.get(ID).getPontos().get(Lista.funcionarios.get(ID).getPontos().size() - 1).baterPonto();
				x = true; 
				float y = Lista.funcionarios.get(ID).getPontos().get(Lista.funcionarios.get(ID).getPontos().size() - 1).getHoras();
				if(y > 8) {
					Lista.funcionarios.get(ID).getDadosFinanceiro().setHoras(Lista.funcionarios.get(ID).getDadosFinanceiro().getHoras() + 8);
					Lista.funcionarios.get(ID).getDadosFinanceiro().setHorasExtras(Lista.funcionarios.get(ID).getDadosFinanceiro().getHorasExtras() + y - 8);
				} else {
					Lista.funcionarios.get(ID).getDadosFinanceiro().setHoras(Lista.funcionarios.get(ID).getDadosFinanceiro().getHoras() + y);
				}
			}
			else {
				Lista.funcionarios.get(ID).getPontos().add(new Ponto());
			}
			try {
				lista.Salvar(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
}
