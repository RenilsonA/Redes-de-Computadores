package Servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import ClassesArray.Funcionarios;
import ClassesArray.Finaneiro;
import ClassesArray.Ponto;

public class Lista {
	public static ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	public static int id;
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Lista.id = id;
	}

	public ArrayList<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionarios> funcionarios) {
		Lista.funcionarios = funcionarios;
	}
	
	public void remover(int x) {
		funcionarios.remove(x);
		try {
			Salvar(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int posicao(int x) {
		for(int a = 0; a < funcionarios.size(); a++) {
			if(funcionarios.get(a).getID() == x) {
				return a;
			}
		}
		return -1;
	}

	public void Ler(String endereco) throws IOException {
		new FileWriter(Inicio_Servidor.endereco + "Funcionarios.txt", true);
		FileReader func = new FileReader(endereco + "Funcionarios.txt");
		BufferedReader Func = new BufferedReader(func);
		String ID = Func.readLine();
		if(ID != null) {
			int id = Integer.parseInt(ID);
			setId(id);
		}
		while((ID = Func.readLine()) != null) {
			Lista.funcionarios.add(new Funcionarios(Integer.parseInt(ID), Func.readLine(), Func.readLine(), Boolean.parseBoolean(Func.readLine()),
				  	   			   Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()),
				  	   			   Func.readLine(), Integer.parseInt(Func.readLine()), Func.readLine(), "null", 0, 0, " "));
			int f = Lista.funcionarios.size() - 1;
			Lista.funcionarios.get(f).setDadosFinanceiro(new Finaneiro(Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), 
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()),
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), LocalDate.parse(Func.readLine()),
						   Integer.parseInt(Func.readLine())));
			Lista.funcionarios.get(f).getBancarios().setBanco(Func.readLine());
			Lista.funcionarios.get(f).getBancarios().setAgencia(Integer.parseInt(Func.readLine()));
			Lista.funcionarios.get(f).getBancarios().setOperacao(Integer.parseInt(Func.readLine()));
			Lista.funcionarios.get(f).getBancarios().setConta(Func.readLine());
			int tamanho = Integer.parseInt(Func.readLine());
			for(int g = 0; g < tamanho; g++) {
				Lista.funcionarios.get(f).getPontos().add(new Ponto(Func.readLine(), Func.readLine(), Func.readLine(), Boolean.parseBoolean(Func.readLine()), 
														  			Float.parseFloat(Func.readLine())));
			}
			
		}
		Func.close();
		func.close();
	}	
	
	public void Salvar(boolean tipo) throws IOException {
		if(tipo == true) {
			FileWriter Funci = new FileWriter(Inicio_Servidor.endereco + "Funcionarios.txt", false);
			PrintWriter arquivoFunc = new PrintWriter(Funci);
			arquivoFunc.println(getId());
			for(Funcionarios x : funcionarios) {			
				arquivoFunc.println(x.getID());
				arquivoFunc.println(x.getNome());
				arquivoFunc.println(x.getEndereco());
				arquivoFunc.println(x.isViaCorreios());
				arquivoFunc.println(x.isEmMaos());
				arquivoFunc.println(x.isViaDeposito());
				arquivoFunc.println(x.isSindicato());
				arquivoFunc.println(x.getIdentificacao());
				arquivoFunc.println(x.getNumeroCasa());
				arquivoFunc.println(x.getCep());
				arquivoFunc.println(x.getDadosFinanceiro().getHoras());
				arquivoFunc.println(x.getDadosFinanceiro().getHorasExtras());
				arquivoFunc.println(x.getDadosFinanceiro().getBonus());
				arquivoFunc.println(x.getDadosFinanceiro().getdescSind());
				arquivoFunc.println(x.getDadosFinanceiro().getDiscExtra());
				arquivoFunc.println(x.getDadosFinanceiro().getAlicota());
				arquivoFunc.println(x.getDadosFinanceiro().getSalarioHora());
				arquivoFunc.println(x.getDadosFinanceiro().getPagamento());
				arquivoFunc.println(x.getDadosFinanceiro().getGrupo());
				arquivoFunc.println(x.getBancarios().getBanco());
				arquivoFunc.println(x.getBancarios().getAgencia());
				arquivoFunc.println(x.getBancarios().getOperacao());
				arquivoFunc.println(x.getBancarios().getConta());
				arquivoFunc.println(x.getPontos().size());
				for(int a = 0; a < x.getPontos().size(); a++) {
					arquivoFunc.println(x.getPontos().get(a).getData());
					arquivoFunc.println(x.getPontos().get(a).getHoraEntrada());
					arquivoFunc.println(x.getPontos().get(a).getHoraSaida());
					arquivoFunc.println(x.getPontos().get(a).isEmTurno());
					arquivoFunc.println(x.getPontos().get(a).getHoras());
				}
			}
			arquivoFunc.flush();
			arquivoFunc.close();
			Funci.close();
		} else {
			FileWriter Funci = new FileWriter(Inicio_Servidor.endereco + "Funcionarios.txt", true);
			PrintWriter arquivoFunc = new PrintWriter(Funci);
			int x = Lista.funcionarios.size();
			if(x == 1) arquivoFunc.println(getId());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getID());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getNome());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getEndereco());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaCorreios());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isEmMaos());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaDeposito());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isSindicato());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getIdentificacao());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getNumeroCasa());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getCep());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getHoras());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getHorasExtras());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getBonus());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getdescSind());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getDiscExtra());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getAlicota());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getSalarioHora());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getPagamento());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosFinanceiro().getGrupo());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getBanco());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getAgencia());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getOperacao());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getConta());
			arquivoFunc.println("0");
			arquivoFunc.flush();
			arquivoFunc.close();
			Funci.close();
		}
	}	
}
