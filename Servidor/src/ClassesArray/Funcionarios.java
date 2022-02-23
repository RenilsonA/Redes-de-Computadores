package ClassesArray;

import java.time.LocalDate;
import java.util.ArrayList;
import Servidor.Tempo;

public class Funcionarios {
	
	private int ID;
	private String nome;
	private String endereco;
	private boolean ViaCorreios;
	private boolean EmMaos;
	private boolean ViaDeposito;
	private boolean sindicato;
	private String Identificacao;
	private int numeroCasa;
	private String cep;
	private Finaneiro DadosFinanceiro = null;
	private DadosBancarios bancarios;
	private ArrayList<Ponto> pontos;

	public Funcionarios(int id, String N, String E, boolean X, boolean Y, boolean Z, boolean Sin,
						String ident, int num, String cep, String banco, int ag, int ope, String conta) {		
		this.ID = id;
		this.nome = N;
		this.endereco = E;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		float x = 0;
		if(Sin) x = 1;
		Tempo tempo = new Tempo();
		DadosFinanceiro = new Finaneiro(0, 0, 0, x, 0, 0, 0, LocalDate.now().plusDays(7 - tempo.DiaemNumero() + 6), 2);
		bancarios = new DadosBancarios(banco, ag, ope, conta);
		pontos = new ArrayList<Ponto>();
	}
	
	public Funcionarios(int id, String N, String E, boolean H, boolean S, boolean C, boolean X, boolean Y, boolean Z, boolean Sin, 
						String ident, int num, String cep, DadosBancarios bank) {		
		this.ID = id;
		this.nome = N;
		this.endereco = E;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		bancarios = bank;
	}
	
	public void modificacao(String N, String E, boolean X, boolean Y, boolean Z, boolean Sin, String ident, int num, String cep, DadosBancarios bank) {		
		this.nome = N;
		this.endereco = E;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		bancarios = bank;
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isViaCorreios() {
		return ViaCorreios;
	}
	public void setViaCorreios(boolean viaCorreios) {
		ViaCorreios = viaCorreios;
	}
	public boolean isEmMaos() {
		return EmMaos;
	}
	public void setEmMaos(boolean emMaos) {
		EmMaos = emMaos;
	}
	public boolean isViaDeposito() {
		return ViaDeposito;
	}
	public void setViaDeposito(boolean viaDeposito) {
		ViaDeposito = viaDeposito;
	}
	public boolean isSindicato() {
		return sindicato;
	}
	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}
	public String getIdentificacao() {
		return Identificacao;
	}
	public void setIdentificacao(String identificacao) {
		Identificacao = identificacao;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	public Finaneiro getDadosFinanceiro() {
		return DadosFinanceiro;
	}
	public void setDadosFinanceiro(Finaneiro DadosFinanceiros) {
		DadosFinanceiro = DadosFinanceiros;
	}
	public DadosBancarios getBancarios() {
		return bancarios;
	}
	public void setBancarios(DadosBancarios bancarios) {
		this.bancarios = bancarios;
	}
}
