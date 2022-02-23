package Servidor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tempo {
	public LocalDate StringparaData(String Data) {
		return LocalDate.parse(Data, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
	}
	public String DataConvertida(LocalDate data) {
		return DateTimeFormatter.ofPattern("dd/MM/uuuu").format(data);
	}
	public LocalDate ConverterData(String data) {
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
	}
	public LocalDate UltimoDiaUtil() {
		int dia = LocalDate.now().lengthOfMonth(), mes = Mes(), ano = Ano();
		while(LocalDate.of(ano, mes, dia).getDayOfWeek() == DayOfWeek.SUNDAY ||
			  LocalDate.of(ano, mes, dia).getDayOfWeek() == DayOfWeek.SATURDAY) {
			dia = dia - 1;
		}
		if(mes >= 10) return LocalDate.parse(ano + "-" + mes + "-" + dia);
		else return LocalDate.parse(ano + "-0" + mes + "-" + dia);
	}
	public int DiaemNumero() {
		LocalDate data = LocalDate.now();
		if(DayOfWeek.MONDAY == data.getDayOfWeek()) return 2;
		else if(DayOfWeek.TUESDAY == data.getDayOfWeek()) return 3;
		else if(DayOfWeek.WEDNESDAY == data.getDayOfWeek()) return 4;
		else if(DayOfWeek.THURSDAY == data.getDayOfWeek()) return 5;
		else if(DayOfWeek.FRIDAY == data.getDayOfWeek()) return 6;
		else if(DayOfWeek.SATURDAY == data.getDayOfWeek()) return 7;
		return 1;
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
	public int DiadoMes() {
		return LocalDate.now().getDayOfMonth();
	}
	public int Mes() {
		return LocalDate.now().getMonthValue();
	}
	public int Ano() {
		return LocalDate.now().getYear();
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
	public int Hora() {
		return LocalTime.now().getHour();
	}
	public int Minutos() {
		return LocalTime.now().getMinute();
	}
	public boolean DiaUtil() {
		int diaPascoa = DiaPascoa(), mesPascoa = MesPascoa();
		LocalDate pascoa = LocalDate.of(Ano(), mesPascoa, diaPascoa);
		LocalDate carnaval = pascoa.minusDays(47);
		LocalDate corpusChristi = pascoa.minusDays(60);
		LocalDate sextaFeiraSanta = pascoa.minusDays(2);
		if((DiadoMes() == 1 && Mes() == 1) || (DiadoMes() == carnaval.getDayOfMonth() && Mes() == carnaval.getMonthValue()) || 
		   (DiadoMes() == sextaFeiraSanta.getDayOfMonth() && Mes() == sextaFeiraSanta.getMonthValue()) || 
		   (DiadoMes() == carnaval.getDayOfMonth() + 1 && Mes() == carnaval.getDayOfMonth()) ||
		   (DiadoMes() == 21 && Mes() == 4) || (DiadoMes() == 1 && Mes() == 5) ||
		   (DiadoMes() == corpusChristi.getDayOfMonth() && Mes() == corpusChristi.getMonthValue()) ||
		   (DiadoMes() == 7 && Mes() == 9) || (DiadoMes() == 12 && Mes() == 10) || (DiadoMes() == 2 && Mes() == 11) ||
		   (DiadoMes() == 15 && Mes() == 11) || (DiadoMes() == 25 && Mes() == 12) && LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY &&
		   LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) return false;
		return true;
	}
	public int MesPascoa() {
		int ano, d, e;
        ano = Ano();
        d = (19*(ano%19)+24)%30;
        e = (2*(ano%4)+4*(ano%7)+6*d+5)%7;
        if(d+e<10) return 3;
        else return 4;
	}
	public int DiaPascoa() {
		int ano, d, e, dia_da_pascoa, mes_da_pascoa;
        ano = Ano();
        d = (19*(ano%19)+24)%30;
        e = (2*(ano%4)+4*(ano%7)+6*d+5)%7;
        if(d+e<10) return d+e+22;
        else {
        	dia_da_pascoa = d+e-9;
        	mes_da_pascoa = 4;
        	 if(dia_da_pascoa==26&&mes_da_pascoa==4) return 19;
             if(dia_da_pascoa==25&&mes_da_pascoa==4&&d==28&&e==6&&(ano%19)>10) return 18;
        }
        return 1;
	}
	public int DiasUteisnoMes() {     //dias que tem que comparecer, considerando 20-22 dias uteis no mês
		int mes = DiadoMes(), dias = LocalDate.now().lengthOfMonth();
        if(mes == 1 || mes == 5 || mes == 6 || mes == 9 || mes == 10 || mes == 12) { //possui somente um feriado
        	return dias - 10;
        } else if(mes == 11 || mes == 2) {		//dois feriados
        	return dias - 11;
        } else if(mes == 4) {					//três feriados
        	return dias - 12;
        }
        return dias - 9;
	}
	public boolean Pagamentos(LocalDate dia, int intervalo, String x, int index) {
		if(x == "Segunda-Feira" && Dia() == "Segunda-Feira" && LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia) {
			return true;
		} else if(x == "Terça-Feira" && Dia() == "Terça-Feira" && LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia) {
			return true;
		} else if(x == "Quarta-Feira" && Dia() == "Quarta-Feira" && LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia) {
			return true;
		} else if(x == "Quinta-Feira" && Dia() == "Quinta-Feira" && LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia) {
			return true;
		} else if(x == "Sexta-Feira" && Dia() == "Sexta-Feira" && LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia){
			return true;
		} else if(LocalDate.now().withDayOfYear(LocalDate.now().getDayOfYear()) == dia) {
			return true;
		}
		return false;
	}
}
