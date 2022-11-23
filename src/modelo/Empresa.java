package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Empresa {
	
	private static Empresa empresa = null;
	private ArrayList<Personal> personal;
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Equipamiento> equipamiento;
	private ArrayList<Instalacion> instalaciones;
	
	private Empresa() {
		personal = new ArrayList<Personal>();
		tecnicos = new ArrayList<Tecnico>();
		clientes = new ArrayList<Cliente>();
		equipamiento = new ArrayList<Equipamiento>();
		instalaciones = new ArrayList<Instalacion>();
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
			tecnicos.add(new Tecnico(nombre, clave, tipo, nivel));
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
			Evaporador.getInstance().consumirCantidad(evap);
			Condensador.getInstance().consumirCantidad(cond);
			KitInstalacion.getInstance().consumirCantidad(kits);
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
	
	public Tecnico obtenerTecnico(int nroEmpleado) {
		Tecnico tecnicos = null;
		for (Tecnico t: this.tecnicos) {
			if (t.getNroEmpleado() == nroEmpleado) {
				tecnicos = t;
			}
		}
		return tecnicos;
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
	
	public boolean consultarAgenda(Tecnico tecnico, int dia, int horario, int tiempo) {
		return tecnico.getAgenda().estaDisponible(dia, horario, tiempo);
	}
	
	public boolean consultarAgenda(Cliente cliente, int dia, int horario, int tiempo) {
		return cliente.getAgenda().estaDisponible(dia, horario, tiempo);
	}
	
	public ArrayList<Personal> getPersonal(){
		return personal;
	}
	
	public ArrayList<Tecnico> getTecnicos(){
		return tecnicos;
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
