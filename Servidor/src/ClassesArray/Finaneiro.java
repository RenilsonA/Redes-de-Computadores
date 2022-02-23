package ClassesArray;

import java.time.LocalDate;

public class Finaneiro {
	private float horas = 0;
	private float horasExtras = 0;
	private float bonus;
	private float descSind;
	private float discExtra;
	private float Alicota;
	private float SalarioHora;
	private LocalDate pagamento;
	private int grupo;

	public Finaneiro(float V, float VE, float B, float Desc, float discEx, float Al, float SH, LocalDate pag, int grup) {
		this.horas = V;
		this.horasExtras = VE;
		this.bonus = B;
		this.descSind = Desc;
		this.discExtra = discEx;
		this.Alicota = Al;
		this.SalarioHora = SH;
		this.pagamento = pag;
		this.grupo = grup;
	}
	
	public float getHoras() {
		return horas;
	}
	public void setHoras(float horas) {
		this.horas = horas + getHoras();
	}
	public float getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(float horasExtras) {
		this.horasExtras = horasExtras*1.5F + getHorasExtras();
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getdescSind() {
		return descSind;
	}
	public void setdescSind(float descontos) {
		this.descSind = descontos;
	}
	public float getDiscExtra() {
		return discExtra;
	}
	public void setDiscExtra(float discExtra) {
		this.discExtra = discExtra;
	}
	public float getAlicota() {
		return Alicota;
	}
	public void setAlicota(float alicota) {
		Alicota = alicota;
	}
	public float getSalarioHora() {
		return SalarioHora;
	}
	public void setSalarioHora(float salarioHora) {
		SalarioHora = salarioHora;
	}
	public LocalDate getPagamento() {
		return pagamento;
	}
	public void setPagamento(LocalDate pagamento) {
		this.pagamento = pagamento;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
}
