package modelo;

import java.time.LocalDateTime;

public class Instalacion {
	
	private static int generador = 0;
	private int nroInstalacion;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private Cliente cliente;
	private Tecnico tecnico;
	private int[] equipamiento = new int[3];
	private int[] tiempos = new int[3];
	private double litrosCombustible;
	private EstadoInstalacion estado;
	private boolean almuezo;
	private boolean soportePared;
	private boolean seguroTrabajo;
	
	public Instalacion(Cliente cliente, Tecnico tecnico, LocalDateTime inicio, int evap, int cond, int kits) {
		this.nroInstalacion = generador;
		generador++;
		this.inicio = inicio;
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.equipamiento[0] = evap;
		this.equipamiento[1] = cond;
		this.equipamiento[2] = kits;
		this.estado = EstadoInstalacion.PROGRAMADA;
	}
	
	public void finalizarInstalacion(LocalDateTime fin, int evap, int cond, int kits, boolean almuerzo, double litros) {
		this.almuezo = almuerzo;
		this.litrosCombustible = litros;
		this.equipamiento[0] = this.equipamiento[0] + evap;
		this.equipamiento[1] = this.equipamiento[1] + cond;
		this.equipamiento[2] = this.equipamiento[2] + kits;
		this.estado = EstadoInstalacion.FINALIZADA;
	}

	public int getNroInstalacion() {
		return nroInstalacion;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public int[] getEquipamiento() {
		return equipamiento;
	}
	
	public void setEquipamiento(int evap, int cond, int kits) {
		this.equipamiento[0] = evap;
		this.equipamiento[1] = cond;
		this.equipamiento[2] = kits;
	}
	
	public void setTiempos(int dia, int horario, int tiempo) {
		this.tiempos[0] = dia;
		this.tiempos[1] = horario;
		this.tiempos[2] = tiempo;
	}
	
	public int[] getTiempos() {
		return tiempos;
	}

	public double getLitrosCombustible() {
		return litrosCombustible;
	}

	public EstadoInstalacion getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoInstalacion estado) {
		this.estado = estado;
	}

	public boolean isAlmuezo() {
		return almuezo;
	}

	public boolean isSoportePared() {
		return soportePared;
	}

	public boolean isSeguroTrabajo() {
		return seguroTrabajo;
	}
	
	
	

}
