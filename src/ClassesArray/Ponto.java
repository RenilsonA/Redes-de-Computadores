package ClassesArray;

import java.time.LocalDate;
import java.time.LocalTime;
import Servidor.Tempo;

public class Ponto {
	private String Data;
	private String HoraEntrada;
	private String HoraSaida;
	private boolean EmTurno;
	private float horas;

	public Ponto() {
		Tempo t = new Tempo();
		this.Data = t.DataConvertida(LocalDate.now());
		this.HoraEntrada = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
		this.horas = LocalTime.now().getHour() + LocalTime.now().getMinute()/60 + LocalTime.now().getSecond()/3600;
		this.EmTurno = true;
	}
	
	public Ponto(String D, String HE, String HS, boolean ET, float h) {
		this.Data = D;
		this.HoraEntrada = HE;
		this.HoraSaida = HS;
		this.EmTurno = ET;
		this.horas = h;
	}

	public void baterPonto() {
		this.HoraSaida = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
		this.horas = (LocalTime.now().getHour() + LocalTime.now().getMinute()/60 + LocalTime.now().getSecond()/3600) - getHoras();
		this.EmTurno = false;
	}

	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getHoraEntrada() {
		return HoraEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		HoraEntrada = horaEntrada;
	}
	public String getHoraSaida() {
		return HoraSaida;
	}
	public void setHoraSaida(String horaSaida) {
		HoraSaida = horaSaida;
	}
	public boolean isEmTurno() {
		return EmTurno;
	}
	public void setEmTurno(boolean emTurno) {
		EmTurno = emTurno;
	}
	public float getHoras() {
		return horas;
	}
	public void setHoras(float horas) {
		this.horas = horas;
	}
}
