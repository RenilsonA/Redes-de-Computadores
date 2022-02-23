package Administrativo;

import ClassesArray.DadosBancarios;
import ClassesArray.Funcionarios;
import Servidor.Lista;

public class Administrativo {
	
	public int cadastrar(int id, String N, String E, boolean X, boolean Y, boolean Z,
						  boolean Sin, String ident, int num, String cep, String bank, int ag, int ope, String conta) {
		int IDLast = 0;
		if(Lista.funcionarios.size() > 0) IDLast = Lista.funcionarios.get(Lista.funcionarios.size() - 1).getID();
		if(IDLast >= id) id = IDLast + 1;
		Lista.setId(id);
		Lista.funcionarios.add(new Funcionarios(id, N, E, X, Y, Z, Sin, ident, num, cep, bank, ag, ope, conta));
		return id;
	}
	
	public void modificar(int x, String N, String E, boolean X, boolean Y, boolean Z, boolean Sin, String ident,
						  int num, String cep, String bank, int ag, int ope, String conta) {
		if(Sin) Lista.funcionarios.get(x).getDadosFinanceiro().setdescSind(1);
		Lista.funcionarios.get(x).modificacao(N, E, X, Y, Z, Sin, ident, num, cep, new DadosBancarios(bank, ag, ope, conta));
	}
	public boolean remover(int ID) {
		Lista l = new Lista();
		if(l.posicao(ID) != -1) {
			Lista.funcionarios.remove(ID);
		} else {
			return false;
		}
		return true;
	}
}
