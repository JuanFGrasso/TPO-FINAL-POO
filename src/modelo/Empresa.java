package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Empresa {
	
	private static Empresa empresa = null;
	private ArrayList<Personal> personal;
	private ArrayList<Cliente> clientes;
	private ArrayList<Equipamiento> equipamiento;
	private ArrayList<Instalacion> instalaciones;
	
	private Empresa() {
		personal = new ArrayList<Personal>();
		clientes = new ArrayList<Cliente>();
		equipamiento = new ArrayList<Equipamiento>();
		equipamiento.add(Evaporador.getInstance());
		equipamiento.add(Condensador.getInstance());
		equipamiento.add(KitInstalacion.getInstance());
	}
	
	public static Empresa getInstace() {
		if (empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}
	
	public void agregarPersonal(String nombre, String clave, TipoEmpleado tipo, NivelTecnico nivel) {
		switch (tipo) {
		case ADMINISTRADOR:
			personal.add(new Administrador(nombre, clave, tipo));
			break;
		case ADMINISTRATIVO:
			personal.add(new Administrativo(nombre, clave, tipo));
			break;
		case OPERADOR:
			personal.add(new Operador(nombre, clave, tipo));
			break;
		case TECNICO:
			personal.add(new Tecnico(nombre, clave, tipo, nivel));
		}
	}
	
	public void agregarCliente(int documento, String nombre, String direccion) {
		clientes.add(new Cliente(documento, nombre, direccion));
	}
	
	public boolean agregarInstalacion(Cliente cliente, Tecnico tecnico, int dia, int horario, int tiempo, LocalDateTime inicio, int evap, int cond, int kits) {
		if (Evaporador.getInstance().getCantidad() >= evap && Condensador.getInstance().getCantidad() >= cond && KitInstalacion.getInstance().getCantidad() >= kits) {
			Instalacion instalacion = new Instalacion(cliente, tecnico, inicio, evap, cond, kits);
			instalaciones.add(instalacion);
			cliente.getAgenda().agendarInstalacion(instalacion, dia, horario, tiempo);
			tecnico.getAgenda().agendarInstalacion(instalacion, dia, horario, tiempo);
			return true;
		} else {
			return false;
		}
		
	}
	
	public Personal obtenerPersonal(int nroEmpleado) {
		Personal personal = null;
		for (Personal p: this.personal) {
			if (p.getNroEmpleado() == nroEmpleado) {
				personal = p;
			}
		}
		return personal;
	}
	
	public Cliente obtenerCliente(int documento) {
		Cliente cliente = null;
		for (Cliente c: clientes) {
			if (c.getDocumento() == documento) {
				cliente = c;
			}
		}
		return cliente;
	}
	
	public ArrayList<Personal> getPersonal(){
		return personal;
	}
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public ArrayList<Equipamiento> getEquipamiento(){
		return equipamiento;
	}
	
	public ArrayList<Instalacion> getInstalaciones(){
		return instalaciones;
	}
	

}
