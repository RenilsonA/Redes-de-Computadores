package Inicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Tempo {
	public int DiadoMes() {
		return LocalDate.now().getDayOfMonth();
	}
	public int Mes() {
		return LocalDate.now().getMonthValue();
	}
	public int Ano() {
		return LocalDate.now().getYear();
	}
	public String Dia() {
		LocalDate data = LocalDate.now();
		if(DayOfWeek.MONDAY == data.getDayOfWeek()) return "Segunda-Feira";
		else if(DayOfWeek.TUESDAY == data.getDayOfWeek()) return "Terça-Feira";
		else if(DayOfWeek.WEDNESDAY == data.getDayOfWeek()) return "Quarta-Feira";
		else if(DayOfWeek.THURSDAY == data.getDayOfWeek()) return "Quinta-Feira";
		else if(DayOfWeek.FRIDAY == data.getDayOfWeek()) return "Sexta-Feira";
		else if(DayOfWeek.SATURDAY == data.getDayOfWeek()) return "Sábado";
		return "Domingo";
	}
	public String Horas() {
		LocalTime tempo = LocalTime.now();
		String h = "";
		String m = "";
		String s = "";
		if(tempo.getHour() < 10) h = "0" + Integer.toString(tempo.getHour());
		else h = Integer.toString(tempo.getHour());
		if(tempo.getMinute() < 10) m = "0" + Integer.toString(tempo.getMinute());
		else m = Integer.toString(tempo.getMinute());
		if(tempo.getSecond() < 10) s = "0" + Integer.toString(tempo.getSecond());
		else s = Integer.toString(tempo.getSecond());
		String x = h + ":" + m + ":" + s;
		return x;
	}	
}
