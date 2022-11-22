package modelo;

import java.time.LocalDateTime;

public class Agenda {
	
	private Instalacion[][] agenda;
	private int dia;
	private int horario;
	
	private static int DIA = 6;
	private static int HORARIOS = 24;
	
	public Agenda() {
		agenda = new Instalacion[DIA][HORARIOS];
		for (int i = 0; i < DIA; i++) {
			for (int j = 0; j < HORARIOS; j++) {
				agenda[i][j] = null;
				
			}
		}
	}
	
	public void agendarInstalacion(Instalacion instalacion, int dia, int horario, int tiempo) {
		for (int i = horario; i < horario + tiempo; i++) {
			agenda[dia][i] = instalacion;
		}
	}
	
	public boolean estaDisponible(int dia, int horario, int tiempo) {
		for (int i = horario; i < horario + tiempo; i++) {
			if (agenda[dia][i] != null) {
				return false;
			}
		}
		return true;
	}
	
	public Instalacion getInstalacion() {
		for (int i = 0; i < DIA; i++) {
			for(int j = 0; j < HORARIOS; j++) {
				if (agenda[i][j] != null) {
					return agenda[i][j];
				}
			}
		}
		return null;
	}
	
	public Instalacion[][] getAgenda(){
		return agenda;
	}

}
