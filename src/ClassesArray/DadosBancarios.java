package ClassesArray;

public class DadosBancarios {
	private String banco;
	private int agencia;
	private int operacao;
	private String conta;
	
	public DadosBancarios(String banco, int agencia, int operacao, String conta) {
		this.banco = banco;
		this.agencia = agencia;
		this.operacao = operacao;
		this.conta = conta;
	}
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
}
