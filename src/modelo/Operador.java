package modelo;

import java.time.LocalDateTime;

public class Operador extends Personal{
	
	public Operador(String nombre, String clave, TipoEmpleado tipo) {
		this.nroEmpleado = generador;
		generador++;
		this.nombre = nombre;
		this.clave = clave;
		this.tipo = tipo;
	}
	
	public boolean consultarAgenda(Tecnico tecnico, int dia, int horario, int tiempo) {
		return tecnico.getAgenda().estaDisponible(dia, horario, tiempo);
	}
	
	public boolean consultarAgenda(Cliente cliente, int dia, int horario, int tiempo) {
		return cliente.getAgenda().estaDisponible(dia, horario, tiempo);
	}
	
	public boolean agendarInstalacion(Cliente cliente, Tecnico tecnico, int dia, int horario, int tiempo, LocalDateTime inicio, int evap, int cond, int kits) {
		if (consultarAgenda(cliente, dia, horario, tiempo) && consultarAgenda(tecnico, dia, horario, tiempo)) {
			if (Empresa.getInstace().agregarInstalacion(cliente, tecnico, dia, horario, tiempo, inicio, evap, cond, kits)) {
				return true;
			}
		}
		return false;
	}

}
